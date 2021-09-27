package hoteleria.service;

import hoteleria.entidad.Reservation;
import hoteleria.entidad.Room;
import hoteleria.entidad.Turist;
import hoteleria.exception.HotelException;
import hoteleria.persistencia.ReservationDAO;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationService {

    private Scanner read;
    private ReservationDAO reservationDAO;
    private RoomService roomService;
    private TuristService turistService;

    public ReservationService() {
        read = new Scanner(System.in).useDelimiter("\n");
        reservationDAO = new ReservationDAO();
        roomService = new RoomService();
        turistService = new TuristService();
    }

    public void createReservation(LocalDate since, LocalDate until, Turist turist, Room room) throws HotelException {
        try {
            Reservation reservation = new Reservation();

            reservation.setSince(since);
            reservation.setUntil(until);
            reservation.setTurist(turist);
            reservation.setRoom(room);

            reservationDAO.storeReservation(reservation);
        } catch (HotelException e) {
            throw e;
        }
    }

    public void dataEntry() throws HotelException {
        try {
            List<Turist> turists = turistService.getTurists();
            List<Room> rooms = roomService.getRooms();

            System.out.println("Since: ");
            LocalDate since = createDate();
            
            System.out.println("Until: ");
            LocalDate until = createDate();
            
            System.out.println("List room ");
            for (Room room : rooms) {
                System.out.println("•Room " + room.getNumber());
            }
            System.out.print("Select number room: ");
            Room room = roomService.getRoomByNumber(read.nextInt());
            System.out.println("List turist: ");
            for (Turist turist : turists) {
                System.out.println("•Turist's name: " + turist.getName());
            }
            System.out.println("Select name turist: ");
            Turist turist = turistService.getTuristByName(read.next());
            
            createReservation(since, until, turist, room);
            
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public void showReservations() throws HotelException {
        try {
            List<Reservation> reservations = reservationDAO.showReservations();
            if(reservations.isEmpty()){
                System.out.println("Reservations not found");
            } else {
                System.out.println("----- RESERVATION LIST -----");
                System.out.printf("%-5s%-15s%-15s%-20s%-20s%-20s%-20s\n", "ID", "SINCE", "UNTIL", "TURIST", "ROOM", "HOTEL", "ADDRESS");
                reservations.forEach((reservation) -> {
                    System.out.printf("%-5s%-15s%-15s%-20s%-20s%-20s%-20s\n", reservation.getId(), reservation.getSince(), reservation.getUntil(), reservation.getTurist().getName(), reservation.getRoom().getNumber(), reservation.getRoom().getHotel().getName(), reservation.getRoom().getHotel().getAddress());
                });
            }
        } catch (HotelException e) {
            throw e;
        }
    }

    private LocalDate createDate() {
        System.out.print("Day: ");
        Integer day = read.nextInt();
        System.out.print("Month: ");
        Integer month = read.nextInt();
        System.out.print("Year: ");
        Integer year = read.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

}
