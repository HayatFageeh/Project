package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class HRTest {
    
    @Test
    public void testReviewRequestsFileExists() {

    // Setup
    HR hr = new HR();

    // Calling
    hr.reviewRequests();

    File file = new File("output.txt");

    // Assertion
    assertTrue(file.exists());
}
    @Test
    public void testOutputFileNotEmpty() throws Exception {

    // Setup
    HR hr = new HR();

    // Calling
    hr.reviewRequests();

    File file = new File("output.txt");
    String content = Files.readString(file.toPath());

    // Assertion
    assertFalse(content.isEmpty());
} 
    @Test
    public void testOutputContainsStatus() throws Exception {

    // Setup
    HR hr = new HR();

    // Calling
    hr.reviewRequests();

    File file = new File("output.txt");
    String content = Files.readString(file.toPath());

    // Assertion
    assertTrue(content.contains("Status"));
}

}