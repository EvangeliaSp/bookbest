package dataGeneration;

import java.sql.Date;


public class ReservationGenerator {

    public ReservationGenerator(int id) {
        Reservation reservation = new Reservation();
        reservation.setRoomId(id);
        Date arrival = arrival();
        reservation.setArrival(arrival);
        reservation.setDeparture(departure(arrival));
    }


    private Date arrival() {
        //Date arrival = new Date();
        return null;
    }

    private Date departure(Date arrival) {
        Date departure = null;
        if(departure.before(arrival)) {

        }
        return null;
    }
}
