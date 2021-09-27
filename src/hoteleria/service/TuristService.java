/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.service;

import hoteleria.entidad.Turist;
import hoteleria.exception.HotelException;
import hoteleria.persistencia.TuristDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alaga
 */
public class TuristService {
    
    private Scanner read;
    private TuristDAO turistDAO;
    
    public TuristService() {
        read = new Scanner(System.in).useDelimiter("\n");
        turistDAO = new TuristDAO(); 
    }
    
    public void createTurist(String name, String address, String profession, String maritalStatus) throws HotelException {
        try {
            Turist turist = new Turist(name, address, profession, maritalStatus);         
            turistDAO.storeTurist(turist);           
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public void dataEntry() throws HotelException {
        try {
            System.out.println("----- REGISTER TURIST -----\n");
            System.out.print("Name: ");
            String name = read.next();
            System.out.print("Address: ");
            String address = read.next();
            System.out.print("Profession: ");
            String profession = read.next();
            System.out.print("Marital Status: ");
            String maritalStatus = read.next();
            
            createTurist(name, address, profession, maritalStatus);
            
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public void showTurist() throws HotelException {
        try {
            List<Turist> turists = turistDAO.showTurist();
            if(turists.isEmpty()){
                System.out.println("Not found turists");
            } else {
                System.out.println("----- LIST TURIST -----");
                System.out.printf("%-5s%-25s%-25s%-25s%-15s\n", "ID", "NAME", "ADDRESS", "PROFESSION", "MARITAL STATUS");
                turists.forEach((turist) -> {
                    System.out.printf("%-5s%-25s%-25s%-25s%-15s\n", turist.getId(), turist.getName(), turist.getAddress(), turist.getProfession(), turist.getMaritalStatus());
                });
                System.out.println("\n");
            }   
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public List<Turist> getTurists() throws HotelException {
        try {
            List<Turist> turists = turistDAO.showTurist();
            return turists;
        } catch (HotelException e) {
            throw e;
        }
    }
    
    public Turist getTuristByName(String name) throws HotelException {
        try {
            Turist turist = turistDAO.searchTuristByName(name);
            return turist;
        } catch (HotelException e) {
            throw e;
        }
    }
    
}
