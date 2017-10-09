package dao;

import entities.Hotel;

import javax.persistence.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    @Override
    public void create(Statement stmt, Hotel hotel) {
        try {
            String sql = "INSERT INTO Hotel VALUES (" +
                    hotel.getIdHotel() + ", " +
                    hotel.getName() + ", " +
                    hotel.getPrice() + ", " +
                    hotel.getRating() + ", " +
                    hotel.getDistance() + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        /*EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("bookbest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(hotel);
        entityManager.close();
        entityManagerFactory.close();*/
    }

    @Override
    public List<Hotel> list() {
        List<Hotel> hotels;
        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("bookbest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);
        hotels = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return hotels;
        //return null;
    }
}
