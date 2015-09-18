CREATE DATABASE IF NOT EXISTS `showfactory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `showfactory`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: showfactory
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `box`
--

DROP TABLE IF EXISTS `box`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `box` (
  `boxID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name`  VARCHAR(255)     DEFAULT NULL,
  `Note`  VARCHAR(4096)    DEFAULT NULL,
  PRIMARY KEY (`boxID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `box`
--

LOCK TABLES `box` WRITE;
/*!40000 ALTER TABLE `box` DISABLE KEYS */;
/*!40000 ALTER TABLE `box` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `box_has_item`
--

DROP TABLE IF EXISTS `box_has_item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `box_has_item` (
  `boxID`  INT(11) NOT NULL,
  `itemID` INT(11) NOT NULL,
  PRIMARY KEY (`boxID`, `itemID`),
  KEY `fk_Box_has_Item_Item1_idx` (`itemID`),
  KEY `fk_Box_has_Item_Box1_idx` (`boxID`),
  CONSTRAINT `fk_Box_has_Item_Box1` FOREIGN KEY (`boxID`) REFERENCES `box` (`boxID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Box_has_Item_Item1` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `box_has_item`
--

LOCK TABLES `box_has_item` WRITE;
/*!40000 ALTER TABLE `box_has_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `box_has_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryID`   INT(11) NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(45)      DEFAULT NULL,
  `abbreviation` VARCHAR(45)      DEFAULT NULL,
  `lastID`       INT(11)          DEFAULT '0',
  PRIMARY KEY (`categoryID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category`
VALUES (1, 'PA', 'pa', 0), (2, 'Light', 'li', 0), (3, 'Various', 'va', 0), (4, 'Supplies', 'su', 0),
  (5, 'Rigging', 'ri', 0), (6, 'Molton', 'mo', 0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `eventID`  INT(11) NOT NULL AUTO_INCREMENT,
  `Note`     VARCHAR(4096)    DEFAULT NULL,
  `Location` VARCHAR(255)     DEFAULT NULL,
  `Customer` VARCHAR(255)     DEFAULT NULL,
  `from`     TIMESTAMP(6)     DEFAULT NULL
  COMMENT 'CREATE TABLE IF NOT EXISTS `mydb`.`Event` (\n  `id` INT NOT NULL AUTO_INCREMENT COMMENT '''',\n  `Note` VARCHAR(4096) NULL COMMENT '''',\n  `Location` VARCHAR(255) NULL COMMENT '''',\n  `Customer` VARCHAR(255) NOT NULL COMMENT '''',\n  `from` TIMESTAMP(6) NULL COMMENT '''',\n  `till` DATE NULL COMMENT '''',\n  PRIMARY KEY (`id`)  COMMENT '''')\nENGINE = InnoDB',
  `till`     TIMESTAMP(6)     DEFAULT NULL,
  PRIMARY KEY (`eventID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
  /*!50003 CREATE */ /*!50017 DEFINER =`root`@`localhost` */ /*!50003 TRIGGER `Event_BEFORE_DELETE` BEFORE DELETE ON `event`

FOR EACH ROW BEGIN

  DELETE FROM event_has_item
  WHERE event_has_item.eventID = old.eventID;

  DELETE FROM event_has_box
  WHERE event_has_box.eventID = old.eventID;

END */;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;

--
-- Table structure for table `event_has_box`
--

DROP TABLE IF EXISTS `event_has_box`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_has_box` (
  `eventID` INT(11) NOT NULL,
  `boxID`   INT(11) NOT NULL,
  PRIMARY KEY (`eventID`, `boxID`),
  KEY `fk_Event_has_Box_Box1_idx` (`boxID`),
  KEY `fk_Event_has_Box_Event1_idx` (`eventID`),
  CONSTRAINT `fk_Event_has_Box_Box1` FOREIGN KEY (`boxID`) REFERENCES `box` (`boxID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_has_Box_Event1` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_has_box`
--

