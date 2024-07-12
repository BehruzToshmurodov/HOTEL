package uz.pdp.entity;

import java.util.ArrayList;

public class User {

    private String name;
    private String phoneNumber;

    private String UserLevel = "USER";

    private ArrayList<Room> history;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Room> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Room> history) {
        this.history = history;
    }

    public String getUserLevel() {
        return UserLevel;
    }

    public void setUserLevel(String userLevel) {
        UserLevel = userLevel;
    }
 }


