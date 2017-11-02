package entities;

import javax.persistence.*;

@Entity
public class Room {
    private int id;
    private int pricePerNight;
    private double rating;
    private Accommodation accommodationByAccId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price_per_night", nullable = false)
    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Basic
    @Column(name = "rating", nullable = false, precision = 0)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (pricePerNight != room.pricePerNight) return false;
        if (Double.compare(room.rating, rating) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + pricePerNight;
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "id", nullable = false)
    public Accommodation getAccommodationByAccId() {
        return accommodationByAccId;
    }

    public void setAccommodationByAccId(Accommodation accommodationByAccId) {
        this.accommodationByAccId = accommodationByAccId;
    }
}
