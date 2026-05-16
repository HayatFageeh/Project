package com.mycompany.mobileattendancesystem;
import java.util.ArrayList;

public class CheckIn {

    public String checkIn(String location) {

        String workLocation = "https://maps.app.goo.gl/UQkESSe9yHTgh3cj8?g_st=iw";

        if (location.equalsIgnoreCase(workLocation)) {
            return "Attendance recorded successfully";
        } else {
            return "Wrong location\nTry Again";
        }
    }
}
