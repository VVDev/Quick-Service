# SQL Manager 2007 Lite for MySQL 4.0.5.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : dbquick


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `dbquick`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `dbquick`;

#
# Structure for the `attivita` table : 
#

DROP TABLE IF EXISTS `attivita`;

CREATE TABLE `attivita` (
  `Id` int(3) NOT NULL auto_increment,
  `Nome` varchar(20) default NULL,
  `Descrizione` longtext,
  `DataA` varchar(20) default NULL,
  `Ora` varchar(20) default NULL,
  `Posti_disponibili` float default NULL,
  `Prezzo` float default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `prenotazioni` table : 
#

DROP TABLE IF EXISTS `prenotazioni`;

CREATE TABLE `prenotazioni` (
  `Id` int(3) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `posti` int(11) default NULL,
  `Prenotato` varchar(2) default NULL,
  `Cf` char(16) default NULL,
  KEY `prenotazioni_ibfk_1` (`Id`),
  KEY `prenotazioni_ibfk_2` (`Cf`),
  CONSTRAINT `prenotazioni_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `attivita` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `ruolo` table : 
#

DROP TABLE IF EXISTS `ruolo`;

CREATE TABLE `ruolo` (
  `Codice` char(3) NOT NULL,
  `Descrizione` varchar(10) default NULL,
  PRIMARY KEY  (`Codice`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `utente` table : 
#

DROP TABLE IF EXISTS `utente`;

CREATE TABLE `utente` (
  `Cf` char(16) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `User_name` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Codice_ruolo` char(3) NOT NULL,
  PRIMARY KEY  (`Cf`),
  KEY `Utente_ibfk_1` (`Codice_ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Definition for the `spCancellaAttivita` procedure : 
#

DROP PROCEDURE IF EXISTS `spCancellaAttivita`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spCancellaAttivita`(IN IdA INTEGER(3))
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
  delete  from Attivita where Id = IdA;
END;

#
# Definition for the `spGetLogin` procedure : 
#

DROP PROCEDURE IF EXISTS `spGetLogin`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spGetLogin`(iN User char(5), in Pass char(5))
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
	select * from utente where utente.User_name=User and utente.Password=PASS;
END;

#
# Definition for the `spInserisciAttivita` procedure : 
#

DROP PROCEDURE IF EXISTS `spInserisciAttivita`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spInserisciAttivita`(IN NomeA VARCHAR(20), IN DescrizioneA VARCHAR(100), IN DataA VARCHAR(20), IN OraA VARCHAR(20), IN PostiA INTEGER(11), IN PrezzoA FLOAT)
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
Insert into Attivita (Nome,Descrizione,DataA,Ora,Posti_disponibili,Prezzo) values(NomeA,DescrizioneA,DataA,OraA,PostiA,PrezzoA);
END;

#
# Definition for the `spInsertGestore` procedure : 
#

DROP PROCEDURE IF EXISTS `spInsertGestore`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spInsertGestore`(IN CfG CHAR(16), IN NomeG VARCHAR(20), IN CognomeG VARCHAR(20), IN UsrG VARCHAR(20), IN PwdG VARCHAR(20), IN RuoloG CHAR(3))
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
insert into utente (Cf, Nome, Cognome, User_name, Password, Codice_ruolo) values(CfG, NomeG, CognomeG, UsrG, PwdG, RuoloG);
END;

#
# Definition for the `spInsertPrenotazione` procedure : 
#

DROP PROCEDURE IF EXISTS `spInsertPrenotazione`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spInsertPrenotazione`(IN IdA INTEGER(11), IN NomeA VARCHAR(20), IN CognomeA VARCHAR(20), IN PostiA INTEGER(11), IN PrenotatoA VARCHAR(2), IN CfA CHAR(16))
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
 INSERT into    prenotazioni (Id,Nome,Cognome,posti,Prenotato,Cf ) Values (IdA,NomeA,CognomeA,PostiA,PrenotatoA,CfA) ;
END;

#
# Definition for the `spSelezionaAttivita` procedure : 
#

DROP PROCEDURE IF EXISTS `spSelezionaAttivita`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spSelezionaAttivita`()
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
       Select * from attivita ;
END;

#
# Definition for the `spUpdateAttivita` procedure : 
#

DROP PROCEDURE IF EXISTS `spUpdateAttivita`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spUpdateAttivita`(IN IdA INTEGER(3), IN NomeA VARCHAR(20), IN DescA LONGTEXT, IN Data VARCHAR(20), IN OraA VARCHAR(20), IN PostiA INTEGER(11), IN PrezzoA FLOAT)
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
 update attivita set Nome = NomeA, Descrizione = DescA, DataA = DATA, Ora = OraA,Posti_disponibili = PostiA,Prezzo =PrezzoA where Id = IdA ; 
END;

#
# Definition for the `spVisualizzaPrenotazioni` procedure : 
#

DROP PROCEDURE IF EXISTS `spVisualizzaPrenotazioni`;

CREATE DEFINER = 'root'@'localhost' PROCEDURE `spVisualizzaPrenotazioni`()
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
     select * from prenotazioni;
END;

#
# Data for the `attivita` table  (LIMIT 0,500)
#

INSERT INTO `attivita` (`Id`, `Nome`, `Descrizione`, `DataA`, `Ora`, `Posti_disponibili`, `Prezzo`) VALUES 
  (1,'gioco1','Caccia al tesoro','2004-07-03','10:00:00',1100,90),
  (4,'1','11','1','1',1,1);

COMMIT;

#
# Data for the `prenotazioni` table  (LIMIT 0,500)
#

INSERT INTO `prenotazioni` (`Id`, `Nome`, `Cognome`, `posti`, `Prenotato`, `Cf`) VALUES 
  (1,'dsf','ddddd',4,'SI','1234567892154698'),
  (1,'luca','rossi',10,'SI','1234567892154698');

COMMIT;

#
# Data for the `ruolo` table  (LIMIT 0,500)
#

INSERT INTO `ruolo` (`Codice`, `Descrizione`) VALUES 
  ('abc','n[\r\n¹');

COMMIT;

#
# Data for the `utente` table  (LIMIT 0,500)
#

INSERT INTO `utente` (`Cf`, `Nome`, `Cognome`, `User_name`, `Password`, `Codice_ruolo`) VALUES 
  ('1234567890987654','gest','gest','gest','gest','002'),
  ('1234567892154698','luca','giordano','luc','gio','003'),
  ('9876545678987654','a','a','admin','admin','001'),
  ('bbbccc22d33e4441','luca','Francicanava','1','1','002');

COMMIT;

