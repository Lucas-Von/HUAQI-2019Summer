-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: financial
-- ------------------------------------------------------
-- Server version	5.7.25-log

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `article_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `md_content` text,
  `html_content` text,
  `category` int(11) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `pageviews` bigint(255) unsigned DEFAULT '0',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bond`
--

DROP TABLE IF EXISTS `bond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bond` (
  `id` bigint(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond`
--

LOCK TABLES `bond` WRITE;
/*!40000 ALTER TABLE `bond` DISABLE KEYS */;
INSERT INTO `bond` VALUES (1,'债券1','8888',99);
/*!40000 ALTER TABLE `bond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bond_and_fund`
--

DROP TABLE IF EXISTS `bond_and_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bond_and_fund` (
  `fund_id` bigint(255) DEFAULT NULL,
  `bond_id` bigint(255) DEFAULT NULL,
  `investment_proportion` float DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond_and_fund`
--

LOCK TABLES `bond_and_fund` WRITE;
/*!40000 ALTER TABLE `bond_and_fund` DISABLE KEYS */;
/*!40000 ALTER TABLE `bond_and_fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bond_foundation`
--

DROP TABLE IF EXISTS `bond_foundation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bond_foundation` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `fund_name` varchar(255) DEFAULT NULL,
  `fund_share` float DEFAULT NULL,
  `fund_scale` float DEFAULT NULL,
  `fund_unit_value` float DEFAULT NULL,
  `expect_return_rate` float DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `debt_sum` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond_foundation`
--

LOCK TABLES `bond_foundation` WRITE;
/*!40000 ALTER TABLE `bond_foundation` DISABLE KEYS */;
INSERT INTO `bond_foundation` VALUES (1,'国债',1000,200000,200,0.2,'2019-09-01 08:55:49',1000),(2,'企业债',1000,100000,100,0.2,'2019-09-01 08:55:49',1000);
/*!40000 ALTER TABLE `bond_foundation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bond_rate_log`
--

DROP TABLE IF EXISTS `bond_rate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bond_rate_log` (
  `fund_id` bigint(255) DEFAULT NULL,
  `fund_name` varchar(45) DEFAULT NULL,
  `net_worth` double DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond_rate_log`
--

LOCK TABLES `bond_rate_log` WRITE;
/*!40000 ALTER TABLE `bond_rate_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bond_rate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `user_id` varchar(45) DEFAULT NULL,
  `cardnum` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash`
--

DROP TABLE IF EXISTS `cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `payment_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash`
--

LOCK TABLES `cash` WRITE;
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `user_id` bigint(255) NOT NULL,
  `article_id` bigint(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) DEFAULT NULL,
  `article_id` bigint(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposit` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit`
--

LOCK TABLES `deposit` WRITE;
/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposit_product`
--

DROP TABLE IF EXISTS `deposit_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposit_product` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit_product`
--

LOCK TABLES `deposit_product` WRITE;
/*!40000 ALTER TABLE `deposit_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `deposit_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposit_recommend`
--

DROP TABLE IF EXISTS `deposit_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposit_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `rate` double(11,5) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `start_amount` double DEFAULT NULL,
  `risk_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit_recommend`
--

LOCK TABLES `deposit_recommend` WRITE;
/*!40000 ALTER TABLE `deposit_recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `deposit_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dom_stock`
--

DROP TABLE IF EXISTS `dom_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dom_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dom_stock`
--

LOCK TABLES `dom_stock` WRITE;
/*!40000 ALTER TABLE `dom_stock` DISABLE KEYS */;
INSERT INTO `dom_stock` VALUES (1,'啊啊啊啊？','601991',99);
/*!40000 ALTER TABLE `dom_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) NOT NULL,
  `type` int(10) NOT NULL DEFAULT '1',
  `detail` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_ID` bigint(255) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `QQ` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `solved` bit(1) NOT NULL DEFAULT b'0',
  `solver_ID` bigint(255) DEFAULT NULL,
  `solve_time` timestamp NULL DEFAULT NULL,
  `solve_text` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'为什么不开大？',1,'喂，老板，他刚才又没开大；我没骂他，我上局就没骂他；这个人应该是思想出了问题','2019-08-27 15:27:58',1,NULL,NULL,'123456@789.com',_binary '',7,'2019-08-27 15:27:58','对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区'),(2,'一个数学问题',1,'1+1=?','2019-08-27 15:27:58',1,NULL,NULL,'123456@789.com',_binary '\0',0,NULL,NULL);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `for_stock`
--

DROP TABLE IF EXISTS `for_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `for_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `for_stock`
--

LOCK TABLES `for_stock` WRITE;
/*!40000 ALTER TABLE `for_stock` DISABLE KEYS */;
INSERT INTO `for_stock` VALUES (1,'阿这','123123',12);
/*!40000 ALTER TABLE `for_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fortune`
--

DROP TABLE IF EXISTS `fortune`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fortune` (
  `user_id` bigint(255) NOT NULL,
  `record_date` date NOT NULL,
  `funds` double DEFAULT NULL,
  `saving` double DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `stocks` double DEFAULT NULL,
  `qdii` double DEFAULT NULL,
  `gold` double DEFAULT NULL,
  `bond` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fortune`
--

LOCK TABLES `fortune` WRITE;
/*!40000 ALTER TABLE `fortune` DISABLE KEYS */;
INSERT INTO `fortune` VALUES (1,'2019-08-21',2500,2600,2400,2500,200,500,1500),(1,'2019-08-22',2600,2600,2400,2500,400,500,1500),(1,'2019-08-28',8000,2600,2400,2500,1600,500,1500),(1,'2019-08-29',2600,9600,2400,2500,3200,500,1500),(1,'2019-08-30',2600,9800,2400,2800,3200,500,1500),(1,'2019-08-31',2600,9800,2400,2800,3200,500,1500),(1,'2019-09-01',2600,9800,2400,2800,3300,500,1500),(2,'2019-09-01',2600,9800,2400,2800,3300,500,1500),(1,'2019-09-02',200,50,30,999,999,66,0),(2,'2019-09-02',0,0,0,0,0,0,0),(3,'2019-09-02',0,0,0,0,0,0,0),(1,'2019-09-05',200,50,30,999,999,66,0),(2,'2019-09-05',0,0,0,0,0,0,0),(3,'2019-09-05',0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `fortune` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fund`
--

DROP TABLE IF EXISTS `fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fund` (
  `name` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `fund` (name, rate, "time") values ("国投瑞银钱多宝货币A",0.0021,"2019-09-08")
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund`
--

LOCK TABLES `fund` WRITE;
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
/*!40000 ALTER TABLE `fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funds_and_invest_out_platform`
--

DROP TABLE IF EXISTS `funds_and_invest_out_platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funds_and_invest_out_platform` (
  `user_id` bigint(255) NOT NULL,
  `funds` double DEFAULT NULL,
  `invest` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funds_and_invest_out_platform`
--

LOCK TABLES `funds_and_invest_out_platform` WRITE;
/*!40000 ALTER TABLE `funds_and_invest_out_platform` DISABLE KEYS */;
INSERT INTO `funds_and_invest_out_platform` VALUES (1,800,500);
/*!40000 ALTER TABLE `funds_and_invest_out_platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gold`
--

DROP TABLE IF EXISTS `gold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gold` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gold`
--

LOCK TABLES `gold` WRITE;
/*!40000 ALTER TABLE `gold` DISABLE KEYS */;
/*!40000 ALTER TABLE `gold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gold_history_config`
--

DROP TABLE IF EXISTS `gold_history_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gold_history_config` (
  `user_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gold_history_config`
--

LOCK TABLES `gold_history_config` WRITE;
/*!40000 ALTER TABLE `gold_history_config` DISABLE KEYS */;
INSERT INTO `gold_history_config` VALUES (1,20,4,80,'2019-08-30 07:00:57',0),(1,20,4,80,'2019-08-30 13:12:40',0),(1,20,4,80,'2019-08-30 13:14:04',0),(1,20,4,80,'2019-08-30 13:17:01',0),(1,20,20,20,'2019-08-30 16:03:03',0);
/*!40000 ALTER TABLE `gold_history_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `if_changed_email`
--

DROP TABLE IF EXISTS `if_changed_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `if_changed_email` (
  `email` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `if_changed_email`
--

LOCK TABLES `if_changed_email` WRITE;
/*!40000 ALTER TABLE `if_changed_email` DISABLE KEYS */;
/*!40000 ALTER TABLE `if_changed_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `if_changed_password`
--

DROP TABLE IF EXISTS `if_changed_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `if_changed_password` (
  `email` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `if_changed_password`
--

LOCK TABLES `if_changed_password` WRITE;
/*!40000 ALTER TABLE `if_changed_password` DISABLE KEYS */;
/*!40000 ALTER TABLE `if_changed_password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ins_product`
--

DROP TABLE IF EXISTS `ins_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ins_product` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `compensation` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ins_product`
--

LOCK TABLES `ins_product` WRITE;
/*!40000 ALTER TABLE `ins_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `ins_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance` (
  `user_id` bigint(255) NOT NULL,
  `person_role` varchar(255),
  `kind` varchar(255),
  `permiun` float ,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"husband","寿险",100000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"wife","寿险",100000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"husband","重疾险",500000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"wife","重疾险",50000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"child_one","寿险",50000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"child_two","寿险",50000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"old_one","寿险",50000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"old_two","寿险",150000,251);
insert into insurance (user_id, person_role, kind, permiun, amount) VALUES (1,"whole family","车险",50000,251);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investment`
--

DROP TABLE IF EXISTS `investment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investment` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investment`
--

LOCK TABLES `investment` WRITE;
/*!40000 ALTER TABLE `investment` DISABLE KEYS */;
/*!40000 ALTER TABLE `investment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `light` (
  `user_id` bigint(255) NOT NULL,
  `comment_id` bigint(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `max_invest`
--

DROP TABLE IF EXISTS `max_invest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `max_invest` (
  `user_id` bigint(255) NOT NULL,
  `type` varchar(45) NOT NULL,
  `max` float NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `max_invest`
--

LOCK TABLES `max_invest` WRITE;
/*!40000 ALTER TABLE `max_invest` DISABLE KEYS */;
/*!40000 ALTER TABLE `max_invest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `time` timestamp NULL DEFAULT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `is_read` bit(1) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'2019-08-26 15:27:58',1,1,'尊敬的用户，您的账户有新的调仓操作，请确认',_binary '\0',_binary '\0'),(2,'2019-08-27 15:27:58',1,3,'尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区',_binary '\0',_binary '\0'),(3,'2019-08-27 15:56:53',2,3,'文章：《标题1》下的评论：“评论？？？”被一举报，请去确认情况是否属实！',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_bond`
--

DROP TABLE IF EXISTS `my_bond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_bond` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_bond`
--

LOCK TABLES `my_bond` WRITE;
/*!40000 ALTER TABLE `my_bond` DISABLE KEYS */;
INSERT INTO `my_bond` VALUES (1,'8888',200,300,1.5,500,6);
/*!40000 ALTER TABLE `my_bond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_depo`
--

DROP TABLE IF EXISTS `my_depo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_depo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) NOT NULL,
  `type` int(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double(255,5) DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `proportion` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_depo`
--

LOCK TABLES `my_depo` WRITE;
/*!40000 ALTER TABLE `my_depo` DISABLE KEYS */;
INSERT INTO `my_depo` VALUES (1,1,1,50,'长实储蓄',0.56000,'2020-08-30',2);
/*!40000 ALTER TABLE `my_depo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_fund`
--

DROP TABLE IF EXISTS `my_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_fund` (
  `user_id` bigint(255) NOT NULL,
  `balance` float DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `pay_password` varchar(255) DEFAULT NULL,
  `accuring_amount` float
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_fund`
--

LOCK TABLES `my_fund` WRITE;
/*!40000 ALTER TABLE `my_fund` DISABLE KEYS */;
INSERT INTO `my_fund` VALUES (1,200,'2019-08-30','888888');
/*!40000 ALTER TABLE `my_fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_gold`
--

DROP TABLE IF EXISTS `my_gold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_gold` (
  `user_id` bigint(255) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `diff` double DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `profit` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_gold`
--

LOCK TABLES `my_gold` WRITE;
/*!40000 ALTER TABLE `my_gold` DISABLE KEYS */;
INSERT INTO `my_gold` VALUES (1,50,2,66,300);
/*!40000 ALTER TABLE `my_gold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_ins`
--

DROP TABLE IF EXISTS `my_ins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_ins` (
  `user_id` bigint(255) NOT NULL,
  `beneficiary` varchar(255) DEFAULT NULL,
  `kind` varchar(255),
  `maturity` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `premiun` float DEFAULT NULL,
  `name` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_ins`
--

LOCK TABLES `my_ins` WRITE;
/*!40000 ALTER TABLE `my_ins` DISABLE KEYS */;
INSERT INTO `my_ins` VALUES (1,'20',25,'2020-08-30',30);
/*!40000 ALTER TABLE `my_ins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_qdii`
--

DROP TABLE IF EXISTS `my_qdii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_qdii` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(45) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_amount` float NOT NULL,
  `purchase_total` float NOT NULL,
  `hold_price` float NOT NULL,
  `hold_amount` float NOT NULL,
  `hold_total` float NOT NULL,
  `profit` float NOT NULL DEFAULT '0',
  `profit_rate` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_qdii`
--

LOCK TABLES `my_qdii` WRITE;
/*!40000 ALTER TABLE `my_qdii` DISABLE KEYS */;
INSERT INTO `my_qdii` VALUES (1,'123123',1,1000,1000,99.9,100,999,-1,-0.001);
/*!40000 ALTER TABLE `my_qdii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_stock`
--

DROP TABLE IF EXISTS `my_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_stock` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_amount` int(11) NOT NULL,
  `purchase_total` float NOT NULL,
  `hold_price` float NOT NULL,
  `hold_amount` int(11) NOT NULL,
  `hold_total` float NOT NULL,
  `profit` float NOT NULL DEFAULT '0',
  `profit_rate` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_stock`
--

LOCK TABLES `my_stock` WRITE;
/*!40000 ALTER TABLE `my_stock` DISABLE KEYS */;
INSERT INTO `my_stock` VALUES (1,'601991',1,1000,1000,99.9,100,999,-1,-0.001);
/*!40000 ALTER TABLE `my_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_trade`
--

DROP TABLE IF EXISTS `personal_trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_trade` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `trans_id` bigint(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` timestamp NULL DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  `product_id` bigint(255) NOT NULL,
  `amount` float NOT NULL,
  `price` float NOT NULL,
  `fee` float NOT NULL,
  `total` float NOT NULL,
  `user_id` bigint(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `is_customize` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_trade`
--

LOCK TABLES `personal_trade` WRITE;
/*!40000 ALTER TABLE `personal_trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_bond_fund`
--

DROP TABLE IF EXISTS `platform_bond_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_bond_fund` (
  `handling_fee` float DEFAULT NULL,
  `bond_property` float DEFAULT NULL,
  `residual_property` float DEFAULT NULL,
  `return_rate_seven` float DEFAULT '0',
  `return_rate_thirty` float DEFAULT '0',
  `return_rate_ninety` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_bond_fund`
--

LOCK TABLES `platform_bond_fund` WRITE;
/*!40000 ALTER TABLE `platform_bond_fund` DISABLE KEYS */;
INSERT INTO `platform_bond_fund` VALUES (0.1,300000,10000,0,0,0);
/*!40000 ALTER TABLE `platform_bond_fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_trade`
--

DROP TABLE IF EXISTS `platform_trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_trade` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product` varchar(45) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `real_total` float NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_trade`
--

LOCK TABLES `platform_trade` WRITE;
/*!40000 ALTER TABLE `platform_trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `platform_trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `user_id` bigint(255) NOT NULL,
  `admin_id` bigint(255) NOT NULL,
  `view_type` varchar(45) DEFAULT NULL,
  `pro_or_invest` varchar(45) DEFAULT NULL,
  `asset_type` varchar(45) DEFAULT NULL,
  `prefers` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionnaire` (
  `user_id` bigint(255) NOT NULL,
  `record_date` date DEFAULT NULL,
  `fin_infor` int(11) DEFAULT NULL,
  `vol_chose` int(11) DEFAULT NULL,
  `stock_prefer` int(11) DEFAULT NULL,
  `bank_card` int(11) DEFAULT NULL,
  `current_deposit` double DEFAULT NULL,
  `fixed_deposit` double DEFAULT NULL,
  `have_fund` int(11) DEFAULT NULL,
  `have_bank` int(11) DEFAULT NULL,
  `board_wages` double DEFAULT NULL,
  `board_wage_outside` double DEFAULT NULL,
  `monthly_supply` double DEFAULT NULL,
  `monthly_traffic` double DEFAULT NULL,
  `monthly_phone` double DEFAULT NULL,
  `monthly_play` double DEFAULT NULL,
  `last_clothes` double DEFAULT NULL,
  `last_tourist` double DEFAULT NULL,
  `monthly_tenement` double DEFAULT NULL,
  `asset` double DEFAULT NULL,
  `total_income` double DEFAULT NULL,
  `wife_inborn_year` int(11) DEFAULT NULL,
  `hus_inborn_year` int(11) DEFAULT NULL,
  `child_num` int(11) DEFAULT NULL,
  `old_num` int(11) DEFAULT NULL,
  `hus_income` double DEFAULT NULL,
  `wife_income` double DEFAULT NULL,
  `car_value` double DEFAULT NULL,
  `life_cost` double DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `marrige` int(11) DEFAULT NULL,
  `chile_born_year` int(11) DEFAULT NULL,
  `want_to_be_vip` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `questionnaire_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommend` (
  `user_id` bigint(255) NOT NULL,
  `stocks_rate` double DEFAULT NULL,
  `qdii_rate` double DEFAULT NULL,
  `gold_rate` double DEFAULT NULL,
  `bond_rate` double DEFAULT NULL,
  `total_volatility` double DEFAULT NULL,
  `total_yield` double DEFAULT NULL,
  `invest_prefer` varchar(45) DEFAULT NULL,
  `funds_rate` double DEFAULT NULL,
  `insurance_rate` double DEFAULT NULL,
  `saving_rate` double DEFAULT NULL,
  `invest_rate` double DEFAULT NULL,
  `min_finance_fragility` double DEFAULT NULL,
  `total_risk_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `recommend_allocation_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_adjustment`
--

DROP TABLE IF EXISTS `stock_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_adjustment` (
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stock_code` varchar(6) NOT NULL,
  `stockname` varchar(50) NOT NULL,
  `account_deployed_change` int(11) NOT NULL,
  `m_already_deployed` float NOT NULL,
  `price_deployed` float NOT NULL,
  PRIMARY KEY (`date`,`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_adjustment`
--

LOCK TABLES `stock_adjustment` WRITE;
/*!40000 ALTER TABLE `stock_adjustment` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_record`
--

DROP TABLE IF EXISTS `transfer_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_record` (
  `id` bigint(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` timestamp NULL DEFAULT NULL,
  `gold_total` float NOT NULL,
  `gold_delta` float NOT NULL,
  `bond_total` float NOT NULL,
  `bond_delta` float NOT NULL,
  `stock_total` float NOT NULL,
  `stock_delta` float NOT NULL,
  `user_id` bigint(255) NOT NULL,
  `status` int(11) NOT NULL,
  `is_customize` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_record`
--

LOCK TABLES `transfer_record` WRITE;
/*!40000 ALTER TABLE `transfer_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `identity_num` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_num` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perms` varchar(45) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `status` int(255) unsigned zerofill DEFAULT '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `profile_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,NULL,'admin','admin',NULL,'9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc',NULL,'admin',000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,'2019-08-26 23:28:19','https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg'),(1,'320684199809070018','xyh','153604998@qq.com','18951899427','9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc',NULL,'xyhhh',000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,'2019-08-17 01:58:08','xxx'),(2,'320684199809070019','xxyh','153604998@qq.comm',NULL,NULL,NULL,'xxyhhh',000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,'2019-08-20 06:46:34',NULL),(3,'320684199809070020','xyh','153604998@qq.commm',NULL,NULL,NULL,'xyhhhhhh',000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,'2019-08-20 06:47:10',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_bond_fund`
--

DROP TABLE IF EXISTS `user_bond_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_bond_fund` (
  `user_id` bigint(255) DEFAULT NULL,
  `fund_name` varchar(255) DEFAULT NULL,
  `bond_proportion` double DEFAULT NULL,
  `fund_share` double DEFAULT NULL,
  `net_worth` double DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `inject` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bond_fund`
--

LOCK TABLES `user_bond_fund` WRITE;
/*!40000 ALTER TABLE `user_bond_fund` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_bond_fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'financial'
--

--
-- Dumping routines for database 'financial'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-06 22:27:41
