package dao;

import entities.RoomFacility;

import java.sql.Statement;

public interface RoomFacilityDAO {

    void create(Statement statement, RoomFacility roomFacility);

}
