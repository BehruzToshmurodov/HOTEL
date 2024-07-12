package uz.pdp.util;

public interface Messages {

    static void success(){
        System.out.println();
        System.out.println( " Done ✅ " );
    }

    static void cancel(){
        System.out.println();
        System.out.println( " Something went wrong ❌ " );
    }

    static void tryAgain(){
        System.out.println();
        System.out.println( " Please try again \uD83D\uDD04 " );
    }

    static String strike( String txt ){
        String ANSI_STRIKE  = "\u001B[9m";
        String ANSI_RESET  = "\u001B[0m";
        return ANSI_STRIKE + txt + ANSI_RESET;
    }

    static void thankYou(){
        System.out.println();
        System.out.println("\t".repeat(2) + " Thank You for Your Attention \uD83E\uDD1D " );
    }

}
