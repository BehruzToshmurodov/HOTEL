package uz.pdp.services;

import uz.pdp.authservice.AuthService;
import uz.pdp.db.DB;
import uz.pdp.entity.Bookings;
import uz.pdp.entity.Room;
import uz.pdp.entity.User;
import uz.pdp.enums.BookingStatus;
import uz.pdp.enums.UserStatus;
import uz.pdp.util.Input;
import uz.pdp.util.Messages;

public class AdminService {

    public static void start() {

        while (true) {

            menuForAdmin();
            Integer entered_commend = Input.inputInt("Enter commend");
            switch (entered_commend) {
                case 1 -> {

                    Integer floor = Input.inputInt("Enter floor");
                    Integer roomNumber = Input.inputInt("Enter room number");

                    Room room = new Room(floor, roomNumber);

                    Integer month = Input.inputInt("Enter month");
                    Integer from = Input.inputInt("From");
                    Integer to = Input.inputInt("To");

                    if (isFree(month, from, to, room)) {
                        System.out.println("This room is free ✅");
                    }

                }
                case 2 -> {

                    String userName = Input.inputStr("Enter user's name");
                    String userPhoneNumber = Input.inputStr("Enter user's phone number");

                    User user = new User(userName , userPhoneNumber);
                    DB.USER_LIST.add(user);

                        Integer floor = Input.inputInt("Enter floor");
                        Integer room_number = Input.inputInt("Enter room number");


                        Integer month = Input.inputInt("Enter month");
                        Integer from = Input.inputInt("From");
                        Integer to = Input.inputInt("To");

                        if ( isFree(month , from , to , new Room(floor , room_number) ) ){

                            System.out.println("""
                                    ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                                    1 - Book
                                    0 - Exit
                                    ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                                    """);
                            Integer commend = Input.inputInt("Enter commend");
                            switch (commend) {
                                case 1->{
                                    Bookings books = new Bookings(floor , room_number , month , from , to);
                                    books.setBookingStatus(BookingStatus.RESERVE);
                                    books.setUserId(user.getUuid());
                                    DB.BOOKS.add(books);

                                }
                                case 0->{

                                }
                            }

                        } else {
                            System.out.println("This room is not free ❌");
                        }

                }
                case 3 -> {

                    if ( DB.BOOKS.size() != 0 ){
                        int i = 1;
                        for (Bookings book : DB.BOOKS) {
                            System.out.print(i++ + ". " + book.getFloor() + "-qavat " + book.getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> " );
                            if ( book.getFrom() < book.getTo() ){
                                System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+book.getMonth()+".2024"  );
                            }
                            else if (book.getFrom() > book.getTo()){
                                System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+ (book.getMonth()+1)+".2024"  );
                            }
                        }
                    } else {
                        System.out.println(" There are not bookings ❌");
                    }

                }
                case 4 -> {
                    showHistory();
                }
                case 5 -> {

                    for (int i = 0; i < DB.BOOKS.size(); i++) {
                        if ( DB.BOOKS.get(i).getBookingStatus().equals(BookingStatus.RESERVE) ){
                            System.out.print(i+1 + ". " + DB.BOOKS.get(i).getFloor() + "-qavat " + DB.BOOKS.get(i).getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> " );
                            if ( DB.BOOKS.get(i).getFrom() < DB.BOOKS.get(i).getTo() ){
                                System.out.println( DB.BOOKS.get(i).getFrom()+"." + DB.BOOKS.get(i).getMonth()+".2024 - " + DB.BOOKS.get(i).getTo()+"."+DB.BOOKS.get(i).getMonth()+".2024"  );
                            }
                            else if (DB.BOOKS.get(i).getFrom() > DB.BOOKS.get(i).getTo()){
                                System.out.println( DB.BOOKS.get(i).getFrom()+"." + DB.BOOKS.get(i).getMonth()+".2024 - " + DB.BOOKS.get(i).getTo()+"."+ (DB.BOOKS.get(i).getMonth()+1)+".2024"  );
                            }
                        }
                    }

                    System.out.println();

                    int bookingIndex = Input.inputInt("Select reserve that you want cancel")-1;

                    boolean remove = DB.BOOKS.remove(DB.BOOKS.get(bookingIndex));

                    if (remove){
                        Messages.success();
                    } else {
                        System.out.println("You entered wrong commend !");
                    }


                }
                case 0->{
                    AuthService.CURRENT_USER = null;
                    return;
                }
            }

        }
    }

    private static boolean isFree(Integer month, Integer from, Integer to, Room room) {
        return room.getMonth() < month || room.getFrom() < from && room.getTo() < to || room.getMonth() < month && room.getFrom() < from && room.getTo() > to;
    }

    private static void showHistory() {
        menuForHistory();
        Integer entered_commend = Input.inputInt("Enter commend");
        switch (entered_commend) {
            case 1->{
                if ( DB.BOOKS.size() != 0 ) {
                    for (Bookings book : DB.BOOKS) {
                        System.out.print(". " + book.getFloor() + "-qavat " + book.getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> " );
                        if ( book.getFrom() < book.getTo() ){
                            System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+book.getMonth()+".2024"  );
                        }
                        else if (book.getFrom() > book.getTo()){
                            System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+ (book.getMonth()+1)+".2024"  );
                        }
                    }
                }
            }
            case 2->{
               User user = chooseUser();
               showBookingsByUser(user);
            }
            case 3->{
                showBookingsByDate();
            }
        }

    }

    private static void showBookingsByDate() {

    }

    private static void showBookingsByUser(User user) {
        for (Bookings book : DB.BOOKS) {
            if ( book.getUserId().equals(user.getUuid()) ){
                System.out.print(". " + book.getFloor() + "-qavat " + book.getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> " );
                if ( book.getFrom() < book.getTo() ){
                    System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+book.getMonth()+".2024"  );
                }
                else if (book.getFrom() > book.getTo()){
                    System.out.println( book.getFrom()+"." + book.getMonth()+".2024 - " + book.getTo()+"."+ (book.getMonth()+1)+".2024"  );
                }
            }
        }
    }

    private static User chooseUser() {

        for (int i = 0; i < DB.USER_LIST.size(); i++) {
            if (DB.USER_LIST.get(i).getUserStatus() != UserStatus.ADMIN) {
                int j = i + 1;
                System.out.println((j) + ". " + DB.USER_LIST.get(i).getName() + " " + DB.USER_LIST.get(i).getPhoneNumber());
            }
        }

        Integer selected_user = Input.inputInt("Select user")-1;

        return DB.USER_LIST.get(selected_user);

    }

    private static void menuForHistory() {

        System.out.println("""
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                1 - All history
                2 - Show history by user
                3 - Show History between date
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);

    }

    private static void menuForAdmin() {

        System.out.println("""
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                1 - Check room
                2 - Reserve room
                3 - Show active bookings
                4 - History
                5 - Cancel reserve
                
                0 - Log out
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);

    }
}
