package com.karthik.event;

public class Ticket {
    int ticket_id;
    int reg_id;
    String issue_date;

    public Ticket(int ticket_id, int reg_id, String issue_date) {
        this.ticket_id = ticket_id;
        this.reg_id = reg_id;
        this.issue_date = issue_date;
    }
}