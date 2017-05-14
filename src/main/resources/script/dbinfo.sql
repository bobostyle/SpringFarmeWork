CREATE database if not exists mybatis;
use mybatis;
DROP TABLE IF EXISTS CUSTOMER; --������ڣ���ô��ɾ�����ٴ�������������ڣ�ֱ�Ӵ�����
CREATE table CUSTOMER(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	NAME varchar(255) DEFAULT NULL,
	CONTACT varchar(255) NOT NULL,
	TELEPHONE varchar(255) NOT NULL,
	EMAIL varchar(255)NOT NULL,
	REMARK TEXT,
	PRIMARY KEY (ID)
)ENGINE=INNODB,CHARSET=UTF8;
--�Ƿ���ڣ��������ڣ��Ͳ������ˣ�ֱ��ʹ�þɱ���������ڣ��Ŵ�����


INSERT INTO TABLE CUSTOMER
('NAME', 'CONTACT', 'TELEPHONE', 'EMAIL', 'REMARK')
VALUES
('customer1','Jack','88888888','@qq.com',null),
('customer2','BoBo','99999999','@zte.com', null);


