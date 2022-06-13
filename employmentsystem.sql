CREATE DATABASE `employmentsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `compensation` (
  `id_compensation` int NOT NULL AUTO_INCREMENT,
  `type_com` varchar(25) NOT NULL,
  `amount` int DEFAULT NULL,
  `description_com` varchar(50) DEFAULT NULL,
  `date_com` date NOT NULL,
  `id_employe` int NOT NULL,
  PRIMARY KEY (`id_compensation`),
  KEY `id_em_idx` (`id_employe`),
  CONSTRAINT `id_em` FOREIGN KEY (`id_employe`) REFERENCES `employee` (`id_employee`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `id_employee` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) NOT NULL,
  `birth` date NOT NULL,
  `position` varchar(50) NOT NULL,
  PRIMARY KEY (`id_employee`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

