/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.service;

import hoteleria.entidad.Hotel;
import hoteleria.entidad.Room;
import hoteleria.exception.HotelException;
import hoteleria.persistencia.HotelDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alaga
 */
public class HotelService {

    private Scanner read;
    private HotelDAO hotelDAO;
    
    public HotelService() {
        read = new Scanner(System.in).useDelimiter("\n");
        hotelDAO = new HotelDAO();
    }
    
    public void createHotel(String name, String address, String city, String neighborhood) throws HotelException {
        try {
            Hotel hotel = new Hotel();
            
            hotel.setName(name);
            hotel.setAddress(address);
            hotel.setNeighborhood(neighborhood);
            hotel.setCity(city);
            
            hotelDAO.storeHotel(hotel);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void dataEntry() throws HotelException {
        try {
            System.out.println("----- REGISTER HOTEL -----\n");
            System.out.print("Name: ");
            String name = read.next();
            System.out.print("Address: ");
            String address = read.next();
            System.out.print("Neighborhood: ");
            String neighborhood = read.next();
            System.out.print("City: ");
            String city = read.next();
            
            createHotel(name, address, city, neighborhood);
            
        } catch (Exception e) {
            throw e;
        }
    }

    public Hotel searchHotelById(Integer position) throws HotelException{
        try {
            Hotel hotel = hotelDAO.searchHotelById(position);
            return hotel;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Hotel> getHotels() throws HotelException {
        try {
            List<Hotel> hotels = hotelDAO.showHotel();
            return hotels;
        } catch (Exception e) {
            throw e;
        }
    }

    public void showHotels() throws HotelException {
        try {
            List<Hotel> hotels = hotelDAO.showHotel();
            if(hotels.isEmpty()){
                System.out.println("Not found hotels");
            } else {
                System.out.println("----- LIST HOTEL -----");
                System.out.printf("%-5s%-15s%-20s%-15s%-15s\n", "ID", "NOMBRE", "DIRECCION", "NEIGHBORHOOD", "CITY");
                hotels.forEach((hotel) -> {
                    System.out.printf("%-5s%-15s%-20s%-15s%-15s\n", hotel.getId(), hotel.getName(), hotel.getAddress(), hotel.getNeighborhood(), hotel.getCity());
                });
                System.out.println("");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
