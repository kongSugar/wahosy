-- TODO DB erstellen & auswählen
CREATE DATABASE IF NOT EXISTS `showfactory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `showfactory`;


-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: #########    DatabaseOld: showfactory
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
-- Table structure for table `...`
--

-- TODO RUN SCRIPT

DROP TABLE IF EXISTS `...`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `...` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `Item_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `Item_id`),
  KEY `fk_Light_Item1_idx` (`Item_id`),
  CONSTRAINT `fk_Light_Item10` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `box`
--

DROP TABLE IF EXISTS `box`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `box` (
  `idBox`   INT(11) NOT NULL AUTO_INCREMENT,
  `Name`    VARCHAR(255)     DEFAULT NULL,
  `Note`    VARCHAR(45)      DEFAULT NULL,
  `Item_id` INT(11) NOT NULL,
  PRIMARY KEY (`idBox`, `Item_id`),
  KEY `fk_Box_Item1_idx` (`Item_id`),
  CONSTRAINT `fk_Box_Item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `idCategory` INT(11)     NOT NULL,
  `name`       VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategory`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id`       INT(11)      NOT NULL AUTO_INCREMENT,
  `Note`     VARCHAR(4096)         DEFAULT NULL,
  `Location` VARCHAR(255)          DEFAULT NULL,
  `Customer` VARCHAR(255) NOT NULL,
  `from`     DATETIME              DEFAULT NULL
  COMMENT 'CREATE TABLE IF NOT EXISTS `mydb`.`Event` (\n  `id` INT NOT NULL AUTO_INCREMENT COMMENT '''',\n  `Note` VARCHAR(4096) NULL COMMENT '''',\n  `Location` VARCHAR(255) NULL COMMENT '''',\n  `Customer` VARCHAR(255) NOT NULL COMMENT '''',\n  `from` TIMESTAMP(6) NULL COMMENT '''',\n  `till` DATE NULL COMMENT '''',\n  PRIMARY KEY (`id`)  COMMENT '''')\nENGINE = InnoDB',
  `till`     DATETIME              DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `event_has_item`
--

DROP TABLE IF EXISTS `event_has_item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_has_item` (
  `Event_id` INT(11) NOT NULL,
  `Item_id`  INT(11) NOT NULL,
  PRIMARY KEY (`Event_id`, `Item_id`),
  KEY `fk_Event_has_Item_Item1_idx` (`Item_id`),
  KEY `fk_Event_has_Item_Event1_idx` (`Event_id`),
  CONSTRAINT `fk_Event_has_Item_Event1` FOREIGN KEY (`Event_id`) REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_has_Item_Item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id`                  INT(11)      NOT NULL AUTO_INCREMENT,
  `Name`                VARCHAR(255) NOT NULL,
  `Manufacturer`        VARCHAR(255)          DEFAULT NULL,
  `Weight`              INT(11)      NOT NULL,
  `SerialNumber`        VARCHAR(255)          DEFAULT NULL,
  `Note`                VARCHAR(4096)         DEFAULT NULL,
  `Box_idBox`           INT(11)               DEFAULT NULL,
  `Category_idCategory` INT(11)      NOT NULL,
  PRIMARY KEY (`id`, `Category_idCategory`),
  KEY `fk_Item_Box1_idx` (`Box_idBox`),
  KEY `fk_Item_Category1_idx` (`Category_idCategory`),
  CONSTRAINT `fk_Item_Box1` FOREIGN KEY (`Box_idBox`) REFERENCES `box` (`idBox`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Category1` FOREIGN KEY (`Category_idCategory`) REFERENCES `category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `light` (
  `idLight` INT(11) NOT NULL AUTO_INCREMENT,
  `Item_id` INT(11) NOT NULL,
  PRIMARY KEY (`idLight`, `Item_id`),
  KEY `fk_Light_Item1_idx` (`Item_id`),
  CONSTRAINT `fk_Light_Item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pa`
--

DROP TABLE IF EXISTS `pa`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pa` (
  `id`      INT(11) NOT NULL,
  `Item_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `Item_id`),
  KEY `fk_PA_Item1_idx` (`Item_id`),
  CONSTRAINT `fk_PA_Item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place_in_rack`
--

DROP TABLE IF EXISTS `place_in_rack`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `place_in_rack` (
  `Item_id`    INT(11) NOT NULL,
  `Rack_Level` INT(11) NOT NULL,
  `Rack_Id`    INT(11) NOT NULL,
  PRIMARY KEY (`Item_id`, `Rack_Level`, `Rack_Id`),
  KEY `fk_Place_in_Rack_Rack1_idx` (`Rack_Level`, `Rack_Id`),
  CONSTRAINT `fk_Place_in_Rack_Item1` FOREIGN KEY (`Item_id`) REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Place_in_Rack_Rack1` FOREIGN KEY (`Rack_Level`, `Rack_Id`) REFERENCES `rack` (`Level`, `Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rack`
--

DROP TABLE IF EXISTS `rack`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rack` (
  `Level` INT(11) NOT NULL,
  `Id`    INT(11) NOT NULL,
  PRIMARY KEY (`Level`, `Id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2015-09-06 14:09:58
