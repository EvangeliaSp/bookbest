package entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Facility {
    private int id;
    private byte[] petsAllowed;
    private byte[] parking;
    private byte[] nonSmokingRooms;
    private byte[] roomService;
    private byte[] restaurant;
    private byte[] forDisabledGuests;
    private byte[] freeWifi;
    private byte[] fitnessCentre;
    private byte[] familyRooms;
    private byte[] swimmingPool;
    private byte[] spaAndWellnessCentre;
    private byte[] airportShuttle;
    private byte[] reception24Hour;
    private byte[] sauna;
    private byte[] massage;
    private byte[] bicycleRental;
    private byte[] cycling;
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
    public byte[] getPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(byte[] petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    @Basic
    @Column(name = "parking", nullable = true)
    public byte[] getParking() {
        return parking;
    }

    public void setParking(byte[] parking) {
        this.parking = parking;
    }

    @Basic
    @Column(name = "non_smoking_rooms", nullable = true)
    public byte[] getNonSmokingRooms() {
        return nonSmokingRooms;
    }

    public void setNonSmokingRooms(byte[] nonSmokingRooms) {
        this.nonSmokingRooms = nonSmokingRooms;
    }

    @Basic
    @Column(name = "room_service", nullable = true)
    public byte[] getRoomService() {
        return roomService;
    }

    public void setRoomService(byte[] roomService) {
        this.roomService = roomService;
    }

    @Basic
    @Column(name = "restaurant", nullable = true)
    public byte[] getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(byte[] restaurant) {
        this.restaurant = restaurant;
    }

    @Basic
    @Column(name = "for_disabled_guests", nullable = true)
    public byte[] getForDisabledGuests() {
        return forDisabledGuests;
    }

    public void setForDisabledGuests(byte[] forDisabledGuests) {
        this.forDisabledGuests = forDisabledGuests;
    }

    @Basic
    @Column(name = "free_wifi", nullable = true)
    public byte[] getFreeWifi() {
        return freeWifi;
    }

    public void setFreeWifi(byte[] freeWifi) {
        this.freeWifi = freeWifi;
    }

    @Basic
    @Column(name = "fitness_centre", nullable = true)
    public byte[] getFitnessCentre() {
        return fitnessCentre;
    }

    public void setFitnessCentre(byte[] fitnessCentre) {
        this.fitnessCentre = fitnessCentre;
    }

    @Basic
    @Column(name = "family_rooms", nullable = true)
    public byte[] getFamilyRooms() {
        return familyRooms;
    }

    public void setFamilyRooms(byte[] familyRooms) {
        this.familyRooms = familyRooms;
    }

    @Basic
    @Column(name = "swimming_pool", nullable = true)
    public byte[] getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(byte[] swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Basic
    @Column(name = "spa_and_wellness_centre", nullable = true)
    public byte[] getSpaAndWellnessCentre() {
        return spaAndWellnessCentre;
    }

    public void setSpaAndWellnessCentre(byte[] spaAndWellnessCentre) {
        this.spaAndWellnessCentre = spaAndWellnessCentre;
    }

    @Basic
    @Column(name = "airport_shuttle", nullable = true)
    public byte[] getAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(byte[] airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    @Basic
    @Column(name = "reception_24-hour", nullable = true)
    public byte[] getReception24Hour() {
        return reception24Hour;
    }

    public void setReception24Hour(byte[] reception24Hour) {
        this.reception24Hour = reception24Hour;
    }

    @Basic
    @Column(name = "sauna", nullable = true)
    public byte[] getSauna() {
        return sauna;
    }

    public void setSauna(byte[] sauna) {
        this.sauna = sauna;
    }

    @Basic
    @Column(name = "massage", nullable = true)
    public byte[] getMassage() {
        return massage;
    }

    public void setMassage(byte[] massage) {
        this.massage = massage;
    }

    @Basic
    @Column(name = "bicycle_rental", nullable = true)
    public byte[] getBicycleRental() {
        return bicycleRental;
    }

    public void setBicycleRental(byte[] bicycleRental) {
        this.bicycleRental = bicycleRental;
    }

    @Basic
    @Column(name = "cycling", nullable = true)
    public byte[] getCycling() {
        return cycling;
    }

    public void setCycling(byte[] cycling) {
        this.cycling = cycling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        if (id != facility.id) return false;
        if (!Arrays.equals(petsAllowed, facility.petsAllowed)) return false;
        if (!Arrays.equals(parking, facility.parking)) return false;
        if (!Arrays.equals(nonSmokingRooms, facility.nonSmokingRooms)) return false;
        if (!Arrays.equals(roomService, facility.roomService)) return false;
        if (!Arrays.equals(restaurant, facility.restaurant)) return false;
        if (!Arrays.equals(forDisabledGuests, facility.forDisabledGuests)) return false;
        if (!Arrays.equals(freeWifi, facility.freeWifi)) return false;
        if (!Arrays.equals(fitnessCentre, facility.fitnessCentre)) return false;
        if (!Arrays.equals(familyRooms, facility.familyRooms)) return false;
        if (!Arrays.equals(swimmingPool, facility.swimmingPool)) return false;
        if (!Arrays.equals(spaAndWellnessCentre, facility.spaAndWellnessCentre)) return false;
        if (!Arrays.equals(airportShuttle, facility.airportShuttle)) return false;
        if (!Arrays.equals(reception24Hour, facility.reception24Hour)) return false;
        if (!Arrays.equals(sauna, facility.sauna)) return false;
        if (!Arrays.equals(massage, facility.massage)) return false;
        if (!Arrays.equals(bicycleRental, facility.bicycleRental)) return false;
        if (!Arrays.equals(cycling, facility.cycling)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(petsAllowed);
        result = 31 * result + Arrays.hashCode(parking);
        result = 31 * result + Arrays.hashCode(nonSmokingRooms);
        result = 31 * result + Arrays.hashCode(roomService);
        result = 31 * result + Arrays.hashCode(restaurant);
        result = 31 * result + Arrays.hashCode(forDisabledGuests);
        result = 31 * result + Arrays.hashCode(freeWifi);
        result = 31 * result + Arrays.hashCode(fitnessCentre);
        result = 31 * result + Arrays.hashCode(familyRooms);
        result = 31 * result + Arrays.hashCode(swimmingPool);
        result = 31 * result + Arrays.hashCode(spaAndWellnessCentre);
        result = 31 * result + Arrays.hashCode(airportShuttle);
        result = 31 * result + Arrays.hashCode(reception24Hour);
        result = 31 * result + Arrays.hashCode(sauna);
        result = 31 * result + Arrays.hashCode(massage);
        result = 31 * result + Arrays.hashCode(bicycleRental);
        result = 31 * result + Arrays.hashCode(cycling);
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
