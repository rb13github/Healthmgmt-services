CREATE TABLE employee

( employeeName varchar(100) NOT NULL,
  employeeId varchar(11) NOT NULL ,

 employeeAddress varchar(100) DEFAULT NULL,

 employeeEmail varchar(100) DEFAULT NULL,

 PRIMARY KEY (employeeId)

);

CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name varchar(100) NOT NULL,
  brand varchar(100) NOT NULL,
  madein varchar(100) NOT NULL,
  price float NOT NULL  
);

CREATE TABLE appuser (
  username varchar(100) NOT NULL PRIMARY KEY,
  password varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  role varchar(50) NOT NULL
);