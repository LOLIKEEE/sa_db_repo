-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: timesheet
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `Customers`
--

DROP TABLE IF EXISTS `Customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customers` (
  `idCustomer` smallint NOT NULL AUTO_INCREMENT,
  `Customer_Name` varchar(45) DEFAULT NULL,
  `Customer_Contact_Number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customers`
--

LOCK TABLES `Customers` WRITE;
/*!40000 ALTER TABLE `Customers` DISABLE KEYS */;
INSERT INTO `Customers` VALUES (1,'GSD Software & Technology','0722222222'),(2,'Porsche','0044754220000'),(3,'BMW Group','0044754229992');
/*!40000 ALTER TABLE `Customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `idEmployee` smallint NOT NULL AUTO_INCREMENT,
  `Employee_Name` varchar(35) DEFAULT NULL,
  `Employee_Age` smallint DEFAULT NULL,
  `Employee_Phone_Number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEmployee`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Nicolae',26,'0754827541'),(2,'Radu',31,'0754827555'),(3,'Gabriel',25,'0754827010'),(4,'Cristian',20,'0770753938'),(5,'Vladislav',25,'0776331490');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects`
--

DROP TABLE IF EXISTS `Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Projects` (
  `idProject` smallint NOT NULL AUTO_INCREMENT,
  `Project_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProject`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES (1,'Software Academy Training'),(2,'Porsche Backend'),(3,'BMW Sales platform');
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects_Owners`
--

DROP TABLE IF EXISTS `Projects_Owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Projects_Owners` (
  `idProjectOwner` smallint NOT NULL AUTO_INCREMENT,
  `Project_Owner_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProjectOwner`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects_Owners`
--

LOCK TABLES `Projects_Owners` WRITE;
/*!40000 ALTER TABLE `Projects_Owners` DISABLE KEYS */;
INSERT INTO `Projects_Owners` VALUES (1,'Darius'),(2,'Andreas'),(3,'Harald');
/*!40000 ALTER TABLE `Projects_Owners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `idTaskType` smallint NOT NULL AUTO_INCREMENT,
  `Task_Name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idTaskType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Study'),(2,'Development');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_traking`
--

DROP TABLE IF EXISTS `time_traking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_traking` (
  `idRecord` smallint NOT NULL AUTO_INCREMENT,
  `idEmployee` smallint DEFAULT NULL,
  `idProject` smallint DEFAULT NULL,
  `worked_hours` smallint DEFAULT NULL,
  `idProjectOwner` smallint DEFAULT NULL,
  `idTaskType` smallint DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `idCustomer` smallint DEFAULT NULL,
  `comment` varchar(80) DEFAULT NULL,
  `record_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idRecord`),
  KEY `idEmployee_idx` (`idEmployee`),
  KEY `idProject_idx` (`idProject`),
  KEY `idProjectOwner_idx` (`idProjectOwner`),
  KEY `idTaskType_idx` (`idTaskType`),
  KEY `idCustomer_idx` (`idCustomer`),
  CONSTRAINT `idCustomer` FOREIGN KEY (`idCustomer`) REFERENCES `Customers` (`idCustomer`),
  CONSTRAINT `idEmployee` FOREIGN KEY (`idEmployee`) REFERENCES `Employee` (`idEmployee`),
  CONSTRAINT `idProject` FOREIGN KEY (`idProject`) REFERENCES `Projects` (`idProject`),
  CONSTRAINT `idProjectOwner` FOREIGN KEY (`idProjectOwner`) REFERENCES `Projects_Owners` (`idProjectOwner`),
  CONSTRAINT `idTaskType` FOREIGN KEY (`idTaskType`) REFERENCES `tasks` (`idTaskType`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_traking`
--

LOCK TABLES `time_traking` WRITE;
/*!40000 ALTER TABLE `time_traking` DISABLE KEYS */;
INSERT INTO `time_traking` VALUES (1,1,1,2,1,1,'2022-09-26','2022-09-26',1,'I studied the mysql tutorial pretty hard.',0),(2,1,2,2,2,1,'2022-09-26','2022-09-26',2,'I studied the project.',0),(3,1,3,2,3,2,'2022-09-27','2022-09-27',2,'I developed all features.',0),(4,2,3,3,3,2,'2022-09-28','2022-09-28',3,'I fixed the following bugs: BMW-9999, BMW-9998',1),(5,2,2,5,2,2,'2022-09-28','2022-09-28',2,'Refactoring: PBP-0001',1),(6,2,1,5,1,2,'2022-09-28','2022-09-28',1,'Studied SQL Databases',1),(7,3,3,8,3,2,'2022-09-28','2022-09-28',3,'I fixed the following bugs: BMW-9999',1),(8,3,2,1,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0001',1),(9,3,1,1,1,2,'2022-09-29','2022-09-29',1,'Studied OCA',1),(10,4,1,3,1,1,'2022-09-28','2022-09-28',3,'Studied database normalization',0),(11,4,2,4,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0337',0),(12,4,3,2,3,2,'2022-09-29','2022-09-29',1,'Created user storys for next iteration',1),(13,5,3,6,1,2,'2022-09-28','2022-09-28',3,'created unit-test for task: 004156',1),(14,5,2,4,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0227',0),(15,5,1,7,3,1,'2022-09-29','2022-09-29',1,'geting familiar with sql',0),(16,4,2,99,1,2,'2022-09-27','2022-09-27',1,'test comment',0);
/*!40000 ALTER TABLE `time_traking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'timesheet'
--
/*!50003 DROP PROCEDURE IF EXISTS `workingHoursProject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `workingHoursProject`(in projectNameVar varchar(45))
BEGIN
SELECT Employee.Employee_Name, SUM(time_traking.worked_hours), Projects.Project_Name Projects FROM time_traking
INNER JOIN Employee ON time_traking.idEmployee = Employee.idEmployee
INNER JOIN Projects ON time_traking.idProject = Projects.idProject
WHERE Projects.Project_Name = projectNameVar
GROUP BY Employee.Employee_Name, Projects.idProject;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-09 20:41:36
