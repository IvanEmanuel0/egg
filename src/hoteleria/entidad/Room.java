package hoteleria.entidad;

import hoteleria.enums.RoomType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
    private Boolean privateBathroom;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private Boolean heating;
    @Column(nullable = false)
    private RoomType roomType;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel hotel;
    

    public Room() {
    }

    public Room(Integer id, Integer number, Boolean privateBathroom, String telephone, Boolean heating, RoomType roomType, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.privateBathroom = privateBathroom;
        this.telephone = telephone;
        this.heating = heating;
        this.roomType = roomType;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getPrivateBathroom() {
        return privateBathroom;
    }

    public void setPrivateBathroom(Boolean privateBathroom) {
        this.privateBathroom = privateBathroom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getHeating() {
        return heating;
    }

    public void setHeating(Boolean heating) {
        this.heating = heating;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
