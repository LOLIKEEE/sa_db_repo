-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer_info` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NULL DEFAULT NULL,
  `customer_phone_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`employee_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee_info` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `employee_name` VARCHAR(45) NULL DEFAULT NULL,
  `employee_age` INT NULL DEFAULT NULL,
  `employee_phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `employee_experience` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`project_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`project_info` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `project_owner` VARCHAR(45) NULL DEFAULT NULL,
  `project_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `fk_project_info_customer_info_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_project_info_customer_info`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer_info` (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`result_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`result_status` (
  `status_id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`task_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`task_type` (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `task` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`task_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`time_tracking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`time_tracking` (
  `employee_id` INT NULL DEFAULT NULL,
  `project_id` INT NULL DEFAULT NULL,
  `task_id` INT NULL DEFAULT NULL,
  `worked_hours` INT NULL DEFAULT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `comment` VARCHAR(100) NULL DEFAULT NULL,
  `status_id` INT NULL DEFAULT NULL,
  `employee_info_employee_id` INT NOT NULL,
  `task_type_task_id` INT NOT NULL,
  `result_status_status_id` INT NOT NULL,
  `project_info_project_id` INT NOT NULL,
  INDEX `fk_time_tracking_employee_info1_idx` (`employee_info_employee_id` ASC) VISIBLE,
  INDEX `fk_time_tracking_task_type1_idx` (`task_type_task_id` ASC) VISIBLE,
  INDEX `fk_time_tracking_result_status1_idx` (`result_status_status_id` ASC) VISIBLE,
  INDEX `fk_time_tracking_project_info1_idx` (`project_info_project_id` ASC) VISIBLE,
  CONSTRAINT `fk_time_tracking_employee_info1`
    FOREIGN KEY (`employee_info_employee_id`)
    REFERENCES `mydb`.`employee_info` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_time_tracking_task_type1`
    FOREIGN KEY (`task_type_task_id`)
    REFERENCES `mydb`.`task_type` (`task_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_time_tracking_result_status1`
    FOREIGN KEY (`result_status_status_id`)
    REFERENCES `mydb`.`result_status` (`status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_time_tracking_project_info1`
    FOREIGN KEY (`project_info_project_id`)
    REFERENCES `mydb`.`project_info` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

USE `mydb` ;

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`employee_view`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee_view` (`employee_name` INT, `project_name` INT, `worked_hours` INT);

-- -----------------------------------------------------
-- procedure find_by_customer_id
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_by_customer_id`( IN find_by_id varchar(40))
BEGIN
 select customer_id, customer_name  from customer_info where find_by_id = customer_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_all_employees
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_employees`(in emp_name varchar(20))
BEGIN
select employee_name , employee_id from employee_info where emp_name= employee_name;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure search_employees_by_name
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_employees_by_name`(in emp_name varchar(20))
BEGIN
select employee_name , employee_id from employee_info where emp_name= employee_name;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_rec
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_rec`(IN rez INT, IN emp_name VARCHAR(45), IN proj_name VARCHAR(45))
BEGIN
	SET SQL_SAFE_UPDATES = 0;	
	UPDATE time_tracking
    SET status_id = rez
    WHERE
		rez <> 0 AND
		time_tracking.employee_id IN (SELECT employee_id FROM employee_info 
        WHERE employee_info.employee_name = emp_name) AND 
        time_tracking.project_id IN (SELECT project_id FROM project_info WHERE project_info.project_name = proj_name);	
	SET SQL_SAFE_UPDATES = 1;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- View `mydb`.`employee_view`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`employee_view`;
USE `mydb`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mydb`.`employee_view` AS select `mydb`.`employee_info`.`employee_name` AS `employee_name`,`mydb`.`project_info`.`project_name` AS `project_name`,`mydb`.`time_tracking`.`worked_hours` AS `worked_hours` from ((`mydb`.`time_tracking` join `mydb`.`employee_info` on((`mydb`.`time_tracking`.`employee_id` = `mydb`.`employee_info`.`employee_id`))) join `mydb`.`project_info` on((`mydb`.`time_tracking`.`project_id` = `mydb`.`project_info`.`project_id`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
