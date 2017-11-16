package dataMapping;

import dao.airtickets.AccommodationDAO;
import dao.airtickets.AccommodationDAOImpl;
import dao.airtickets.FacilityDAO;
import dao.airtickets.FacilityDAOImpl;
import entities.airtickets.Accommodation;
import entities.airtickets.Facility;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.Statement;
import java.util.List;

public class AirticketsMapping {
    Statement statement;
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    DataToOntology dataToOntology;

    public AirticketsMapping(Statement statement) throws OWLOntologyCreationException {
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
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasLocationRating", accommodation.getGuestLocationRating());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCityCenterDistance", accommodation.getDistanceFromCityCenter());

            // Hotel Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "allowsPets", facility.getPetsAllowed());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasParking", facility.getParking());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasNonSmokingRooms", facility.getNonSmokingRooms());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRoomService", facility.getRoomService());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasRestaurant", facility.getRestaurant());
            if(facility.getForDisabledGuests() != null) {
                dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasHandicappedRooms", facility.getForDisabledGuests());
                dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasHandicappedFacilities", facility.getForDisabledGuests());
            }
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFreeWifi", facility.getFreeWifi());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFitnessCenter", facility.getFitnessCentre());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFamilyRooms", facility.getFamilyRooms());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSwimmingPool", facility.getSwimmingPool());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSpa&Wellness", facility.getSpaAndWellnessCentre());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasAirportShuttle", facility.getAirportShuttle());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "has24HourReception", facility.getFrontDesk24Hour());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSauna", facility.getSauna());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasMassage", facility.getMassage());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBicycleRental", facility.getBicycleRental());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCycling", facility.getCycling());

            // Room Facilities
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "includesBreakfast", facility.getBreakfastIncluded());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "includesBreakfast&Dinner", facility.getBreakfastAndDinner());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasSelfCatering", facility.getSelfCatering());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasFreeCancellation", facility.getFreeCancellation());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasNoCCBooking", facility.getBookWithoutCreditCard());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "needsNoPrepayment", facility.getNoPrepayment());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasAirCondition", facility.getAirConditioning());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasBath", facility.getBath());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasCoffeeMachine", facility.getCoffeeMachine());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasElectricKettle", facility.getElectricKettle());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasTV", facility.getFlatScreenTv());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasTeaCoffeeMaker", facility.getTeaCoffeeMaker());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "isSoundProofing", facility.getSoundProofing());
            dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, "hasKitchen", facility.getKitchenKitchenette());
        }
    }
}
