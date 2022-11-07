CREATE DEFINER=`root`@`localhost` PROCEDURE `update_rec`(IN rez INT, IN emp_name VARCHAR(10), IN proj_name VARCHAR(45))
BEGIN
	SET SQL_SAFE_UPDATES = 0;	
	UPDATE time_tracking
    SET status_id = rez
    WHERE
		rez <> 0 AND
		time_tracking.employee_id IN (SELECT employee_id FROM employee_info WHERE employee_info.employee_name = emp_name) AND 
        time_tracking.project_id IN (SELECT project_id FROM project_info WHERE project_info.project_name = proj_name);	
	SET SQL_SAFE_UPDATES = 1;
END