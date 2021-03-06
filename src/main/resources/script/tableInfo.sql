--父表 
DROP TABLE IF EXISTS CUSTOMER;  -- 先删除子表 
DROP TABLE IF EXISTS BUSINESS;  -- 再删除父表 (由于使用了唯一性约束)

CREATE TABLE BUSINESS(
	BUSINESS_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	BUSINESS_NAME varchar(255)  NOT NULL,
	BUSINESS_ADDRESS varchar(2000) NOT NULL,
	PRIMARY KEY (BUSINESS_ID)
)ENGINE=INNODB,CHARSET=UTF8,AUTO_INCREMENT=1;

--子表
CREATE TABLE CUSTOMER(
	CUSTOMER_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	CUSTOMER_BUSINESS_ID BIGINT(20) NOT NULL,
	CUSTOMER_NAME varchar(255) NOT NULL,
	CUSTOMER_CONTACT varchar(255) NOT NULL,
	CUSTOMER_TELEPHONE varchar(255) NOT NULL,
	CUSTOMER_EMAIL varchar(255),
	CUSTOMER_REMARK varchar(2000),
	PRIMARY KEY (CUSTOMER_ID),
	FOREIGN KEY (CUSTOMER_BUSINESS_ID) REFERENCES BUSINESS(BUSINESS_ID),
	UNIQUE KEY UNIQUE_KEY_NAME (CUSTOMER_BUSINESS_ID, CUSTOMER_NAME, CUSTOMER_TELEPHONE)   
)ENGINE=INNODB,CHARSET=UTF8;

INSERT INTO BUSINESS
(BUSINESS_NAME, BUSINESS_ADDRESS)
VALUES
('business1', 'shenzhen'),
('business2', 'xili');

INSERT INTO CUSTOMER
(CUSTOMER_BUSINESS_ID, CUSTOMER_NAME, CUSTOMER_CONTACT, CUSTOMER_TELEPHONE, CUSTOMER_EMAIL, CUSTOMER_REMARK)
VALUES
('1', 'customer1', 'Jack', '88888888', '@qq.com' , null),
('1', 'customer2', 'BoBo', '99999999', '@zte.com', null),
('2', 'customer3', 'Tom', '77777777', '@qq.com' , null),
('2', 'customer3', 'Jun', '33333333', '@zte.com', null);