LOCK TABLES `event_has_box` WRITE;
/*!40000 ALTER TABLE `event_has_box` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_has_box` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_has_item`
--

DROP TABLE IF EXISTS `event_has_item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_has_item` (
  `eventID` INT(11) NOT NULL,
  `itemID`  INT(11) NOT NULL,
  PRIMARY KEY (`eventID`, `itemID`),
  KEY `fk_Event_has_Item_Item1_idx` (`itemID`),
  KEY `fk_Event_has_Item_Event1_idx` (`eventID`),
  CONSTRAINT `fk_Event_has_Item_Event1` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_has_Item_Item1` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_has_item`
--

LOCK TABLES `event_has_item` WRITE;
/*!40000 ALTER TABLE `event_has_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_has_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `itemID`       INT(11)      NOT NULL AUTO_INCREMENT,
  `Name`         VARCHAR(255) NOT NULL,
  `Manufacturer` VARCHAR(255)          DEFAULT NULL,
  `Weight`       INT(11)      NOT NULL,
  `SerialNumber` VARCHAR(255)          DEFAULT NULL,
  `Note`         VARCHAR(4096)         DEFAULT NULL,
  `categoryID`   INT(11)      NOT NULL,
  `storeID`      VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  UNIQUE KEY `storeID_UNIQUE` (`storeID`),
  KEY `fk_Item_Category1_idx` (`categoryID`),
  CONSTRAINT `fk_Item_Category1` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
  /*!50003 CREATE */ /*!50017 DEFINER =`root`@`localhost` */ /*!50003 TRIGGER `Item_BEFORE_INSERT` BEFORE INSERT ON `item`

FOR EACH ROW BEGIN

  DECLARE lastID_ INT;

  DECLARE abbreviation_ VARCHAR(45);


  SELECT
    lastID,
    abbreviation
  INTO lastID_, abbreviation_
  FROM Category
  WHERE categoryID = NEW.categoryID FOR UPDATE;

  UPDATE Category
  SET lastID = lastID + 1
  WHERE categoryID = NEW.categoryID;

  SET NEW.storeID = concat(abbreviation_, lastID_);

END */;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
  /*!50003 CREATE */ /*!50017 DEFINER =`root`@`localhost` */ /*!50003 TRIGGER `Item_BEFORE_UPDATE` BEFORE UPDATE ON `item`

FOR EACH ROW BEGIN


  DECLARE lastID_ INT;

  DECLARE abbreviation_ VARCHAR(45);


  IF NEW.categoryID != OLD.categoryID
  THEN

    SELECT
      lastID,
      abbreviation
    INTO lastID_, abbreviation_
    FROM Category
    WHERE categoryID = NEW.categoryID FOR UPDATE;

    UPDATE Category
    SET lastID = lastID + 1
    WHERE categoryID = NEW.categoryID;

    SET NEW.storeID = concat(abbreviation_, lastID_);

  END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
  /*!50003 CREATE */ /*!50017 DEFINER =`root`@`localhost` */ /*!50003 TRIGGER `Item_BEFORE_DELETE` BEFORE DELETE ON `item`

FOR EACH ROW BEGIN

  DELETE FROM event_has_item
  WHERE event_has_item.itemID = old.itemID;

  DELETE FROM Box_has_Item
  WHERE Box_has_Item.itemID = old.itemID;

  DELETE FROM Rack_has_item
  WHERE Rack_has_item.itemID = old.itemID;

END */;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;

--
-- Table structure for table `rack`
--

DROP TABLE IF EXISTS `rack`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rack` (
  `column` INT(11) NOT NULL,
  `row`    INT(11) NOT NULL,
  `note`   VARCHAR(4096) DEFAULT NULL,
  PRIMARY KEY (`column`, `row`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rack`
--

LOCK TABLES `rack` WRITE;
/*!40000 ALTER TABLE `rack` DISABLE KEYS */;
/*!40000 ALTER TABLE `rack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rack_has_item`
--

DROP TABLE IF EXISTS `rack_has_item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rack_has_item` (
  `Rack_column` INT(11) NOT NULL,
  `Rack_row`    INT(11) NOT NULL,
  `itemID`      INT(11) NOT NULL,
  PRIMARY KEY (`Rack_column`, `Rack_row`, `itemID`),
  KEY `fk_Rack_has_Item_Item1_idx` (`itemID`),
  KEY `fk_Rack_has_Item_Rack1_idx` (`Rack_column`, `Rack_row`),
  CONSTRAINT `fk_Rack_has_Item_Item1` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rack_has_Item_Rack1` FOREIGN KEY (`Rack_column`, `Rack_row`) REFERENCES `rack` (`column`, `row`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rack_has_item`
--

LOCK TABLES `rack_has_item` WRITE;
/*!40000 ALTER TABLE `rack_has_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `rack_has_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2015-09-15 23:44:41
