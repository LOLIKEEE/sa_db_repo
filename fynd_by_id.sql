CREATE DEFINER=`root`@`localhost` PROCEDURE `find_by_customer_id`( IN find_by_id varchar(40))
BEGIN
 select customer_id, customer_name  from customer_info where find_by_id = customer_id;
END