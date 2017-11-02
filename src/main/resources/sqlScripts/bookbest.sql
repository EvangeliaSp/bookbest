CREATE DATABASE bookbest;

USE bookbest;

CREATE TABLE `Accommodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `stars` int(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postal_code` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `Room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_id` int(11) NOT NULL,
  `price_per_night` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`acc_id`) REFERENCES `Accommodation` (`id`)
) AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `pets_allowed` BINARY(1) NULL,
  `parking` BINARY(1) NULL,
  `non_smoking_rooms` BINARY(1) NULL,
  `room_service` BINARY(1) NULL,
  `restaurant` BINARY(1) NULL,
  `for_disabled_guests` BINARY(1) NULL,
  `free_wifi` BINARY(1) NULL,
  `fitness_centre` BINARY(1) NULL,
  `family_rooms` BINARY(1) NULL,
  `swimming_pool` BINARY(1) NULL,
  `spa_and_wellness_centre` BINARY(1) NULL,
  `airport_shuttle` BINARY(1) NULL,
  `24-hour_reception` BINARY(1) NULL,
  `sauna` BINARY(1) NULL,
  `massage` BINARY(1) NULL,
  `bicycle_rental` BINARY(1) NULL,
  `cycling` BINARY(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) CHARSET=utf8;

CREATE TABLE `RoomFacility` (
  `id` int(11) NOT NULL,
  `breakfast_included` BINARY(1) NULL,
  `breakfast_and_dinner` BINARY(1) NULL,
  `self_catering` BINARY(1) NULL,
  `free_cancellation` BINARY(1) NULL,
  `book_without_credit` BINARY(1) NULL,
  `no_prepayment` BINARY(1) NULL,
  `air_conditioning` BINARY(1) NULL,
  `bath` BINARY(1) NULL,
  `coffee_machine` BINARY(1) NULL,
  `electric_kettle` BINARY(1) NULL,
  `flat-screen_TV` BINARY(1) NULL,
  `kitchen/kitchenette` BINARY(1) NULL,
  `sound_proofing` BINARY(1) NULL,
  `tea/coffee_maker` BINARY(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Room` (`id`)
) CHARSET=utf8;

CREATE TABLE `Reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `arrival` DATE NOT NULL,
  `departure` DATE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`room_id`) REFERENCES `Room` (`id`)
)  AUTO_INCREMENT=1 CHARSET=utf8;