package dao.booking;

import entities.booking.Facility;

import java.sql.Statement;

public interface FacilityDAO {

    void create(Statement stmt, Facility facility);

}
