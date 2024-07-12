package uz.pdp.entity;

import java.util.Date;

public class Room {

    private int floor ;
    private int room ;

    private Boolean status = false;

    private Date from ;
    private Date to ;

    public Room(int floor, int room, Boolean status) {
        this.floor = floor;
        this.room = room;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
