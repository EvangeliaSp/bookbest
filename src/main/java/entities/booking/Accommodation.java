package entities.booking;

import javax.persistence.*;

@Entity
public class Accommodation {
    private int id;
    private String name;
    private String type;
    private Integer starRating;
    private int pricePerNight;
    private Double guestRating;
    private String country;
    private String city;
    private Double distanceFromCityCenter;
    private Double guestLocationRating;
    private String roomType;
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
    @Column(name = "guestRating", nullable = true, precision = 0)
    public Double getGuestRating() {
        return guestRating;
    }

    public void setGuestRating(Double guestRating) {
        this.guestRating = guestRating;
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
    @Column(name = "distanceFromCityCenter", nullable = true, precision = 0)
    public Double getDistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    public void setDistanceFromCityCenter(Double distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    @Basic
    @Column(name = "guestLocationRating", nullable = true, precision = 0)
    public Double getGuestLocationRating() {
        return guestLocationRating;
    }

    public void setGuestLocationRating(Double guestLocationRating) {
        this.guestLocationRating = guestLocationRating;
    }

    @Basic
    @Column(name = "roomType", nullable = true, length = 255)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
        if (guestRating != null ? !guestRating.equals(that.guestRating) : that.guestRating != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (distanceFromCityCenter != null ? !distanceFromCityCenter.equals(that.distanceFromCityCenter) : that.distanceFromCityCenter != null)
            return false;
        if (guestLocationRating != null ? !guestLocationRating.equals(that.guestLocationRating) : that.guestLocationRating != null)
            return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + pricePerNight;
        result = 31 * result + (guestRating != null ? guestRating.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (distanceFromCityCenter != null ? distanceFromCityCenter.hashCode() : 0);
        result = 31 * result + (guestLocationRating != null ? guestLocationRating.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
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
