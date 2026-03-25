package com.karthik.event;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EventDAO dao = new EventDAO();

        while (true) {
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register for Event");
            System.out.println("4. Generate Ticket");
            System.out.println("5. View Tickets");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter Event Name: ");
                    String name = sc.next();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.next();
                    System.out.print("Enter Location: ");
                    String loc = sc.next();

                    dao.addEvent(new Event(0, name, date, loc));
                    break;

                case 2:
                    dao.viewEvents();
                    break;

                case 3:
                    dao.viewEvents(); // show events first
                    System.out.print("Enter Event ID: ");
                    int eventId = sc.nextInt();
                    System.out.print("Enter Your Name: ");
                    String user = sc.next();

                    dao.registerUser(eventId, user);
                    break;

                case 4:
                    System.out.print("Enter Registration ID: ");
                    int regId = sc.nextInt();

                    dao.generateTicket(regId);
                    break;

                case 5:
                    dao.viewTickets();
                    break;

                case 6:
                    System.out.println("Exit...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}