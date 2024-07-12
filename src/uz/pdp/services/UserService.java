package uz.pdp.services;

import uz.pdp.entity.Room;
import uz.pdp.util.Input;

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
               case 2->{}
               case 3->{}
               case 4->{}
               case 5->{}
               case 6->{}
           }

       }

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
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);
    }
}
