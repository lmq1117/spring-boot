drop table if exists member;
create table member (
id bigint(20) NOT NULL AUTO_INCREMENT,
username varchar(40) DEFAULT NULL,
name varchar(20) DEFAULT NULL,
age int(3) DEFAULT NULL,
balance decimal(10,2) DEFAULT NULL,
primary key(id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--  ALTER TABLE USER ADD level int(10) NOT NULL DEFAULT 0 AFTER username
