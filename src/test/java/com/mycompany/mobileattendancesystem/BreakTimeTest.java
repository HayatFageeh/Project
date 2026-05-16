
package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BreakTimeTest {

    @Test
    public void testLogBreakTimeWithNoAnswer() {

        // Setup
        BreakTime instance = new BreakTime();

        // Calling
        String result = instance.logBreakTime(
                1,
                "no",
                ""
        );

        // Assertion
        assertEquals(
                "Returning to menu",
                result
        );
    }

    @Test
    public void testLogBreakTimeWithInvalidAnswer() {

        // Setup
        BreakTime instance = new BreakTime();

        // Calling
        String result = instance.logBreakTime(
                1,
                "maybe",
                ""
        );

        // Assertion
        assertEquals(
                "Invalid answer\nPlease enter yes or no",
                result
        );
    }

    @Test
    public void testLogBreakTimeWithInvalidTime() {

        // Setup
        BreakTime instance = new BreakTime();

        // Calling
        String result = instance.logBreakTime(
                1,
                "yes",
                "abc"
        );

        // Assertion
        assertEquals(
                "Invalid time format\nPlease enter time like 10:00 or 10:30",
                result
        );
    }

    @Test
    public void testLogBreakTimeSuccessfully() {

        // Setup
        BreakTime instance = new BreakTime();

        // Calling
        String result = instance.logBreakTime(
                1,
                "yes",
                "10:00"
        );

        // Assertion
        assertEquals(
                "Done\nYour break time is one hour",
                result
        );
    }

    @Test
    public void testLogBreakTimeConflict() {

        // Setup
        BreakTime instance = new BreakTime();

        instance.logBreakTime(
                1,
                "yes",
                "10:00"
        );

        // Calling
        String result = instance.logBreakTime(
                2,
                "yes",
                "10:30"
        );

        // Assertion
        assertEquals(
                "Rejected\nAnother employee already booked this break time\nTry again",
                result
        );
    }

}




