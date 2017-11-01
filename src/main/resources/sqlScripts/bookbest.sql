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

CREATE TABLE `AccommodationRoom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_id` int(11) NOT NULL,
  `price_per_night` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`acc_id`) REFERENCES `Accommodation` (`id`)
) AUTO_INCREMENT=1 CHARSET=utf8;

CREATE TABLE `Reservation` (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `arrival` DATE NOT NULL,
  `departure` DATE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`room_id`) REFERENCES `AccommodationRoom` (`id`)
) CHARSET=utf8;