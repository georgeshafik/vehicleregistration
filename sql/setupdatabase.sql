-- as root
CREATE DATABASE IF NOT EXISTS `vehicleregistrationdb`;
FLUSH PRIVILEGES;

CREATE USER 'nswdcs'@'localhost' IDENTIFIED WITH mysql_native_password BY 'nswdcs@2023';
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON `vehicleregistrationdb`.* TO 'nswdcs'@'localhost';
FLUSH PRIVILEGES;

SET time_zone = "+10:00";
SET @@session.time_zone = "+10:00";
SET @@global.time_zone = "+10:00";

SELECT @@global.time_zone;
SELECT @@session.time_zone;

-- set it back
SET @@session.time_zone = "SYSTEM";
SET @@global.time_zone = "SYSTEM";

-- as user
USE `vehicleregistrationdb`;

DROP TABLE IF EXISTS `vehicle`;
DROP TABLE IF EXISTS `individual`;

CREATE TABLE `individual` (
    `id` varchar(50) NOT NULL,
    `firstname` varchar(255) NOT NULL,
    `secondname` varchar(255) NOT NULL,
    `middlename` varchar(255) DEFAULT NULL,
    `dob` date DEFAULT NULL,
    `licenseno` varchar(50) DEFAULT NULL,
    `isactive` boolean DEFAULT false,
    `datecreated` timestamp,
    `datemodified` timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE `vehicle` (
    `id` varchar(50) NOT NULL,
    `vinno` varchar(50) NOT NULL,
    `registrationno` varchar(50) NOT NULL,
    `personid` varchar(50),
    `vehiclemake` varchar(50) NOT NULL,
    `vehiclemodel` varchar(50) NOT NULL,
    `mfgyeardate` date DEFAULT NULL,
    `datecreated` timestamp,
    `datemodified` timestamp,
    FOREIGN KEY (personid) REFERENCES individual(id),
    PRIMARY KEY (id, registrationno)
);

INSERT INTO `individual` VALUES ('L22346789','Andy','Newton','','1984-11-22','22346789',true, now(), now());
INSERT INTO `individual` VALUES ('H45678109','Andrew','Newton','','1974-12-11','17893247',true,'2001-11-15 12:20:00','2001-11-12 12:20:00');
INSERT INTO `individual` VALUES ('L71209819','Steven','John','','1990-8-9','24870912',true,'2014-08-9 13:12:13','2014-08-9 13:12:13');
INSERT INTO `individual` VALUES ('L22569809','JOHN','Citizen','new','1965-3-12','22569809',true,'2011-07-19 15:11:13','2011-07-19 15:11:13');
INSERT INTO `individual` VALUES ('K56123409','Kayla','merkoviz','','1989-4-11','19890987',false,'2011-06-11 15:11:13','2011-06-11 15:11:13');

INSERT INTO `vehicle` VALUES ('CG12GH','V12782348-12830912709147','CG12GH','L22346789','HYUNDAI','TUCSON','2011-1-1 00:00:00','2011-11-15 12:20:24','2011-11-12 12:20:24');
INSERT INTO `vehicle` VALUES ('AH1845','K129631289641209701927410','AH1845','H45678109','AUDI','A4','2014-1-1 00:00:00','2011-11-12 12:20:24','2011-11-12 12:20:24');
INSERT INTO `vehicle` VALUES ('RN12GH','GH12312894819AH12342','RN12GH','L71209819','KIA','CERATO','2010-1-1 00:00:00','2014-08-9 13:12:13','2014-08-9 13:12:13');
INSERT INTO `vehicle` VALUES ('KG86BV','H1230917290H12311221','KG86BV','L22569809','KIA','X5','2011-1-1 00:00:00','2011-07-19 15:11:13','2011-07-19 15:11:13');
INSERT INTO `vehicle` VALUES ('AH23YU','HJ1203971209AH1243','AH23YU','K56123409','HYUNDAI','I30','2009-1-1 00:00:00','2011-06-11 15:11:13','2011-06-11 15:11:13');
