package dao;

import entities.Hotel;

import java.sql.Statement;
import java.util.List;

public interface HotelDAO {

    void create(Statement stmt, Hotel hotel);

    void delete(Statement stmt, int idHotel);

    List<Hotel> list(Statement stmt);

    int count(Statement stmt);

    Hotel find(Statement stmt, int idHotel);
}
