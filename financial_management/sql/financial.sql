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
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond`
--

LOCK TABLES `bond` WRITE;
/*!40000 ALTER TABLE `bond` DISABLE KEYS */;
INSERT INTO `bond` VALUES (1,'债券1','019613',500),(2,'债券2','9802',500),(3,'债券3','019320',500),(4,'债券4','019587',500),(5,'债券5','101801146',500),(6,'债券6','1880025',500),(7,'债券7','101751041',500),(8,'债券8','101800345',500);
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
INSERT INTO `bond_and_fund` VALUES (1,1,0.25,100),(1,2,0.25,100),(1,3,0.25,100),(1,4,0.25,100),(2,5,0.25,50),(2,6,0.25,50),(2,7,0.25,50),(2,8,0.25,50);
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
INSERT INTO `bond_foundation` VALUES (1,'national',1000,200000,200,0.2,'2019-09-01 08:55:49',1000),(2,'corporate',1000,100000,100,0.2,'2019-09-01 08:55:49',1000);
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

insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",100,"2019-09-01");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",130,"2019-09-02");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",140,"2019-09-03");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",140,"2019-09-04");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",120,"2019-09-05");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",130,"2019-09-06");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",140,"2019-09-07");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",140,"2019-09-08");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",160,"2019-09-09");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",150,"2019-09-10");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",170,"2019-09-11");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",190,"2019-09-12");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",140,"2019-09-13");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (1,"national",180,"2019-09-14");

insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",100,"2019-09-01");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",130,"2019-09-02");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",140,"2019-09-03");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",140,"2019-09-04");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",120,"2019-09-05");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",130,"2019-09-06");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",140,"2019-09-07");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",140,"2019-09-08");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",160,"2019-09-09");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",150,"2019-09-10");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",170,"2019-09-11");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",190,"2019-09-12");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",140,"2019-09-13");
insert into `bond_rate_log` (fund_id, fund_name, net_worth, `time`)  values (2,"corporate",180,"2019-09-14");
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
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2996 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dom_stock`
--

