CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `timesheet`.`employeeproj` AS
    SELECT 
        `timesheet`.`employee_info`.`employee_name` AS `employee_name`,
        `timesheet`.`project_info`.`project_name` AS `project_name`,
        `timesheet`.`time_tracking`.`worked_hours` AS `worked_hours`
    FROM
        ((`timesheet`.`time_tracking`
        JOIN `timesheet`.`employee_info` ON ((`timesheet`.`time_tracking`.`employee_id` = `timesheet`.`employee_info`.`employee_id`)))
        JOIN `timesheet`.`project_info` ON ((`timesheet`.`time_tracking`.`project_id` = `timesheet`.`project_info`.`project_id`)))