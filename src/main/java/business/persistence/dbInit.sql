/*
    You might want to rename the database to your own needs.
    If so, please substitute `startcode` with whatever your project is called.
 */
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fogdb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
                           `carport_id` int NOT NULL AUTO_INCREMENT,
                           `length` double NOT NULL,
                           `width` double NOT NULL,
                           `rooftype` varchar(45) NOT NULL,
                           `shed_id` int DEFAULT NULL,
                           `sum` double NOT NULL,
                           PRIMARY KEY (`carport_id`),
                           UNIQUE KEY `carport_id_UNIQUE` (`carport_id`),
                           KEY `fk_carport_shed1_idx` (`shed_id`),
                           CONSTRAINT `fk_carport_shed1` FOREIGN KEY (`shed_id`) REFERENCES `shed` (`shed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
INSERT INTO `carport` VALUES (1,230,304,'fsa',NULL,0),(4,240,240,'tom',1,0);
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiallist`
--

DROP TABLE IF EXISTS `materiallist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiallist` (
                                `materiallist_id` int NOT NULL AUTO_INCREMENT,
                                `carport_id` int NOT NULL,
                                `materials_id` int NOT NULL,
                                `amount` double NOT NULL,
                                `unit_id` int NOT NULL,
                                PRIMARY KEY (`materiallist_id`),
                                UNIQUE KEY `materiallist_id_UNIQUE` (`materiallist_id`),
                                UNIQUE KEY `carport_id_UNIQUE` (`carport_id`),
                                KEY `fk_materiallist_materials1_idx` (`materials_id`),
                                KEY `fk_materiallist_unit1_idx` (`unit_id`),
                                CONSTRAINT `fk_materiallist_carport1` FOREIGN KEY (`carport_id`) REFERENCES `carport` (`carport_id`),
                                CONSTRAINT `fk_materiallist_materials1` FOREIGN KEY (`materials_id`) REFERENCES `materials` (`materials_id`),
                                CONSTRAINT `fk_materiallist_unit1` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiallist`
--

LOCK TABLES `materiallist` WRITE;
/*!40000 ALTER TABLE `materiallist` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiallist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
                             `materials_id` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) NOT NULL,
                             `sizes_id` int NOT NULL,
                             `description` varchar(150) NOT NULL,
                             `price` double NOT NULL,
                             PRIMARY KEY (`materials_id`),
                             UNIQUE KEY `materials_id_UNIQUE` (`materials_id`),
                             KEY `fk_materials_sizes1_idx` (`sizes_id`),
                             CONSTRAINT `fk_materials_sizes1` FOREIGN KEY (`sizes_id`) REFERENCES `sizes` (`sizes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (16,'trykimp',1,'understern brædder til for & bag ende',233),(17,'trykimp',2,'understernbrædder til siderne',350),(18,'trykimp',3,'oversternbrædder til forenden',161),(19,'trykimp',4,'oversternbrædder til siderne',242),(20,'lægte',5,'til z på bagside af dør',71),(21,'reglar',6,'løsholter til skur gavle',94),(22,'reglar',7,'løsholter til skur sider',83),(23,'spærtræ',8,'remme i sider, sadles ned i stolper',509),(24,'spærtræ',9,'remme i sider, sadles ned i stopler (skur del, deles)',431),(25,'spærtræ',10,'spær, monteres på rem',509),(26,'trykimp',11,'stolper nedgraves 90 cm. i jord',105),(27,'trykimp',12,'til beklædning af skur 1 på 2',27),(28,'trykimp',13,'vandbrædt på stern i sider',95),(29,'trykimp',14,'vandbrædt på stern i forende',46),(30,'plastmo ecolite blåtonet',15,'tagplader monteres på spær',250),(31,'plastmo ecolite blåtonet',16,'tagplader monteres på spær',129);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `order_id` int NOT NULL AUTO_INCREMENT,
                          `user_id` int NOT NULL,
                          `carport_id` int NOT NULL,
                          `price` double NOT NULL,
                          `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                          `status` int NOT NULL,
                          PRIMARY KEY (`order_id`),
                          UNIQUE KEY `order_id_UNIQUE` (`order_id`),
                          UNIQUE KEY `carport_id_UNIQUE` (`carport_id`),
                          KEY `fk_order_user1` (`user_id`),
                          KEY `fk_order_status1_idx` (`status`),
                          CONSTRAINT `fk_order_carport1` FOREIGN KEY (`carport_id`) REFERENCES `carport` (`carport_id`),
                          CONSTRAINT `fk_order_status1` FOREIGN KEY (`status`) REFERENCES `status` (`status_id`),
                          CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,1,1,0,NULL,1),(4,1,4,0,NULL,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postalcode`
--

DROP TABLE IF EXISTS `postalcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postalcode` (
                              `postalcode` int NOT NULL,
                              `city` varchar(45) NOT NULL,
                              PRIMARY KEY (`postalcode`),
                              UNIQUE KEY `postalcode_UNIQUE` (`postalcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postalcode`
--

LOCK TABLES `postalcode` WRITE;
/*!40000 ALTER TABLE `postalcode` DISABLE KEYS */;
INSERT INTO `postalcode` VALUES (3700,'Rønne');
/*!40000 ALTER TABLE `postalcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
                           `request_id` int NOT NULL AUTO_INCREMENT,
                           `carport_id` int NOT NULL,
                           `user_id` int NOT NULL,
                           `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (`request_id`),
                           UNIQUE KEY `request_id_UNIQUE` (`request_id`),
                           UNIQUE KEY `carport_id_UNIQUE` (`carport_id`),
                           KEY `fk_request_user1_idx` (`user_id`),
                           CONSTRAINT `fk_request_carport1` FOREIGN KEY (`carport_id`) REFERENCES `carport` (`carport_id`),
                           CONSTRAINT `fk_request_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shed`
--

DROP TABLE IF EXISTS `shed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shed` (
                        `shed_id` int NOT NULL AUTO_INCREMENT,
                        `length` double NOT NULL,
                        `width` double NOT NULL,
                        PRIMARY KEY (`shed_id`),
                        UNIQUE KEY `shed_id_UNIQUE` (`shed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shed`
--

LOCK TABLES `shed` WRITE;
/*!40000 ALTER TABLE `shed` DISABLE KEYS */;
INSERT INTO `shed` VALUES (1,0,0);
/*!40000 ALTER TABLE `shed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
                         `sizes_id` int NOT NULL AUTO_INCREMENT,
                         `height` double DEFAULT NULL,
                         `length` double DEFAULT NULL,
                         `width` double DEFAULT NULL,
                         PRIMARY KEY (`sizes_id`),
                         UNIQUE KEY `sizes_id_UNIQUE` (`sizes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,25,300,200),(2,25,540,200),(3,25,360,125),(4,25,540,125),(5,38,420,73),(6,45,270,95),(7,45,240,95),(8,45,600,195),(9,45,480,195),(10,45,600,195),(11,97,300,97),(12,19,210,100),(13,19,540,100),(14,19,360,100),(15,NULL,600,NULL),(16,NULL,360,NULL);
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
                          `status_id` int NOT NULL AUTO_INCREMENT,
                          `status` varchar(45) NOT NULL,
                          PRIMARY KEY (`status_id`),
                          UNIQUE KEY `status_id_UNIQUE` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'request'),(2,'offer'),(3,'decline'),(4,'accept');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
                        `unit_id` int NOT NULL AUTO_INCREMENT,
                        `unit` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`unit_id`),
                        UNIQUE KEY `unit_id_UNIQUE` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'stk'),(2,'pakke'),(3,'rulle'),(4,'sæt');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `email` varchar(45) NOT NULL,
                        `role` varchar(45) NOT NULL,
                        `password` varchar(45) NOT NULL,
                        `address` varchar(45) DEFAULT NULL,
                        `postalcode` int DEFAULT NULL,
                        `phonenr` int DEFAULT NULL,
                        PRIMARY KEY (`user_id`),
                        UNIQUE KEY `user_id_UNIQUE` (`user_id`),
                        UNIQUE KEY `email_UNIQUE` (`email`),
                        KEY `fk_user_postalcode_idx` (`postalcode`),
                        CONSTRAINT `fk_user_postalcode` FOREIGN KEY (`postalcode`) REFERENCES `postalcode` (`postalcode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dummy123','customer','123',NULL,NULL,NULL),(2,'1j21','customer','123',NULL,NULL,NULL),(3,'emplo1','employee','1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 10:02:31
