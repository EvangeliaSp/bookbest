package entities;

import javax.persistence.*;

@Entity
public class RoomFacility {
    private int id;
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
    private Room roomById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "flat_screen_TV", nullable = true)
    public Byte getFlatScreenTv() {
        return flatScreenTv;
    }

    public void setFlatScreenTv(Byte flatScreenTv) {
        this.flatScreenTv = flatScreenTv;
    }

    @Basic
    @Column(name = "kitchen_kitchenette", nullable = true)
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
    @Column(name = "tea_coffee_maker", nullable = true)
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

        RoomFacility that = (RoomFacility) o;

        if (id != that.id) return false;
        if (breakfastIncluded != null ? !breakfastIncluded.equals(that.breakfastIncluded) : that.breakfastIncluded != null)
            return false;
        if (breakfastAndDinner != null ? !breakfastAndDinner.equals(that.breakfastAndDinner) : that.breakfastAndDinner != null)
            return false;
        if (selfCatering != null ? !selfCatering.equals(that.selfCatering) : that.selfCatering != null) return false;
        if (freeCancellation != null ? !freeCancellation.equals(that.freeCancellation) : that.freeCancellation != null)
            return false;
        if (bookWithoutCreditCard != null ? !bookWithoutCreditCard.equals(that.bookWithoutCreditCard) : that.bookWithoutCreditCard != null)
            return false;
        if (noPrepayment != null ? !noPrepayment.equals(that.noPrepayment) : that.noPrepayment != null) return false;
        if (airConditioning != null ? !airConditioning.equals(that.airConditioning) : that.airConditioning != null)
            return false;
        if (bath != null ? !bath.equals(that.bath) : that.bath != null) return false;
        if (coffeeMachine != null ? !coffeeMachine.equals(that.coffeeMachine) : that.coffeeMachine != null)
            return false;
        if (electricKettle != null ? !electricKettle.equals(that.electricKettle) : that.electricKettle != null)
            return false;
        if (flatScreenTv != null ? !flatScreenTv.equals(that.flatScreenTv) : that.flatScreenTv != null) return false;
        if (kitchenKitchenette != null ? !kitchenKitchenette.equals(that.kitchenKitchenette) : that.kitchenKitchenette != null)
            return false;
        if (soundProofing != null ? !soundProofing.equals(that.soundProofing) : that.soundProofing != null)
            return false;
        if (teaCoffeeMaker != null ? !teaCoffeeMaker.equals(that.teaCoffeeMaker) : that.teaCoffeeMaker != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
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
    public Room getRoomById() {
        return roomById;
    }

    public void setRoomById(Room roomById) {
        this.roomById = roomById;
    }
}
