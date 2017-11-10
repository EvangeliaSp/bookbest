package dao;

import entities.Room;

import java.sql.Statement;

public interface RoomDAO {

    void create(Statement stmt, Room room);
}
