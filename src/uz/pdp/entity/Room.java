package uz.pdp.entity;

import uz.pdp.enums.RoomStatus;

import java.util.Date;

public class Room {

    private int floor ;
    private int room ;

    private RoomStatus statusRoom = RoomStatus.FREE;

    private int month ;
    private int from ;
    private int to ;

    public Room(int floor, int room) {
        this.floor = floor;
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public RoomStatus getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(RoomStatus statusRoom) {
        this.statusRoom = statusRoom;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
