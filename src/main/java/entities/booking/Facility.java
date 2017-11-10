package entities.booking;

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
    private Byte breakfastIncluded;
    private Byte breakfastAndDinner;
    private Byte selfCatering;
    private Byte freeCancellation;
    private Byte bookWithoutCreditCard;
    private Byte noPrepayment;
    private Byte airConditioning;
    private Byte bath;
    private Byte coffeeMachine;
    private Byte electricKettle;
    private Byte flatScreenTv;
    private Byte kitchenKitchenette;
    private Byte soundProofing;
    private Byte teaCoffeeMaker;
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

    @Basic
    @Column(name = "breakfast_included", nullable = true)
    public Byte getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(Byte breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    @Basic
    @Column(name = "breakfast_and_dinner", nullable = true)
    public Byte getBreakfastAndDinner() {
        return breakfastAndDinner;
    }

    public void setBreakfastAndDinner(Byte breakfastAndDinner) {
        this.breakfastAndDinner = breakfastAndDinner;
    }

    @Basic
    @Column(name = "self_catering", nullable = true)
    public Byte getSelfCatering() {
        return selfCatering;
    }

    public void setSelfCatering(Byte selfCatering) {
        this.selfCatering = selfCatering;
    }

    @Basic
    @Column(name = "free_cancellation", nullable = true)
    public Byte getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Byte freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    @Basic
    @Column(name = "book_without_credit_card", nullable = true)
    public Byte getBookWithoutCreditCard() {
        return bookWithoutCreditCard;
    }

    public void setBookWithoutCreditCard(Byte bookWithoutCreditCard) {
        this.bookWithoutCreditCard = bookWithoutCreditCard;
    }

    @Basic
    @Column(name = "no_prepayment", nullable = true)
    public Byte getNoPrepayment() {
        return noPrepayment;
    }

    public void setNoPrepayment(Byte noPrepayment) {
        this.noPrepayment = noPrepayment;
    }

    @Basic
    @Column(name = "air_conditioning", nullable = true)
    public Byte getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Byte airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Basic
    @Column(name = "bath", nullable = true)
    public Byte getBath() {
        return bath;
    }

    public void setBath(Byte bath) {
        this.bath = bath;
    }

    @Basic
    @Column(name = "coffee_machine", nullable = true)
    public Byte getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(Byte coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Basic
    @Column(name = "electric_kettle", nullable = true)
    public Byte getElectricKettle() {
        return electricKettle;
    }

    public void setElectricKettle(Byte electricKettle) {
        this.electricKettle = electricKettle;
    }

    @Basic
    @Column(name = "flat-screen_TV", nullable = true)
    public Byte getFlatScreenTv() {
        return flatScreenTv;
    }

    public void setFlatScreenTv(Byte flatScreenTv) {
        this.flatScreenTv = flatScreenTv;
    }

    @Basic
    @Column(name = "kitchen/kitchenette", nullable = true)
    public Byte getKitchenKitchenette() {
        return kitchenKitchenette;
    }

    public void setKitchenKitchenette(Byte kitchenKitchenette) {
        this.kitchenKitchenette = kitchenKitchenette;
    }

    @Basic
    @Column(name = "sound_proofing", nullable = true)
    public Byte getSoundProofing() {
        return soundProofing;
    }

    public void setSoundProofing(Byte soundProofing) {
        this.soundProofing = soundProofing;
    }

    @Basic
    @Column(name = "tea/coffee_maker", nullable = true)
    public Byte getTeaCoffeeMaker() {
        return teaCoffeeMaker;
    }

    public void setTeaCoffeeMaker(Byte teaCoffeeMaker) {
        this.teaCoffeeMaker = teaCoffeeMaker;
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
        if (breakfastIncluded != null ? !breakfastIncluded.equals(facility.breakfastIncluded) : facility.breakfastIncluded != null)
            return false;
        if (breakfastAndDinner != null ? !breakfastAndDinner.equals(facility.breakfastAndDinner) : facility.breakfastAndDinner != null)
            return false;
        if (selfCatering != null ? !selfCatering.equals(facility.selfCatering) : facility.selfCatering != null)
            return false;
        if (freeCancellation != null ? !freeCancellation.equals(facility.freeCancellation) : facility.freeCancellation != null)
            return false;
        if (bookWithoutCreditCard != null ? !bookWithoutCreditCard.equals(facility.bookWithoutCreditCard) : facility.bookWithoutCreditCard != null)
            return false;
        if (noPrepayment != null ? !noPrepayment.equals(facility.noPrepayment) : facility.noPrepayment != null)
            return false;
        if (airConditioning != null ? !airConditioning.equals(facility.airConditioning) : facility.airConditioning != null)
            return false;
        if (bath != null ? !bath.equals(facility.bath) : facility.bath != null) return false;
        if (coffeeMachine != null ? !coffeeMachine.equals(facility.coffeeMachine) : facility.coffeeMachine != null)
            return false;
        if (electricKettle != null ? !electricKettle.equals(facility.electricKettle) : facility.electricKettle != null)
            return false;
        if (flatScreenTv != null ? !flatScreenTv.equals(facility.flatScreenTv) : facility.flatScreenTv != null)
            return false;
        if (kitchenKitchenette != null ? !kitchenKitchenette.equals(facility.kitchenKitchenette) : facility.kitchenKitchenette != null)
            return false;
        if (soundProofing != null ? !soundProofing.equals(facility.soundProofing) : facility.soundProofing != null)
            return false;
        if (teaCoffeeMaker != null ? !teaCoffeeMaker.equals(facility.teaCoffeeMaker) : facility.teaCoffeeMaker != null)
            return false;

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
        result = 31 * result + (breakfastIncluded != null ? breakfastIncluded.hashCode() : 0);
        result = 31 * result + (breakfastAndDinner != null ? breakfastAndDinner.hashCode() : 0);
        result = 31 * result + (selfCatering != null ? selfCatering.hashCode() : 0);
        result = 31 * result + (freeCancellation != null ? freeCancellation.hashCode() : 0);
        result = 31 * result + (bookWithoutCreditCard != null ? bookWithoutCreditCard.hashCode() : 0);
        result = 31 * result + (noPrepayment != null ? noPrepayment.hashCode() : 0);
        result = 31 * result + (airConditioning != null ? airConditioning.hashCode() : 0);
        result = 31 * result + (bath != null ? bath.hashCode() : 0);
        result = 31 * result + (coffeeMachine != null ? coffeeMachine.hashCode() : 0);
        result = 31 * result + (electricKettle != null ? electricKettle.hashCode() : 0);
        result = 31 * result + (flatScreenTv != null ? flatScreenTv.hashCode() : 0);
        result = 31 * result + (kitchenKitchenette != null ? kitchenKitchenette.hashCode() : 0);
        result = 31 * result + (soundProofing != null ? soundProofing.hashCode() : 0);
        result = 31 * result + (teaCoffeeMaker != null ? teaCoffeeMaker.hashCode() : 0);
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
