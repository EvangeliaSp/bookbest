package dao.hotelclub;

import entities.hotelclub.Facility;

import java.sql.Statement;

public interface FacilityDAO {

    void create(Statement stmt, Facility facility);

    Facility find(Statement statement, int id);

}
