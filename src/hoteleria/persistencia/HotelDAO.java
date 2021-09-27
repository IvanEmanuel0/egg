/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteleria.persistencia;

import hoteleria.entidad.Hotel;
import hoteleria.exception.HotelException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author alaga
 */
public class HotelDAO {
    
    private EntityManager em;
    
    public HotelDAO() {
        em = Persistence.createEntityManagerFactory("HoteleriaPU").createEntityManager();
    }
    
    public void storeHotel(Hotel h) throws HotelException {
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR storing hotel");
        }
    }
    
    public void updateHotel(Hotel h) throws HotelException {
        try {
            em.getTransaction().begin();
            em.merge(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR updating hotel");
        }
    }
    
    public void removeHotel(Hotel h) throws HotelException {
        try {
            em.getTransaction().begin();
            em.remove(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR deleting hotel");
        }
    }
    
    public List<Hotel> showHotel() throws HotelException {
        try {
            List<Hotel> hotels = em.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList();
            return hotels;
        } catch (Exception e) {
            throw new HotelException("ERROR showing hotels");
        }
    }
    
    public Hotel searchHotelById(Integer id) throws HotelException {
        try {
            Hotel hotel = em.find(Hotel.class, id);
            return hotel;
        } catch (Exception e) {
            throw new HotelException("ERROR searching hotel by id");
        }
    }
    
}
