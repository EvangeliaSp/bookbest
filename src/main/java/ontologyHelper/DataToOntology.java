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

            OWLIndividual owlIndividual = ontologyHelper.createIndividual(name);
            ontologyHelper.associateIndividualWithClass(owlOntology, owlClass, owlIndividual);

            ontologyHelper.createIndividual(owlOntology, owlIndividual, owlClass);
            createIndividual(ontologyHelper, owlOntology, owlIndividual, owlClass);

            int id = hotel.getIdHotel();
            ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, "hasId", String.valueOf(id));

            if(hotel.getPrice() != null) {
                price = hotel.getPrice();
                ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, "hasPrice", price);
            }
            if(hotel.getRating() != null) {
                rating = hotel.getRating();
                ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, "hasRating", rating);
            }
            if(hotel.getDistance() != null) {
                distance = hotel.getDistance();
                ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, "hasDistance", distance);
            }
        }
    }

    private void createIndividual(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, OWLClass owlClass) throws OWLOntologyStorageException {
        OWLDataFactory owlDataFactory = ontologyHelper.getOwlDataFactory();

        OWLClassAssertionAxiom owlClassAssertionAxiom = owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlClassAssertionAxiom);
        ontologyHelper.saveOntology(owlOntology, addAxiom);
    }
}