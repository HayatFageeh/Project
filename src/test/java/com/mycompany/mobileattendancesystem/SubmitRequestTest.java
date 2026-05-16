
package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SubmitRequestTest {

    @Test
    public void testSubmitSickLeaveSuccess() throws Exception {

    // Setup
    SubmitRequest request = new SubmitRequest();

    // Calling
    String result = request.submitSickLeaveRequest(
            348700,
            "Fever",
            "I am sick"
    );

    // Assertion
    assertEquals(
            "Sick leave request submitted successfully",
            result
    );
}

    @Test
    public void testSubmitSickLeaveRequestWithEmptyReason() {

        // Setup
        SubmitRequest instance = new SubmitRequest();

        // Calling
        String result = instance.submitSickLeaveRequest(
                348700,
                "",
                "I have fever"
        );

        // Assertion
        assertEquals("Invalid Input\nTry Again", result);
    }

    @Test
    public void testSubmitSickLeaveRequestWithEmptyDescription() {

        // Setup
        SubmitRequest instance = new SubmitRequest();

        // Calling
        String result = instance.submitSickLeaveRequest(
                348700,
                "Sick",
                ""
        );

        // Assertion
        assertEquals("Invalid Input\nTry Again", result);
    }

    @Test
    public void testRequestFileWrite() throws Exception {

    // Setup
    SubmitRequest request = new SubmitRequest();

    // Calling
    request.submitSickLeaveRequest(
            348700,
            "Fever",
            "I am sick"
    );

    // Assertion
    String content = java.nio.file.Files.readString(
            java.nio.file.Path.of("output.txt")
    );

    assertTrue(content.contains("Sick Leave Request"));
}

}

