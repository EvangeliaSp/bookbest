package dataMapping;

import dao.hotelclub.AccommodationDAO;
import dao.hotelclub.AccommodationDAOImpl;
import dao.hotelclub.FacilityDAO;
import dao.hotelclub.FacilityDAOImpl;
import entities.hotelclub.Accommodation;
import entities.hotelclub.Facility;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.Statement;
import java.util.List;

public class HotelclubMapping {
    Statement statement;
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    DataToOntology dataToOntology;

    public HotelclubMapping(Statement statement) throws OWLOntologyCreationException {
        this.statement = statement;
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        this.owlOntology = ontologyHelper.readOntology();
        this.dataToOntology = new DataToOntology();
    }

    public void importData() throws OWLOntologyStorageException {
        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        List<Accommodation> accommodations = accommodationDAO.list(this.statement);

        FacilityDAO facilityDAO = new FacilityDAOImpl();
        Facility facility;

        for(Accommodation accommodation: accommodations) {
            facility = facilityDAO.find(this.statement, accommodation.getId());

            // Create the individual
            OWLIndividual owlIndividual = ontologyHelper.createIndividual(accommodation.getName());
            OWLClass owlClass = ontologyHelper.getFirstClass(owlOntology);
            ontologyHelper.associateIndividualWithClass(owlOntology, owlClass, owlIndividual);

            // Hotel Data properties
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasType", accommodation.getType());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasStarRating", accommodation.getStars());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasPricePerNight", accommodation.getPricePerNight());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRating", accommodation.getRating());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "isInCountry", accommodation.getCountry());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "isInCity", accommodation.getCity());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasLocationRating", accommodation.getLocation());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCityCenterDistance", accommodation.getDistanceFromCityCenter());

            // Hotel Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "allowsPets", facility.getPetFriendly());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasParking", facility.getFreeParking());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSmokingAreas", facility.getSmokingAreas());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRestaurant", facility.getRestaurant());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFreeWifi", facility.getFreeWifi());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFitnessCenter", facility.getGym());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSwimmingPool", facility.getPool());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasAirportShuttle", facility.getAirportTransfer());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSpa", facility.getSpa());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBar", facility.getBar());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCribs", facility.getCribsAvailable());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasChildcare", facility.getChildcare());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBusinessFacilities", facility.getBusinessFacilities());

            // Room Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "includesBreakfast", facility.getFreeBreakfast());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasKitchen", facility.getKitchen());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBathtub", facility.getBathtubInRoom());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasAccessibleBathroom", facility.getAccessibleBathroom());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasInRoomAccessibility", facility.getInRoomAccessibility());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRollInShower", facility.getRollInShower());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasWheelchairAccess", facility.getWheelchairAccess());
        }
    }
}
