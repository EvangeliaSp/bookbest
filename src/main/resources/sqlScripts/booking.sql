CREATE DATABASE booking;

USE booking;

CREATE TABLE `Accommodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `starRating` int(11) NULL,
  `pricePerNight` int(11) NOT NULL,
  `guestRating` double NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `distanceFromCityCenter` double NULL,
  `guestLocationRating` double NULL,
  `roomType` varchar(255) NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `petsAllowed` tinyint(1) NULL,
  `parking` tinyint(1) NULL,
  `nonSmokingRooms` tinyint(1) NULL,
  `roomService` tinyint(1) NULL,
  `restaurant` tinyint(1) NULL,
  `forDisabledGuests` tinyint(1) NULL,
  `freeWifi` tinyint(1) NULL,
  `fitnessCentre` tinyint(1) NULL,
  `familyRooms` tinyint(1) NULL,
  `swimmingPool` tinyint(1) NULL,
  `spaAndWellnessCentre` tinyint(1) NULL,
  `airportShuttle` tinyint(1) NULL,
  `reception24Hour` tinyint(1) NULL,
  `sauna` tinyint(1) NULL,
  `massage` tinyint(1) NULL,
  `bicycleRental` tinyint(1) NULL,
  `cycling` tinyint(1) NULL,
  `breakfastIncluded` tinyint(1) NULL,
  `breakfastAndDinner` tinyint(1) NULL,
  `selfCatering` tinyint(1) NULL,
  `freeCancellation` tinyint(1) NULL,
  `bookWithoutCreditCard` tinyint(1) NULL,
  `noPrepayment` tinyint(1) NULL,
  `airConditioning` tinyint(1) NULL,
  `bath` tinyint(1) NULL,
  `coffeeMachine` tinyint(1) NULL,
  `electricKettle` tinyint(1) NULL,
  `flatScreenTV` tinyint(1) NULL,
  `kitchenKitchenette` tinyint(1) NULL,
  `soundProofing` tinyint(1) NULL,
  `teaCoffeeMaker` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;