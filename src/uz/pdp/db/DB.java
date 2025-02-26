package uz.pdp.db;

import uz.pdp.entity.Bookings;
import uz.pdp.entity.Hotel;
import uz.pdp.entity.Room;
import uz.pdp.entity.User;
import uz.pdp.enums.UserStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface DB {

    Hotel HOTEL = new Hotel();
    ArrayList<User> USER_LIST = new ArrayList<>();

    ArrayList<Bookings> BOOKS = new ArrayList<>();



    static void generateFunction(){

        USER_LIST.add(
                new User("Behruz" , "887115400")
        );

        USER_LIST.get(0).setUserStatus(UserStatus.ADMIN);

        HOTEL.getRooms().add( new Room(1 , 1 ));
        HOTEL.getRooms().add( new Room(1 , 2 ));
        HOTEL.getRooms().add( new Room(1 , 3 ));
        HOTEL.getRooms().add( new Room(1 , 4 ));
        HOTEL.getRooms().add( new Room(1 , 5 ));


        HOTEL.getRooms().add( new Room(2 , 6 ));
        HOTEL.getRooms().add( new Room(2 , 7 ));
        HOTEL.getRooms().add( new Room(2 , 8 ));
        HOTEL.getRooms().add( new Room(2 , 9 ));
        HOTEL.getRooms().add( new Room(2 , 10 ));

        HOTEL.getRooms().add( new Room(3 , 11 ));
        HOTEL.getRooms().add( new Room(3 , 12 ));
        HOTEL.getRooms().add( new Room(3 , 13 ));
        HOTEL.getRooms().add( new Room(3 , 14 ));
        HOTEL.getRooms().add( new Room(3 , 15 ));


        HOTEL.getRooms().add( new Room(4 , 16 ));
        HOTEL.getRooms().add( new Room(4 , 17 ));
        HOTEL.getRooms().add( new Room(4 , 18 ));
        HOTEL.getRooms().add( new Room(4 , 19 ));
        HOTEL.getRooms().add( new Room(4 , 20 ));

        HOTEL.getRooms().add( new Room(5 , 21 ));
        HOTEL.getRooms().add( new Room(5 , 22 ));
        HOTEL.getRooms().add( new Room(5 , 23 ));
        HOTEL.getRooms().add( new Room(5 , 24 ));
        HOTEL.getRooms().add( new Room(5 , 25 ));


    }

    static void loadBookings() {

        try (
                FileInputStream fileInputStream = new FileInputStream("dbForBookings.text" );
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            BOOKS.addAll( (List<Bookings>) objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            //
        }
    }


    static void upLoadBookings() {

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("dbForBookings.text");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject( BOOKS);

        } catch (IOException e) {
            throw  new RuntimeException();
        }
    }

    static void loadUsers() {

        try (
                FileInputStream fileInputStream = new FileInputStream("dbForUsers.text" );
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            USER_LIST.addAll( (List<User>) objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            //
        }
    }


    static void upLoadUsers() {

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("dbForUsers.text");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject( USER_LIST);

        } catch (IOException e) {
            throw  new RuntimeException();
        }
    }


}
