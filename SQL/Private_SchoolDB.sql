-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: private_school
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `ASS_ID` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `DESCR` varchar(200) NOT NULL,
  `ORAL_MARK` int NOT NULL,
  `TOTAL_MARK` int NOT NULL,
  PRIMARY KEY (`ASS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (1,'Design of a Private School Structure','Implement a private school structure with Javascript.',15,100),(2,'Design of a basic Web Application','Create a basic web app to perform simple tasks.',20,100),(3,'Continue to develop in Javascript','Javascript to create another Web App.',20,100),(4,'FINAL project in Javascript using Node.js','Use Node.js to achieve everything you have dreamt of.',20,130),(5,'Design a java jdbc program!','Create a Java program to connect with a server.',10,100),(6,'Design a java-based Web App.','Use Netbeans and/or Android Studio IDE to create an app.',15,110),(7,'Design a basic Windows App','Use C# to create it.',10,100),(8,'Design a Windows 10 application','Use C# to design it and provide it with basic functionalities.',15,110),(9,'Design a Web App with React','Use React.js and its functions to develop it.',10,100),(10,'Create a completed Website','You need to use React.js and Javascript for this.',15,110),(11,'Create more with Javascript','Do all you can!',10,100),(12,'Design Trees','Design many Trees',10,100),(13,'Hi','Lol',13,100);
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignment_student`
--

DROP TABLE IF EXISTS `assignment_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment_student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ass_id` int NOT NULL,
  `std_id` int NOT NULL,
  `course_id` int DEFAULT NULL,
  `st_oral_mark` int DEFAULT '-1',
  `st_total_mark` int DEFAULT '-1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDS_UNIQUE` (`ass_id`,`std_id`,`course_id`),
  KEY `std_id` (`std_id`),
  KEY `FK_COURSE_ID_COURSE_COURSE_ID` (`course_id`),
  CONSTRAINT `assignment_student_ibfk_1` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ASS_ID`),
  CONSTRAINT `assignment_student_ibfk_2` FOREIGN KEY (`std_id`) REFERENCES `student` (`STD_ID`),
  CONSTRAINT `FK_COURSE_ID_COURSE_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment_student`
--

LOCK TABLES `assignment_student` WRITE;
/*!40000 ALTER TABLE `assignment_student` DISABLE KEYS */;
INSERT INTO `assignment_student` VALUES (5,11,1,1,8,77),(6,3,1,1,10,-1),(7,1,1,1,-1,-1),(8,11,2,1,-1,-1),(9,3,2,1,-1,-1),(10,1,2,1,-1,-1),(11,3,2,4,-1,-1),(12,6,2,4,-1,-1),(13,7,2,4,-1,-1),(14,9,2,4,-1,-1),(15,10,2,4,-1,-1),(16,2,3,3,-1,-1),(17,5,3,3,-1,-1),(18,7,3,3,-1,-1),(19,8,3,3,-1,-1),(20,1,4,2,-1,-1),(21,2,4,2,-1,-1),(22,3,4,2,-1,-1),(23,3,5,2,-1,-1),(24,1,5,2,-1,-1),(25,2,5,2,-1,-1),(26,8,6,3,-1,-1),(27,7,6,3,-1,-1),(28,5,6,3,-1,-1),(29,2,6,3,-1,-1),(30,1,7,1,-1,-1),(31,3,7,1,-1,-1),(32,11,7,1,-1,-1),(33,10,7,4,-1,-1),(34,7,7,4,-1,-1),(35,6,7,4,-1,-1),(36,3,7,4,-1,-1),(37,9,7,4,-1,-1),(42,1,1,2,-1,-1),(43,2,1,2,-1,-1),(44,3,1,2,-1,-1),(45,13,2,1,-1,-1),(46,13,7,1,-1,-1),(47,13,1,1,10,99);
/*!40000 ALTER TABLE `assignment_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `COURSE_ID` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `STREAM` varchar(50) NOT NULL,
  `TYP` varchar(50) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  PRIMARY KEY (`COURSE_ID`),
  UNIQUE KEY `TITLE` (`TITLE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'CB8','JavaScript','Part-Time','2020-01-01','2020-06-25'),(2,'CB9','Java','Full-Time','2020-01-03','2020-05-01'),(3,'CB10','C#','Full-Time','2019-09-20','2019-12-31'),(4,'CB11','React.js','Part-Time','2020-03-20','2020-08-20');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_assignment`
--

DROP TABLE IF EXISTS `course_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_assignment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `ass_id` int NOT NULL,
  `sub_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`,`ass_id`),
  KEY `ass_id` (`ass_id`),
  CONSTRAINT `course_assignment_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`COURSE_ID`),
  CONSTRAINT `course_assignment_ibfk_2` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ASS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_assignment`
--

LOCK TABLES `course_assignment` WRITE;
/*!40000 ALTER TABLE `course_assignment` DISABLE KEYS */;
INSERT INTO `course_assignment` VALUES (1,2,2,'2020-02-28 23:59:00'),(3,2,1,'2020-03-31 23:59:00'),(4,2,3,'2020-04-30 23:59:00'),(5,1,1,'2020-03-31 23:59:00'),(6,1,3,'2020-02-05 23:59:00'),(7,1,11,'2020-06-20 23:59:00'),(8,4,9,'2020-05-25 23:59:00'),(9,4,7,'2020-05-31 23:59:00'),(10,4,6,'2020-04-21 23:59:00'),(11,4,10,'2020-06-30 23:59:00'),(12,4,3,'2020-04-30 23:59:00'),(13,3,5,'2019-10-25 23:59:00'),(14,3,7,'2019-09-30 23:59:00'),(15,3,8,'2019-12-25 23:59:00'),(16,3,2,'2019-12-25 23:59:59'),(19,1,13,'2020-05-02 22:10:03');
/*!40000 ALTER TABLE `course_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_student` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int NOT NULL,
  `STD_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COURSE_ID` (`COURSE_ID`,`STD_ID`),
  KEY `STD_ID` (`STD_ID`),
  CONSTRAINT `course_student_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`),
  CONSTRAINT `course_student_ibfk_2` FOREIGN KEY (`STD_ID`) REFERENCES `student` (`STD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_student`
--

LOCK TABLES `course_student` WRITE;
/*!40000 ALTER TABLE `course_student` DISABLE KEYS */;
INSERT INTO `course_student` VALUES (1,1,1),(3,1,2),(9,1,7),(12,2,1),(5,2,4),(6,2,5),(2,3,3),(7,3,6),(4,4,2),(8,4,7);
/*!40000 ALTER TABLE `course_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_trainer`
--

DROP TABLE IF EXISTS `course_trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_trainer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int NOT NULL,
  `TRAINER_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COURSE_ID` (`COURSE_ID`,`TRAINER_ID`),
  KEY `TRAINER_ID` (`TRAINER_ID`),
  CONSTRAINT `course_trainer_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`),
  CONSTRAINT `course_trainer_ibfk_2` FOREIGN KEY (`TRAINER_ID`) REFERENCES `trainer` (`TRAINER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_trainer`
--

LOCK TABLES `course_trainer` WRITE;
/*!40000 ALTER TABLE `course_trainer` DISABLE KEYS */;
INSERT INTO `course_trainer` VALUES (8,1,1),(5,1,3),(4,1,6),(9,2,1),(6,2,2),(7,2,5),(14,2,10),(11,3,1),(10,3,2),(1,3,7),(13,3,8),(3,4,1),(2,4,4),(12,4,8);
/*!40000 ALTER TABLE `course_trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `STD_ID` int NOT NULL AUTO_INCREMENT,
  `F_NAME` varchar(60) NOT NULL,
  `L_NAME` varchar(60) NOT NULL,
  `BIRTH_DATE` date NOT NULL,
  `TUITION_FEES` int DEFAULT '0',
  PRIMARY KEY (`STD_ID`),
  UNIQUE KEY `F_NAME` (`F_NAME`,`L_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Aris','Plexi','1990-09-20',2500),(2,'Spyros','Georgakis','1990-09-17',2100),(3,'Stavros','Kizalas','1990-04-21',2300),(4,'Hlias','Papavasileiou','1992-03-12',2000),(5,'Dimitris','Katsamagos','1991-03-10',1900),(6,'Filippos','Dedekeridis','1983-11-16',2500),(7,'Dionisis','Kalintzakis','1990-01-09',2800),(13,'Aris','Plexiglass','2020-04-29',2500),(16,'Aris','Oulou','1990-09-19',300),(17,'Aris','Apostolakis','1990-03-20',45),(18,'lol','zero','2020-12-02',450),(19,'plexi','ouloooooo','2020-10-11',200);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `TRAINER_ID` int NOT NULL AUTO_INCREMENT,
  `F_NAME` varchar(60) NOT NULL,
  `L_NAME` varchar(60) NOT NULL,
  `SUBJECT` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`TRAINER_ID`),
  UNIQUE KEY `F_NAME` (`F_NAME`,`L_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (1,'Nikos','Karapas','Java'),(2,'George','Pasparakis','General Admin'),(3,'Giwrgos','Irakleidis','Java'),(4,'Argiris','Trap','MySQL'),(5,'Mike','Chamilos','MySQL-JDBC'),(6,'Tasos','Lelakis','Java and Programming Knowledge'),(7,'Steve','Jobs','C#, C++, Apps in Windows 10'),(8,'Bill','Gates','Swift and iOS development'),(10,'Jim','Jason','C++');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'private_school'
--
/*!50003 DROP PROCEDURE IF EXISTS `getProductPerSales` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getProductPerSales`(inout productList varchar (1000))
begin
declare prod_done, order_done boolean default false;
declare c_prod_id, ord_prod_id int;
declare c_prod_name varchar(100);
declare c_prod_price decimal(8,2);


declare cursorProducts cursor for select prod_id, name, price from products;
declare continue handler for not found set prod_done = true;


open cursorProducts;
prodloop: loop
fetch  from cursorProducts into c_prod_id, c_prod_name, c_prod_price;
    if prod_done then
            leave prodloop;
    end if;
    
    Block1: begin
declare curOrdersProd cursor for 
select product_id from order_products where product_id = c_prod_id and quantity*price > 10;
declare continue handler for not found set order_done = true;
    open curOrdersProd;
    ordersloop: loop
    fetch from curOrdersProd into ord_prod_id;
        if order_done then
            leave ordersloop;
        end if;
        
        set productList = concat(c_prod_name, "--", productList);
    end loop ordersloop;
    close curOrdersProd;
    end block1;
    
end loop prodloop;
close cursorProducts;


end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03  2:15:38
