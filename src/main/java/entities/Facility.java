package entities;

import javax.persistence.*;

@Entity
public class Facility {
    private int id;
    private Byte petsAllowed;
    private Byte parking;
    private Byte nonSmokingRooms;
    private Byte roomService;
    private Byte restaurant;
    private Byte forDisabledGuests;
    private Byte freeWifi;
    private Byte fitnessCentre;
    private Byte familyRooms;
    private Byte swimmingPool;
    private Byte spaAndWellnessCentre;
    private Byte airportShuttle;
    private Byte reception24Hour;
    private Byte sauna;
    private Byte massage;
    private Byte bicycleRental;
    private Byte cycling;
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
    @Column(name = "pets_allowed", nullable = true)
    public Byte getPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(Byte petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    @Basic
    @Column(name = "parking", nullable = true)
    public Byte getParking() {
        return parking;
    }

    public void setParking(Byte parking) {
        this.parking = parking;
    }

    @Basic
    @Column(name = "non_smoking_rooms", nullable = true)
    public Byte getNonSmokingRooms() {
        return nonSmokingRooms;
    }

    public void setNonSmokingRooms(Byte nonSmokingRooms) {
        this.nonSmokingRooms = nonSmokingRooms;
    }

    @Basic
    @Column(name = "room_service", nullable = true)
    public Byte getRoomService() {
        return roomService;
    }

    public void setRoomService(Byte roomService) {
        this.roomService = roomService;
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
    @Column(name = "for_disabled_guests", nullable = true)
    public Byte getForDisabledGuests() {
        return forDisabledGuests;
    }

    public void setForDisabledGuests(Byte forDisabledGuests) {
        this.forDisabledGuests = forDisabledGuests;
    }

    @Basic
    @Column(name = "free_wifi", nullable = true)
    public Byte getFreeWifi() {
        return freeWifi;
    }

    public void setFreeWifi(Byte freeWifi) {
        this.freeWifi = freeWifi;
    }

    @Basic
    @Column(name = "fitness_centre", nullable = true)
    public Byte getFitnessCentre() {
        return fitnessCentre;
    }

    public void setFitnessCentre(Byte fitnessCentre) {
        this.fitnessCentre = fitnessCentre;
    }

    @Basic
    @Column(name = "family_rooms", nullable = true)
    public Byte getFamilyRooms() {
        return familyRooms;
    }

    public void setFamilyRooms(Byte familyRooms) {
        this.familyRooms = familyRooms;
    }

    @Basic
    @Column(name = "swimming_pool", nullable = true)
    public Byte getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Byte swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Basic
    @Column(name = "spa_and_wellness_centre", nullable = true)
    public Byte getSpaAndWellnessCentre() {
        return spaAndWellnessCentre;
    }

    public void setSpaAndWellnessCentre(Byte spaAndWellnessCentre) {
        this.spaAndWellnessCentre = spaAndWellnessCentre;
    }

    @Basic
    @Column(name = "airport_shuttle", nullable = true)
    public Byte getAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(Byte airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    @Basic
    @Column(name = "reception_24-hour", nullable = true)
    public Byte getReception24Hour() {
        return reception24Hour;
    }

    public void setReception24Hour(Byte reception24Hour) {
        this.reception24Hour = reception24Hour;
    }

    @Basic
    @Column(name = "sauna", nullable = true)
    public Byte getSauna() {
        return sauna;
    }

    public void setSauna(Byte sauna) {
        this.sauna = sauna;
    }

    @Basic
    @Column(name = "massage", nullable = true)
    public Byte getMassage() {
        return massage;
    }

    public void setMassage(Byte massage) {
        this.massage = massage;
    }

    @Basic
    @Column(name = "bicycle_rental", nullable = true)
    public Byte getBicycleRental() {
        return bicycleRental;
    }

    public void setBicycleRental(Byte bicycleRental) {
        this.bicycleRental = bicycleRental;
    }

    @Basic
    @Column(name = "cycling", nullable = true)
    public Byte getCycling() {
        return cycling;
    }

    public void setCycling(Byte cycling) {
        this.cycling = cycling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        if (id != facility.id) return false;
        if (petsAllowed != null ? !petsAllowed.equals(facility.petsAllowed) : facility.petsAllowed != null)
            return false;
        if (parking != null ? !parking.equals(facility.parking) : facility.parking != null) return false;
        if (nonSmokingRooms != null ? !nonSmokingRooms.equals(facility.nonSmokingRooms) : facility.nonSmokingRooms != null)
            return false;
        if (roomService != null ? !roomService.equals(facility.roomService) : facility.roomService != null)
            return false;
        if (restaurant != null ? !restaurant.equals(facility.restaurant) : facility.restaurant != null) return false;
        if (forDisabledGuests != null ? !forDisabledGuests.equals(facility.forDisabledGuests) : facility.forDisabledGuests != null)
            return false;
        if (freeWifi != null ? !freeWifi.equals(facility.freeWifi) : facility.freeWifi != null) return false;
        if (fitnessCentre != null ? !fitnessCentre.equals(facility.fitnessCentre) : facility.fitnessCentre != null)
            return false;
        if (familyRooms != null ? !familyRooms.equals(facility.familyRooms) : facility.familyRooms != null)
            return false;
        if (swimmingPool != null ? !swimmingPool.equals(facility.swimmingPool) : facility.swimmingPool != null)
            return false;
        if (spaAndWellnessCentre != null ? !spaAndWellnessCentre.equals(facility.spaAndWellnessCentre) : facility.spaAndWellnessCentre != null)
            return false;
        if (airportShuttle != null ? !airportShuttle.equals(facility.airportShuttle) : facility.airportShuttle != null)
            return false;
        if (reception24Hour != null ? !reception24Hour.equals(facility.reception24Hour) : facility.reception24Hour != null)
            return false;
        if (sauna != null ? !sauna.equals(facility.sauna) : facility.sauna != null) return false;
        if (massage != null ? !massage.equals(facility.massage) : facility.massage != null) return false;
        if (bicycleRental != null ? !bicycleRental.equals(facility.bicycleRental) : facility.bicycleRental != null)
            return false;
        if (cycling != null ? !cycling.equals(facility.cycling) : facility.cycling != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (petsAllowed != null ? petsAllowed.hashCode() : 0);
        result = 31 * result + (parking != null ? parking.hashCode() : 0);
        result = 31 * result + (nonSmokingRooms != null ? nonSmokingRooms.hashCode() : 0);
        result = 31 * result + (roomService != null ? roomService.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        result = 31 * result + (forDisabledGuests != null ? forDisabledGuests.hashCode() : 0);
        result = 31 * result + (freeWifi != null ? freeWifi.hashCode() : 0);
        result = 31 * result + (fitnessCentre != null ? fitnessCentre.hashCode() : 0);
        result = 31 * result + (familyRooms != null ? familyRooms.hashCode() : 0);
        result = 31 * result + (swimmingPool != null ? swimmingPool.hashCode() : 0);
        result = 31 * result + (spaAndWellnessCentre != null ? spaAndWellnessCentre.hashCode() : 0);
        result = 31 * result + (airportShuttle != null ? airportShuttle.hashCode() : 0);
        result = 31 * result + (reception24Hour != null ? reception24Hour.hashCode() : 0);
        result = 31 * result + (sauna != null ? sauna.hashCode() : 0);
        result = 31 * result + (massage != null ? massage.hashCode() : 0);
        result = 31 * result + (bicycleRental != null ? bicycleRental.hashCode() : 0);
        result = 31 * result + (cycling != null ? cycling.hashCode() : 0);
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
