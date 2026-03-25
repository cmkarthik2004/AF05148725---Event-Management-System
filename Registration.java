package com.karthik.event;

public class Registration {
    int reg_id;
    int event_id;
    String user_name;

    public Registration(int reg_id, int event_id, String user_name) {
        this.reg_id = reg_id;
        this.event_id = event_id;
        this.user_name = user_name;
    }
}