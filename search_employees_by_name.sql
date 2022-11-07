CREATE DEFINER=`root`@`localhost` PROCEDURE `search_employees_by_name`(in emp_name varchar(20))
BEGIN
select employee_name , employee_id from employee_info where emp_name= employee_name;

END