package com.karthik.event;
import java.sql.*;

public class EventDAO {

    // ADD EVENT
    public void addEvent(Event e) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO events(event_name, event_date, location) VALUES (?, ?, ?)"
            );

            ps.setString(1, e.name);
            ps.setString(2, e.date);
            ps.setString(3, e.location);

            ps.executeUpdate();
            System.out.println("Event Added ✅");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // VIEW EVENTS
    public void viewEvents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM events");

            System.out.println("\nID | Name | Date | Location");
            System.out.println("----------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("event_id") + " | " +
                    rs.getString("event_name") + " | " +
                    rs.getString("event_date") + " | " +
                    rs.getString("location")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE EVENT
    public void updateEvent(int id, String name) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE events SET event_name=? WHERE event_id=?"
            );

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Event Updated ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE EVENT
    public void deleteEvent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM events WHERE event_id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Event Deleted ❌");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // REGISTER USER
    public void registerUser(int eventId, String userName) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO registrations(event_id, user_name) VALUES (?, ?)"
            );

            ps.setInt(1, eventId);
            ps.setString(2, userName);

            ps.executeUpdate();
            System.out.println("User Registered ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // GENERATE TICKET
    public void generateTicket(int regId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tickets(reg_id, issue_date) VALUES (?, CURDATE())"
            );

            ps.setInt(1, regId);

            ps.executeUpdate();
            System.out.println("Ticket Generated ✅");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // VIEW TICKETS (JOIN)
    public void viewTickets() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT t.ticket_id, r.user_name, e.event_name " +
                "FROM tickets t " +
                "JOIN registrations r ON t.reg_id = r.reg_id " +
                "JOIN events e ON r.event_id = e.event_id"
            );

            System.out.println("\nTicketID | User | Event");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ticket_id") + " | " +
                    rs.getString("user_name") + " | " +
                    rs.getString("event_name")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}