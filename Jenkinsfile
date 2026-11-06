
pipeline {

    agent any

    tools {
        jdk 'Java-21'
        maven 'Maven-3.9'
    }

    environment {
        SONAR_PROJECT_KEY = 'jenkins-sonarqube-automation'
    }

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/udaykn13811-hub/Maven-Sonarqube-Jenkins_intergration.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Testing') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh """
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:5.5.0.6356:sonar \
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY}
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "SonarQube Quality Gate failed: ${qg.status}"
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build Successful - Quality Gate Passed!'
        }

        failure {
            echo 'Build Failed - Check Jenkins and SonarQube Reports.'
        }

        always {
            echo 'Pipeline Execution Completed.'
        }
    }
}

