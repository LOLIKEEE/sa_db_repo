-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: time_sheet
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
-- Temporary view structure for view `bmw`
--

DROP TABLE IF EXISTS `bmw`;
/*!50001 DROP VIEW IF EXISTS `bmw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bmw` AS SELECT 
 1 AS `employee_id`,
 1 AS `project_name`,
 1 AS `worked_hours`,
 1 AS `start_date`,
 1 AS `end_date`,
 1 AS `comment`,
 1 AS `record_status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_contact_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_idx` (`customer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'GSD Software & Technology','0040722222222'),(2,'BMW group','0044754229992'),(3,'Porsche','0044754220000');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `employee_age` int DEFAULT NULL,
  `employee_phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Nicolae',26,'0040754827541'),(2,'Radu',31,'0040754827555'),(3,'Gabriel',25,'0040754827010'),(4,'Cristian',22,'0040735497813'),(5,'Sebastian',27,'0040754222211');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `gsd`
--

DROP TABLE IF EXISTS `gsd`;
/*!50001 DROP VIEW IF EXISTS `gsd`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `gsd` AS SELECT 
 1 AS `employee_id`,
 1 AS `project_name`,
 1 AS `worked_hours`,
 1 AS `start_date`,
 1 AS `end_date`,
 1 AS `comment`,
 1 AS `record_status`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `porsche`
--

DROP TABLE IF EXISTS `porsche`;
/*!50001 DROP VIEW IF EXISTS `porsche`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `porsche` AS SELECT 
 1 AS `employee_id`,
 1 AS `project_name`,
 1 AS `worked_hours`,
 1 AS `start_date`,
 1 AS `end_date`,
 1 AS `comment`,
 1 AS `record_status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `project_name`
--

DROP TABLE IF EXISTS `project_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_name` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_name`
--

LOCK TABLES `project_name` WRITE;
/*!40000 ALTER TABLE `project_name` DISABLE KEYS */;
INSERT INTO `project_name` VALUES (1,'Software Academy Training'),(2,'BMW Sales platform'),(3,'Porsche Backend');
/*!40000 ALTER TABLE `project_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_owner`
--

DROP TABLE IF EXISTS `project_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_owner` (
  `id` int NOT NULL,
  `project_owner_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_owner`
--

LOCK TABLES `project_owner` WRITE;
/*!40000 ALTER TABLE `project_owner` DISABLE KEYS */;
INSERT INTO `project_owner` VALUES (1,'Darius'),(2,'Andreas'),(3,'Harald');
/*!40000 ALTER TABLE `project_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_type`
--

DROP TABLE IF EXISTS `task_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_type` (
  `id` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_type`
--

LOCK TABLES `task_type` WRITE;
/*!40000 ALTER TABLE `task_type` DISABLE KEYS */;
INSERT INTO `task_type` VALUES (1,'Developement'),(2,'Study');
/*!40000 ALTER TABLE `task_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_tracking`
--

DROP TABLE IF EXISTS `time_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_tracking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `customer` int DEFAULT NULL,
  `project_name` int DEFAULT NULL,
  `project_owner` int DEFAULT NULL,
  `task_type` int DEFAULT NULL,
  `worked_hours` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `record_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_idx` (`employee_id`),
  KEY `fk_customer_idx1` (`customer`),
  KEY `customer_idx` (`id`,`customer`),
  KEY `project_name_idx` (`project_name`),
  KEY `project_owner_idx` (`project_owner`),
  KEY `task_type_idx` (`task_type`),
  CONSTRAINT `customer` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`),
  CONSTRAINT `employees` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `project_name` FOREIGN KEY (`project_name`) REFERENCES `project_name` (`id`),
  CONSTRAINT `project_owner` FOREIGN KEY (`project_owner`) REFERENCES `project_owner` (`id`),
  CONSTRAINT `task_type` FOREIGN KEY (`task_type`) REFERENCES `task_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_tracking`
--

LOCK TABLES `time_tracking` WRITE;
/*!40000 ALTER TABLE `time_tracking` DISABLE KEYS */;
INSERT INTO `time_tracking` VALUES (1,1,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','paid'),(2,1,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','unpaid'),(3,3,2,2,2,2,8,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9999','paid'),(4,3,1,1,1,1,1,'2022-09-29','2022-09-29','Studied OCA','unpaid'),(5,4,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','unpaid'),(6,4,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','paid'),(7,5,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','unpaid'),(8,5,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','paid'),(9,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9999','unpaid'),(10,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9998','paid'),(11,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9997','paid'),(12,2,1,1,1,1,5,'2022-09-28','2022-09-28','GSD Software & Technology','unpaid'),(13,1,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(14,2,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(15,3,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(16,4,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','unpaid'),(17,5,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','unpaid');
/*!40000 ALTER TABLE `time_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `bmw`
--

/*!50001 DROP VIEW IF EXISTS `bmw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bmw` AS select `time_tracking`.`employee_id` AS `employee_id`,`time_tracking`.`project_name` AS `project_name`,`time_tracking`.`worked_hours` AS `worked_hours`,`time_tracking`.`start_date` AS `start_date`,`time_tracking`.`end_date` AS `end_date`,`time_tracking`.`comment` AS `comment`,`time_tracking`.`record_status` AS `record_status` from `time_tracking` where (`time_tracking`.`project_name` = '2') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gsd`
--

/*!50001 DROP VIEW IF EXISTS `gsd`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gsd` AS select `time_tracking`.`employee_id` AS `employee_id`,`time_tracking`.`project_name` AS `project_name`,`time_tracking`.`worked_hours` AS `worked_hours`,`time_tracking`.`start_date` AS `start_date`,`time_tracking`.`end_date` AS `end_date`,`time_tracking`.`comment` AS `comment`,`time_tracking`.`record_status` AS `record_status` from `time_tracking` where (`time_tracking`.`project_name` = '1') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `porsche`
--

/*!50001 DROP VIEW IF EXISTS `porsche`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `porsche` AS select `time_tracking`.`employee_id` AS `employee_id`,`time_tracking`.`project_name` AS `project_name`,`time_tracking`.`worked_hours` AS `worked_hours`,`time_tracking`.`start_date` AS `start_date`,`time_tracking`.`end_date` AS `end_date`,`time_tracking`.`comment` AS `comment`,`time_tracking`.`record_status` AS `record_status` from `time_tracking` where (`time_tracking`.`project_name` = '3') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-17 19:00:46
