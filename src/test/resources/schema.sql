CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address_line` varchar(255) NOT NULL,
  `city` varchar(50) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
);

CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
);

CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` BOOLEAN DEFAULT FALSE NOT NULL,
  `id_number` varchar(8) NOT NULL,
  `max_quantity` int NOT NULL,
  `min_quantity` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `contact_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`)
);