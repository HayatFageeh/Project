package com.mycompany.mobileattendancesystem;
import java.io.FileWriter;
import java.io.IOException;

public class SubmitRequest {
    public String submitSickLeaveRequest(int employeeId, String reason, String description) {

        if (reason.isEmpty() || description.isEmpty()) {
            return "Invalid Input\nTry Again";
        }
        String requestDetails =
                "===== Sick Leave Request =====\n" + "Employee ID: " + employeeId + "\n"
                + "Reason: " + reason + "\n" + "Description: " + description + "\n"
                + "Status: Pending\n" + "-----------------------------\n";

        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(requestDetails);
            writer.close();
            return "Sick leave request submitted successfully";

        } catch (IOException e) {
            return "Error saving request";
        }
    }
    public String submitPermissionRequest(int employeeId, String reason, String description) {

    if (reason.isEmpty() || description.isEmpty()) {
        return "Invalid Input\nTry Again";
    }

    String requestDetails =
            "===== Permission Request =====\n"
            + "Employee ID: " + employeeId + "\n"
            + "Reason: " + reason + "\n"
            + "Description: " + description + "\n"
            + "Status: Pending\n"
            + "-----------------------------\n";

    try {
        FileWriter writer = new FileWriter("output.txt", true);
        writer.write(requestDetails);
        writer.close();

        return "Permission request submitted successfully";

    } catch (IOException e) {
        return "Error saving request";
    }
}
}
