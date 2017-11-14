package ontologyHelper;

import org.semanticweb.owlapi.model.*;

public class OntologyGenerator {
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;

    public OntologyGenerator() throws OWLOntologyCreationException {
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        OWLOntology owlOntology = ontologyHelper.createOntology();
        this.owlOntology = owlOntology;
    }

    // Create OWL Class
    public void generateClasses() throws OWLOntologyStorageException {
        OWLClass owlClass = ontologyHelper.createClass("Hotel");
        ontologyHelper.saveOntology(owlOntology, owlClass);
    }

    // Create OWL Data Properties
    public void generateDataProperties() throws OWLOntologyStorageException {

        OWLDataProperty owlDataProperty;

        // Data Properties about Hotel

        owlDataProperty = ontologyHelper.createDataProperty("hasName");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasStarRating");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasPricePerNight");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRating");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("isInCountry");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("isInCity");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasLocationRating");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRoomType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasCityCenterDistance");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);


        // Data Properties about Hotel facilities

        owlDataProperty = ontologyHelper.createDataProperty("allowsPets");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasParking");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasNonSmokingRooms");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasNonSmokingFacilities");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasSmokingAreas");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRoomService");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRestaurant");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasHandicappedRooms");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasHandicappedFacilities");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasFreeWifi");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasFitnessCenter");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasFamilyRooms");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasSwimmingPool");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasSpa&Wellness");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasAirportShuttle");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("has24HourReception");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasSauna");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasMassage");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBicycleRental");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasCycling");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBusinessCenter");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBusinessFacilities");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasCasino");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBar");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasChildCare");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasCribs");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);


        // Data Properties about Hotel's Rooms facilities

        owlDataProperty = ontologyHelper.createDataProperty("includesBreakfast");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("includesBreakfast&Dinner");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasSelfCatering");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasFreeCancellation");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("booksWithoutCreditCard");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasNoPrepayment");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasPayLater");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasAirConditioning");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBath");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasCoffeeMachine");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasElectricKettle");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasTV");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasKitchen");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasTeaCoffeeMaker");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBathtub");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("isSoundProofing");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasAccessibleBathroom");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasInRoomAccessibility");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRollInShower");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasWheelchairAccess");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        // Data Properties about Hotel's Room type

        owlDataProperty = ontologyHelper.createDataProperty("isFamilyFriendly");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasBusinessType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasRomanticType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasAdventureType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);

        owlDataProperty = ontologyHelper.createDataProperty("hasLuxuryType");
        ontologyHelper.saveOntology(owlOntology, owlDataProperty);


    }

}
