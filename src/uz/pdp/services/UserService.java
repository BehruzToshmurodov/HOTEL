package uz.pdp.services;

import uz.pdp.util.Input;

public class UserService {

    public static void start() {

        menuForUser();
        Integer entered_commend = Input.inputInt("Enter commend");
        switch (entered_commend) {
            case 1->{}
            case 2->{}
            case 3->{}
            case 4->{}
            case 5->{}
            case 6->{}
        }

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
