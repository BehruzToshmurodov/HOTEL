package uz.pdp.entity;

import uz.pdp.enums.UserStatus;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    private final UUID uuid = UUID.randomUUID();
    private String name;
    private String phoneNumber;

    private UserStatus userStatus = UserStatus.USER;

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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UUID getUuid() {
        return uuid;
    }
}


