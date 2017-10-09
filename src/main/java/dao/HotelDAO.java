package dao;

import entities.Hotel;

import java.sql.Statement;
import java.util.List;

public interface HotelDAO {

    void create(Statement stmt, Hotel hotel);

    List<Hotel> list();
}
