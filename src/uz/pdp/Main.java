package uz.pdp;

import uz.pdp.authservice.AuthService;
import uz.pdp.db.DB;
import uz.pdp.enums.UserStatus;
import uz.pdp.services.AdminService;
import uz.pdp.services.UserService;
import uz.pdp.util.Input;

public class Main {

    static {
        DB.generateFunction();
    }
    public static void main(String[] args) {

        while (true) {

            menuForAuth();
            Integer entered_commend = Input.inputInt("enter commend");
            switch (entered_commend) {
                case 1 -> {
                    AuthService.singIn();
                }
                case 2 -> {
                    AuthService.singUp();
                }
                case 0 -> {

                }
            }


            if (AuthService.CURRENT_USER.getUserStatus().equals(UserStatus.USER)) {
                UserService.start();
            } else if (AuthService.CURRENT_USER.getUserStatus().equals(UserStatus.ADMIN)) {
                AdminService.start();
            }

        }

    }

    private static void menuForAuth() {
        System.out.println("""
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                1 - Sing In
                2 - Sing up
                
                0 - Exit
                ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                
                """);
    }
}
