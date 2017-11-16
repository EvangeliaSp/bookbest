package dao.airtickets;

import entities.airtickets.Facility;

import java.sql.Statement;

public interface FacilityDAO {

    void create(Statement statement, Facility facility);

    Facility find(Statement statement, int id);
}
