package dao.priceline;

import entities.priceline.Facility;

import java.sql.Statement;

public interface FacilityDAO {

    void create(Statement statement, Facility facility);

}
