package dao;

import entities.Facility;

import java.sql.Statement;

public interface FacilityDAO {

    void create(Statement stmt, Facility facility);

}
