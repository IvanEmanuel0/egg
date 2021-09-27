package hoteleria.persistencia;

import hoteleria.entidad.Turist;
import hoteleria.exception.HotelException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TuristDAO {
    
    private EntityManager em;
    
    public TuristDAO() {
        em = Persistence.createEntityManagerFactory("HoteleriaPU").createEntityManager();
    }
    
    public void storeTurist(Turist t) throws HotelException {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR storing turist");
        }
    }
    
    public void updateTurist(Turist t) throws HotelException {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR updating turist");
        }
    }
    
    public void removeTurist(Turist t) throws HotelException {
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new HotelException("ERROR deleting turist");
        }
    }
    
    public List<Turist> showTurist() throws HotelException {
        try {
            List<Turist> turists = em.createQuery("SELECT t FROM Turist t", Turist.class).getResultList();
            return turists;
        } catch (Exception e) {
            throw new HotelException("ERROR showing turists");
        }
    }
    
    public Turist searchTuristByName(String name) throws HotelException {
        try {
            Turist turist = em.createQuery("SELECT t FROM Turist t WHERE t.name = :name", Turist.class).setParameter("name", name).getSingleResult();
            return turist;
        } catch (Exception e) {
            throw new HotelException("ERROR searching turist by name");
        }
    }
    
}
