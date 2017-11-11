package entities.priceline;

import javax.persistence.*;

@Entity
public class Accommodation {
    private int id;
    private String name;
    private String type;
    private Integer starRating;
    private int pricePerNight;
    private String country;
    private String city;
    private Integer people;
    private Double location;
    private Double guestRating;
    private Facility facilityById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "starRating", nullable = true)
    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    @Basic
    @Column(name = "pricePerNight", nullable = false)
    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "people", nullable = true)
    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    @Basic
    @Column(name = "location", nullable = true, precision = 0)
    public Double getLocation() {
        return location;
    }

    public void setLocation(Double location) {
        this.location = location;
    }

    @Basic
    @Column(name = "guestRating", nullable = true, precision = 0)
    public Double getGuestRating() {
        return guestRating;
    }

    public void setGuestRating(Double guestRating) {
        this.guestRating = guestRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        if (id != that.id) return false;
        if (pricePerNight != that.pricePerNight) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (starRating != null ? !starRating.equals(that.starRating) : that.starRating != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (people != null ? !people.equals(that.people) : that.people != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (guestRating != null ? !guestRating.equals(that.guestRating) : that.guestRating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + pricePerNight;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (people != null ? people.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (guestRating != null ? guestRating.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "accommodationById")
    public Facility getFacilityById() {
        return facilityById;
    }

    public void setFacilityById(Facility facilityById) {
        this.facilityById = facilityById;
    }
}