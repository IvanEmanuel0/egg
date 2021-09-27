/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.service;

import hoteleria.entidad.Hotel;
import hoteleria.entidad.Room;
import hoteleria.enums.RoomType;
import hoteleria.exception.HotelException;
import hoteleria.persistencia.RoomDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomService {
    
    private Scanner read;
    private RoomDAO roomDAO;
    private HotelService hotelService;
    
    public RoomService() {
        read = new Scanner(System.in).useDelimiter("\n");
        roomDAO = new RoomDAO();
        hotelService = new HotelService();
    }
    
    public void createRoom(Integer number, Boolean privateBathroom, String telephone, Boolean heating, RoomType roomType, Hotel hotel) throws HotelException {
        try {
            Room room = new Room();
            
            room.setNumber(number);
            room.setPrivateBathroom(privateBathroom);
            room.setTelephone(telephone);
            room.setHeating(heating);
            room.setRoomType(roomType);
            room.setHotel(hotel);
            
            roomDAO.storeRoom(room);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void dataEntry() throws HotelException {
        int i = 1;
        
        try {
            List<Hotel>hotels = hotelService.getHotels();
            
            System.out.println("----- REGISTER ROOM -----\n");
            System.out.print("Number: ");
            Integer number = read.nextInt();
            System.out.print("Private bathroom [Y/N]: ");
            String answer = read.next();
            Boolean privateRoom = answer.equalsIgnoreCase("Y");
            System.out.print("Telephone: ");
            String telephone = read.next();
            System.out.print("Heating [Y/N]: ");
            answer = read.next();
            Boolean heating = answer.equalsIgnoreCase("Y");
            System.out.println("Select room type ");
            for (RoomType roomType : RoomType.values()) {
                System.out.println(i+". " + roomType);
                i++;
            }
            System.out.print("Room type number: ");
            Integer position = read.nextInt();
            RoomType roomType = RoomType.values()[position];
            System.out.println("Select hotel ");
            for (Hotel hotel : hotels) {
                System.out.println(hotel.getId() + ". " + hotel.getName());
            }
            System.out.print("Hotel number: ");
            position = read.nextInt();
            Hotel hotel = hotelService.searchHotelById(position);
            
            createRoom(number, privateRoom, telephone, heating, roomType, hotel);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void showRooms() throws HotelException {
        try {
            List<Room> rooms = roomDAO.showRooms();
            if(rooms.isEmpty()){
                System.out.println("Not found rooms");
            } else {
                System.out.println("----- LIST ROOM -----");
                System.out.printf("%-5s%-15s%-17s%-15s%-15s%-15s%-15s\n", "ID", "NUMBER", "PRIVATE BATHROOM", "TELEPHONE", "HEATING", "TYPE ROOM", "HOTEL");
                for (Room room : rooms) {
                    System.out.printf("%-5s%-15s%-17s%-15s%-15s%-15s%-15s\n",room.getId(), room.getNumber(), room.getPrivateBathroom(), room.getTelephone(), room.getHeating(), room.getRoomType(), room.getHotel().getName());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Room> getRooms() throws HotelException {
        try {
            List<Room> rooms = roomDAO.showRooms();
            return rooms;
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public Room getRoomByNumber(Integer number) throws HotelException {
        try {
            Room room = roomDAO.searchRoomByNumber(number);
            return room;
        } catch (HotelException e) {
            throw e;
        }
    }
    
}
