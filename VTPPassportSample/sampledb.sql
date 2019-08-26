CREATE USER 'vtp'@'localhost' IDENTIFIED BY 'vtppwd';

create database vtp;

GRANT ALL PRIVILEGES ON vtp . * TO 'vtp'@'localhost';

use vtp;

-- CREATE TABLE passportProfile (
--     UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(24),
--     displayname VARCHAR(100),
--     trustedEmails VARCHAR(100),
--     trustedMobiles VARCHAR(100),
--     extData BLOB
--  );

 CREATE TABLE passportProfile (
    UID INT NOT NULL  PRIMARY KEY,
    username VARCHAR(24),
    displayname VARCHAR(100),
    trustedEmails VARCHAR(100),
    trustedMobiles VARCHAR(100),
    extData BLOB
 );

 