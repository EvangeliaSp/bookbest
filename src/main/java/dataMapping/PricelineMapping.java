package dataMapping;

import dao.priceline.AccommodationDAO;
import dao.priceline.AccommodationDAOImpl;
import dao.priceline.FacilityDAO;
import dao.priceline.FacilityDAOImpl;
import entities.priceline.Accommodation;
import entities.priceline.Facility;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.Statement;
import java.util.List;

public class PricelineMapping {
    Statement statement;
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    DataToOntology dataToOntology;

    public PricelineMapping(Statement statement) throws OWLOntologyCreationException {
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
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasStarRating", accommodation.getStarRating());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasPricePerNight", accommodation.getPricePerNight());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRating", accommodation.getGuestRating());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "isInCountry", accommodation.getCountry());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "isInCity", accommodation.getCity());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasLocationRating", accommodation.getLocation());

            // Hotel Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "allowsPets", facility.getPetsAllowed());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasParking", facility.getFreeParking());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasNonSmokingRooms", facility.getNoSmokingRoomsFacilities());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasNonSmokingFacilities", facility.getNoSmokingRoomsFacilities());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRestaurant", facility.getRestaurant());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasHandicappedRooms", facility.getHandicappedRoomsFacilities());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasHandicappedFacilities", facility.getHandicappedRoomsFacilities());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFreeWifi", facility.getFreeInternet());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFitnessCenter", facility.getFitnessCenter());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSwimmingPool", facility.getSwimmingPool());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasAirportShuttle", facility.getAirportShuttle());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSpa", facility.getSpa());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCasino", facility.getCasino());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBusinessFacilities", facility.getBusinessCenter());


            // Room Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "includesBreakfast", facility.getFreeBreakfast());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFreeCancellation", facility.getFreeCancellation());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasPayLater", facility.getPayLater());
        }
    }
}
