package uz.pdp.entity;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms = new ArrayList<>();


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

}
