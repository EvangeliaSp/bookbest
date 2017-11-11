package dao.hotelclub;

import entities.hotelclub.Accommodation;

import java.sql.Statement;
import java.util.List;

public interface AccommodationDAO {

    void create(Statement stmt, Accommodation accommodation);

    List<Accommodation> list(Statement stmt);
}
