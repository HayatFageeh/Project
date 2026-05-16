package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckInTest {

  @Test
  public void testCheckInSuccess() {

    // Setup
    CheckIn checkIn = new CheckIn();

    // Calling
    String result = checkIn.checkIn("https://maps.app.goo.gl/UQkESSe9yHTgh3cj8?g_st=iw");

    // Assertion
    assertEquals("Attendance recorded successfully", result);
}

    @Test
    public void testCheckInWrongLocation() {

    // Setup
    CheckIn checkIn = new CheckIn();

    // Calling
    String result = checkIn.checkIn("https://google.com");

    // Assertion
    assertEquals("Wrong location\nTry Again", result);
}

    @Test
    public void testCheckInCorrectLocationIgnoreCase() {

        // Setup
        CheckIn instance = new CheckIn();

        String location =
                "HTTPS://MAPS.APP.GOO.GL/UQKESSE9YHTGH3CJ8?G_ST=IW";

        // Calling
        String result = instance.checkIn(location);

        // Assertion
        assertEquals(
                "Attendance recorded successfully",
                result
        );
    }
    @Test
    public void testCheckInSimilarButWrong() {

    // Setup
    CheckIn checkIn = new CheckIn();

    // Calling
    String result = checkIn.checkIn("https://maps.app.goo.gl/UQkESSe9yHTgh3cj8");

    // Assertion
    assertEquals("Wrong location\nTry Again", result);
}
}