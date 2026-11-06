
package com.aa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAddition() {
        assertEquals(30, App.add(10, 20));
    }

    @Test
    void testMessage() {
        assertEquals(
            "Welcome to AA Software Technologies",
            App.getMessage()
        );
    }
}

