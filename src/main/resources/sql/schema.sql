CREATE TABLE `TBL_USER` (
  `ID`        NUMBER(30, 0) IDENTITY(1.1) PRIMARY KEY ,
  `USERNAME`  VARCHAR2(30) NOT NULL UNIQUE ,
  `PASSWORD`  VARCHAR2(50) NOT NULL ,
  `FIRSTNAME` VARCHAR2(20) ,
  `LASTNAME`  VARCHAR2(20) ,
);