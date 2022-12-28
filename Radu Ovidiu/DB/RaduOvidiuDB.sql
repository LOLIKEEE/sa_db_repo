CREATE DATABASE  IF NOT EXISTS `timesheet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `timesheet`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: timesheet
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
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'GSD Software & Technology','0040722222222'),(2,'BMW group','0044754229992'),(3,'Porsche','0044754220000');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Nicolae',26,'0040754827541'),(2,'Radu',31,'0040754827555'),(3,'Gabriel',25,'0040754827010'),(4,'Cristian',22,'0040735497813'),(5,'Sebastian',27,'0040754222211');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_name`
--

LOCK TABLES `project_name` WRITE;
/*!40000 ALTER TABLE `project_name` DISABLE KEYS */;
INSERT INTO `project_name` VALUES (1,'Software Academy Training'),(2,'BMW Sales platform'),(3,'Porsche Backend');
/*!40000 ALTER TABLE `project_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_owner`
--

LOCK TABLES `project_owner` WRITE;
/*!40000 ALTER TABLE `project_owner` DISABLE KEYS */;
INSERT INTO `project_owner` VALUES (1,'Darius'),(2,'Andreas'),(3,'Harald');
/*!40000 ALTER TABLE `project_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_type`
--

LOCK TABLES `task_type` WRITE;
/*!40000 ALTER TABLE `task_type` DISABLE KEYS */;
INSERT INTO `task_type` VALUES (1,'Developement'),(2,'Study');
/*!40000 ALTER TABLE `task_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `time_tracking`
--

LOCK TABLES `time_tracking` WRITE;
/*!40000 ALTER TABLE `time_tracking` DISABLE KEYS */;
INSERT INTO `time_tracking` VALUES (1,1,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','paid'),(2,1,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','unpaid'),(3,3,2,2,2,2,8,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9999','paid'),(4,3,1,1,1,1,1,'2022-09-29','2022-09-29','Studied OCA','unpaid'),(5,4,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','unpaid'),(6,4,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','paid'),(7,5,1,1,1,1,2,'2022-09-26','2022-09-26','I studied the mysql tutorial pretty hard.','unpaid'),(8,5,2,2,2,2,2,'2022-09-26','2022-09-26','I developed all features.','paid'),(9,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9999','paid'),(10,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9998','paid'),(11,2,2,2,2,2,3,'2022-09-28','2022-09-28','I fixed the following bugs: BMW-9997','paid'),(12,2,1,1,1,1,5,'2022-09-28','2022-09-28','GSD Software & Technology','unpaid'),(13,1,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(14,2,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(15,3,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','paid'),(16,4,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','unpaid'),(17,5,3,3,3,2,2,'2022-09-26','2022-09-26','I studied the project.','unpaid');
/*!40000 ALTER TABLE `time_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'timesheet'
--

--
-- Dumping routines for database 'timesheet'
--
/*!50003 DROP PROCEDURE IF EXISTS `get_project_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_project_name`(
project int
)
BEGIN
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select employees.employee_name, SUM(time_tracking.worked_hours) , project_name.project_name from time_tracking
join employees on time_tracking.employee_id = employees.id
join project_name on time_tracking.project_name = project_name.id
where   project_name.id= project
 group by employee_name ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_record_status` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_record_status`(set_record_status varchar(45), employee varchar(45), project varchar(45))
BEGIN
UPDATE time_tracking
SET record_status = set_record_status
WHERE employee_id = (SELECT id FROM employees WHERE employee_name = employee)
AND 
project_name = (SELECT id FROM project_name WHERE project_name = project);
select time_tracking.id Id, employee_name Employee, employee_age Age, employee_phone_number Phone, record_status Record   from employees 
join time_tracking on time_tracking.employee_id = employees.id
join project_name on time_tracking.project_name = project_name.id
where employee_name=employee and record_status=set_record_status limit 1 ; 
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

-- Dump completed on 2022-12-28 21:58:49
