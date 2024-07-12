package uz.pdp.entity;

import uz.pdp.enums.RoomStatus;

import java.util.Date;

public class Room {

    private int floor ;
    private int room ;

    private RoomStatus statusRoom = RoomStatus.FREE;

    private Date from ;
    private Date to ;

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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
