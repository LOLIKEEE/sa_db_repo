CREATE PROCEDURE `returnProj` (IN proj_name VARCHAR(45))
BEGIN
		SELECT
			employee_name,
			project_name,
			SUM(worked_hours)
		FROM
			employeeproj
		WHERE
			project_name = proj_name;
END
