/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.persistencia;

import hoteleria.entidad.Room;
import hoteleria.exception.HotelException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author alaga
 */
public class RoomDAO {
    
    private EntityManager em;
    
    public RoomDAO() {
        em = Persistence.createEntityManagerFactory("HoteleriaPU").createEntityManager();
    }
    
    public void storeRoom(Room r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR storing room");
        }
    }
    
    public void updateRoom(Room r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR updating room");
        }
    }
    
    public void removeRoom(Room r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR deleting room");
        }
    } 
    
    public List<Room> showRooms() throws HotelException {//getRooms
        try {
            List<Room> rooms = em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
            return rooms;
        } catch (Exception e) {
            throw new HotelException("ERROR showing rooms");
        }
    }
    
    public Room searchRoomByNumber(Integer number) throws HotelException {//findRoomByNumber
        try {
            Room room = em.createQuery("SELECT r FROM Room r where r.number = :number", Room.class).setParameter("number", number).getSingleResult();
            return room;
        } catch (Exception e) {
            throw new HotelException("ERROR searching room by number");
        }
    }
    
}
