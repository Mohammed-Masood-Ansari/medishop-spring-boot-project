-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: medishop
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (123,'admin@gmail.com','admin@123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_vendors`
--

DROP TABLE IF EXISTS `admin_vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_vendors` (
  `admin_id` int NOT NULL,
  `vendors_id` int NOT NULL,
  UNIQUE KEY `UK_3kng3a5ms7o9cpll9b5jew1c` (`vendors_id`),
  KEY `FK4xhsj4h22wyh7ggqssqiy4bkb` (`admin_id`),
  CONSTRAINT `FK4xhsj4h22wyh7ggqssqiy4bkb` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FK89nsd5i7myutlllwtj5xe58ds` FOREIGN KEY (`vendors_id`) REFERENCES `vendor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_vendors`
--

LOCK TABLES `admin_vendors` WRITE;
/*!40000 ALTER TABLE `admin_vendors` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_vendors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adhar` bigint DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(8) DEFAULT NULL,
  `phone` bigint NOT NULL,
  `image` tinyblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`),
  UNIQUE KEY `UK_jtjm4970daae9ov37sml2w61q` (`adhar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (654,'Noida sector 15',5647657,'2004-12-12','ankit12@yahoo.in','ankit','Ankit@12',342534578,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_medicines`
--

DROP TABLE IF EXISTS `customer_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_medicines` (
  `customers_id` int NOT NULL,
  `medicines_id` int NOT NULL,
  KEY `FKgycehb7u505pohk07a2mkv56q` (`medicines_id`),
  KEY `FKaq8u64h7msk15p9k1rp8ucipj` (`customers_id`),
  CONSTRAINT `FKaq8u64h7msk15p9k1rp8ucipj` FOREIGN KEY (`customers_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKgycehb7u505pohk07a2mkv56q` FOREIGN KEY (`medicines_id`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_medicines`
--

LOCK TABLES `customer_medicines` WRITE;
/*!40000 ALTER TABLE `customer_medicines` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` int NOT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `expirydate` date DEFAULT NULL,
  `medicine_status` varchar(8) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (123,'APPOLO','fever medicine','2024-04-12','active','DOLO50MG',150,12);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine_vendors`
--

DROP TABLE IF EXISTS `medicine_vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine_vendors` (
  `medicines_id` int NOT NULL,
  `vendors_id` int NOT NULL,
  KEY `FKgbkcos5eh87wy3e3jbw37j3x2` (`vendors_id`),
  KEY `FKr3qgfbbmyjr02w1tybsn0m6nh` (`medicines_id`),
  CONSTRAINT `FKgbkcos5eh87wy3e3jbw37j3x2` FOREIGN KEY (`vendors_id`) REFERENCES `vendor` (`id`),
  CONSTRAINT `FKr3qgfbbmyjr02w1tybsn0m6nh` FOREIGN KEY (`medicines_id`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_vendors`
--

LOCK TABLES `medicine_vendors` WRITE;
/*!40000 ALTER TABLE `medicine_vendors` DISABLE KEYS */;
INSERT INTO `medicine_vendors` VALUES (123,999);
/*!40000 ALTER TABLE `medicine_vendors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_entitiy`
--

DROP TABLE IF EXISTS `order_entitiy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_entitiy` (
  `order_id` bigint NOT NULL,
  `customer_delivery_date` date DEFAULT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `estimated_delivery_date` date DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `quantity` int NOT NULL,
  `total_ammount` double NOT NULL,
  `customer_id` int DEFAULT NULL,
  `medicine_id` int DEFAULT NULL,
  `vendor_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `UK_loxpjc1oc79n8wwifm4u6e4c0` (`customer_id`),
  UNIQUE KEY `UK_8oayr85iclfwgtkpgpbjuidiu` (`medicine_id`),
  UNIQUE KEY `UK_g59pq6ceykon30ou6ote2g04m` (`vendor_id`),
  CONSTRAINT `FKfe34skcbpfvq8uq0l4h364258` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  CONSTRAINT `FKsptutv5ejg2qcaoxuorbghjx4` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `FKtapucc5u30e4leo3f7wbr1ckh` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_entitiy`
--

LOCK TABLES `order_entitiy` WRITE;
/*!40000 ALTER TABLE `order_entitiy` DISABLE KEYS */;
INSERT INTO `order_entitiy` VALUES (9991149721,'2024-03-01','Noida Qspider','2024-03-04','2024-02-29','pending','Online',2,300,654,123,NULL);
/*!40000 ALTER TABLE `order_entitiy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adhar` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint NOT NULL,
  `vendor_status` varchar(255) DEFAULT NULL,
  `admin_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6ity1bimg9cvjcmkoe8h7bkpi` (`adhar`),
  KEY `FK5y5ieieybr044wcmve6johu9i` (`admin_id`),
  CONSTRAINT `FK5y5ieieybr044wcmve6johu9i` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (888,'Faizabad',921145435,'shivam57243@gmail.com','shivam-tiwari','tiwari@123',89898989,'active',123),(999,'Bangalore',23456789,'vinay453@gmail.com','vinay-tiwari','vinay@123',5467890,'active',123);
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_customers`
--

DROP TABLE IF EXISTS `vendor_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor_customers` (
  `vendor_id` int NOT NULL,
  `customers_id` int NOT NULL,
  KEY `FKa6nx810me5mvv5mhtuibxoogw` (`customers_id`),
  KEY `FKe91jhuxtbnylo7mdj8rkbvcm6` (`vendor_id`),
  CONSTRAINT `FKa6nx810me5mvv5mhtuibxoogw` FOREIGN KEY (`customers_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKe91jhuxtbnylo7mdj8rkbvcm6` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_customers`
--

LOCK TABLES `vendor_customers` WRITE;
/*!40000 ALTER TABLE `vendor_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-04 20:35:16
