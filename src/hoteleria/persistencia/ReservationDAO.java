package hoteleria.persistencia;

import hoteleria.entidad.Reservation;
import hoteleria.exception.HotelException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ReservationDAO {

    private EntityManager em;
    
    public ReservationDAO() {
        em = Persistence.createEntityManagerFactory("HoteleriaPU").createEntityManager();
    }
    
    public void storeReservation(Reservation r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR storing reservation");
        }
    }
    
    public void updateReservation(Reservation r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR updating reservation");
        }
    }
    
    public void removeReservation(Reservation r) throws HotelException {
        try {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR deleting reservation");
        }
    }
    
    public List<Reservation> showReservations() throws HotelException {//get
        try {
            List<Reservation> reservations = em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
            return reservations;
        } catch (Exception e) {
            throw new HotelException("ERROR showing reservations");
        }
    }
    
    public List<Reservation> searchReservationByTurist(String nombre) throws HotelException {//find
        try {
            List<Reservation> reservations = em.createQuery("SELECT r FROM Reservation r WHERE r.turist.name = :nombre", Reservation.class).setParameter("nombre", nombre).getResultList();
            return reservations;
        } catch (Exception e) {
            throw new HotelException("ERROR searching reservations by turist");
        }
    }
    
}
