package hoteleria.entidad;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate since;
    @Column(nullable = false)
    private LocalDate until;
    @JoinColumn(nullable = false)
    //@ManyToOne
    private Turist turist;
    @JoinColumn(nullable = false)
    //@ManyToOne
    private Room room;

    public Reservation() {
    }

    public Reservation(Integer id, LocalDate since, LocalDate until, Turist turist, Room room) {
        this.id = id;
        this.since = since;
        this.until = until;
        this.turist = turist;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Turist getTurist() {
        return turist;
    }

    public void setTurist(Turist turist) {
        this.turist = turist;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
}
