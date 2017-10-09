package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
@Table(name = "Hotel", schema = "bookbest")//, catalog = "")
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idHotel;
    private String name;
    private String price;
    private String rating;
    private String distance;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idHotel")
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "distance")
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel that = (Hotel) o;

        if (idHotel != that.idHotel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHotel;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }
}
