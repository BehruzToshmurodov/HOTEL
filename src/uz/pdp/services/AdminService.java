package uz.pdp.services;

import uz.pdp.util.Input;

public class AdminService {

    public static void start() {

        menuForAdmin();
        Integer entered_commend = Input.inputInt("Enter commend");
        switch (entered_commend) {
            case 1->{}
            case 2->{}
            case 3->{}
            case 4->{
                showHistory();
            }
            case 5->{}
        }

    }

    private static void showHistory() {
        menuForHistory();
        Integer entered_commend = Input.inputInt("Enter commend");
        switch (entered_commend) {
            case 1->{}
            case 2->{}
            case 3->{}
        }

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
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);

    }
}
