package dao.booking;

import entities.booking.Accommodation;

import java.sql.Statement;
import java.util.List;

public interface AccommodationDAO {

    void create(Statement statement, Accommodation accommodation);

    List<Accommodation> list(Statement statement);

}
