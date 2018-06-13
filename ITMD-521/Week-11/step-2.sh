#!/bin/sh


mysql -u root  -pitmd521   << eof\
use hadoopguide;

DELIMITER $$
 CREATE PROCEDURE dbInsert()
 BEGIN
 DECLARE i INT;
 SET i = 1;
 WHILE i <= 5000 DO
 INSERT INTO widgets (widget_name,price,design_date,version,design_comment) VALUES ((ELT(1+floor(rand()*3),'sprocket','gizmo','gadget')), ELT(1+floor(rand()*
),'0.25','4.00','99.99'), ELT(1+floor(rand()*3),'2012-10-12','2009-11-30','1983-08-13'), ELT(1+floor(rand()*3),'1','4','13'), ELT(1+floor(rand()*3),'connects
two gizmos','connects three gizmos','Our flagship product') );
 set i=i+1;
 END WHILE;
 END$$
DELIMITER ;
CALL dbInsert();
