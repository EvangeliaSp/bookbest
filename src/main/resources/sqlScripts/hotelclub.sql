CREATE DATABASE hotelclub;

USE hotelclub;

CREATE TABLE `Accommodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `stars` int(11) NULL,
  `pricePerNight` int(11) NOT NULL,
  `rating` double NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `location` double NULL,
  `distanceFromCityCenter` double NULL,
  `roomTypePeople` int(11) NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `airportTransfer` tinyint(1) NULL,
  `bar` tinyint(1) NULL,
  `businessFacilities` tinyint(1) NULL,
  `childcare` tinyint(1) NULL,
  `connectingRoomsAvailable` tinyint(1) NULL,
  `cribsAvailable` tinyint(1) NULL,
  `freeBreakfast` tinyint(1) NULL,
  `freeParking` tinyint(1) NULL,
  `freeWifi` tinyint(1) NULL,
  `gym` tinyint(1) NULL,
  `petFriendly` tinyint(1) NULL,
  `pool` tinyint(1) NULL,
  `restaurant` tinyint(1) NULL,
  `smokingAreas` tinyint(1) NULL,
  `spa` tinyint(1) NULL,
  `bathtubInRoom` tinyint(1) NULL,
  `kitchen` tinyint(1) NULL,
  `accessibleBathroom` tinyint(1) NULL,
  `inRoomAccessebility` tinyint(1) NULL,
  `rollInShower` tinyint(1) NULL,
  `wheelchairAccess` tinyint(1) NULL,
  `familyFriendly` tinyint(1) NULL,
  `business` tinyint(1) NULL,
  `romantic` tinyint(1) NULL,
  `adventure` tinyint(1) NULL,
  `luxury` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;