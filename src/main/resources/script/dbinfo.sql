CREATE database if not exists mybatis;
use mybatis;
DROP TABLE IF EXISTS CUSTOMER; --如果存在，那么先删除表，再创建。如果不存在，直接创建。
CREATE table CUSTOMER(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	NAME varchar(255) DEFAULT NULL,
	CONTACT varchar(255) NOT NULL,
	TELEPHONE varchar(255) NOT NULL,
	EMAIL varchar(255)NOT NULL,
	REMARK TEXT,
	PRIMARY KEY (ID)
)ENGINE=INNODB,CHARSET=UTF8;
--是否存在，如果表存在，就不创建了，直接使用旧表。如果不存在，才创建。


INSERT INTO TABLE CUSTOMER
('NAME', 'CONTACT', 'TELEPHONE', 'EMAIL', 'REMARK')
VALUES
('customer1','Jack','88888888','@qq.com',null),
('customer2','BoBo','99999999','@zte.com', null);


