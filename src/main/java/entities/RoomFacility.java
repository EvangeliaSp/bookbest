package entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class RoomFacility {
    private int id;
    private byte[] breakfastIncluded;
    private byte[] breakfastAndDinner;
    private byte[] selfCatering;
    private byte[] freeCancellation;
    private byte[] bookWithoutCredit;
    private byte[] noPrepayment;
    private byte[] airConditioning;
    private byte[] bath;
    private byte[] coffeeMachine;
    private byte[] electricKettle;
    private byte[] flatScreenTv;
    private byte[] kitchenKitchenette;
    private byte[] soundProofing;
    private byte[] teaCoffeeMaker;
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
    public byte[] getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(byte[] breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    @Basic
    @Column(name = "breakfast_and_dinner", nullable = true)
    public byte[] getBreakfastAndDinner() {
        return breakfastAndDinner;
    }

    public void setBreakfastAndDinner(byte[] breakfastAndDinner) {
        this.breakfastAndDinner = breakfastAndDinner;
    }

    @Basic
    @Column(name = "self_catering", nullable = true)
    public byte[] getSelfCatering() {
        return selfCatering;
    }

    public void setSelfCatering(byte[] selfCatering) {
        this.selfCatering = selfCatering;
    }

    @Basic
    @Column(name = "free_cancellation", nullable = true)
    public byte[] getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(byte[] freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    @Basic
    @Column(name = "book_without_credit", nullable = true)
    public byte[] getBookWithoutCredit() {
        return bookWithoutCredit;
    }

    public void setBookWithoutCredit(byte[] bookWithoutCredit) {
        this.bookWithoutCredit = bookWithoutCredit;
    }

    @Basic
    @Column(name = "no_prepayment", nullable = true)
    public byte[] getNoPrepayment() {
        return noPrepayment;
    }

    public void setNoPrepayment(byte[] noPrepayment) {
        this.noPrepayment = noPrepayment;
    }

    @Basic
    @Column(name = "air_conditioning", nullable = true)
    public byte[] getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(byte[] airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Basic
    @Column(name = "bath", nullable = true)
    public byte[] getBath() {
        return bath;
    }

    public void setBath(byte[] bath) {
        this.bath = bath;
    }

    @Basic
    @Column(name = "coffee_machine", nullable = true)
    public byte[] getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(byte[] coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Basic
    @Column(name = "electric_kettle", nullable = true)
    public byte[] getElectricKettle() {
        return electricKettle;
    }

    public void setElectricKettle(byte[] electricKettle) {
        this.electricKettle = electricKettle;
    }

    @Basic
    @Column(name = "flat-screen_TV", nullable = true)
    public byte[] getFlatScreenTv() {
        return flatScreenTv;
    }

    public void setFlatScreenTv(byte[] flatScreenTv) {
        this.flatScreenTv = flatScreenTv;
    }

    @Basic
    @Column(name = "kitchen/kitchenette", nullable = true)
    public byte[] getKitchenKitchenette() {
        return kitchenKitchenette;
    }

    public void setKitchenKitchenette(byte[] kitchenKitchenette) {
        this.kitchenKitchenette = kitchenKitchenette;
    }

    @Basic
    @Column(name = "sound_proofing", nullable = true)
    public byte[] getSoundProofing() {
        return soundProofing;
    }

    public void setSoundProofing(byte[] soundProofing) {
        this.soundProofing = soundProofing;
    }

    @Basic
    @Column(name = "tea/coffee_maker", nullable = true)
    public byte[] getTeaCoffeeMaker() {
        return teaCoffeeMaker;
    }

    public void setTeaCoffeeMaker(byte[] teaCoffeeMaker) {
        this.teaCoffeeMaker = teaCoffeeMaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomFacility that = (RoomFacility) o;

        if (id != that.id) return false;
        if (!Arrays.equals(breakfastIncluded, that.breakfastIncluded)) return false;
        if (!Arrays.equals(breakfastAndDinner, that.breakfastAndDinner)) return false;
        if (!Arrays.equals(selfCatering, that.selfCatering)) return false;
        if (!Arrays.equals(freeCancellation, that.freeCancellation)) return false;
        if (!Arrays.equals(bookWithoutCredit, that.bookWithoutCredit)) return false;
        if (!Arrays.equals(noPrepayment, that.noPrepayment)) return false;
        if (!Arrays.equals(airConditioning, that.airConditioning)) return false;
        if (!Arrays.equals(bath, that.bath)) return false;
        if (!Arrays.equals(coffeeMachine, that.coffeeMachine)) return false;
        if (!Arrays.equals(electricKettle, that.electricKettle)) return false;
        if (!Arrays.equals(flatScreenTv, that.flatScreenTv)) return false;
        if (!Arrays.equals(kitchenKitchenette, that.kitchenKitchenette)) return false;
        if (!Arrays.equals(soundProofing, that.soundProofing)) return false;
        if (!Arrays.equals(teaCoffeeMaker, that.teaCoffeeMaker)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(breakfastIncluded);
        result = 31 * result + Arrays.hashCode(breakfastAndDinner);
        result = 31 * result + Arrays.hashCode(selfCatering);
        result = 31 * result + Arrays.hashCode(freeCancellation);
        result = 31 * result + Arrays.hashCode(bookWithoutCredit);
        result = 31 * result + Arrays.hashCode(noPrepayment);
        result = 31 * result + Arrays.hashCode(airConditioning);
        result = 31 * result + Arrays.hashCode(bath);
        result = 31 * result + Arrays.hashCode(coffeeMachine);
        result = 31 * result + Arrays.hashCode(electricKettle);
        result = 31 * result + Arrays.hashCode(flatScreenTv);
        result = 31 * result + Arrays.hashCode(kitchenKitchenette);
        result = 31 * result + Arrays.hashCode(soundProofing);
        result = 31 * result + Arrays.hashCode(teaCoffeeMaker);
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
