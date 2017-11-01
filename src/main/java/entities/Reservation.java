package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reservation {
    private int id;
    private Date arrival;
    private Date departure;
    private AccommodationRoom accommodationRoomByRoomId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "arrival", nullable = false)
    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    @Basic
    @Column(name = "departure", nullable = false)
    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (arrival != null ? !arrival.equals(that.arrival) : that.arrival != null) return false;
        if (departure != null ? !departure.equals(that.departure) : that.departure != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    public AccommodationRoom getAccommodationRoomByRoomId() {
        return accommodationRoomByRoomId;
    }

    public void setAccommodationRoomByRoomId(AccommodationRoom accommodationRoomByRoomId) {
        this.accommodationRoomByRoomId = accommodationRoomByRoomId;
    }
}
