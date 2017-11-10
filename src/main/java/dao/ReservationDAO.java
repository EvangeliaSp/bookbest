package dao;

import entities.Reservation;

import java.sql.Statement;

public interface ReservationDAO {

    void create(Statement stmt, Reservation reservation);
}
