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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` smallint NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_contact_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'GSD Software & Technology','0722222222'),(2,'Porsche','0044754220000'),(3,'BMW Group','0044754229992');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emloyee_id` smallint NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(35) DEFAULT NULL,
  `employee_age` smallint DEFAULT NULL,
  `employee_phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emloyee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nicolae',26,'0754827541'),(2,'Radu',31,'0754827555'),(3,'Gabriel',25,'0754827010'),(4,'Cristian',20,'0770753938'),(5,'Vladislav',25,'0776331490');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_owners`
--

DROP TABLE IF EXISTS `project_owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_owners` (
  `project_owner_id` smallint NOT NULL AUTO_INCREMENT,
  `project_owner_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`project_owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_owners`
--

LOCK TABLES `project_owners` WRITE;
/*!40000 ALTER TABLE `project_owners` DISABLE KEYS */;
INSERT INTO `project_owners` VALUES (1,'Darius'),(2,'Andreas'),(3,'Harald');
/*!40000 ALTER TABLE `project_owners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `project_id` smallint NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Software Academy Training'),(2,'Porsche Backend'),(3,'BMW Sales platform');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_status`
--

DROP TABLE IF EXISTS `record_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record_status` (
  `record_status_id` smallint NOT NULL AUTO_INCREMENT,
  `record_status_description` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`record_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_status`
--

LOCK TABLES `record_status` WRITE;
/*!40000 ALTER TABLE `record_status` DISABLE KEYS */;
INSERT INTO `record_status` VALUES (1,'paid'),(2,'unpaid');
/*!40000 ALTER TABLE `record_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `task_id` smallint NOT NULL AUTO_INCREMENT,
  `taks_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
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
  `time_tranking_id` smallint NOT NULL AUTO_INCREMENT,
  `employee_id` smallint DEFAULT NULL,
  `project_id` smallint DEFAULT NULL,
  `worked_hours` smallint DEFAULT NULL,
  `project_owner_id` smallint DEFAULT NULL,
  `task_id` smallint DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `customer_id` smallint DEFAULT NULL,
  `comment` varchar(80) DEFAULT NULL,
  `record_status_id` smallint DEFAULT NULL,
  PRIMARY KEY (`time_tranking_id`),
  KEY `id_idx` (`customer_id`),
  KEY `id_idx1` (`employee_id`),
  KEY `id_idx2` (`project_owner_id`),
  KEY `id_idx3` (`project_id`),
  KEY `id_idx4` (`task_id`),
  KEY `record_status_id_idx` (`record_status_id`),
  CONSTRAINT `customers_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`emloyee_id`),
  CONSTRAINT `project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`),
  CONSTRAINT `project_owners_id` FOREIGN KEY (`project_owner_id`) REFERENCES `project_owners` (`project_owner_id`),
  CONSTRAINT `record_status_id` FOREIGN KEY (`record_status_id`) REFERENCES `record_status` (`record_status_id`),
  CONSTRAINT `task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_traking`
--

LOCK TABLES `time_traking` WRITE;
/*!40000 ALTER TABLE `time_traking` DISABLE KEYS */;
INSERT INTO `time_traking` VALUES (1,1,1,2,1,1,'2022-09-26','2022-09-26',1,'I studied the mysql tutorial pretty hard.',2),(2,1,2,2,2,1,'2022-09-26','2022-09-26',2,'I studied the project.',2),(3,1,3,2,3,2,'2022-09-27','2022-09-27',2,'I developed all features.',2),(4,2,3,3,3,2,'2022-09-28','2022-09-28',3,'I fixed the following bugs: BMW-9999, BMW-9998',1),(5,2,2,5,2,2,'2022-09-28','2022-09-28',2,'Refactoring: PBP-0001',1),(6,2,1,5,1,2,'2022-09-28','2022-09-28',1,'Studied SQL Databases',1),(7,3,3,8,3,2,'2022-09-28','2022-09-28',3,'I fixed the following bugs: BMW-9999',1),(8,3,2,1,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0001',1),(9,3,1,1,1,2,'2022-09-29','2022-09-29',1,'Studied OCA',1),(10,4,1,3,1,1,'2022-09-28','2022-09-28',3,'Studied database normalization',1),(11,4,2,4,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0337',1),(12,4,3,2,3,2,'2022-09-29','2022-09-29',1,'Created user storys for next iteration',1),(13,5,3,6,1,2,'2022-09-28','2022-09-28',3,'created unit-test for task: 004156',1),(14,5,2,4,2,2,'2022-09-29','2022-09-29',2,'Tested the frontend app: PBP-0227',2),(15,5,1,7,3,1,'2022-09-29','2022-09-29',1,'geting familiar with sql',2),(16,4,2,99,1,2,'2022-09-27','2022-09-27',1,'test comment',1);
/*!40000 ALTER TABLE `time_traking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'timesheet'
--

--
-- Dumping routines for database 'timesheet'
--
/*!50003 DROP PROCEDURE IF EXISTS `updateStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStatus`(in employeeName varchar(45), in projectName varchar(45))
BEGIN
UPDATE time_traking
SET record_status = 1
WHERE idEmployee = (SELECT idEmployee FROM Employee WHERE Employee_Name = employeeName)
AND 
idProject = (SELECT idProject FROM Projects WHERE Project_Name = projectName);
SELECT * FROM Employee WHERE Employee_Name = employeeName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
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

-- Dump completed on 2022-10-20 16:13:46
