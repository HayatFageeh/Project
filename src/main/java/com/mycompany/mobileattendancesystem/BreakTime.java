package com.mycompany.mobileattendancesystem;
import java.util.ArrayList;

public class BreakTime {

    ArrayList<Integer> employeeIds = new ArrayList<Integer>();
    ArrayList<Integer> startTimes = new ArrayList<Integer>();
    ArrayList<Integer> endTimes = new ArrayList<Integer>();

    public String logBreakTime(int employeeId, String answer, String startTimeText) {
        if (answer.equalsIgnoreCase("no")) {
            return "Returning to menu";
        }
        if (!answer.equalsIgnoreCase("yes")) {
            return "Invalid answer\nPlease enter yes or no";
        }
        int startTime = convertTimeToMinutes(startTimeText);
        if (startTime == -1) {
            return "Invalid time format\nPlease enter time like 10:00 or 10:30";
        }
        int endTime = startTime + 60;

        for (int i = 0; i < employeeIds.size(); i++) {
            if (employeeIds.get(i) != employeeId) {
                if (startTime < endTimes.get(i) && endTime > startTimes.get(i)) {
                    return "Rejected\nAnother employee already booked this break time\nTry again";
                }
            }
        }
        employeeIds.add(employeeId);
        startTimes.add(startTime);
        endTimes.add(endTime);
        return "Done\nYour break time is one hour";
    }

    public int convertTimeToMinutes(String time) {
        if (!time.contains(":")) {
            return -1;
        }

        String[] parts = time.split(":");
        if (parts.length != 2) {
            return -1;
        }

        int hour;
        int minute;

        try {
            hour = Integer.parseInt(parts[0]);
            minute = Integer.parseInt(parts[1]);
        } catch (Exception e) {
            return -1;
        }

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return -1;
        }

        return hour * 60 + minute;
    }
}