package entities;

import javax.persistence.*;

@Entity
public class AccommodationRoom {
    private int id;
    private int pricePerNight;
    private int rating;
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
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccommodationRoom that = (AccommodationRoom) o;

        if (id != that.id) return false;
        if (pricePerNight != that.pricePerNight) return false;
        if (rating != that.rating) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pricePerNight;
        result = 31 * result + rating;
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
