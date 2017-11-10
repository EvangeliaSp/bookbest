package dao;

import entities.RoomFacility;

import java.sql.Statement;

public interface RoomFacilityDAO {

    void create(Statement stmt, RoomFacility roomFacility);

}
