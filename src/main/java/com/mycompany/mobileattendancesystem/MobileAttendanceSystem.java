package com.mycompany.mobileattendancesystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MobileAttendanceSystem {

    static ArrayList<Integer> employeeIds = new ArrayList<Integer>();
    static ArrayList<String> passwords = new ArrayList<String>();
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<String> roles = new ArrayList<String>();
    static ArrayList<String> requests = new ArrayList<String>();
    static ArrayList<String> requestStatus = new ArrayList<String>();
    static BreakTime breakManager = new BreakTime();
    static int currentEmployeeId;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        addUsers();
        while (true) {

            System.out.print("Enter Employee ID: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Enter Password: ");
            String password = input.nextLine();

            int index = login(id, password);

            if (index == -1) {
                System.out.println("Invalid Employee ID or Password");
                System.out.println("Try Again\n");
            } else {
                currentEmployeeId = id;
                System.out.println("\nLogin successful");
                System.out.println("Welcome " + names.get(index));

                if (roles.get(index).equals("Employee")) {
                    employeeMenu(names.get(index));
                } else {
                    hrMenu();
                }
                break;
            }
        }
    }

    public static void addUsers() {

        employeeIds.add(652100);
        passwords.add("Yara6521");
        names.add("Yara");
        roles.add("Employee");

        employeeIds.add(348700);
        passwords.add("Hayat3487");
        names.add("Hayat");
        roles.add("Employee");

        employeeIds.add(456789);
        passwords.add("RaghadSh123");
        names.add("Raghad Alshammari");
        roles.add("Employee");

        employeeIds.add(987654);
        passwords.add("RaghadQ456");
        names.add("Raghad Alqarni");
        roles.add("Employee");

        employeeIds.add(125642);
        passwords.add("HR98453");
        names.add("HR");
        roles.add("HR");
    }

    public static int login(int id, String password) {

        for (int i = 0; i < employeeIds.size(); i++) {
            if (id == employeeIds.get(i) && password.equals(passwords.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void employeeMenu(String employeeName) {

        int choice;
        do {
            System.out.println("\n===== Employee Menu =====");
            System.out.println("1. Check In");
            System.out.println("2. Break Time");
            System.out.println("3. Request");
            System.out.println("4. Exit");

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                checkIn();
            } else if (choice == 2) {
                breakTime();
            } else if (choice == 3) {
                sendRequest(employeeName);
            } else if (choice == 4) {
                System.out.println("Goodbye");
            } else {
                System.out.println("Wrong choice");
            }
        } while (choice != 4);
    }

    public static void hrMenu() {

    int choice;
    do {
        System.out.println("\n===== HR Menu =====");
        System.out.println("1. View Requests");
        System.out.println("2. Exit");

        System.out.print("Choose: ");
        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            HR hr = new HR();
            hr.reviewRequests(input.nextLine());
        } else if (choice == 2) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Wrong choice");
        }

    } while (choice != 2);
}

    public static void checkIn() {

    System.out.print("Enter your location: ");
    String location = input.nextLine();

    System.out.println("Checking location...");

    CheckIn check = new CheckIn();
    String result = check.checkIn(location);

    System.out.println(result);
    }

    public static void breakTime() {

    System.out.print("Do you want a break? yes/no: ");
    String answer = input.nextLine();

    if (answer.equalsIgnoreCase("no")) {
        System.out.println("Returning to menu");
        return;
    }

    System.out.print("Enter break start time example 10:30: ");
    String startTime = input.nextLine();

    String result = breakManager.logBreakTime(currentEmployeeId, answer, startTime);
    System.out.println(result);
}
   
    public static void sendRequest(String employeeName) {

    System.out.println("\n===== Request Menu =====");
    System.out.println("1. Sick Leave");
    System.out.println("2. Permission");

    System.out.print("Choose request type: ");
    int choice = input.nextInt();
    input.nextLine();

    if (choice != 1 && choice != 2) {
        System.out.println("Wrong choice");
        return;
    }

    System.out.print("Enter reason: ");
    String reason = input.nextLine();

    System.out.print("Enter description: ");
    String description = input.nextLine();

    SubmitRequest request = new SubmitRequest();

    String result;

    if (choice == 1) {
        result = request.submitSickLeaveRequest(currentEmployeeId, reason, description);
    } else {
        result = request.submitPermissionRequest(currentEmployeeId, reason, description);
    }

    System.out.println(result);
}
}
    

