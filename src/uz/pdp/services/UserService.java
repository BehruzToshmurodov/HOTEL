package uz.pdp.services;

import uz.pdp.authservice.AuthService;
import uz.pdp.db.DB;
import uz.pdp.entity.Bookings;
import uz.pdp.entity.Room;
import uz.pdp.entity.User;
import uz.pdp.enums.BookingStatus;
import uz.pdp.util.Input;
import uz.pdp.util.Messages;

public class UserService {

    public static void start() {

       while (true){
           menuForUser();
           Integer entered_commend = Input.inputInt("Enter commend");
           switch (entered_commend) {
               case 1->{

                   Integer floor = Input.inputInt("Enter floor");
                   Integer roomNumber = Input.inputInt("Enter room number");

                   Room room = new Room(floor , roomNumber);

                   Integer month = Input.inputInt("Enter month");
                   Integer from = Input.inputInt("From");
                   Integer to = Input.inputInt("To");

                   if ( isFree(month , from , to , room) ){
                       System.out.println("This room is free ✅");
                   }

               }
               case 2->{

                   Integer floor = Input.inputInt("Enter floor");
                   Integer roomNumber = Input.inputInt("Enter room number");

                   Room room = new Room(floor , roomNumber);

                   Integer month = Input.inputInt("Enter month");
                   Integer from = Input.inputInt("From");
                   Integer to = Input.inputInt("To");

                   if ( isFree(month , from , to , room) ){

                       System.out.println("""
                               1 - Book
                               0 - Cancel
                               """);
                       Integer enter_commend = Input.inputInt("Enter commend");
                       switch (enter_commend) {
                           case 1->{
                               Bookings bookings = new Bookings(floor , roomNumber , month , from , to);
                               bookings.setUserId(AuthService.CURRENT_USER.getUuid());
                               DB.BOOKS.add(bookings);
                               Messages.success();
                           }
                           case 0->{

                           }
                       }


                   }


               }
               case 3->{
                   showBookingsByUser(AuthService.CURRENT_USER);
                   int index = Input.inputInt("Choose booking that you want cancel")-1;
                   DB.BOOKS.get(index).setBookingStatus(BookingStatus.Deleted_BY_USER);
                   Messages.success();
               }
               case 4->{
                   showBookingsByUser(AuthService.CURRENT_USER);
               }
               case 5->{
                   showHistory();
               }
               case 6->{}
               case 0->{
                   AuthService.logOut();
                   return;
               }
           }

       }

    }

    private static void showHistory() {

        for (int i = 0; i < DB.BOOKS.size(); i++) {
            if (DB.BOOKS.get(i).getUserId().equals(AuthService.CURRENT_USER.getUuid())) {
                System.out.print(i + 1 + ". " + DB.BOOKS.get(i).getFloor() + "-qavat " + DB.BOOKS.get(i).getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> ");
                if (DB.BOOKS.get(i).getFrom() < DB.BOOKS.get(i).getTo()) {
                    System.out.println(DB.BOOKS.get(i).getFrom() + "." + DB.BOOKS.get(i).getMonth() + ".2024 - " + DB.BOOKS.get(i).getTo() + "." + DB.BOOKS.get(i).getMonth() + ".2024");
                } else if (DB.BOOKS.get(i).getFrom() > DB.BOOKS.get(i).getTo()) {
                    System.out.print(DB.BOOKS.get(i).getFrom() + "." + DB.BOOKS.get(i).getMonth() + ".2024 - " + DB.BOOKS.get(i).getTo() + "." + (DB.BOOKS.get(i).getMonth() + 1) + ".2024  status: " + DB.BOOKS.get(i).getBookingStatus() );
                }
            }
        }
    }

    private static void showBookingsByUser(User user) {
        for (int i = 0; i < DB.BOOKS.size(); i++) {
            if ( DB.BOOKS.get(i).getUserId().equals(user.getUuid()) && !DB.BOOKS.get(i).getBookingStatus().equals(BookingStatus.Deleted_BY_USER)  ){
                System.out.print( i+1 + ". " + DB.BOOKS.get(i).getFloor() + "-qavat " + DB.BOOKS.get(i).getRoomNumber() + "-xonadon ⎯⎯⎯⎯⎯⎯> " );
                if ( DB.BOOKS.get(i).getFrom() < DB.BOOKS.get(i).getTo() ){
                    System.out.println( DB.BOOKS.get(i).getFrom()+"." + DB.BOOKS.get(i).getMonth()+".2024 - " + DB.BOOKS.get(i).getTo()+"."+DB.BOOKS.get(i).getMonth()+".2024"  );
                }
                else if (DB.BOOKS.get(i).getFrom() > DB.BOOKS.get(i).getTo()){
                    System.out.println( DB.BOOKS.get(i).getFrom()+"." + DB.BOOKS.get(i).getMonth()+".2024 - " + DB.BOOKS.get(i).getTo()+"."+ (DB.BOOKS.get(i).getMonth()+1)+".2024"  );
                }
            }
        }

        System.out.println();

        }
    private static boolean isFree(Integer month, Integer from, Integer to, Room room) {
        return room.getMonth() < month || room.getFrom() < from && room.getTo() < to || room.getMonth() < month && room.getFrom() < from && room.getTo() > to;
    }

    private static void menuForUser() {
        System.out.println("""
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                1 - Check room
                2 - Book room
                3 - Cancel booking
                4 - Show active bookings
                5 - History
                6 - Balance
                
                0 - Log out
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);
    }
}