LOCK TABLES `dom_stock` WRITE;
/*!40000 ALTER TABLE `dom_stock` DISABLE KEYS */;
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (1, '000001', '平安银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (2, '000002', '万科Ａ', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (3, '000063', '中兴通讯', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (4, '000069', '华侨城Ａ', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (5, '000100', 'TCL集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (6, '000157', '中联重科', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (7, '000166', '申万宏源', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (8, '000333', '美的集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (9, '000338', '潍柴动力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (10, '000402', '金融街', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (11, '000408', '藏格控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (12, '000413', '东旭光电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (13, '000415', '渤海租赁', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (14, '000423', '东阿阿胶', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (15, '000425', '徐工机械', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (16, '000538', '云南白药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (17, '000553', '安道麦A', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (18, '000568', '泸州老窖', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (19, '000596', '古井贡酒', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (20, '000625', '长安汽车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (21, '000627', '天茂集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (22, '000629', '攀钢钒钛', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (23, '000630', '铜陵有色', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (24, '000651', '格力电器', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (25, '000656', '金科股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (26, '000661', '长春高新', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (27, '000671', '阳光城', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (28, '000703', '恒逸石化', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (29, '000709', '河钢股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (30, '000725', '京东方A', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (31, '000728', '国元证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (32, '000768', '中航飞机', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (33, '000776', '广发证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (34, '000783', '长江证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (35, '000786', '北新建材', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (36, '000858', '五 粮 液', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (37, '000876', '新 希 望', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (38, '000895', '双汇发展', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (39, '000898', '鞍钢股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (40, '000938', '紫光股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (41, '000961', '中南建设', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (42, '000963', '华东医药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (43, '001979', '招商蛇口', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (44, '002001', '新和成', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (45, '002007', '华兰生物', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (46, '002008', '大族激光', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (47, '002010', '传化智联', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (48, '002024', '苏宁易购', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (49, '002027', '分众传媒', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (50, '002032', '苏泊尔', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (51, '002044', '美年健康', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (52, '002050', '三花智控', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (53, '002065', '东华软件', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (54, '002081', '金螳螂', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (55, '002120', '韵达股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (56, '002142', '宁波银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (57, '002146', '荣盛发展', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (58, '002153', '石基信息', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (59, '002179', '中航光电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (60, '002202', '金风科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (61, '002230', '科大讯飞', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (62, '002236', '大华股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (63, '002241', '歌尔股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (64, '002252', '上海莱士', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (65, '002271', '东方雨虹', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (66, '002294', '信立泰', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (67, '002304', '洋河股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (68, '002310', '东方园林', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (69, '002311', '海大集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (70, '002352', '顺丰控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (71, '002410', '广联达', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (72, '002411', '延安必康', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (73, '002415', '海康威视', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (74, '002422', '科伦药业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (75, '002456', '欧菲光', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (76, '002460', '赣锋锂业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (77, '002466', '天齐锂业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (78, '002468', '申通快递', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (79, '002475', '立讯精密', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (80, '002493', '荣盛石化', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (81, '002508', '老板电器', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (82, '002555', '三七互娱', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (83, '002558', '巨人网络', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (84, '002594', '比亚迪', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (85, '002601', '龙蟒佰利', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (86, '002602', '世纪华通', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (87, '002624', '完美世界', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (88, '002625', '光启技术', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (89, '002673', '西部证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (90, '002714', '牧原股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (91, '002736', '国信证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (92, '002739', '万达电影', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (93, '002773', '康弘药业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (94, '002925', '盈趣科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (95, '002938', '鹏鼎控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (96, '002939', '长城证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (97, '002945', '华林证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (98, '300003', '乐普医疗', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (99, '300015', '爱尔眼科', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (100, '300017', '网宿科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (101, '300024', '机器人', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (102, '300033', '同花顺', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (103, '300059', '东方财富', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (104, '300070', '碧水源', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (105, '300072', '三聚环保', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (106, '300122', '智飞生物', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (107, '300124', '汇川技术', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (108, '300136', '信维通信', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (109, '300142', '沃森生物', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (110, '300144', '宋城演艺', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (111, '300251', '光线传媒', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (112, '300296', '利亚德', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (113, '300408', '三环集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (114, '300413', '芒果超媒', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (115, '300433', '蓝思科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (116, '300498', '温氏股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (117, '600000', '浦发银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (118, '600004', '白云机场', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (119, '600009', '上海机场', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (120, '600010', '包钢股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (121, '600011', '华能国际', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (122, '600015', '华夏银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (123, '600016', '民生银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (124, '600018', '上港集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (125, '600019', '宝钢股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (126, '600023', '浙能电力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (127, '600025', '华能水电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (128, '600027', '华电国际', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (129, '600028', '中国石化', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (130, '600029', '南方航空', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (131, '600030', '中信证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (132, '600031', '三一重工', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (133, '600036', '招商银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (134, '600038', '中直股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (135, '600048', '保利地产', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (136, '600050', '中国联通', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (137, '600061', '国投资本', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (138, '600066', '宇通客车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (139, '600068', '葛洲坝', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (140, '600085', '同仁堂', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (141, '600089', '特变电工', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (142, '600100', '同方股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (143, '600104', '上汽集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (144, '600109', '国金证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (145, '600111', '北方稀土', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (146, '600115', '东方航空', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (147, '600118', '中国卫星', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (148, '600153', '建发股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (149, '600170', '上海建工', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (150, '600176', '中国巨石', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (151, '600177', '雅戈尔', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (152, '600188', '兖州煤业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (153, '600196', '复星医药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (154, '600208', '新湖中宝', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (155, '600219', '南山铝业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (156, '600221', '海航控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (157, '600233', '圆通速递', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (158, '600271', '航天信息', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (159, '600276', '恒瑞医药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (160, '600297', '广汇汽车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (161, '600299', '安迪苏', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (162, '600309', '万华化学', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (163, '600332', '白云山', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (164, '600339', '中油工程', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (165, '600340', '华夏幸福', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (166, '600346', '恒力石化', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (167, '600352', '浙江龙盛', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (168, '600362', '江西铜业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (169, '600369', '西南证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (170, '600372', '中航电子', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (171, '600383', '金地集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (172, '600390', '五矿资本', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (173, '600398', '海澜之家', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (174, '600406', '国电南瑞', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (175, '600415', '小商品城', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (176, '600436', '片仔癀', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (177, '600438', '通威股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (178, '600482', '中国动力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (179, '600487', '亨通光电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (180, '600489', '中金黄金', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (181, '600498', '烽火通信', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (182, '600516', '方大炭素', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (183, '600519', '贵州茅台', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (184, '600522', '中天科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (185, '600535', '天士力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (186, '600547', '山东黄金', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (187, '600566', '济川药业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (188, '600570', '恒生电子', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (189, '600583', '海油工程', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (190, '600585', '海螺水泥', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (191, '600588', '用友网络', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (192, '600606', '绿地控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (193, '600637', '东方明珠', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (194, '600660', '福耀玻璃', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (195, '600663', '陆家嘴', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (196, '600674', '川投能源', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (197, '600688', '上海石化', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (198, '600690', '海尔智家', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (199, '600703', '三安光电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (200, '600704', '物产中大', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (201, '600705', '中航资本', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (202, '600733', '北汽蓝谷', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (203, '600741', '华域汽车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (204, '600760', '中航沈飞', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (205, '600795', '国电电力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (206, '600809', '山西汾酒', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (207, '600816', '安信信托', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (208, '600837', '海通证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (209, '600867', '通化东宝', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (210, '600886', '国投电力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (211, '600887', '伊利股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (212, '600893', '航发动力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (213, '600900', '长江电力', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (214, '600919', '江苏银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (215, '600926', '杭州银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (216, '600958', '东方证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (217, '600977', '中国电影', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (218, '600998', '九州通', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (219, '600999', '招商证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (220, '601006', '大秦铁路', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (221, '601009', '南京银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (222, '601012', '隆基股份', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (223, '601018', '宁波港', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (224, '601021', '春秋航空', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (225, '601066', '中信建投', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (226, '601088', '中国神华', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (227, '601108', '财通证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (228, '601111', '中国国航', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (229, '601117', '中国化学', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (230, '601138', '工业富联', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (231, '601155', '新城控股', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (232, '601162', '天风证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (233, '601166', '兴业银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (234, '601169', '北京银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (235, '601186', '中国铁建', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (236, '601198', '东兴证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (237, '601211', '国泰君安', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (238, '601212', '白银有色', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (239, '601216', '君正集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (240, '601225', '陕西煤业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (241, '601228', '广州港', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (242, '601229', '上海银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (243, '601238', '广汽集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (244, '601288', '农业银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (245, '601298', '青岛港', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (246, '601318', '中国平安', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (247, '601319', '中国人保', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (248, '601328', '交通银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (249, '601336', '新华保险', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (250, '601360', '三六零', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (251, '601377', '兴业证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (252, '601390', '中国中铁', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (253, '601398', '工商银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (254, '601555', '东吴证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (255, '601577', '长沙银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (256, '601600', '中国铝业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (257, '601601', '中国太保', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (258, '601607', '上海医药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (259, '601618', '中国中冶', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (260, '601628', '中国人寿', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (261, '601633', '长城汽车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (262, '601668', '中国建筑', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (263, '601669', '中国电建', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (264, '601688', '华泰证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (265, '601727', '上海电气', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (266, '601766', '中国中车', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (267, '601788', '光大证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (268, '601800', '中国交建', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (269, '601808', '中海油服', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (270, '601818', '光大银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (271, '601828', '美凯龙', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (272, '601838', '成都银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (273, '601857', '中国石油', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (274, '601877', '正泰电器', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (275, '601878', '浙商证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (276, '601881', '中国银河', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (277, '601888', '中国国旅', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (278, '601898', '中煤能源', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (279, '601899', '紫金矿业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (280, '601901', '方正证券', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (281, '601919', '中远海控', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (282, '601933', '永辉超市', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (283, '601939', '建设银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (284, '601985', '中国核电', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (285, '601988', '中国银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (286, '601989', '中国重工', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (287, '601992', '金隅集团', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (288, '601997', '贵阳银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (289, '601998', '中信银行', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (290, '603019', '中科曙光', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (291, '603156', '养元饮品', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (292, '603160', '汇顶科技', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (293, '603259', '药明康德', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (294, '603260', '合盛硅业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (295, '603288', '海天味业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (296, '603799', '华友钴业', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (297, '603833', '欧派家居', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (298, '603858', '步长制药', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (299, '603986', '兆易创新', 0);
INSERT INTO financial.dom_stock (id, code, name, latest_price) VALUES (300, '603993', '洛阳钼业', 0);
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
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `for_stock`
--

LOCK TABLES `for_stock` WRITE;
/*!40000 ALTER TABLE `for_stock` DISABLE KEYS */;
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (1, '123123', '阿这', 12);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (2, '123321', '啊这', 23);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (4, '001092', '广发生物科技指数(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (7, '161127', '易标普生物科技人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (10, '160719', '嘉实黄金', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (13, '161116', '易方达黄金主题', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (16, '164701', '汇添富黄金及贵金属', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (19, '320013', '诺安全球黄金', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (22, '000179', '广发美国房地产指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (25, '003463', '泰达宏利亚洲债券(QDII)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (28, '003464', '泰达宏利亚洲债券(QDII)C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (31, '005440', '华安全球稳健配置(QDII-FOF)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (34, '270027', '广发全球农业指数(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (37, '005441', '华安全球稳健配置(QDII-FOF)C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (40, '007361', '易方达中短期美元债(QDII)C人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (43, '007360', '易方达中短期美元债(QDII)A人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (46, '002286', '中银美元债债券人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (49, '320017', '诺安全球收益不动产', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (52, '004420', '汇添富美元债债券人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (55, '004419', '汇添富美元债债券人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (58, '000103', '国泰中国企业境外高收益债', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (61, '003387', '工银全球美元债C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (64, '005243', '融通中国概念债券', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (67, '002393', '华安全球美元收益债C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (70, '004161', '国泰企业信用精选A人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (73, '002391', '华安全球美元收益债人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (76, '004164', '国泰企业信用精选C人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (79, '161126', '易方达标普医疗保健人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (82, '160140', '南方道琼斯美国精选A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (85, '160141', '南方道琼斯美国精选C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (88, '002880', '华夏大中华信用债C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (91, '002877', '华夏大中华信用债A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (94, '000342', '嘉实新兴市场A1(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (97, '002429', '华安全球美元票息债C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (100, '002426', '华安全球美元票息债人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (103, '002400', '南方亚洲美元债人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (106, '050030', '博时亚洲票息收益债券', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (109, '002401', '南方亚洲美元债人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (112, '001063', '华夏收益债券(QDII)C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (115, '001061', '华夏收益债券(QDII)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (118, '004998', '长信全球债券人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (121, '000369', '广发全球医疗保健(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (124, '001936', '国泰全球绝对收益人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (127, '006448', '华夏全球聚享C人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (130, '006445', '华夏全球聚享A人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (133, '100050', '富国全球债券人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (136, '007205', '银华美元债精选(QDII)C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (139, '007204', '银华美元债精选(QDII)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (142, '000290', '鹏华全球高收益债(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (145, '000274', '广发亚太中高收益债券', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (148, '005912', '广发全球收益(QDII)人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (151, '001984', '上投摩根中国生物医药(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (154, '005913', '广发全球收益(QDII)人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (157, '070031', '嘉实全球房地产(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (160, '003629', '上投摩根全球多元配置人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (163, '002891', '华夏移动互联混合人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (166, '004877', '汇添富全球医疗混合人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (169, '005613', '上投富时发达市场REITs', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (172, '005698', '华夏全球科技先锋混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (175, '161815', '银华抗通胀主题', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (178, '050020', '博时抗通胀增强回报', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (181, '001691', '南方香港成长(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (184, '486002', '工银全球精选股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (187, '163813', '中银全球策略', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (190, '161129', '易方达原油A类人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (193, '003321', '易方达原油C类人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (196, '202801', '南方全球精选配置', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (199, '000043', '嘉实美国成长股票人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (202, '519981', '长信标普100等权重指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (205, '501018', '南方原油A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (208, '006476', '南方原油C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (211, '000614', '华安德国30(DAX)联接', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (214, '040046', '华安纳斯达克100指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (217, '005557', '广发海外多元配置人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (220, '183001', '银华全球优选', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (223, '000834', '大成纳斯达克100', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (226, '000041', '华夏全球股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (229, '161130', '易方达纳斯达克100人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (232, '160723', '嘉实原油(QDII-LOF)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (235, '006282', '上投欧洲动力(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (238, '486001', '工银全球股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (241, '050025', '博时标普500ETF联接A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (244, '006075', '博时标普500ETF联接C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (247, '003243', '上投摩根中国世纪人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (250, '161125', '易方达标普500指数人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (253, '270042', '广发纳斯达克100指数A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (256, '006479', '广发纳斯达克100指数C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (259, '160213', '国泰纳斯达克100指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (262, '519696', '交银环球精选混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (265, '460010', '华泰柏瑞亚洲领导企业混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (268, '519601', '海富通中国海外混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (271, '096001', '大成标普500等权重指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (274, '270023', '广发全球精选股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (277, '519602', '海富通大中华混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (280, '161620', '融通核心价值混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (283, '161128', '易标普信息科技人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (286, '005534', '华夏新时代混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (289, '006308', '汇添富全球消费混合人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (292, '160416', '华安标普全球石油指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (295, '006309', '汇添富全球消费混合人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (298, '262001', '景顺长城大中华混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (301, '006373', '国富全球科技互联混合人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (304, '206006', '鹏华环球发现', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (307, '040018', '华安香港精选股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (310, '161229', '国投瑞银中国价值发现股票', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (313, '118002', '易方达标普消费品指数A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (316, '005676', '易方达标普消费品指数C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (319, '001668', '汇添富全球互联混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (322, '160125', '南方香港优选股票', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (325, '162719', '广发道琼斯石油指数人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (328, '004243', '广发道琼斯石油指数人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (331, '378006', '上投摩根全球新兴市场混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (334, '206011', '鹏华美国房地产(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (337, '006555', '浦银安盛全球智能科技(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (340, '163208', '诺安油气能源', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (343, '002379', '工银香港中小盘人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (346, '377016', '上投摩根亚太优势混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (349, '165513', '信诚全球商品主题', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (352, '006779', '广发恒生中国企业(QDII)C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (355, '006778', '广发恒生中国企业(QDII)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (358, '040021', '华安大中华升级股票', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (361, '070012', '嘉实海外中国股票混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (364, '160216', '国泰大宗商品', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (367, '000988', '嘉实全球互联网股票人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (370, '006105', '泰达宏利印度(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (373, '161714', '招商标普金砖四国指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (376, '160644', '鹏华港美互联股票人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (379, '005699', '工银新经济人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (382, '100061', '富国中国中小盘混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (385, '470888', '汇添富香港混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (388, '002230', '华夏大中华混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (391, '160121', '南方金砖四国指数(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (394, '050015', '博时大中华亚太精选', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (397, '118001', '易方达亚洲精选股票', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (400, '160923', '大成海外中国机会混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (403, '162411', '华宝标普油气上游股票', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (406, '378546', '上投摩根全球天然资源混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (409, '000934', '国富大中华精选混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (412, '006327', '易方达中证海外联接人民币A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (415, '457001', '国富亚洲机会股票(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (418, '006328', '易方达中证海外联接人民币C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (421, '100055', '富国全球科技互联网(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (424, '539001', '建信全球机遇混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (427, '165510', '信诚四国配置', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (430, '162415', '华宝标普美国消费人民币', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (433, '241001', '华宝海外中国成长混合', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (436, '164906', '交银中证海外中国互联网指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (439, '110031', '易方达恒生国企ETF联接A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (442, '005675', '易方达恒生国企ETF联接C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (445, '539002', '建信新兴市场混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (448, '160717', '嘉实恒生中国企业', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (451, '006263', '易方达香港小型股指数C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (454, '161124', '易方达香港小型股指数A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (457, '080006', '长盛环球行业混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (460, '539003', '建信全球资源混合(QDII)', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (463, '160922', '大成恒生综合中小型股指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (466, '501021', '华宝香港中小(QDII-LOF)A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (469, '161831', '银华恒生国企指数分级', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (472, '501302', '南方恒指ETF联接A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (475, '160924', '大成恒生指数', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (478, '005659', '南方恒指ETF联接C', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (481, '164705', '汇添富恒生指数分级', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (484, '000071', '华夏恒生ETF联接A', 0);
INSERT INTO financial.for_stock (id, code, name, latest_price) VALUES (487, '000948', '华夏沪港通恒生ETF联接A', 0);
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
  `time` date DEFAULT NULL,
  `seven_annualized` float DEFAULT '0',
  `fourteen_annualized` float DEFAULT '0',
  `twentyeight_annualized` float DEFAULT '0',
  `thirty_yield_rate` float DEFAULT '0',
  `ninty_yield_rate` float DEFAULT '0',
  `since_yield_rate` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund`
--

LOCK TABLES `fund` WRITE;
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
INSERT INTO `fund` VALUES ('国投瑞银钱多宝货币A','2019-09-08',0,0,0,0,0,0);
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
  `person_role` varchar(255) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `permiun` float DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (1,'husband','寿险',100000,251),(1,'wife','寿险',100000,251),(1,'husband','重疾险',500000,251),(1,'wife','重疾险',50000,251),(1,'child_1','寿险',50000,251),(1,'child_2','寿险',50000,251),(1,'old_1','寿险',50000,251),(1,'old_2','寿险',150000,251),(1,'whole family','车险',50000,251);
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

-- ----------------------------
-- Records of message
-- ----------------------------

INSERT INTO `message` VALUES ('2', '2019-08-27 23:27:58', '1', '3', '尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区', '\0', '\0');
INSERT INTO `message` VALUES ('3', '2019-08-27 23:56:53', '2', '3', '文章：《标题1》下的评论：“评论？？？”被一举报，请去确认情况是否属实！', '\0', '\0');
INSERT INTO `message` VALUES (10,CURRENT_TIMESTAMP,1,1,'调仓消息 qdii 123123',0,0),
                             (20,'2019-09-09 09:09:09',1,1,'调仓消息 qdii 123321 已确认',1,0);

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
  `purchase_quantity` int(11) DEFAULT NULL,
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
  `accuring_amount` float DEFAULT '0',
  `last_revenue` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_fund`
--

LOCK TABLES `my_fund` WRITE;
/*!40000 ALTER TABLE `my_fund` DISABLE KEYS */;
INSERT INTO `my_fund` VALUES (1,200,'2019-08-30','888888',0,0);
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
  `kind` varchar(255) DEFAULT NULL,
  `maturity` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `premiun` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_ins`
--

LOCK TABLES `my_ins` WRITE;
/*!40000 ALTER TABLE `my_ins` DISABLE KEYS */;
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
  `hold_price` float NOT NULL,
  `hold_num` int(11) NOT NULL,
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
INSERT INTO `my_qdii` VALUES (1,'123123',99.9,100,999,-1,-0.001);
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
INSERT INTO `my_stock` VALUES (1,'601991',99.9,100,999,-1,-0.001);
/*!40000 ALTER TABLE `my_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overseas_bond_recommend`
--

DROP TABLE IF EXISTS `overseas_bond_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `overseas_bond_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `redemption` varchar(255) DEFAULT NULL,
  `bond_type` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `mechanism` varchar(255) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `assets_type` varchar(255) DEFAULT NULL,
  `subscription_rate` varchar(255) DEFAULT NULL,
  `early_redemption_fee` varchar(255) DEFAULT NULL,
  `service_fee` varchar(255) DEFAULT NULL,
  `risk_rating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overseas_bond_recommend`
--

LOCK TABLES `overseas_bond_recommend` WRITE;
/*!40000 ALTER TABLE `overseas_bond_recommend` DISABLE KEYS */;
INSERT INTO `overseas_bond_recommend` VALUES (2,'116CN','2.625','2027/11/2','20','国债','美元','CHINA GOVT INTL BOND2','一年2次，5月2日/11月2日','NA/NA','亚太(不含日本)/新\n兴市场债券','$50,000以下：债券剩余期限<2年，0.75%；债券剩余期限>2年，1% / %50,000以上：0.5%','0.005','0.0025','1'),(3,'115CN','2.125','2022/11/2','20','国债','美元','CHINA GOVT INTL BOND2','一年2次，5月2日/11月2日','NA/NA','亚太(不含日本)/新\n兴市场债券','$50,000以下：债券剩余期限<2年，0.75%；债券剩余期限>2年，1% / %50,000以上：0.5%','0.005','0.0025','1'),(4,'118AG','3.4','2027/12/6\n(Callable)','20','高级债','美元','ALIBABA GROUP HOLDING2','一年2次，6月6日/12月6日','A1/A+','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(5,'117AG','2.8','2023/6/6\n(Callable)','20','高级债','美元','ALIBABA GROUP HOLDING2','一年2次，6月6日/12月6日','A1/A+','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(6,'MS017','3.95','2027/4/23','2','从属债','美元','MORGAN STANLEY3','一年2次，4月23日/10月23日','Baa2/BBB','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(7,'361AB','4.1','2027/9/6','2','高级债','澳元','FBG FINANCE PTY LTD2','一年2次，3月6日/9月6日','Baa1/A-','亚太(不含日本)/新\n兴市场债券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','4'),(8,'362LO','4.25','2027/11/22','2','高级债','澳元','LLOYDS BANKING GROUP PLC3','一年2次，5月22日/11月22日','A3/BBB+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','2'),(9,'CTG01','3M LIBOR\n+143bps','2023/9/1\n(Callable)','2','高级债','美元','CITIGROUP INC2','一年4次，3月1日/6月1日/9月1日/12月1日','A3/BBB+','美国/全球投资级债\n券','$50,000以下：1.5% / $50,000以上，1%','0.005','0.0025','2'),(10,'BOC02','3M LIBOR\n+88bps','2022/11/22','20','高级债','美元','BANK OF CHINA/PARIS2','一年4次，2月22日/5月22日/8月22日/11月22日','A1/A','亚太(不含日本)/新\n兴市场债券','$50,000以下：1.5% / $50,000以上，1%','0.005','0.0025','1'),(11,'101MB','3.9','2026/1/15','2','高级债','美元','麦格理银行MACQUARIE BANK\nLTD','一年2次，1月15日/7月15日','A2/A','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(12,'102AG','3.6','2024/11/28\n(Callable)','20','高级债','美元','阿里巴巴集团控股有限公司AL IBABA GROUP HOLDING','一年2次，5月28日/11月28日','A1/A+','亚太(不含日本)/新兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(13,'103HP','4.9','2025/10/15\n(Callable)','2','高级债','美元','惠普企业HP ENTERPRISE CO','一年2次，4月15日/10月15日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(14,'104FD','4.134','2025/8/4','20','高级债','美元','福特汽车信贷有限责任公司F ORD MOTOR CREDIT CO LLC','一年2次，2月4日/8月4日','Baa3/BBB','美国/全球投资级债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(15,'105AG','3.75','2025/7/10\n(Callable)','2','高级债','美元','美国国际集团AMERICAN INTL\nGROUP','一年2次，1月10日/7月10日','Baa1/BBB+','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(16,'107HP','3.6','2020/10/15\n(Callable)','2','高级债','美元','惠普企业HP ENTERPRISE CO','一年2次，4月15日/10月15日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(17,'108JD','3.125','2021/4/29','20','高级债','美元','京东JD.COM INC','一年2次，4月29日/10月29日','Baa2/BBB','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(18,'109HR','4.875','2026/11/22','20','高级债','美元','华融HUARONG FINANCE II','一年2次，5月22日/11月22日','NA/BBB+','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','3'),(19,'110CH','4.25','2025/4/1\n(Callable)','2','高级债','美元','COACH INC','一年2次，3月1日/6月1日/9月1日/12月1日','Baa2/BBB-','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(20,'113GS','2.35','2021/11/15\n(Callable)','2','高级债','美元','高盛GOLDMAN SACHS GROUP\nINC','一年2次，3月1日/6月1日/9月1日/12月1日','A3/BBB+','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','2'),(21,'112EB','2.875','2021/8/1\n(Callable)','2','高级债','美元','EBAY INC','一年2次，3月1日/6月1日/9月1日/12月1日','Baa1/BBB+','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(22,'173LF','5.25','2020/5/13','10','高级债','美元','利丰有限公司LI & FUNG LTD','一年2次，5月13日/11月13日','Baa3/BBB','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(23,'175MG','6','2020/1/14','2','高级债','美元','麦格理集团有限公司MACQUA\nRIE GROUP LTD','一年2次，1月14日/7月14日','A3/BBB','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','2'),(24,'183HA','3.625','2020/2/7','20','高级债','美元','海南航空HAINAN AIRLINE HK','一年2次，2月7日/8月7日','A1/A','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(25,'186CP','3.95','2022/4/19','20','高级债','美元','中石油CNPC GENERAL CAPITAL','一年2次，4月19日/10月19日','A2/A','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(26,'187GS','3.625','2023/1/22','2','高级债','美元','高盛GOLDMAN SACHS GROUP\nINC','一年2次，1月22日/7月22日','A3/BBB+','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','2'),(27,'188GE','3.15','2022/9/7','2','高级债','美元','通用电气GENERAL ELEC CAP\nCORP','一年2次，3月7日/9月7日','Baa1/BBB+','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(28,'189DB','3.7','2024/5/30','2','高级债','美元','德意志银行（伦敦）DEUTSCH\nE BANK AG LONDON','一年2次，5月30日/11月30日','Baa3/BBB-','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(29,'190CO','3.95','2022/11/15','20','高级债','美元','中国海外发展CHINA\nOVERSEAS FINANCE C','一年2次，5月15日/11月15日','Baa1/BBB+','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(30,'192SO','6','2024/7/30','20','高级债','美元','远洋地产宝财I有限公司SINO\nOCEAN LND TRS FIN I','一年2次，1月30日/7月30日','Baa3/NR','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','3'),(31,'193CD','4.25','2025/4/23','20','高级债','美元','中国信达融资CHINA CINDA\nFINANCE 2015','一年2次，4月23日/10月23日','Baa1/A-','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','4'),(32,'195CD','3.125','2020/4/23','20','高级债','美元','中国信达融资CHINA CINDA\nFINANCE 2015','一年2次，4月23日/10月23日','Baa1/A-','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','4'),(33,'196BD','3','2020/6/30','20','高级债','美元','百度BAIDU INC','一年2次，6月30日/12月30日','A3/NA','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','2'),(34,'197BC','2.875','2020/6/30','20','高级债','美元','中国银行（香港）BANK OF\nCHINA HONG KONG','一年2次，6月30日/12月30日','A1/NA','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','2'),(35,'356CC','4.25','2021/8/12','3','高级债','澳元','可口可乐阿马提尔有限公司C\nOCA-COLA AMATIL LTD','一年1次，43689','A3/BBB+','亚太(不含日本)/新\n兴市场债券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','2'),(36,'357AP','3.7','2022/8/28','2','高级债','澳元','苹果公司APPLE INC','一年2次，2月28日/8月28日','Aa1/AA+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','4'),(37,'358IT','4','2022/12/1','2','高级债','澳元','英特尔公司INTEL CORP','一年2次，6月1日/12月1日','A1/A+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','1'),(38,'359CS','4','2021/3/9','2','高级债','澳元','瑞士信贷银行/悉尼CREDIT\nSUISSE/SYDNEY','一年2次，3月9日/9月9日','A1/A+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','1'),(39,'360CT','3.75','2023/10/27','2','高级债','澳元','花旗集团CITIGROUP INC','一年2次，4月27日/10月27日','A3/BBB+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','2'),(40,'BA013','3.95','2025/4/21','2','从属债','美元','美国银行BANK OF AMERICA\nCORP','一年2次，4月21日/10月21日','Baa1/BBB+','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(41,'BO007','5.55','2020/2/11','10','从属债','美元','中国银行（香港）BANK OF\nCHINA HONG KONG','一年2次，2月11日/8月11日','A3/A','亚太(不含日本)/新\n兴市场债券','0.02','0.005','0.005','1'),(42,'C012U','4.05','2022/7/30','2','从属债','美元','花旗集团CITIGROUP INC','一年2次，1月30日/7月30日','Baa2/BBB','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(43,'CT014','3.875','2025/3/26','2','从属债','美元','花旗集团CITIGROUP INC','一年2次，3月26日/9月26日','Baa2/BBB','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(44,'CT016','4.3','2026/11/20','2','从属债','美元','花旗集团CITIGROUP INC','一年2次，5月20日/11月20日','Baa2/BBB','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(45,'EA008','6.125','2020/7/16','10','从属债','美元','东亚银行BANK OF EAST ASIA\nLTD','一年2次，1月16日/7月16日','Baa3/BBB','亚太(不含日本)/新\n兴市场债券','0.02','0.005','0.005','5'),(46,'HS015','4.25','2024/3/14','20','从属债','美元','汇丰控股HSBC HOLDINGS PLC','一年2次，3月14日/9月14日','A3/BBB+','美国/全球投资级债\n券','0.02','0.005','0.005','2'),(47,'MG010','6.625','2021/4/7','2','从属债','美元','麦格理银行MACQUARIE BANK\nLTD','一年2次，4月7日/10月7日','Baa2/BBB','亚太(不含日本)/新\n兴市场债券','0.02','0.005','0.005','5'),(48,'SC011','3.95','2023/1/11','20','从属债','美元','渣打集团STANDARD\nCHARTERED PLC','一年2次，1月11日/7月11日','Baa2/BBB-','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(49,'SG012','4.25','2025/4/14','20','从属债','美元','法国兴业银行SOCIETE\nGENERALE','一年2次，4月14日/10月14日','Baa3/BBB','美国/全球投资级债\n券','0.02','0.005','0.005','5'),(50,'119BC','2.375','2020/2/14','20','高级债','美元','中国银行（香港）BANK OF\nCHINA/HONG KONG','一年2次，2月14日/8月14日','A1/A','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(51,'120SC','5.875','2020/6/24','10','从属债','美元','渣打银行（香港）STANDARD\nCHARTERED BK HK','一年2次，6月24日/12月24日','Baa1/A-','亚太(不含日本)/新\n兴市场债券','0.02','0.005','0.005','4'),(52,'121MB','2.85','2020/7/29','2','高级债','美元','麦格理银行MACQUARIE BANK\nLTD','一年2次，1月29日/7月29日','A2/A','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','1'),(53,'MQG03','3M Libor\n+135bps','3/27/2024\n(callable)','2','高级债','美元','麦格理集团MACQUARIE\nGROUP LTD','一年4次，3月27日/6月27日/9月27日/12月27日','A3/BBB','亚太(不含日本)/新\n兴市场债券','$50,000以下：1.5% / $50,000以上，1%','0.005','0.0025','2'),(54,'VOD04','3M  Libor\n+99bps','2024/1/16','2','高级债','美元','沃达丰集团VODAFONE\nGROUP PLC','一年4次，4月16日/7月16日/10月16日/1月16日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下：1.5% / $50,000以上，1%','0.005','0.0025','5'),(55,'122VG','4.375','2028/5/30','2','高级债','美元','沃达丰集团VODAFONE\nGROUP PLC','一年2次，5月30日/11月30日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(56,'123VG','4.125','2025/5/30','2','高级债','美元','沃达丰集团VODAFONE\nGROUP PLC','一年2次，5月30日/11月30日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(57,'124VG','3.75','2024/1/16','2','高级债','美元','沃达丰集团VODAFONE\nGROUP PLC','一年2次，1月16日/7月16日','Baa2/BBB','美国/全球投资级债\n券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','5'),(58,'125WB','2.7','2026/8/19','2','高级债','美元','西太平洋银行WESTPAC\nBANKING CORP','一年2次，2月19日/8月19日','Aa3/AA-','亚太(不含日本)/新\n兴市场债券','$50,000以下，1.5% / $50,000以上，1%','0.005','0.0025','4'),(59,'126DF','4.5','2021/9/21','100','高级债','人民\n币','戴姆勒国际金融公司 DAIMLER\nINTL FINANCE BV','一年1次，43729','A2/A','美国/全球投资级债\n券','0.01','0.005','0.0025','1'),(60,'127BC','4.65','2021/3/5','100','高级债','人民\n币','中国银行（澳门）\nBANK OF CHINA/MACAU','一年2次，3月5日/9月5日','A1/A','亚太(不含日本)/新\n兴市场债券','0.01','0.005','0.0025','1'),(61,'363LO','4','2025/3/7','2','高级债','澳元','劳埃德银行集团LLOYDS\nBANKING GROUP PLC','一年2次，3月7日/9月7日','A3/BBB+','美国/全球投资级债\n券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','2'),(62,'364SG','3.925','2023/9/20','20','高级债 (非优先）','澳元','法国兴业银行\nSOCIETE GENERALE','一年2次，3月20日/9月20日','Baa2/BBB+','美国/全球投资级债券','A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%','0.005','0.0025','5');
/*!40000 ALTER TABLE `overseas_bond_recommend` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_trade`
--

LOCK TABLES `personal_trade` WRITE;
/*!40000 ALTER TABLE `personal_trade` DISABLE KEYS */;
INSERT INTO `personal_trade` VALUES (1,NULL,'2019-09-01 09:09:09','2019-09-01 09:09:20','DOMSTOCK',1,100,12.3,0,1230,1,1,_binary '\0'),(2,NULL,'2019-09-01 09:09:09','2019-09-01 09:09:20','GOLD',1,1,100,1,101,1,1,_binary '\0');
/*!40000 ALTER TABLE `personal_trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_bond_fund`
--

DROP TABLE IF EXISTS `platform_bond_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_bond_fund` (
  `bond_property` float DEFAULT NULL,
  `residual_property` float DEFAULT NULL,
  `return_rate_seven` float DEFAULT '0',
  `return_rate_thirty` float DEFAULT '0',
  `return_rate_ninety` float DEFAULT '0',
  `commission_rate_one` float DEFAULT '0.03',
  `commission_rate_two` float DEFAULT '0.03',
  `commission_rate_three` float DEFAULT '0.03'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_bond_fund`
--

LOCK TABLES `platform_bond_fund` WRITE;
/*!40000 ALTER TABLE `platform_bond_fund` DISABLE KEYS */;
INSERT INTO `platform_bond_fund` VALUES (300000,10000,0,0,0,0.03,0.03,0.03);
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
-- Table structure for table `qdii_adjustment`
--

DROP TABLE IF EXISTS `qdii_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qdii_adjustment` (
  `qdii_code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `share_deployed` float NOT NULL,
  `number_deployed` int(11) NOT NULL,
  `m_already_deployed` float NOT NULL,
  `price_deployed` float NOT NULL,
  `user_id` bigint(255) NOT NULL,
  `trans_id` bigint(255) NOT NULL,
  PRIMARY KEY (`trans_id`,`qdii_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qdii_adjustment`
--

LOCK TABLES `qdii_adjustment` WRITE;
/*!40000 ALTER TABLE `qdii_adjustment` DISABLE KEYS */;
INSERT INTO `qdii_adjustment` VALUES ('123123','阿这',-0.1,-1,-1.2,12,1,1),('123321','啊这',1,10,23,23,1,2);
/*!40000 ALTER TABLE `qdii_adjustment` ENABLE KEYS */;
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
  `chile_born_year` varchar(45) DEFAULT NULL,
  `vip_level` int(11) DEFAULT NULL,
  `unpaid_arrears` double DEFAULT NULL,
  `previous_arrears_due` double DEFAULT NULL,
  `line_of_credit` double DEFAULT NULL,
  `cash_advance` double DEFAULT NULL,
  `last_payment` double DEFAULT NULL,
  `minimum_due_payment` double DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `questionnaire_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
INSERT INTO `questionnaire` VALUES (1,'2019-09-14',1,1,2,5,230,2300,1,2,3500,3000,300,200,20,50,300,200,100,200000,100000,1973,1966,4,0,25000,25000,50000,50000,55,1,'2000',2,50,50,50,30,20,50);
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
  `vip_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `recommend_allocation_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (1,0.2,0.1,NULL,NULL,NULL,NULL,'保守型',NULL,NULL,NULL,0.3,NULL,NULL,NULL);
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_adjustment`
--

DROP TABLE IF EXISTS `stock_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_adjustment` (
  `order_time` float NULL,
  `code` varchar(15) NOT NULL,
  `state_message` varchar(20) NOT NULL,
  `order_amount` int(11) NOT NULL,
  `complete_amount` int(11) NOT NULL,
  `fee` float NOT NULL,
  `total` float NOT NULL,
  `price` float NOT NULL,
  `trans_id` bigint(255) NOT NULL,
  `user_id` bigint(255) NOT NULL,
  PRIMARY KEY (`trans_id`,`code`)
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
-- Table structure for table `transfer_message`
--

DROP TABLE IF EXISTS `transfer_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_message` (
  `trans_id` bigint(255) NOT NULL,
  `message_id` bigint(255) NOT NULL,
  KEY `fk_transfer` (`trans_id`),
  KEY `fk_message` (`message_id`),
  CONSTRAINT `fk_message` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_transfer` FOREIGN KEY (`trans_id`) REFERENCES `transfer_record` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_message`
--

LOCK TABLES `transfer_message` WRITE;
/*!40000 ALTER TABLE `transfer_message` DISABLE KEYS */;
INSERT INTO `transfer_message` VALUES (1,10),(2,20);
/*!40000 ALTER TABLE `transfer_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_record`
--

DROP TABLE IF EXISTS `transfer_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_record` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(255) NOT NULL,
  `is_qdii` bit(1) NOT NULL,
  `is_checked` bit(1) NOT NULL DEFAULT b'0',
  `is_denied` bit(1) NOT NULL DEFAULT b'0',
  `is_customize` bit(1) NOT NULL DEFAULT b'0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_record`
--

LOCK TABLES `transfer_record` WRITE;
/*!40000 ALTER TABLE `transfer_record` DISABLE KEYS */;
INSERT INTO `transfer_record` VALUES (1,'2019-09-14 11:32:03',NULL,1,_binary '',_binary '\0',_binary '\0',_binary '\0',0),(2,'2019-09-09 01:09:09','2019-09-09 11:19:19',1,_binary '',_binary '',_binary '',_binary '\0',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
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
INSERT INTO `user_bond_fund` VALUES (1,'national',0.75,34,50,'2019-03-09 16:00:00',100),(1,'corporate',0.75,34,50,'2019-03-09 16:00:00',100);
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

-- Dump completed on 2019-09-14 19:35:20
