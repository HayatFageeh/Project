package com.mycompany.mobileattendancesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;

public class MobileAttendanceSystemTest {

    @Test
    public void testLoginSuccessEmployee() {

        // Setup
        MobileAttendanceSystem.addUsers();

        // Calling
        int result = MobileAttendanceSystem.login(
                348700,
                "Hayat3487"
        );

        // Assertion
        assertEquals(1, result);
    }

    @Test
    public void testLoginWrongPassword() {

        // Setup
        MobileAttendanceSystem.addUsers();

        // Calling
        int result = MobileAttendanceSystem.login(
                348700,
                "wrongPassword"
        );

        // Assertion
        assertEquals(-1, result);
    }
    
    @Test
    public void testLoginWrongId() {

       // Setup
       MobileAttendanceSystem.addUsers();

       // Calling
        int result = MobileAttendanceSystem.login(
            111111,
            "Hayat3487"
    );

      // Assertion
      assertEquals(-1, result);
   }   

    
    @Test
    public void testLoginHR() {

     // Setup
     MobileAttendanceSystem.addUsers();

     // Calling
     int result = MobileAttendanceSystem.login(
            125642,
            "HR98453"
    );

     // Assertion
     assertEquals(4, result);
}
    
    @Test
    public void testAddUsers() {

     // Setup
     MobileAttendanceSystem.employeeIds.clear();
     MobileAttendanceSystem.passwords.clear();
     MobileAttendanceSystem.names.clear();
     MobileAttendanceSystem.roles.clear();
     MobileAttendanceSystem.addUsers();

     // Calling
     int size = MobileAttendanceSystem.employeeIds.size();

     // Assertion
     assertEquals(5, size);
}
}
