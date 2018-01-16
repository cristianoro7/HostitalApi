-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `appointment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patient_id` bigint(20) unsigned NOT NULL,
  `consulting_date` datetime NOT NULL,
  `medicine_list_id` bigint(20) unsigned DEFAULT NULL,
  `doctor_id` bigint(20) unsigned DEFAULT NULL,
  `department_id` bigint(20) unsigned DEFAULT NULL,
  `consulting_room_id` bigint(20) unsigned DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  `finish` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`appointment_id`,`patient_id`),
  KEY `patient_id` (`patient_id`),
  KEY `medicine_list_id` (`medicine_list_id`),
  KEY `department_id` (`department_id`),
  KEY `consulting_room_id` (`consulting_room_id`),
  KEY `appointment_ibfk_3_idx` (`doctor_id`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`medicine_list_id`) REFERENCES `medicine_list` (`medicine_id`),
  CONSTRAINT `appointment_ibfk_4` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `appointment_ibfk_5` FOREIGN KEY (`consulting_room_id`) REFERENCES `consulting_room` (`consulting_room_id`),
  CONSTRAINT `fk_appointment_1` FOREIGN KEY (`doctor_id`) REFERENCES `h_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,1,'2018-12-12 12:00:00',1,1,1,1,'2017-12-12 12:00:00',NULL,1),(5,2,'2018-12-12 12:00:00',NULL,1,1,1,'2018-12-12 12:00:00',NULL,1),(7,3,'2017-12-01 12:30:00',NULL,1,1,1,'2018-01-16 15:25:27',NULL,0);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_report`
--

