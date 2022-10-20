-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `time tracking`
--

DROP TABLE IF EXISTS `time tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time tracking` (
  `employeeID` int DEFAULT NULL,
  `projectID` int DEFAULT NULL,
  `taskID` int DEFAULT NULL,
  `worked_hours` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `statusID` int DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  KEY `1_idx` (`employeeID`),
  KEY `2_idx` (`taskID`),
  KEY `3_idx` (`statusID`),
  KEY `4_idx` (`projectID`),
  KEY `5_idx` (`customerID`),
  CONSTRAINT `1` FOREIGN KEY (`employeeID`) REFERENCES `employee info` (`employeeID`),
  CONSTRAINT `2` FOREIGN KEY (`taskID`) REFERENCES `tasks` (`taskID`),
  CONSTRAINT `3` FOREIGN KEY (`statusID`) REFERENCES `status results` (`statusID`),
  CONSTRAINT `4` FOREIGN KEY (`projectID`) REFERENCES `project info` (`projectID`),
  CONSTRAINT `5` FOREIGN KEY (`customerID`) REFERENCES `customer info` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time tracking`
--

LOCK TABLES `time tracking` WRITE;
/*!40000 ALTER TABLE `time tracking` DISABLE KEYS */;
INSERT INTO `time tracking` VALUES (1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.',2,NULL),(1,3,1,2,'2022-09-26','2022-09-26','I studied the project.',2,NULL),(1,2,2,2,'2022-09-27','2022-09-27','I developed all features.',2,NULL),(2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9999',1,NULL),(5,4,2,3,'2022-09-30','2022-09-30','Refactoring: SPA-0003',1,NULL),(5,2,3,2,'2022-09-30','2022-09-30','Tested the backend app: BMW-0001',1,NULL),(6,5,1,2,'2022-09-26','2022-09-26','fix bug #1237.',2,NULL);
/*!40000 ALTER TABLE `time tracking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-20  1:58:46
