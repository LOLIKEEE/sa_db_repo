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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-17 18:59:10
