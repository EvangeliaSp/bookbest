package ontologyHelper;

import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;
import org.semanticweb.owlapi.apibinding.OWLManager;
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

            createIndividual(ontologyHelper, owlOntology, individual, owlClass);

            int id = hotel.getIdHotel();
            saveChanges(ontologyHelper, owlOntology, individual, "hasId", String.valueOf(id), owlClass);


            if(hotel.getPrice() != null) {
                price = hotel.getPrice();
                saveChanges(ontologyHelper, owlOntology, individual, "price", price, owlClass);
            }
            if(hotel.getRating() != null) {
                rating = hotel.getRating();
                saveChanges(ontologyHelper, owlOntology, individual, "rating", rating, owlClass);
            }
            if(hotel.getDistance() != null) {
                distance = hotel.getDistance();
                saveChanges(ontologyHelper, owlOntology, individual, "distance", distance, owlClass);
            }
        }
    }

    private void saveChanges(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value, OWLClass owlClass) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = ontologyHelper.createDataProperty(property);
        OWLAxiom owlAxiom = ontologyHelper.createDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, value);

        //OWLDataFactory owlDataFactory = ontologyHelper.getOwlDataFactory();

       // OWLClassAssertionAxiom owlClassAssertionAxiom = owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        ontologyHelper.saveOntology(owlOntology, addAxiom);
    }

    private void createIndividual(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, OWLClass owlClass) throws OWLOntologyStorageException {
        OWLDataFactory owlDataFactory = ontologyHelper.getOwlDataFactory();

        OWLClassAssertionAxiom owlClassAssertionAxiom = owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlClassAssertionAxiom);
        ontologyHelper.saveOntology(owlOntology, addAxiom);
    }


}
