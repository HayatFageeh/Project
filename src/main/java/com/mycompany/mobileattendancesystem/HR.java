package com.mycompany.mobileattendancesystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HR {

    public void reviewRequests() {
        try {
            File file = new File("output.txt");

            Scanner reader = new Scanner(file);
            ArrayList<String> requests = new ArrayList<String>();

            String request = "";

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                request += line + "\n";

                if (line.equals("-----------------------------")) {
                    requests.add(request);
                    request = "";
                }
            }

            reader.close();

            if (requests.isEmpty()) {
                System.out.println("No Requests Found");
                return;
            }

            System.out.println("Total Requests: " + requests.size());

            Scanner input = new Scanner(System.in);

            for (int i = 0; i < requests.size(); i++) {
                System.out.println("\n===== Request " + (i + 1) + " =====");
                System.out.println(requests.get(i));

                if (requests.get(i).contains("Status: Pending")) {
                    System.out.print("Enter decision for this request (approve/reject): ");
                    String decision = input.nextLine();

                    if (decision.equalsIgnoreCase("approve")) {
                        requests.set(i, requests.get(i).replace("Status: Pending", "Status: Approved"));
                        System.out.println("Request Approved");
                    } else if (decision.equalsIgnoreCase("reject")) {
                        requests.set(i, requests.get(i).replace("Status: Pending", "Status: Rejected"));
                        System.out.println("Request Rejected");
                    } else {
                        System.out.println("Invalid Decision, request stays Pending");
                    }
                }
            }
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < requests.size(); i++) {
                writer.write(requests.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}