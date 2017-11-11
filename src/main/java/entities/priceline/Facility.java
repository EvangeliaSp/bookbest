package entities.priceline;

import javax.persistence.*;

@Entity
public class Facility {
    private int id;
    private Byte freeInternet;
    private Byte freeParking;
    private Byte freeBreakfast;
    private Byte petsAllowed;
    private Byte swimmingPool;
    private Byte airportShuttle;
    private Byte noSmokingRoomsFacilities;
    private Byte fitnessCenter;
    private Byte handicappedRoomsFacilities;
    private Byte businessCenter;
    private Byte casino;
    private Byte spa;
    private Byte restaurant;
    private Byte freeCancellation;
    private Byte payLater;
    private Accommodation accommodationById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "freeInternet", nullable = true)
    public Byte getFreeInternet() {
        return freeInternet;
    }

    public void setFreeInternet(Byte freeInternet) {
        this.freeInternet = freeInternet;
    }

    @Basic
    @Column(name = "freeParking", nullable = true)
    public Byte getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(Byte freeParking) {
        this.freeParking = freeParking;
    }

    @Basic
    @Column(name = "freeBreakfast", nullable = true)
    public Byte getFreeBreakfast() {
        return freeBreakfast;
    }

    public void setFreeBreakfast(Byte freeBreakfast) {
        this.freeBreakfast = freeBreakfast;
    }

    @Basic
    @Column(name = "petsAllowed", nullable = true)
    public Byte getPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(Byte petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    @Basic
    @Column(name = "swimmingPool", nullable = true)
    public Byte getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Byte swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Basic
    @Column(name = "airportShuttle", nullable = true)
    public Byte getAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(Byte airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    @Basic
    @Column(name = "noSmokingRoomsFacilities", nullable = true)
    public Byte getNoSmokingRoomsFacilities() {
        return noSmokingRoomsFacilities;
    }

    public void setNoSmokingRoomsFacilities(Byte noSmokingRoomsFacilities) {
        this.noSmokingRoomsFacilities = noSmokingRoomsFacilities;
    }

    @Basic
    @Column(name = "fitnessCenter", nullable = true)
    public Byte getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(Byte fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    @Basic
    @Column(name = "handicappedRoomsFacilities", nullable = true)
    public Byte getHandicappedRoomsFacilities() {
        return handicappedRoomsFacilities;
    }

    public void setHandicappedRoomsFacilities(Byte handicappedRoomsFacilities) {
        this.handicappedRoomsFacilities = handicappedRoomsFacilities;
    }

    @Basic
    @Column(name = "businessCenter", nullable = true)
    public Byte getBusinessCenter() {
        return businessCenter;
    }

    public void setBusinessCenter(Byte businessCenter) {
        this.businessCenter = businessCenter;
    }

    @Basic
    @Column(name = "casino", nullable = true)
    public Byte getCasino() {
        return casino;
    }

    public void setCasino(Byte casino) {
        this.casino = casino;
    }

    @Basic
    @Column(name = "spa", nullable = true)
    public Byte getSpa() {
        return spa;
    }

    public void setSpa(Byte spa) {
        this.spa = spa;
    }

    @Basic
    @Column(name = "restaurant", nullable = true)
    public Byte getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Byte restaurant) {
        this.restaurant = restaurant;
    }

    @Basic
    @Column(name = "freeCancellation", nullable = true)
    public Byte getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Byte freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    @Basic
    @Column(name = "payLater", nullable = true)
    public Byte getPayLater() {
        return payLater;
    }

    public void setPayLater(Byte payLater) {
        this.payLater = payLater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        if (id != facility.id) return false;
        if (freeInternet != null ? !freeInternet.equals(facility.freeInternet) : facility.freeInternet != null)
            return false;
        if (freeParking != null ? !freeParking.equals(facility.freeParking) : facility.freeParking != null)
            return false;
        if (freeBreakfast != null ? !freeBreakfast.equals(facility.freeBreakfast) : facility.freeBreakfast != null)
            return false;
        if (petsAllowed != null ? !petsAllowed.equals(facility.petsAllowed) : facility.petsAllowed != null)
            return false;
        if (swimmingPool != null ? !swimmingPool.equals(facility.swimmingPool) : facility.swimmingPool != null)
            return false;
        if (airportShuttle != null ? !airportShuttle.equals(facility.airportShuttle) : facility.airportShuttle != null)
            return false;
        if (noSmokingRoomsFacilities != null ? !noSmokingRoomsFacilities.equals(facility.noSmokingRoomsFacilities) : facility.noSmokingRoomsFacilities != null)
            return false;
        if (fitnessCenter != null ? !fitnessCenter.equals(facility.fitnessCenter) : facility.fitnessCenter != null)
            return false;
        if (handicappedRoomsFacilities != null ? !handicappedRoomsFacilities.equals(facility.handicappedRoomsFacilities) : facility.handicappedRoomsFacilities != null)
            return false;
        if (businessCenter != null ? !businessCenter.equals(facility.businessCenter) : facility.businessCenter != null)
            return false;
        if (casino != null ? !casino.equals(facility.casino) : facility.casino != null) return false;
        if (spa != null ? !spa.equals(facility.spa) : facility.spa != null) return false;
        if (restaurant != null ? !restaurant.equals(facility.restaurant) : facility.restaurant != null) return false;
        if (freeCancellation != null ? !freeCancellation.equals(facility.freeCancellation) : facility.freeCancellation != null)
            return false;
        if (payLater != null ? !payLater.equals(facility.payLater) : facility.payLater != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (freeInternet != null ? freeInternet.hashCode() : 0);
        result = 31 * result + (freeParking != null ? freeParking.hashCode() : 0);
        result = 31 * result + (freeBreakfast != null ? freeBreakfast.hashCode() : 0);
        result = 31 * result + (petsAllowed != null ? petsAllowed.hashCode() : 0);
        result = 31 * result + (swimmingPool != null ? swimmingPool.hashCode() : 0);
        result = 31 * result + (airportShuttle != null ? airportShuttle.hashCode() : 0);
        result = 31 * result + (noSmokingRoomsFacilities != null ? noSmokingRoomsFacilities.hashCode() : 0);
        result = 31 * result + (fitnessCenter != null ? fitnessCenter.hashCode() : 0);
        result = 31 * result + (handicappedRoomsFacilities != null ? handicappedRoomsFacilities.hashCode() : 0);
        result = 31 * result + (businessCenter != null ? businessCenter.hashCode() : 0);
        result = 31 * result + (casino != null ? casino.hashCode() : 0);
        result = 31 * result + (spa != null ? spa.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        result = 31 * result + (freeCancellation != null ? freeCancellation.hashCode() : 0);
        result = 31 * result + (payLater != null ? payLater.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Accommodation getAccommodationById() {
        return accommodationById;
    }

    public void setAccommodationById(Accommodation accommodationById) {
        this.accommodationById = accommodationById;
    }
}
