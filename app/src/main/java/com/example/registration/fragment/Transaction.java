package com.example.registration.fragment;

public class Transaction {
    private String id;
    private boolean status;
    private String fromUser;
    private String time;
    private String date;
    private int creditsTransferred;

    public Transaction(boolean status, String id, String fromUser, String time, String date, int creditsTransferred) {
        this.status = status;
        this.id = id;
        this.fromUser = fromUser;
        this.time = time;
        this.date = date;
        this.creditsTransferred = creditsTransferred;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCreditsTransferred() {
        return creditsTransferred;
    }

    public void setCreditsTransferred(int creditsTransferred) {
        this.creditsTransferred = creditsTransferred;
    }
}
