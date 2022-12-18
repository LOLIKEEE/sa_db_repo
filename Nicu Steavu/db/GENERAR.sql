-- create DB
CREATE DATABASE `timesheet` DEFAULT CHARACTER SET utf8mb4;

-- use DB
USE timesheet;

-- create table
CREATE TABLE `timesheet`.`time_tracking` (
  `employee_id` INT(10) NULL,
  `project_id` INT(10) NULL,
  `task_id` INT(10) NULL,
  `worked_hours` INT(5) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `comment` VARCHAR(100) NULL,
  `status_id` INT(10) NULL);
  
CREATE TABLE `timesheet`.`employee_info` (
  `employee_id` INT NOT NULL,
  `employee_name` VARCHAR(10) NULL,
  `employee_age` INT(2) NULL,
  `employee_phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`employee_id`));
	
CREATE TABLE `timesheet`.`project_info` (
  `project_id` INT NOT NULL,
  `project_name` VARCHAR(45) NULL,
  `project_owner_name` VARCHAR(45) NULL,
  `customer_id` INT(10) NULL,
  PRIMARY KEY (`project_id`));
  
CREATE TABLE `timesheet`.`customer_info` (
  `customer_id` INT NOT NULL,
  `customer_name` VARCHAR(45) NULL,
  `customer_contact_number` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`));  
  
CREATE TABLE `timesheet`.`task_type` (
  `task_id` INT NOT NULL,
  `task` VARCHAR(45) NULL,
  PRIMARY KEY (`task_id`));
  
CREATE TABLE `timesheet`.`result_status` (
  `status_id` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`status_id`));
-- Add records to our database

INSERT INTO employee_info (employee_id, employee_name, employee_age, employee_phone_number)
VALUES (1, 'Nicolae', 26,'0754827541');
INSERT INTO employee_info (employee_id, employee_name, employee_age, employee_phone_number)
VALUES (2, 'Radu', 31,'0754827555');
INSERT INTO employee_info (employee_id, employee_name, employee_age, employee_phone_number)
VALUES (3, 'Gabriel', 25,'0754827010');
INSERT INTO employee_info (employee_id, employee_name, employee_age, employee_phone_number)
VALUES (4, 'Alex', 22,'075596102');
INSERT INTO employee_info (employee_id, employee_name, employee_age, employee_phone_number)
VALUES (5, 'Loredan', '43','078526312');

INSERT INTO customer_info(customer_id, customer_name, customer_contact_number)
VALUES (1, 'GSD Software & Tehnology', '0722222222');
INSERT INTO customer_info(customer_id, customer_name, customer_contact_number)
VALUES (2, 'Porsche', '0044754220000');
INSERT INTO customer_info(customer_id, customer_name, customer_contact_number)
VALUES (3, 'BMW Group', '0044754229992');
INSERT INTO customer_info(customer_id, customer_name, customer_contact_number)
VALUES (4, 'Spotify AB', '004975433692');

INSERT INTO task_type(task_id, task)
VALUES (1, 'Study');
INSERT INTO task_type(task_id, task)
VALUES (2, 'Development');
INSERT INTO task_type(task_id, task)
VALUES (3, 'Testing');

INSERT INTO result_status(status_id, status)
VALUES (1, 'Paid');
INSERT INTO result_status(status_id, status)
VALUES (2, 'Unpaid');

INSERT INTO project_info(project_id, project_name, project_owner_name, customer_id)
VALUES (1, 'Software Academy Training', 'Darius', 1);
INSERT INTO project_info(project_id, project_name, project_owner_name, customer_id)
VALUES (2, 'BMW Sales platform', 'Harald', 3);
INSERT INTO project_info(project_id, project_name, project_owner_name, customer_id)
VALUES (3, 'Porsche Backend', 'Andreas', 2);
INSERT INTO project_info(project_id, project_name, project_owner_name, customer_id)
VALUES (4, 'Spotify backend', 'Gunther', 4);

INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (1, 1, 1, 2, '2022-09-26', '2022-09-26', 'I studied the mysql tutorial pretty hard.', 2);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (1, 3, 1, 2, '2022-09-26', '2022-09-26', 'I studied the project.', 2);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (1, 2, 2, 2, '2022-09-27', '2022-09-27', 'I developed all features.', 2);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 2, 2, 3, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9999', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 2, 2, 3, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9998', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 2, 2, 3, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9997', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 2, 2, 3, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9996', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 3, 2, 5, '2022-09-28', '2022-09-28', 'Refactoring: PBP-0001', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (2, 1, 1, 5, '2022-09-28', '2022-09-28', 'Studied SQL Databases', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (3, 2, 2, 8, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9999', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (3, 3, 3, 1, '2022-09-28', '2022-09-28', 'Tested the frontend app: PBP-0001', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (3, 1, 1, 1, '2022-09-29', '2022-09-29', 'Studied OCA', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (4, 4, 1, 3, '2022-09-29', '2022-09-29', 'Studied the project', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (4, 4, 2, 1, '2022-09-29', '2022-09-29', 'Fixed the following bugs: SPA-9999', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (4, 2, 2, 1, '2022-09-28', '2022-09-28', 'I fixed the following bugs: BMW-9997', 2);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (5, 4, 2, 3, '2022-09-30', '2022-09-30', 'Refactoring: SPA-0003', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (5, 2, 3, 2, '2022-09-30', '2022-09-30', 'Tested the backend app: BMW-0001', 1);
INSERT INTO time_tracking(employee_id, project_id, task_id, worked_hours, start_date, end_date, comment, status_id)
VALUES (5, 2, 2, 3, '2022-09-30', '2022-09-30', 'I fixed the following bugs: BMW-9995', 1);