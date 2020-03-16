DROP TABLE IF EXISTS TLMS_CUSTOMER;
 
CREATE TABLE TLMS_CUSTOMER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  middle_name VARCHAR(250) DEFAULT NULL,
  customer_type VARCHAR(20) DEFAULT NULL,
  inserted_by varchar(10) DEFAULT 'TEST_ADMIN',
  updated_by varchar(10) DEFAULT 'TEST_ADMIN',
  inserted_date DATE DEFAULT SYSDATE,
  updated_date DATE DEFAULT SYSDATE
);

INSERT INTO TLMS_CUSTOMER (first_name, last_name, middle_name , customer_type) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist','LOAN_GUARANTOR'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur','LOAN_GUARANTOR'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate','LOAN_GUARANTOR');