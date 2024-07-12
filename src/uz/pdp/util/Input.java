package uz.pdp.util;

import java.util.Scanner;

public interface Input {

    Scanner scanner = new Scanner(System.in);
    static Integer inputInt( String msg ){
        System.out.print(" " + msg + ": ");
        if ( scanner.hasNextInt() ){
            return scanner.nextInt();
        } else {
            scanner.next();
            return inputInt(msg);
        }
    }


    static String inputStr( String msg ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" " + msg + ": ");

        return scanner.nextLine();
    }

}
