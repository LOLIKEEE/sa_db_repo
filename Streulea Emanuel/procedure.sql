CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure2`(in update_status int, in e_name varchar(45) , in p_name varchar(45))
BEGIN

UPDATE result_status
    SET status=update_status
    WHERE result_status.status_id IN(SELECT status_id FROM time_tracking
    	WHERE time_tracking.employee_id IN (SELECT employee_id FROM employee_info 
        WHERE employee_info.employee_name = e_name) AND 
        time_tracking.project_id IN (SELECT project_id FROM project_info WHERE project_info.project_name = p_name));



END