DROP TABLE IF EXISTS `case_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_report` (
  `case_report_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patient_id` bigint(20) unsigned DEFAULT NULL,
  `description` varchar(250) NOT NULL,
  `is_pay` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`case_report_id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `case_report_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_report`
--

LOCK TABLES `case_report` WRITE;
/*!40000 ALTER TABLE `case_report` DISABLE KEYS */;
INSERT INTO `case_report` VALUES (1,1,'发烧而已, 吃点药就行了',1,'2017-01-20 00:00:00',NULL),(6,1,'好好的',0,'2018-01-15 12:10:37',NULL),(7,1,'好好的',1,'2018-01-15 12:12:28',NULL),(8,1,'挂号4',1,'2018-01-15 13:07:38',NULL),(9,2,'哈哈哈',1,'2018-01-15 21:05:57',NULL),(10,1,'发烧了',1,'2018-01-16 16:06:28',NULL);
/*!40000 ALTER TABLE `case_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulting_room`
--

DROP TABLE IF EXISTS `consulting_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulting_room` (
  `consulting_room_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `location` char(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  `department_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`consulting_room_id`),
  KEY `fk_consulting_room_1_idx` (`department_id`),
  CONSTRAINT `fk_consulting_room_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulting_room`
--

LOCK TABLES `consulting_room` WRITE;
/*!40000 ALTER TABLE `consulting_room` DISABLE KEYS */;
INSERT INTO `consulting_room` VALUES (1,'一楼-202','2018-01-11 19:29:20','2018-01-14 20:56:32',1),(2,'一楼-102','2018-01-11 19:29:29',NULL,1),(3,'一楼-103','2018-01-11 19:29:32',NULL,1),(4,'一楼-104','2018-01-11 19:29:35','2018-01-14 20:56:18',2),(5,'一楼-105','2018-01-11 19:29:39',NULL,2),(6,'一楼-106','2018-01-11 19:29:42',NULL,4),(7,'一楼-107','2018-01-11 19:29:45','2018-01-14 20:54:57',3),(8,'二楼-201','2018-01-11 19:29:57',NULL,3),(9,'二楼-202','2018-01-11 19:30:00',NULL,3),(10,'二楼-203','2018-01-11 19:30:03',NULL,3),(11,'二楼-204','2018-01-11 19:30:06',NULL,3),(13,'二楼-206','2018-01-11 19:30:11',NULL,4),(17,'222','2018-01-14 22:27:37','2018-01-14 22:27:50',1);
/*!40000 ALTER TABLE `consulting_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `department_name` char(20) NOT NULL,
  `counts` smallint(5) unsigned DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'口腔科',20,'2018-01-11 19:26:55',NULL),(2,'神经科',20,'2018-01-11 19:27:05',NULL),(3,'内科',20,'2018-01-11 19:27:13',NULL),(4,'妇科',20,'2018-01-11 19:27:19',NULL),(5,'男科',20,'2018-01-11 19:27:24',NULL),(6,'眼科',20,'2018-01-11 19:27:30',NULL),(7,'皮肤科',20,'2018-01-11 19:27:40',NULL),(8,'物科',20,'2018-01-13 23:50:00','2018-01-14 16:24:12'),(10,'内分泌科',80,'2018-01-16 15:04:00',NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h_user`
--

DROP TABLE IF EXISTS `h_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` char(20) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` tinyint(3) unsigned NOT NULL,
  `tel_phone` char(20) DEFAULT NULL,
  `title_id` bigint(20) unsigned DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  `user_account` varchar(20) NOT NULL,
  `passwd` varchar(25) NOT NULL,
  `consulting_room_id` bigint(20) unsigned DEFAULT NULL,
  `department_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_account_UNIQUE` (`user_account`),
  KEY `title_id` (`title_id`),
  KEY `fk_h_user_2_idx` (`consulting_room_id`),
  KEY `fk_h_user_1_idx` (`department_id`),
  CONSTRAINT `fk_h_user_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_h_user_2` FOREIGN KEY (`consulting_room_id`) REFERENCES `consulting_room` (`consulting_room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `h_user_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `user_title` (`title_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h_user`
--

LOCK TABLES `h_user` WRITE;
/*!40000 ALTER TABLE `h_user` DISABLE KEYS */;
INSERT INTO `h_user` VALUES (1,'瑟莉娜','女',1,'15625199954',1,'2018-01-11 19:21:34','2018-01-15 22:47:10','424494431','MTIzNDU2',1,1),(2,'test','男',19,'15565872800',1,'2018-01-11 19:24:35','2018-01-16 14:43:31','123456789','MTIzNDU2Nzg5',1,1),(4,'啦啦','女',28,'14573574685',2,'2018-01-15 10:57:34','2018-01-15 23:17:52','956235541','OTU2MjM1NTQx',1,1),(8,'临时','男',25,'12365456534',1,'2018-01-15 16:08:46','2018-01-15 23:16:15','09809809','MDk4MDk4MDk4',1,1),(9,'傻逼','男',1,'15625145044',1,'2018-01-15 18:05:33','2018-01-15 22:41:50','123456','MTIzNDU2',1,1),(10,'柳橙汁','女',19,'12435645436',2,'2018-01-15 18:13:09',NULL,'123123123','MTIzMTIzMTIz',3,1),(11,'拉拉','男',30,'17625342342',1,'2018-01-15 18:14:08','2018-01-15 23:16:37','098098098','MDk4MDk4MDk4',1,1),(12,'阿三','男',35,'15625452044',3,'2018-01-15 18:14:08',NULL,'15625172044','MTIzNDU2',NULL,NULL);
/*!40000 ALTER TABLE `h_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `medicine_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(35) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'脑白金',500.00,'2018-01-11 19:36:50','2018-01-15 11:28:59'),(2,'清心丹',100.50,'2018-01-11 19:36:50',NULL),(3,'还魂丹',10000.04,'2018-01-11 19:36:50',NULL),(5,'天仙水',200.50,'2018-01-13 21:21:11','2018-01-13 21:51:18'),(9,'包子',200.50,'2018-01-16 15:00:21',NULL),(10,'包',200.50,'2018-01-16 15:00:29',NULL);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine_list`
--

DROP TABLE IF EXISTS `medicine_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine_list` (
  `medicine_id` bigint(20) unsigned NOT NULL,
  `case_report_id` bigint(20) unsigned NOT NULL,
  `mount` tinyint(3) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`medicine_id`,`case_report_id`),
  KEY `case_report_id` (`case_report_id`),
  CONSTRAINT `medicine_list_ibfk_1` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`),
  CONSTRAINT `medicine_list_ibfk_2` FOREIGN KEY (`case_report_id`) REFERENCES `case_report` (`case_report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_list`
--

LOCK TABLES `medicine_list` WRITE;
/*!40000 ALTER TABLE `medicine_list` DISABLE KEYS */;
INSERT INTO `medicine_list` VALUES (1,1,2,'2018-01-20 15:20:00',NULL),(1,6,2,'2018-01-15 12:10:37',NULL),(1,7,2,'2018-01-15 12:12:29',NULL),(1,8,2,'2018-01-15 13:07:38',NULL),(1,9,2,'2018-01-15 21:05:57',NULL),(1,10,2,'2018-01-16 16:06:28',NULL),(2,6,3,'2018-01-15 12:10:37',NULL),(2,7,3,'2018-01-15 12:12:29',NULL),(2,8,3,'2018-01-15 13:07:38',NULL),(2,9,1,'2018-01-15 21:05:57',NULL),(2,10,3,'2018-01-16 16:06:28',NULL),(3,6,4,'2018-01-15 12:10:37',NULL),(3,7,4,'2018-01-15 12:12:29',NULL),(3,8,4,'2018-01-15 13:07:38',NULL),(3,10,4,'2018-01-16 16:06:28',NULL);
/*!40000 ALTER TABLE `medicine_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patient_name` char(20) NOT NULL,
  `id_card` char(20) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` tinyint(3) unsigned NOT NULL,
  `tel` char(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `id_card_UNIQUE` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'小红','445224200010030499','女',22,'15625172066','2018-01-12 17:50:00',NULL),(2,'嘻嘻','445224200010080477','女',19,'15625172044','2018-01-14 19:10:55',NULL),(3,'test','44511120000955','女',19,'15625172044','2018-01-16 15:24:38',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_list`
--

DROP TABLE IF EXISTS `pay_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_list` (
  `pay_list_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_report_id` bigint(20) unsigned DEFAULT NULL,
  `total_price` decimal(7,2) NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pay_list_id`),
  KEY `pay_list_ibfk_1_idx` (`case_report_id`),
  CONSTRAINT `pay_list_ibfk_1` FOREIGN KEY (`case_report_id`) REFERENCES `case_report` (`case_report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_list`
--

LOCK TABLES `pay_list` WRITE;
/*!40000 ALTER TABLE `pay_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_title`
--

DROP TABLE IF EXISTS `user_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_title` (
  `title_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title_name` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`title_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_title`
--

LOCK TABLES `user_title` WRITE;
/*!40000 ALTER TABLE `user_title` DISABLE KEYS */;
INSERT INTO `user_title` VALUES (1,'医生','2018-01-11 17:46:36','2018-01-14 14:35:17'),(2,'护士','2018-01-11 17:48:14','2018-01-14 14:55:40'),(3,'管理员','2018-01-11 17:48:14',NULL),(5,'update','2018-01-16 14:51:00','2018-01-16 14:52:19');
/*!40000 ALTER TABLE `user_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_appointment`
--

DROP TABLE IF EXISTS `v_appointment`;
/*!50001 DROP VIEW IF EXISTS `v_appointment`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_appointment` AS SELECT 
 1 AS `appointment_id`,
 1 AS `patient_id`,
 1 AS `patient_name`,
 1 AS `sex`,
 1 AS `age`,
 1 AS `consulting_date`,
 1 AS `doctor_id`,
 1 AS `doctor_name`,
 1 AS `department_name`,
 1 AS `location`,
 1 AS `finish`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_doctor`
--

DROP TABLE IF EXISTS `v_doctor`;
/*!50001 DROP VIEW IF EXISTS `v_doctor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_doctor` AS SELECT 
 1 AS `user_id`,
 1 AS `user_name`,
 1 AS `department_id`,
 1 AS `consulting_room_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_medicine_list`
--

DROP TABLE IF EXISTS `v_medicine_list`;
/*!50001 DROP VIEW IF EXISTS `v_medicine_list`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_medicine_list` AS SELECT 
 1 AS `case_report_id`,
 1 AS `medicine_id`,
 1 AS `medicine_name`,
 1 AS `price`,
 1 AS `mount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_user`
--

DROP TABLE IF EXISTS `v_user`;
/*!50001 DROP VIEW IF EXISTS `v_user`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_user` AS SELECT 
 1 AS `user_id`,
 1 AS `user_name`,
 1 AS `sex`,
 1 AS `age`,
 1 AS `tel_phone`,
 1 AS `title_id`,
 1 AS `title_name`,
 1 AS `department_id`,
 1 AS `department_name`,
 1 AS `consulting_room_id`,
 1 AS `location`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_appointment`
--

/*!50001 DROP VIEW IF EXISTS `v_appointment`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_appointment` AS select `appointment`.`appointment_id` AS `appointment_id`,`patient`.`patient_id` AS `patient_id`,`patient`.`patient_name` AS `patient_name`,`patient`.`sex` AS `sex`,`patient`.`age` AS `age`,`appointment`.`consulting_date` AS `consulting_date`,`h_user`.`user_id` AS `doctor_id`,`h_user`.`user_name` AS `doctor_name`,`department`.`department_name` AS `department_name`,`consulting_room`.`location` AS `location`,`appointment`.`finish` AS `finish` from ((((`appointment` join `patient`) join `h_user`) join `department`) join `consulting_room`) where ((`patient`.`patient_id` = `appointment`.`patient_id`) and (`h_user`.`user_id` = `appointment`.`doctor_id`) and (`department`.`department_id` = `appointment`.`department_id`) and (`consulting_room`.`consulting_room_id` = `appointment`.`consulting_room_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_doctor`
--

/*!50001 DROP VIEW IF EXISTS `v_doctor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_doctor` AS select `v_user`.`user_id` AS `user_id`,`v_user`.`user_name` AS `user_name`,`v_user`.`department_id` AS `department_id`,`v_user`.`consulting_room_id` AS `consulting_room_id` from `v_user` where (`v_user`.`title_id` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_medicine_list`
--

/*!50001 DROP VIEW IF EXISTS `v_medicine_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_medicine_list` AS select `medicine_list`.`case_report_id` AS `case_report_id`,`medicine`.`medicine_id` AS `medicine_id`,`medicine`.`medicine_name` AS `medicine_name`,`medicine`.`price` AS `price`,`medicine_list`.`mount` AS `mount` from (`medicine` join `medicine_list`) where (`medicine`.`medicine_id` = `medicine_list`.`medicine_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_user`
--

/*!50001 DROP VIEW IF EXISTS `v_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user` AS select `h_user`.`user_id` AS `user_id`,`h_user`.`user_name` AS `user_name`,`h_user`.`sex` AS `sex`,`h_user`.`age` AS `age`,`h_user`.`tel_phone` AS `tel_phone`,`h_user`.`title_id` AS `title_id`,`user_title`.`title_name` AS `title_name`,`department`.`department_id` AS `department_id`,`department`.`department_name` AS `department_name`,`consulting_room`.`consulting_room_id` AS `consulting_room_id`,`consulting_room`.`location` AS `location` from (((`h_user` join `department`) join `consulting_room`) join `user_title`) where ((`h_user`.`title_id` = `user_title`.`title_id`) and (`department`.`department_id` = `h_user`.`department_id`) and (`consulting_room`.`consulting_room_id` = `h_user`.`consulting_room_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-16 16:33:26
