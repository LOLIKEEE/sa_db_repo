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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-17 18:59:10
