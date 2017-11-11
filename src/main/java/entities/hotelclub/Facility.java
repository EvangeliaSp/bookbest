package entities.hotelclub;

import javax.persistence.*;

@Entity
public class Facility {
    private int id;
    private Byte airportTransfer;
    private Byte bar;
    private Byte businessFacilities;
    private Byte childcare;
    private Byte connectingRoomsAvailable;
    private Byte cribsAvailable;
    private Byte freeBreakfast;
    private Byte freeParking;
    private Byte freeWifi;
    private Byte gym;
    private Byte petFriendly;
    private Byte pool;
    private Byte restaurant;
    private Byte smokingAreas;
    private Byte spa;
    private Byte bathtubInRoom;
    private Byte kitchen;
    private Byte accessibleBathroom;
    private Byte inRoomAccessebility;
    private Byte rollInShower;
    private Byte wheelchairAccess;
    private Byte familyFriendly;
    private Byte business;
    private Byte romantic;
    private Byte adventure;
    private Byte luxury;
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
    @Column(name = "airport_transfer", nullable = true)
    public Byte getAirportTransfer() {
        return airportTransfer;
    }

    public void setAirportTransfer(Byte airportTransfer) {
        this.airportTransfer = airportTransfer;
    }

    @Basic
    @Column(name = "bar", nullable = true)
    public Byte getBar() {
        return bar;
    }

    public void setBar(Byte bar) {
        this.bar = bar;
    }

    @Basic
    @Column(name = "business_facilities", nullable = true)
    public Byte getBusinessFacilities() {
        return businessFacilities;
    }

    public void setBusinessFacilities(Byte businessFacilities) {
        this.businessFacilities = businessFacilities;
    }

    @Basic
    @Column(name = "childcare", nullable = true)
    public Byte getChildcare() {
        return childcare;
    }

    public void setChildcare(Byte childcare) {
        this.childcare = childcare;
    }

    @Basic
    @Column(name = "connecting_rooms_available", nullable = true)
    public Byte getConnectingRoomsAvailable() {
        return connectingRoomsAvailable;
    }

    public void setConnectingRoomsAvailable(Byte connectingRoomsAvailable) {
        this.connectingRoomsAvailable = connectingRoomsAvailable;
    }

    @Basic
    @Column(name = "cribs_available", nullable = true)
    public Byte getCribsAvailable() {
        return cribsAvailable;
    }

    public void setCribsAvailable(Byte cribsAvailable) {
        this.cribsAvailable = cribsAvailable;
    }

    @Basic
    @Column(name = "free_breakfast", nullable = true)
    public Byte getFreeBreakfast() {
        return freeBreakfast;
    }

    public void setFreeBreakfast(Byte freeBreakfast) {
        this.freeBreakfast = freeBreakfast;
    }

