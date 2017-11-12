CREATE DATABASE priceline;

USE priceline;

CREATE TABLE `Accommodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `starRating` int(11) NULL,
  `pricePerNight` int(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `roomType` varchar(255) NULL,
  `location` double NULL,
  `guestRating` double NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `freeInternet` tinyint(1) NULL,
  `freeParking` tinyint(1) NULL,
  `freeBreakfast` tinyint(1) NULL,
  `petsAllowed` tinyint(1) NULL,
  `swimmingPool` tinyint(1) NULL,
  `airportShuttle` tinyint(1) NULL,
  `noSmokingRoomsFacilities` tinyint(1) NULL,
  `fitnessCenter` tinyint(1) NULL,
  `handicappedRoomsFacilities` tinyint(1) NULL,
  `businessCenter` tinyint(1) NULL,
  `casino` tinyint(1) NULL,
  `spa` tinyint(1) NULL,
  `restaurant` tinyint(1) NULL,
  `freeCancellation` tinyint(1) NULL,
  `payLater` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;