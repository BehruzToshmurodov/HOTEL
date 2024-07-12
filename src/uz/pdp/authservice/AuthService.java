package uz.pdp.authservice;

import uz.pdp.db.DB;
import uz.pdp.entity.User;
import uz.pdp.util.Input;

public class AuthService {

    public static User CURRENT_USER = null;

    public static void singIn(){

        while (true){
            String name = Input.inputStr("Enter name");
            String phone_number = Input.inputStr("Enter phone number");

            for (User user : DB.USER_LIST) {
                if ( user.getName().equals(name) && user.getPhoneNumber().equals(phone_number) ){
                    CURRENT_USER = user;
                    return;
                }
                else {
                    System.out.println("This user not found !");
                }
            }
        }

    }

    public static void singUp(){

        String name = Input.inputStr("Enter name");
        String phone_number = Input.inputStr("Enter phone number");

        User user = new User(name , phone_number);
        DB.USER_LIST.add(user);
        CURRENT_USER = user;

    }

    public static void logOut(){
        CURRENT_USER = null;
    }

}
