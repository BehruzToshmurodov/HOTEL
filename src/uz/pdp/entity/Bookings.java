package uz.pdp.entity;

import uz.pdp.enums.BookingStatus;

import java.io.Serializable;
import java.util.UUID;

public class Bookings implements Serializable {

    private UUID userId;

    private BookingStatus bookingStatus = BookingStatus.BOOKING_BY_USER;
    private int floor;
    private int roomNumber;

    private int month;

    private int from;
    private int to;

    public Bookings(int floor, int roomNumber, int month, int from, int to) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.month = month;
        this.from = from;
        this.to = to;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setToMonth(int toMonth) {
        this.month = toMonth;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
