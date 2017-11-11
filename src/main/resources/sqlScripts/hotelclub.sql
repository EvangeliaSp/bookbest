CREATE DATABASE hotelclub;

USE hotelclub;

CREATE TABLE `Accommodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `stars` int(11) NOT NULL,
  `room_type` varchar(255) NOT NULL,
  `price_per_night` int(11) NOT NULL,
  `rating` double NOT NULL,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postal_code` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facility` (
  `id` int(11) NOT NULL,
  `airport_transfer` tinyint(1) NULL,
  `bar` tinyint(1) NULL,
  `business_facilities` tinyint(1) NULL,
  `childcare` tinyint(1) NULL,
  `connecting_rooms_available` tinyint(1) NULL,
  `cribs_available` tinyint(1) NULL,
  `free_breakfast` tinyint(1) NULL,
  `free_parking` tinyint(1) NULL,
  `free_wifi` tinyint(1) NULL,
  `gym` tinyint(1) NULL,
  `pet_friendly` tinyint(1) NULL,
  `pool` tinyint(1) NULL,
  `restaurant` tinyint(1) NULL,
  `smoking_areas` tinyint(1) NULL,
  `spa` tinyint(1) NULL,
  `bathtub_in_room` tinyint(1) NULL,
  `kitchen` tinyint(1) NULL,
  `accessible_bathroom` tinyint(1) NULL,
  `in_room_accessebility` tinyint(1) NULL,
  `roll_in_shower` tinyint(1) NULL,
  `wheelchair_access` tinyint(1) NULL,
  `family_friendly` tinyint(1) NULL,
  `business` tinyint(1) NULL,
  `romantic` tinyint(1) NULL,
  `adventure` tinyint(1) NULL,
  `luxury` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`id`) REFERENCES `Accommodation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;