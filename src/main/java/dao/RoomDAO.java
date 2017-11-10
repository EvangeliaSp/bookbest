package dao;

import entities.Room;

import java.sql.Statement;
import java.util.List;

public interface RoomDAO {

    void create(Statement statement, Room room);

    List<Room> list(Statement statement);
}
