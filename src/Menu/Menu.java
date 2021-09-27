package Menu;

import hoteleria.exception.HotelException;
import hoteleria.service.HotelService;
import hoteleria.service.ReservationService;
import hoteleria.service.RoomService;
import hoteleria.service.TuristService;
import java.util.Scanner;

public class Menu {

    private Scanner read;
    private TuristService ts;
    private HotelService hs;
    private RoomService rs;
    private ReservationService res;
    
    public Menu() {
        read = new Scanner(System.in).useDelimiter("\n");
        ts = new TuristService();
        hs = new HotelService();
        rs = new RoomService();
        res = new ReservationService();
    }
    
    public void mainInterface() {
        int option = 0, exit = 5;
        do {
            try {
                System.out.println("\n----- MENU -----\n");
                System.out.println("1. Turist menu");
                System.out.println("2. Hotel menu");
                System.out.println("3. Room menu");
                System.out.println("4. Reservation menu");
                System.out.println("5. Exit");
                System.out.print("Waiting asnwer... ");
                
                option = read.nextInt();
                
                switch (option) {
                    case 1:
                        turistInterface();
                        break;
                    case 2:
                        hotelInterface();
                        break;
                    case 3:
                        roomInterface();
                        break;
                    case 4:
                        reservationInterface();
                        break;
                    case 5:
                        System.out.println("Comming out...");
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (option != exit);
    }
    
    public void turistInterface(){
        int option = 0, exit = 3;
        do {
            try {
                System.out.println("\n----- TURIST MENU -----\n");
                System.out.println("1. Register turist");
                System.out.println("2. Show turists");
                System.out.println("3. Exit");
                System.out.print("Waiting asnwer... ");
                
                option = read.nextInt();
                
                switch (option) {
                    case 1:
                        ts.dataEntry();
                        break;
                    case 2:
                        ts.showTurist();
                        break;
                    case 3:
                        System.out.println("Closing turist menu");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR"); 
            }
        } while (option != exit);
        
    }
    
    public void hotelInterface(){
        int option = 0, exit = 3;
        do {
            try {
                System.out.println("\n----- HOTEL MENU -----\n");
                System.out.println("1. Register hotel");
                System.out.println("2. Show hotels");
                System.out.println("3. Exit");
                System.out.print("Waiting asnwer... ");
                
                option = read.nextInt();
                
                switch (option) {
                    case 1:
                        hs.dataEntry();
                        break;
                    case 2:
                        hs.showHotels();
                        break;
                    case 3:
                        System.out.println("Closing hotel menu");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR"); 
            }
        } while (option != exit);
        
    }
    
    public void roomInterface(){
        int option = 0, exit = 3;
        do {
            try {
                System.out.println("\n----- ROOM MENU -----\n");
                System.out.println("1. Register room");
                System.out.println("2. Show rooms");
                System.out.println("3. Exit");
                System.out.print("Waiting asnwer... ");
                
                option = read.nextInt();
                
                switch (option) {
                    case 1:
                        rs.dataEntry();
                        break;
                    case 2:
                        rs.showRooms();
                        break;
                    case 3:
                        System.out.println("Closing room menu");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage()); 
            }
        } while (option != exit);
        
    }
    
    public void reservationInterface(){
        int option = 0, exit = 3;
        do {
            try {
                System.out.println("\n----- RESERVATION MENU -----\n");
                System.out.println("1. Register reservation");
                System.out.println("2. Show reservations");
                System.out.println("3. Exit");
                System.out.print("Waiting asnwer... ");
                
                option = read.nextInt();
                
                switch (option) {
                    case 1:
                        res.dataEntry();
                        break;
                    case 2:
                        res.showReservations();
                        break;
                    case 3:
                        System.out.println("Closing hotel menu");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR"); 
            }
        } while (option != exit);
        
    }
    
}
