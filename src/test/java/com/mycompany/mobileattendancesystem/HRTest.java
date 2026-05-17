package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class HRTest {

    @Test
    public void testReviewRequestsApprove() throws Exception {

        // Setup
        FileWriter writer = new FileWriter("output.txt", false);
        writer.write(
                "Employee: Ali\n" +
                "Status: Pending\n" +
                "-----------------------------\n"
        );
        writer.close();

        HR hr = new HR();

        // Calling
        hr.reviewRequests("approve");

        // Assertion
        String content = Files.readString(new File("output.txt").toPath());
        assertTrue(content.contains("Status: Approved"));
    }

    @Test
    public void testReviewRequestsReject() throws Exception {

        // Setup
        FileWriter writer = new FileWriter("output.txt", false);
        writer.write(
                "Employee: Sara\n" +
                "Status: Pending\n" +
                "-----------------------------\n"
        );
        writer.close();

        HR hr = new HR();

        // Calling
        hr.reviewRequests("reject");

        // Assertion
        String content = Files.readString(new File("output.txt").toPath());
        assertTrue(content.contains("Status: Rejected"));
    }

    @Test
    public void testFileStillExistsAfterProcessing() throws Exception {

        // Setup
        FileWriter writer = new FileWriter("output.txt", false);
        writer.write(
                "Employee: Omar\n" +
                "Status: Pending\n" +
                "-----------------------------\n"
        );
        writer.close();

        HR hr = new HR();

        // Calling
        hr.reviewRequests("approve");

        // Assertion
        File file = new File("output.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testFileNotEmptyAfterProcessing() throws Exception {

        // Setup
        FileWriter writer = new FileWriter("output.txt", false);
        writer.write(
                "Employee: Khalid\n" +
                "Status: Pending\n" +
                "-----------------------------\n"
        );
        writer.close();

        HR hr = new HR();

        // Calling
        hr.reviewRequests("approve");

        // Assertion
        String content = Files.readString(new File("output.txt").toPath());
        assertFalse(content.trim().isEmpty());
    }
}