    @Basic
    @Column(name = "free_parking", nullable = true)
    public Byte getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(Byte freeParking) {
        this.freeParking = freeParking;
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
    @Column(name = "gym", nullable = true)
    public Byte getGym() {
        return gym;
    }

    public void setGym(Byte gym) {
        this.gym = gym;
    }

    @Basic
    @Column(name = "pet_friendly", nullable = true)
    public Byte getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(Byte petFriendly) {
        this.petFriendly = petFriendly;
    }

    @Basic
    @Column(name = "pool", nullable = true)
    public Byte getPool() {
        return pool;
    }

    public void setPool(Byte pool) {
        this.pool = pool;
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
    @Column(name = "smoking_areas", nullable = true)
    public Byte getSmokingAreas() {
        return smokingAreas;
    }

    public void setSmokingAreas(Byte smokingAreas) {
        this.smokingAreas = smokingAreas;
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
    @Column(name = "bathtub_in_room", nullable = true)
    public Byte getBathtubInRoom() {
        return bathtubInRoom;
    }

    public void setBathtubInRoom(Byte bathtubInRoom) {
        this.bathtubInRoom = bathtubInRoom;
    }

    @Basic
    @Column(name = "kitchen", nullable = true)
    public Byte getKitchen() {
        return kitchen;
    }

    public void setKitchen(Byte kitchen) {
        this.kitchen = kitchen;
    }

    @Basic
    @Column(name = "accessible_bathroom", nullable = true)
    public Byte getAccessibleBathroom() {
        return accessibleBathroom;
    }

    public void setAccessibleBathroom(Byte accessibleBathroom) {
        this.accessibleBathroom = accessibleBathroom;
    }

    @Basic
    @Column(name = "in_room_accessebility", nullable = true)
    public Byte getInRoomAccessebility() {
        return inRoomAccessebility;
    }

    public void setInRoomAccessebility(Byte inRoomAccessebility) {
        this.inRoomAccessebility = inRoomAccessebility;
    }

    @Basic
    @Column(name = "roll_in_shower", nullable = true)
    public Byte getRollInShower() {
        return rollInShower;
    }

    public void setRollInShower(Byte rollInShower) {
        this.rollInShower = rollInShower;
    }

    @Basic
    @Column(name = "wheelchair_access", nullable = true)
    public Byte getWheelchairAccess() {
        return wheelchairAccess;
    }

    public void setWheelchairAccess(Byte wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    @Basic
    @Column(name = "family_friendly", nullable = true)
    public Byte getFamilyFriendly() {
        return familyFriendly;
    }

    public void setFamilyFriendly(Byte familyFriendly) {
        this.familyFriendly = familyFriendly;
    }

    @Basic
    @Column(name = "business", nullable = true)
    public Byte getBusiness() {
        return business;
    }

    public void setBusiness(Byte business) {
        this.business = business;
    }

    @Basic
    @Column(name = "romantic", nullable = true)
    public Byte getRomantic() {
        return romantic;
    }

    public void setRomantic(Byte romantic) {
        this.romantic = romantic;
    }

    @Basic
    @Column(name = "adventure", nullable = true)
    public Byte getAdventure() {
        return adventure;
    }

    public void setAdventure(Byte adventure) {
        this.adventure = adventure;
    }

    @Basic
    @Column(name = "luxury", nullable = true)
    public Byte getLuxury() {
        return luxury;
    }

    public void setLuxury(Byte luxury) {
        this.luxury = luxury;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        if (id != facility.id) return false;
        if (airportTransfer != null ? !airportTransfer.equals(facility.airportTransfer) : facility.airportTransfer != null)
            return false;
        if (bar != null ? !bar.equals(facility.bar) : facility.bar != null) return false;
        if (businessFacilities != null ? !businessFacilities.equals(facility.businessFacilities) : facility.businessFacilities != null)
            return false;
        if (childcare != null ? !childcare.equals(facility.childcare) : facility.childcare != null) return false;
        if (connectingRoomsAvailable != null ? !connectingRoomsAvailable.equals(facility.connectingRoomsAvailable) : facility.connectingRoomsAvailable != null)
            return false;
        if (cribsAvailable != null ? !cribsAvailable.equals(facility.cribsAvailable) : facility.cribsAvailable != null)
            return false;
        if (freeBreakfast != null ? !freeBreakfast.equals(facility.freeBreakfast) : facility.freeBreakfast != null)
            return false;
        if (freeParking != null ? !freeParking.equals(facility.freeParking) : facility.freeParking != null)
            return false;
        if (freeWifi != null ? !freeWifi.equals(facility.freeWifi) : facility.freeWifi != null) return false;
        if (gym != null ? !gym.equals(facility.gym) : facility.gym != null) return false;
        if (petFriendly != null ? !petFriendly.equals(facility.petFriendly) : facility.petFriendly != null)
            return false;
        if (pool != null ? !pool.equals(facility.pool) : facility.pool != null) return false;
        if (restaurant != null ? !restaurant.equals(facility.restaurant) : facility.restaurant != null) return false;
        if (smokingAreas != null ? !smokingAreas.equals(facility.smokingAreas) : facility.smokingAreas != null)
            return false;
        if (spa != null ? !spa.equals(facility.spa) : facility.spa != null) return false;
        if (bathtubInRoom != null ? !bathtubInRoom.equals(facility.bathtubInRoom) : facility.bathtubInRoom != null)
            return false;
        if (kitchen != null ? !kitchen.equals(facility.kitchen) : facility.kitchen != null) return false;
        if (accessibleBathroom != null ? !accessibleBathroom.equals(facility.accessibleBathroom) : facility.accessibleBathroom != null)
            return false;
        if (inRoomAccessebility != null ? !inRoomAccessebility.equals(facility.inRoomAccessebility) : facility.inRoomAccessebility != null)
            return false;
        if (rollInShower != null ? !rollInShower.equals(facility.rollInShower) : facility.rollInShower != null)
            return false;
        if (wheelchairAccess != null ? !wheelchairAccess.equals(facility.wheelchairAccess) : facility.wheelchairAccess != null)
            return false;
        if (familyFriendly != null ? !familyFriendly.equals(facility.familyFriendly) : facility.familyFriendly != null)
            return false;
        if (business != null ? !business.equals(facility.business) : facility.business != null) return false;
        if (romantic != null ? !romantic.equals(facility.romantic) : facility.romantic != null) return false;
        if (adventure != null ? !adventure.equals(facility.adventure) : facility.adventure != null) return false;
        if (luxury != null ? !luxury.equals(facility.luxury) : facility.luxury != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (airportTransfer != null ? airportTransfer.hashCode() : 0);
        result = 31 * result + (bar != null ? bar.hashCode() : 0);
        result = 31 * result + (businessFacilities != null ? businessFacilities.hashCode() : 0);
        result = 31 * result + (childcare != null ? childcare.hashCode() : 0);
        result = 31 * result + (connectingRoomsAvailable != null ? connectingRoomsAvailable.hashCode() : 0);
        result = 31 * result + (cribsAvailable != null ? cribsAvailable.hashCode() : 0);
        result = 31 * result + (freeBreakfast != null ? freeBreakfast.hashCode() : 0);
        result = 31 * result + (freeParking != null ? freeParking.hashCode() : 0);
        result = 31 * result + (freeWifi != null ? freeWifi.hashCode() : 0);
        result = 31 * result + (gym != null ? gym.hashCode() : 0);
        result = 31 * result + (petFriendly != null ? petFriendly.hashCode() : 0);
        result = 31 * result + (pool != null ? pool.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        result = 31 * result + (smokingAreas != null ? smokingAreas.hashCode() : 0);
        result = 31 * result + (spa != null ? spa.hashCode() : 0);
        result = 31 * result + (bathtubInRoom != null ? bathtubInRoom.hashCode() : 0);
        result = 31 * result + (kitchen != null ? kitchen.hashCode() : 0);
        result = 31 * result + (accessibleBathroom != null ? accessibleBathroom.hashCode() : 0);
        result = 31 * result + (inRoomAccessebility != null ? inRoomAccessebility.hashCode() : 0);
        result = 31 * result + (rollInShower != null ? rollInShower.hashCode() : 0);
        result = 31 * result + (wheelchairAccess != null ? wheelchairAccess.hashCode() : 0);
        result = 31 * result + (familyFriendly != null ? familyFriendly.hashCode() : 0);
        result = 31 * result + (business != null ? business.hashCode() : 0);
        result = 31 * result + (romantic != null ? romantic.hashCode() : 0);
        result = 31 * result + (adventure != null ? adventure.hashCode() : 0);
        result = 31 * result + (luxury != null ? luxury.hashCode() : 0);
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