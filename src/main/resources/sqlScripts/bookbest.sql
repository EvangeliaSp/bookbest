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
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_id` int(11) NOT NULL,
  `price_per_night` int(11) NOT NULL,
  `rating` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`acc_id`) REFERENCES `Accommodation` (`id`)
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `pets_allowed` tinyint(1) NULL,
  `parking` tinyint(1) NULL,
  `non_smoking_rooms` tinyint(1) NULL,
  `room_service` tinyint(1) NULL,
  `restaurant` tinyint(1) NULL,
  `for_disabled_guests` tinyint(1) NULL,
  `free_wifi` tinyint(1) NULL,
  `fitness_centre` tinyint(1) NULL,
  `family_rooms` tinyint(1) NULL,
  `swimming_pool` tinyint(1) NULL,
  `spa_and_wellness_centre` tinyint(1) NULL,
  `airport_shuttle` tinyint(1) NULL,
  `reception_24-hour` tinyint(1) NULL,
  `sauna` tinyint(1) NULL,
  `massage` tinyint(1) NULL,
  `bicycle_rental` tinyint(1) NULL,
  `cycling` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RoomFacility` (
  `id` int(11) NOT NULL,
  `breakfast_included` tinyint(1) NULL,
  `breakfast_and_dinner` tinyint(1) NULL,
  `self_catering` tinyint(1) NULL,
  `free_cancellation` tinyint(1) NULL,
  `book_without_credit_card` tinyint(1) NULL,
  `no_prepayment` tinyint(1) NULL,
  `air_conditioning` tinyint(1) NULL,
  `bath` tinyint(1) NULL,
  `coffee_machine` tinyint(1) NULL,
  `electric_kettle` tinyint(1) NULL,
  `flat-screen_TV` tinyint(1) NULL,
  `kitchen/kitchenette` tinyint(1) NULL,
  `sound_proofing` tinyint(1) NULL,
  `tea/coffee_maker` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `arrival` DATE NOT NULL,
  `departure` DATE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`room_id`) REFERENCES `Room` (`id`)
)  AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;