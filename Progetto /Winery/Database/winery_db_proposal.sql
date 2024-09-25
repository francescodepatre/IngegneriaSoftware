CREATE DATABASE  IF NOT EXISTS `winery_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `winery_db`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: winery_db
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `proposal`
--

DROP TABLE IF EXISTS `proposal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proposal` (
  `IDProposal` int NOT NULL,
  `ID_wine` int NOT NULL,
  `ID_customer` int NOT NULL,
  `Quantity` int NOT NULL,
  `Date_proposal` date NOT NULL,
  `Total_proposal` float NOT NULL,
  `Date_compilation` date DEFAULT NULL,
  `Seller_sign` int DEFAULT NULL,
  `ID_seller` int DEFAULT NULL,
  PRIMARY KEY (`IDProposal`),
  KEY `ID_wine` (`ID_wine`),
  KEY `ID_customer` (`ID_customer`),
  KEY `proposal_ibfk_3_idx` (`ID_seller`),
  CONSTRAINT `proposal_ibfk_1` FOREIGN KEY (`ID_wine`) REFERENCES `wine` (`IDWine`),
  CONSTRAINT `proposal_ibfk_2` FOREIGN KEY (`ID_customer`) REFERENCES `customer` (`IDCustomer`),
  CONSTRAINT `proposal_ibfk_3` FOREIGN KEY (`ID_seller`) REFERENCES `seller` (`IDSeller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposal`
--

LOCK TABLES `proposal` WRITE;
/*!40000 ALTER TABLE `proposal` DISABLE KEYS */;
INSERT INTO `proposal` VALUES (4618288,6,4,6,'2023-03-14',419.94,NULL,NULL,NULL),(4874718,6,4,12,'2023-03-14',839.88,NULL,NULL,NULL);
/*!40000 ALTER TABLE `proposal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-29  1:38:59
