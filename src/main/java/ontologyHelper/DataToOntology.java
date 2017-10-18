package ontologyHelper;

import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;
import org.semanticweb.owlapi.model.*;

import java.sql.Statement;
import java.util.List;

public class DataToOntology {

    public void importData(Statement stmt, OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLClass owlClass) throws OWLOntologyStorageException {
        HotelDAO hotelDAO = new HotelDAOImpl();
        List<Hotel> hotels = hotelDAO.list(stmt);
        for(Hotel hotel: hotels) {
            String name = hotel.getName(), price, rating, distance;

            OWLIndividual individual = ontologyHelper.createIndividual(name);
            ontologyHelper.associateIndividualWithClass(owlOntology, owlClass, individual);

            int id = hotel.getIdHotel();
            saveChanges(ontologyHelper, owlOntology, individual, "hasId", String.valueOf(id));


            if(hotel.getPrice() != null) {
                price = hotel.getPrice();
                saveChanges(ontologyHelper, owlOntology, individual, "price", price);
            }
            if(hotel.getRating() != null) {
                rating = hotel.getRating();
                saveChanges(ontologyHelper, owlOntology, individual, "rating", rating);
            }
            if(hotel.getDistance() != null) {
                distance = hotel.getDistance();
                saveChanges(ontologyHelper, owlOntology, individual, "distance", distance);
            }
        }
    }

    private void saveChanges(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = ontologyHelper.createDataProperty(property);
        OWLAxiom owlAxiom = ontologyHelper.createDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, value);
        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        ontologyHelper.saveOntology(owlOntology, addAxiom);
    }
}
