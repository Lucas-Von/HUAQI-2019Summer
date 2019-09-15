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
INSERT INTO `bond_foundation` VALUES (1,'national',1000,200000,200,0.2,'2019-09-01 08:55:49',1000),(2,'corporate',1000,100000,200,0.2,'2019-09-01 08:55:49',1000);
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
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
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
INSERT INTO `dom_stock` VALUES (1,'平安银行','000001.XSHE',0),(2,'万科A','000002.XSHE',0),(3,'PT金田A','000003.XSHE',0),(4,'国农科技','000004.XSHE',0),(5,'世纪星源','000005.XSHE',0),(6,'深振业A','000006.XSHE',0),(7,'全新好','000007.XSHE',0),(8,'神州高铁','000008.XSHE',0),(9,'中国宝安','000009.XSHE',0),(10,'*ST美丽','000010.XSHE',0),(11,'深物业A','000011.XSHE',0),(12,'南玻A','000012.XSHE',0),(13,'*ST石化A','000013.XSHE',0),(14,'沙河股份','000014.XSHE',0),(15,'PT中浩A','000015.XSHE',0),(16,'深康佳A','000016.XSHE',0),(17,'深中华A','000017.XSHE',0),(18,'*ST神城','000018.XSHE',0),(19,'深粮控股','000019.XSHE',0),(20,'深华发A','000020.XSHE',0),(21,'深科技','000021.XSHE',0),(22,'深赤湾A','000022.XSHE',0),(23,'深天地A','000023.XSHE',0),(24,'招商地产','000024.XSHE',0),(25,'特力A','000025.XSHE',0),(26,'飞亚达A','000026.XSHE',0),(27,'深圳能源','000027.XSHE',0),(28,'国药一致','000028.XSHE',0),(29,'深深房A','000029.XSHE',0),(30,'富奥股份','000030.XSHE',0),(31,'大悦城','000031.XSHE',0),(32,'深桑达A','000032.XSHE',0),(33,'新都退','000033.XSHE',0),(34,'神州数码','000034.XSHE',0),(35,'中国天楹','000035.XSHE',0),(36,'华联控股','000036.XSHE',0),(37,'深南电A','000037.XSHE',0),(38,'深大通','000038.XSHE',0),(39,'中集集团','000039.XSHE',0),(40,'东旭蓝天','000040.XSHE',0),(41,'中洲控股','000042.XSHE',0),(42,'中航善达','000043.XSHE',0),(43,'深纺织A','000045.XSHE',0),(44,'泛海控股','000046.XSHE',0),(45,'ST中侨','000047.XSHE',0),(46,'*ST康达','000048.XSHE',0),(47,'德赛电池','000049.XSHE',0),(48,'深天马A','000050.XSHE',0),(49,'方大集团','000055.XSHE',0),(50,'皇庭国际','000056.XSHE',0),(51,'深赛格','000058.XSHE',0),(52,'华锦股份','000059.XSHE',0),(53,'中金岭南','000060.XSHE',0),(54,'农产品','000061.XSHE',0),(55,'深圳华强','000062.XSHE',0),(56,'中兴通讯','000063.XSHE',0),(57,'北方国际','000065.XSHE',0),(58,'中国长城','000066.XSHE',0),(59,'华控赛格','000068.XSHE',0),(60,'华侨城A','000069.XSHE',0),(61,'特发信息','000070.XSHE',0),(62,'海王生物','000078.XSHE',0),(63,'盐田港','000088.XSHE',0),(64,'深圳机场','000089.XSHE',0),(65,'天健集团','000090.XSHE',0),(66,'广聚能源','000096.XSHE',0),(67,'中信海直','000099.XSHE',0),(68,'TCL集团','000100.XSHE',0),(69,'宜华健康','000150.XSHE',0),(70,'中成股份','000151.XSHE',0),(71,'丰原药业','000153.XSHE',0),(72,'川能动力','000155.XSHE',0),(73,'华数传媒','000156.XSHE',0),(74,'中联重科','000157.XSHE',0),(75,'常山北明','000158.XSHE',0),(76,'国际实业','000159.XSHE',0),(77,'申万宏源','000166.XSHE',0),(78,'东方盛虹','000301.XSHE',0),(79,'美的集团','000333.XSHE',0),(80,'潍柴动力','000338.XSHE',0),(81,'许继电气','000400.XSHE',0),(82,'冀东水泥','000401.XSHE',0),(83,'金融街','000402.XSHE',0),(84,'振兴生化','000403.XSHE',0),(85,'长虹华意','000404.XSHE',0),(86,'ST鑫光','000405.XSHE',0),(87,'石油大明','000406.XSHE',0),(88,'胜利股份','000407.XSHE',0),(89,'藏格控股','000408.XSHE',0),(90,'*ST地矿','000409.XSHE',0),(91,'*ST沈机','000410.XSHE',0),(92,'英特集团','000411.XSHE',0),(93,'ST五环','000412.XSHE',0),(94,'东旭光电','000413.XSHE',0),(95,'渤海租赁','000415.XSHE',0),(96,'民生控股','000416.XSHE',0),(97,'合肥百货','000417.XSHE',0),(98,'小天鹅A','000418.XSHE',0),(99,'通程控股','000419.XSHE',0),(100,'吉林化纤','000420.XSHE',0),(101,'南京公用','000421.XSHE',0),(102,'ST宜化','000422.XSHE',0),(103,'东阿阿胶','000423.XSHE',0),(104,'徐工机械','000425.XSHE',0),(105,'兴业矿业','000426.XSHE',0),(106,'华天酒店','000428.XSHE',0),(107,'粤高速A','000429.XSHE',0),(108,'张家界','000430.XSHE',0),(109,'晨鸣纸业','000488.XSHE',0),(110,'山东路桥','000498.XSHE',0),(111,'鄂武商A','000501.XSHE',0),(112,'绿景控股','000502.XSHE',0),(113,'国新健康','000503.XSHE',0),(114,'*ST生物','000504.XSHE',0),(115,'京粮控股','000505.XSHE',0),(116,'中润资源','000506.XSHE',0),(117,'珠海港','000507.XSHE',0),(118,'琼民源A','000508.XSHE',0),(119,'华塑控股','000509.XSHE',0),(120,'新金路','000510.XSHE',0),(121,'烯碳退','000511.XSHE',0),(122,'丽珠集团','000513.XSHE',0),(123,'渝开发','000514.XSHE',0),(124,'攀渝钛业','000515.XSHE',0),(125,'国际医学','000516.XSHE',0),(126,'荣安地产','000517.XSHE',0),(127,'四环生物','000518.XSHE',0),(128,'中兵红箭','000519.XSHE',0),(129,'长航凤凰','000520.XSHE',0),(130,'长虹美菱','000521.XSHE',0),(131,'白云山A','000522.XSHE',0),(132,'广州浪奇','000523.XSHE',0),(133,'岭南控股','000524.XSHE',0),(134,'红太阳','000525.XSHE',0),(135,'紫光学大','000526.XSHE',0),(136,'美的电器','000527.XSHE',0),(137,'柳工','000528.XSHE',0),(138,'广弘控股','000529.XSHE',0),(139,'大冷股份','000530.XSHE',0),(140,'穗恒运A','000531.XSHE',0),(141,'华金资本','000532.XSHE',0),(142,'顺钠股份','000533.XSHE',0),(143,'万泽股份','000534.XSHE',0),(144,'*ST猴王','000535.XSHE',0),(145,'华映科技','000536.XSHE',0),(146,'广宇发展','000537.XSHE',0),(147,'云南白药','000538.XSHE',0),(148,'粤电力A','000539.XSHE',0),(149,'中天金融','000540.XSHE',0),(150,'佛山照明','000541.XSHE',0),(151,'TCL通讯','000542.XSHE',0),(152,'皖能电力','000543.XSHE',0),(153,'中原环保','000544.XSHE',0),(154,'金浦钛业','000545.XSHE',0),(155,'金圆股份','000546.XSHE',0),(156,'航天发展','000547.XSHE',0),(157,'湖南投资','000548.XSHE',0),(158,'S湘火炬','000549.XSHE',0),(159,'江铃汽车','000550.XSHE',0),(160,'创元科技','000551.XSHE',0),(161,'靖远煤电','000552.XSHE',0),(162,'安道麦A','000553.XSHE',0),(163,'泰山石油','000554.XSHE',0),(164,'神州信息','000555.XSHE',0),(165,'PT南洋','000556.XSHE',0),(166,'西部创业','000557.XSHE',0),(167,'莱茵体育','000558.XSHE',0),(168,'万向钱潮','000559.XSHE',0),(169,'我爱我家','000560.XSHE',0),(170,'烽火电子','000561.XSHE',0),(171,'宏源证券','000562.XSHE',0),(172,'陕国投A','000563.XSHE',0),(173,'供销大集','000564.XSHE',0),(174,'渝三峡A','000565.XSHE',0),(175,'海南海药','000566.XSHE',0),(176,'海德股份','000567.XSHE',0),(177,'泸州老窖','000568.XSHE',0),(178,'长城股份','000569.XSHE',0),(179,'苏常柴A','000570.XSHE',0),(180,'*ST大洲','000571.XSHE',0),(181,'*ST海马','000572.XSHE',0),(182,'粤宏远A','000573.XSHE',0),(183,'广东甘化','000576.XSHE',0),(184,'盐湖集团','000578.XSHE',0),(185,'威孚高科','000581.XSHE',0),(186,'北部湾港','000582.XSHE',0),(187,'S*ST托普','000583.XSHE',0),(188,'哈工智能','000584.XSHE',0),(189,'ST东电','000585.XSHE',0),(190,'汇源通信','000586.XSHE',0),(191,'金洲慈航','000587.XSHE',0),(192,'PT粤金曼','000588.XSHE',0),(193,'贵州轮胎','000589.XSHE',0),(194,'启迪古汉','000590.XSHE',0),(195,'太阳能','000591.XSHE',0),(196,'平潭发展','000592.XSHE',0),(197,'大通燃气','000593.XSHE',0),(198,'国恒退','000594.XSHE',0),(199,'宝塔实业','000595.XSHE',0),(200,'古井贡酒','000596.XSHE',0),(201,'东北制药','000597.XSHE',0),(202,'兴蓉环境','000598.XSHE',0),(203,'青岛双星','000599.XSHE',0),(204,'建投能源','000600.XSHE',0),(205,'韶能股份','000601.XSHE',0),(206,'金马集团','000602.XSHE',0),(207,'盛达矿业','000603.XSHE',0),(208,'渤海股份','000605.XSHE',0),(209,'顺利办','000606.XSHE',0),(210,'华媒控股','000607.XSHE',0),(211,'阳光股份','000608.XSHE',0),(212,'中迪投资','000609.XSHE',0),(213,'西安旅游','000610.XSHE',0),(214,'*ST天首','000611.XSHE',0),(215,'焦作万方','000612.XSHE',0),(216,'大东海A','000613.XSHE',0),(217,'京汉股份','000615.XSHE',0),(218,'海航投资','000616.XSHE',0),(219,'中油资本','000617.XSHE',0),(220,'吉林化工','000618.XSHE',0),(221,'海螺型材','000619.XSHE',0),(222,'新华联','000620.XSHE',0),(223,'*ST比特','000621.XSHE',0),(224,'恒立实业','000622.XSHE',0),(225,'吉林敖东','000623.XSHE',0),(226,'长安汽车','000625.XSHE',0),(227,'远大控股','000626.XSHE',0),(228,'天茂集团','000627.XSHE',0),(229,'高新发展','000628.XSHE',0),(230,'攀钢钒钛','000629.XSHE',0),(231,'铜陵有色','000630.XSHE',0),(232,'顺发恒业','000631.XSHE',0),(233,'三木集团','000632.XSHE',0),(234,'合金投资','000633.XSHE',0),(235,'英力特','000635.XSHE',0),(236,'风华高科','000636.XSHE',0),(237,'茂化实华','000637.XSHE',0),(238,'万方发展','000638.XSHE',0),(239,'西王食品','000639.XSHE',0),(240,'仁和药业','000650.XSHE',0),(241,'格力电器','000651.XSHE',0),(242,'泰达股份','000652.XSHE',0),(243,'ST九州','000653.XSHE',0),(244,'金岭矿业','000655.XSHE',0),(245,'金科股份','000656.XSHE',0),(246,'中钨高新','000657.XSHE',0),(247,'ST海洋','000658.XSHE',0),(248,'珠海中富','000659.XSHE',0),(249,'*ST南华','000660.XSHE',0),(250,'长春高新','000661.XSHE',0),(251,'天夏智慧','000662.XSHE',0),(252,'永安林业','000663.XSHE',0),(253,'湖北广电','000665.XSHE',0),(254,'经纬纺机','000666.XSHE',0),(255,'美好置业','000667.XSHE',0),(256,'荣丰控股','000668.XSHE',0),(257,'金鸿控股','000669.XSHE',0),(258,'*ST盈方','000670.XSHE',0),(259,'阳光城','000671.XSHE',0),(260,'上峰水泥','000672.XSHE',0),(261,'当代东方','000673.XSHE',0),(262,'ST银山','000675.XSHE',0),(263,'智度股份','000676.XSHE',0),(264,'恒天海龙','000677.XSHE',0),(265,'襄阳轴承','000678.XSHE',0),(266,'大连友谊','000679.XSHE',0),(267,'山推股份','000680.XSHE',0),(268,'视觉中国','000681.XSHE',0),(269,'东方电子','000682.XSHE',0),(270,'远兴能源','000683.XSHE',0),(271,'中山公用','000685.XSHE',0),(272,'东北证券','000686.XSHE',0),(273,'华讯方舟','000687.XSHE',0),(274,'国城矿业','000688.XSHE',0),(275,'ST宏业','000689.XSHE',0),(276,'宝新能源','000690.XSHE',0),(277,'亚太实业','000691.XSHE',0),(278,'惠天热电','000692.XSHE',0),(279,'华泽退','000693.XSHE',0),(280,'滨海能源','000695.XSHE',0),(281,'炼石航空','000697.XSHE',0),(282,'沈阳化工','000698.XSHE',0),(283,'S*ST佳纸','000699.XSHE',0),(284,'模塑科技','000700.XSHE',0),(285,'厦门信达','000701.XSHE',0),(286,'正虹科技','000702.XSHE',0),(287,'恒逸石化','000703.XSHE',0),(288,'浙江震元','000705.XSHE',0),(289,'ST双环','000707.XSHE',0),(290,'大冶特钢','000708.XSHE',0),(291,'河钢股份','000709.XSHE',0),(292,'贝瑞基因','000710.XSHE',0),(293,'京蓝科技','000711.XSHE',0),(294,'锦龙股份','000712.XSHE',0),(295,'丰乐种业','000713.XSHE',0),(296,'中兴商业','000715.XSHE',0),(297,'黑芝麻','000716.XSHE',0),(298,'韶钢松山','000717.XSHE',0),(299,'苏宁环球','000718.XSHE',0),(300,'中原传媒','000719.XSHE',0),(301,'新能泰山','000720.XSHE',0),(302,'西安饮食','000721.XSHE',0),(303,'湖南发展','000722.XSHE',0),(304,'美锦能源','000723.XSHE',0),(305,'京东方A','000725.XSHE',0),(306,'鲁泰A','000726.XSHE',0),(307,'华东科技','000727.XSHE',0),(308,'国元证券','000728.XSHE',0),(309,'燕京啤酒','000729.XSHE',0),(310,'*ST环保','000730.XSHE',0),(311,'四川美丰','000731.XSHE',0),(312,'泰禾集团','000732.XSHE',0),(313,'振华科技','000733.XSHE',0),(314,'罗牛山','000735.XSHE',0),(315,'中交地产','000736.XSHE',0),(316,'ST南风','000737.XSHE',0),(317,'航发控制','000738.XSHE',0),(318,'普洛药业','000739.XSHE',0),(319,'长城信息','000748.XSHE',0),(320,'国海证券','000750.XSHE',0),(321,'锌业股份','000751.XSHE',0),(322,'*ST西发','000752.XSHE',0),(323,'漳州发展','000753.XSHE',0),(324,'山西路桥','000755.XSHE',0),(325,'新华制药','000756.XSHE',0),(326,'浩物股份','000757.XSHE',0),(327,'中色股份','000758.XSHE',0),(328,'中百集团','000759.XSHE',0),(329,'*ST斯太','000760.XSHE',0),(330,'本钢板材','000761.XSHE',0),(331,'西藏矿业','000762.XSHE',0),(332,'锦州石化','000763.XSHE',0),(333,'*ST华信','000765.XSHE',0),(334,'通化金马','000766.XSHE',0),(335,'漳泽电力','000767.XSHE',0),(336,'中航飞机','000768.XSHE',0),(337,'*ST大菲','000769.XSHE',0),(338,'广发证券','000776.XSHE',0),(339,'中核科技','000777.XSHE',0),(340,'新兴铸管','000778.XSHE',0),(341,'甘咨询','000779.XSHE',0),(342,'平庄能源','000780.XSHE',0),(343,'美达股份','000782.XSHE',0),(344,'长江证券','000783.XSHE',0),(345,'武汉中商','000785.XSHE',0),(346,'北新建材','000786.XSHE',0),(347,'*ST创智','000787.XSHE',0),(348,'北大医药','000788.XSHE',0),(349,'万年青','000789.XSHE',0),(350,'泰合健康','000790.XSHE',0),(351,'甘肃电投','000791.XSHE',0),(352,'*ST盐湖','000792.XSHE',0),(353,'华闻传媒','000793.XSHE',0),(354,'英洛华','000795.XSHE',0),(355,'凯撒旅游','000796.XSHE',0),(356,'中国武夷','000797.XSHE',0),(357,'中水渔业','000798.XSHE',0),(358,'酒鬼酒','000799.XSHE',0),(359,'一汽轿车','000800.XSHE',0),(360,'四川九洲','000801.XSHE',0),(361,'北京文化','000802.XSHE',0),(362,'金宇车城','000803.XSHE',0),(363,'*ST炎黄','000805.XSHE',0),(364,'ST银河','000806.XSHE',0),(365,'云铝股份','000807.XSHE',0),(366,'铁岭新城','000809.XSHE',0),(367,'创维数字','000810.XSHE',0),(368,'冰轮环境','000811.XSHE',0),(369,'陕西金叶','000812.XSHE',0),(370,'德展健康','000813.XSHE',0),(371,'美利云','000815.XSHE',0),(372,'ST慧业','000816.XSHE',0),(373,'辽河油田','000817.XSHE',0),(374,'航锦科技','000818.XSHE',0),(375,'岳阳兴长','000819.XSHE',0),(376,'*ST节能','000820.XSHE',0),(377,'京山轻机','000821.XSHE',0),(378,'山东海化','000822.XSHE',0),(379,'超声电子','000823.XSHE',0),(380,'太钢不锈','000825.XSHE',0),(381,'启迪环境','000826.XSHE',0),(382,'*ST长兴','000827.XSHE',0),(383,'东莞控股','000828.XSHE',0),(384,'天音控股','000829.XSHE',0),(385,'鲁西化工','000830.XSHE',0),(386,'五矿稀土','000831.XSHE',0),(387,'*ST龙涤','000832.XSHE',0),(388,'粤桂股份','000833.XSHE',0),(389,'长城动漫','000835.XSHE',0),(390,'富通鑫茂','000836.XSHE',0),(391,'秦川机床','000837.XSHE',0),(392,'财信发展','000838.XSHE',0),(393,'中信国安','000839.XSHE',0),(394,'承德露露','000848.XSHE',0),(395,'华茂股份','000850.XSHE',0),(396,'高鸿股份','000851.XSHE',0),(397,'石化机械','000852.XSHE',0),(398,'冀东装备','000856.XSHE',0),(399,'五粮液','000858.XSHE',0),(400,'国风塑业','000859.XSHE',0),(401,'顺鑫农业','000860.XSHE',0),(402,'中证结构调整','000860.XSHG',0),(403,'海印股份','000861.XSHE',0),(404,'银星能源','000862.XSHE',0),(405,'三湘印象','000863.XSHE',0),(406,'扬子石化','000866.XSHE',0),(407,'*ST安凯','000868.XSHE',0),(408,'张裕A','000869.XSHE',0),(409,'吉电股份','000875.XSHE',0),(410,'新希望','000876.XSHE',0),(411,'天山股份','000877.XSHE',0),(412,'云南铜业','000878.XSHE',0),(413,'潍柴重机','000880.XSHE',0),(414,'中广核技','000881.XSHE',0),(415,'华联股份','000882.XSHE',0),(416,'湖北能源','000883.XSHE',0),(417,'城发环境','000885.XSHE',0),(418,'海南高速','000886.XSHE',0),(419,'中鼎股份','000887.XSHE',0),(420,'峨眉山A','000888.XSHE',0),(421,'中嘉博创','000889.XSHE',0),(422,'法尔胜','000890.XSHE',0),(423,'欢瑞世纪','000892.XSHE',0),(424,'*ST东凌','000893.XSHE',0),(425,'双汇发展','000895.XSHE',0),(426,'*ST津滨','000897.XSHE',0),(427,'鞍钢股份','000898.XSHE',0),(428,'赣能股份','000899.XSHE',0),(429,'现代投资','000900.XSHE',0),(430,'航天科技','000901.XSHE',0),(431,'新洋丰','000902.XSHE',0),(432,'云内动力','000903.XSHE',0),(433,'厦门港务','000905.XSHE',0),(434,'浙商中拓','000906.XSHE',0),(435,'景峰医药','000908.XSHE',0),(436,'数源科技','000909.XSHE',0),(437,'大亚圣象','000910.XSHE',0),(438,'*ST南糖','000911.XSHE',0),(439,'泸天化','000912.XSHE',0),(440,'钱江摩托','000913.XSHE',0),(441,'山大华特','000915.XSHE',0),(442,'华北高速','000916.XSHE',0),(443,'电广传媒','000917.XSHE',0),(444,'嘉凯城','000918.XSHE',0),(445,'金陵药业','000919.XSHE',0),(446,'南方汇通','000920.XSHE',0),(447,'海信家电','000921.XSHE',0),(448,'佳电股份','000922.XSHE',0),(449,'河北宣工','000923.XSHE',0),(450,'众合科技','000925.XSHE',0),(451,'福星股份','000926.XSHE',0),(452,'一汽夏利','000927.XSHE',0),(453,'中钢国际','000928.XSHE',0),(454,'兰州黄河','000929.XSHE',0),(455,'中粮生化','000930.XSHE',0),(456,'中关村','000931.XSHE',0),(457,'华菱钢铁','000932.XSHE',0),(458,'神火股份','000933.XSHE',0),(459,'四川双马','000935.XSHE',0),(460,'华西股份','000936.XSHE',0),(461,'冀中能源','000937.XSHE',0),(462,'紫光股份','000938.XSHE',0),(463,'*ST凯迪','000939.XSHE',0),(464,'南天信息','000948.XSHE',0),(465,'新乡化纤','000949.XSHE',0),(466,'重药控股','000950.XSHE',0),(467,'中国重汽','000951.XSHE',0),(468,'广济药业','000952.XSHE',0),(469,'*ST河化','000953.XSHE',0),(470,'欣龙控股','000955.XSHE',0),(471,'中原油气','000956.XSHE',0),(472,'中通客车','000957.XSHE',0),(473,'东方能源','000958.XSHE',0),(474,'首钢股份','000959.XSHE',0),(475,'锡业股份','000960.XSHE',0),(476,'中南建设','000961.XSHE',0),(477,'东方钽业','000962.XSHE',0),(478,'华东医药','000963.XSHE',0),(479,'天保基建','000965.XSHE',0),(480,'长源电力','000966.XSHE',0),(481,'盈峰环境','000967.XSHE',0),(482,'蓝焰控股','000968.XSHE',0),(483,'安泰科技','000969.XSHE',0),(484,'中科三环','000970.XSHE',0),(485,'*ST高升','000971.XSHE',0),(486,'ST中基','000972.XSHE',0),(487,'佛塑科技','000973.XSHE',0),(488,'银泰资源','000975.XSHE',0),(489,'华铁股份','000976.XSHE',0),(490,'浪潮信息','000977.XSHE',0),(491,'桂林旅游','000978.XSHE',0),(492,'中弘退','000979.XSHE',0),(493,'众泰汽车','000980.XSHE',0),(494,'ST银亿','000981.XSHE',0),(495,'*ST中绒','000982.XSHE',0),(496,'西山煤电','000983.XSHE',0),(497,'大庆华科','000985.XSHE',0),(498,'越秀金控','000987.XSHE',0),(499,'华工科技','000988.XSHE',0),(500,'九芝堂','000989.XSHE',0),(501,'诚志股份','000990.XSHE',0),(502,'闽东电力','000993.XSHE',0),(503,'*ST皇台','000995.XSHE',0),(504,'中国中期','000996.XSHE',0),(505,'新大陆','000997.XSHE',0),(506,'隆平高科','000998.XSHE',0),(507,'华润三九','000999.XSHE',0),(508,'宗申动力','001696.XSHE',0),(509,'招商港口','001872.XSHE',0),(510,'豫能控股','001896.XSHE',0),(511,'招商公路','001965.XSHE',0),(512,'招商蛇口','001979.XSHE',0),(513,'新和成','002001.XSHE',0),(514,'鸿达兴业','002002.XSHE',0),(515,'伟星股份','002003.XSHE',0),(516,'华邦健康','002004.XSHE',0),(517,'*ST德豪','002005.XSHE',0),(518,'精功科技','002006.XSHE',0),(519,'华兰生物','002007.XSHE',0),(520,'大族激光','002008.XSHE',0),(521,'天奇股份','002009.XSHE',0),(522,'传化智联','002010.XSHE',0),(523,'盾安环境','002011.XSHE',0),(524,'凯恩股份','002012.XSHE',0),(525,'中航机电','002013.XSHE',0),(526,'永新股份','002014.XSHE',0),(527,'协鑫能科','002015.XSHE',0),(528,'世荣兆业','002016.XSHE',0),(529,'东信和平','002017.XSHE',0),(530,'*ST华信','002018.XSHE',0),(531,'亿帆医药','002019.XSHE',0),(532,'京新药业','002020.XSHE',0),(533,'*ST中捷','002021.XSHE',0),(534,'科华生物','002022.XSHE',0),(535,'海特高新','002023.XSHE',0),(536,'苏宁易购','002024.XSHE',0),(537,'航天电器','002025.XSHE',0),(538,'山东威达','002026.XSHE',0),(539,'分众传媒','002027.XSHE',0),(540,'思源电气','002028.XSHE',0),(541,'七匹狼','002029.XSHE',0),(542,'达安基因','002030.XSHE',0),(543,'巨轮智能','002031.XSHE',0),(544,'苏泊尔','002032.XSHE',0),(545,'丽江旅游','002033.XSHE',0),(546,'旺能环境','002034.XSHE',0),(547,'华帝股份','002035.XSHE',0),(548,'联创电子','002036.XSHE',0),(549,'久联发展','002037.XSHE',0),(550,'双鹭药业','002038.XSHE',0),(551,'黔源电力','002039.XSHE',0),(552,'南京港','002040.XSHE',0),(553,'登海种业','002041.XSHE',0),(554,'华孚时尚','002042.XSHE',0),(555,'兔宝宝','002043.XSHE',0),(556,'美年健康','002044.XSHE',0),(557,'国光电器','002045.XSHE',0),(558,'轴研科技','002046.XSHE',0),(559,'宝鹰股份','002047.XSHE',0),(560,'宁波华翔','002048.XSHE',0),(561,'紫光国微','002049.XSHE',0),(562,'三花智控','002050.XSHE',0),(563,'中工国际','002051.XSHE',0),(564,'同洲电子','002052.XSHE',0),(565,'云南能投','002053.XSHE',0),(566,'德美化工','002054.XSHE',0),(567,'得润电子','002055.XSHE',0),(568,'横店东磁','002056.XSHE',0),(569,'中钢天源','002057.XSHE',0),(570,'威尔泰','002058.XSHE',0),(571,'云南旅游','002059.XSHE',0),(572,'粤水电','002060.XSHE',0),(573,'浙江交科','002061.XSHE',0),(574,'宏润建设','002062.XSHE',0),(575,'远光软件','002063.XSHE',0),(576,'华峰氨纶','002064.XSHE',0),(577,'东华软件','002065.XSHE',0),(578,'瑞泰科技','002066.XSHE',0),(579,'景兴纸业','002067.XSHE',0),(580,'黑猫股份','002068.XSHE',0),(581,'獐子岛','002069.XSHE',0),(582,'众和退','002070.XSHE',0),(583,'长城影视','002071.XSHE',0),(584,'*ST凯瑞','002072.XSHE',0),(585,'软控股份','002073.XSHE',0),(586,'国轩高科','002074.XSHE',0),(587,'沙钢股份','002075.XSHE',0),(588,'雪莱特','002076.XSHE',0),(589,'大港股份','002077.XSHE',0),(590,'太阳纸业','002078.XSHE',0),(591,'苏州固锝','002079.XSHE',0),(592,'中材科技','002080.XSHE',0),(593,'金螳螂','002081.XSHE',0),(594,'万邦德','002082.XSHE',0),(595,'孚日股份','002083.XSHE',0),(596,'海鸥住工','002084.XSHE',0),(597,'万丰奥威','002085.XSHE',0),(598,'ST东海洋','002086.XSHE',0),(599,'新野纺织','002087.XSHE',0),(600,'鲁阳节能','002088.XSHE',0),(601,'*ST新海','002089.XSHE',0),(602,'金智科技','002090.XSHE',0),(603,'江苏国泰','002091.XSHE',0),(604,'中泰化学','002092.XSHE',0),(605,'国脉科技','002093.XSHE',0),(606,'青岛金王','002094.XSHE',0),(607,'生意宝','002095.XSHE',0),(608,'南岭民爆','002096.XSHE',0),(609,'山河智能','002097.XSHE',0),(610,'浔兴股份','002098.XSHE',0),(611,'海翔药业','002099.XSHE',0),(612,'天康生物','002100.XSHE',0),(613,'广东鸿图','002101.XSHE',0),(614,'ST冠福','002102.XSHE',0),(615,'广博股份','002103.XSHE',0),(616,'恒宝股份','002104.XSHE',0),(617,'信隆健康','002105.XSHE',0),(618,'莱宝高科','002106.XSHE',0),(619,'沃华医药','002107.XSHE',0),(620,'沧州明珠','002108.XSHE',0),(621,'兴化股份','002109.XSHE',0),(622,'三钢闽光','002110.XSHE',0),(623,'威海广泰','002111.XSHE',0),(624,'三变科技','002112.XSHE',0),(625,'ST天润','002113.XSHE',0),(626,'罗平锌电','002114.XSHE',0),(627,'三维通信','002115.XSHE',0),(628,'中国海诚','002116.XSHE',0),(629,'东港股份','002117.XSHE',0),(630,'紫鑫药业','002118.XSHE',0),(631,'康强电子','002119.XSHE',0),(632,'韵达股份','002120.XSHE',0),(633,'科陆电子','002121.XSHE',0),(634,'*ST天马','002122.XSHE',0),(635,'梦网集团','002123.XSHE',0),(636,'天邦股份','002124.XSHE',0),(637,'湘潭电化','002125.XSHE',0),(638,'银轮股份','002126.XSHE',0),(639,'南极电商','002127.XSHE',0),(640,'露天煤业','002128.XSHE',0),(641,'中环股份','002129.XSHE',0),(642,'沃尔核材','002130.XSHE',0),(643,'利欧股份','002131.XSHE',0),(644,'恒星科技','002132.XSHE',0),(645,'广宇集团','002133.XSHE',0),(646,'天津普林','002134.XSHE',0),(647,'东南网架','002135.XSHE',0),(648,'安纳达','002136.XSHE',0),(649,'麦达数字','002137.XSHE',0),(650,'顺络电子','002138.XSHE',0),(651,'拓邦股份','002139.XSHE',0),(652,'东华科技','002140.XSHE',0),(653,'贤丰控股','002141.XSHE',0),(654,'宁波银行','002142.XSHE',0),(655,'*ST印纪','002143.XSHE',0),(656,'宏达高科','002144.XSHE',0),(657,'中核钛白','002145.XSHE',0),(658,'荣盛发展','002146.XSHE',0),(659,'ST新光','002147.XSHE',0),(660,'北纬科技','002148.XSHE',0),(661,'西部材料','002149.XSHE',0),(662,'通润装备','002150.XSHE',0),(663,'北斗星通','002151.XSHE',0),(664,'广电运通','002152.XSHE',0),(665,'石基信息','002153.XSHE',0),(666,'报喜鸟','002154.XSHE',0),(667,'湖南黄金','002155.XSHE',0),(668,'通富微电','002156.XSHE',0),(669,'正邦科技','002157.XSHE',0),(670,'汉钟精机','002158.XSHE',0),(671,'三特索道','002159.XSHE',0),(672,'常铝股份','002160.XSHE',0),(673,'远望谷','002161.XSHE',0),(674,'悦心健康','002162.XSHE',0),(675,'中航三鑫','002163.XSHE',0),(676,'宁波东力','002164.XSHE',0),(677,'红宝丽','002165.XSHE',0),(678,'莱茵生物','002166.XSHE',0),(679,'东方锆业','002167.XSHE',0),(680,'惠程科技','002168.XSHE',0),(681,'智光电气','002169.XSHE',0),(682,'芭田股份','002170.XSHE',0),(683,'楚江新材','002171.XSHE',0),(684,'澳洋健康','002172.XSHE',0),(685,'创新医疗','002173.XSHE',0),(686,'游族网络','002174.XSHE',0),(687,'*ST东网','002175.XSHE',0),(688,'江特电机','002176.XSHE',0),(689,'御银股份','002177.XSHE',0),(690,'延华智能','002178.XSHE',0),(691,'中航光电','002179.XSHE',0),(692,'纳思达','002180.XSHE',0),(693,'粤传媒','002181.XSHE',0),(694,'云海金属','002182.XSHE',0),(695,'怡亚通','002183.XSHE',0),(696,'海得控制','002184.XSHE',0),(697,'华天科技','002185.XSHE',0),(698,'全聚德','002186.XSHE',0),(699,'广百股份','002187.XSHE',0),(700,'*ST巴士','002188.XSHE',0),(701,'中光学','002189.XSHE',0),(702,'*ST集成','002190.XSHE',0),(703,'劲嘉股份','002191.XSHE',0),(704,'融捷股份','002192.XSHE',0),(705,'如意集团','002193.XSHE',0),(706,'武汉凡谷','002194.XSHE',0),(707,'二三四五','002195.XSHE',0),(708,'方正电机','002196.XSHE',0),(709,'证通电子','002197.XSHE',0),(710,'嘉应制药','002198.XSHE',0),(711,'东晶电子','002199.XSHE',0),(712,'*ST云投','002200.XSHE',0),(713,'九鼎新材','002201.XSHE',0),(714,'金风科技','002202.XSHE',0),(715,'海亮股份','002203.XSHE',0),(716,'大连重工','002204.XSHE',0),(717,'国统股份','002205.XSHE',0),(718,'海利得','002206.XSHE',0),(719,'ST准油','002207.XSHE',0),(720,'合肥城建','002208.XSHE',0),(721,'达意隆','002209.XSHE',0),(722,'*ST飞马','002210.XSHE',0),(723,'宏达新材','002211.XSHE',0),(724,'南洋股份','002212.XSHE',0),(725,'特尔佳','002213.XSHE',0),(726,'大立科技','002214.XSHE',0),(727,'诺普信','002215.XSHE',0),(728,'三全食品','002216.XSHE',0),(729,'合力泰','002217.XSHE',0),(730,'拓日新能','002218.XSHE',0),(731,'恒康医疗','002219.XSHE',0),(732,'ST天宝','002220.XSHE',0),(733,'东华能源','002221.XSHE',0),(734,'福晶科技','002222.XSHE',0),(735,'鱼跃医疗','002223.XSHE',0),(736,'三力士','002224.XSHE',0),(737,'濮耐股份','002225.XSHE',0),(738,'江南化工','002226.XSHE',0),(739,'奥特迅','002227.XSHE',0),(740,'合兴包装','002228.XSHE',0),(741,'鸿博股份','002229.XSHE',0),(742,'科大讯飞','002230.XSHE',0),(743,'奥维通信','002231.XSHE',0),(744,'启明信息','002232.XSHE',0),(745,'塔牌集团','002233.XSHE',0),(746,'民和股份','002234.XSHE',0),(747,'安妮股份','002235.XSHE',0),(748,'大华股份','002236.XSHE',0),(749,'恒邦股份','002237.XSHE',0),(750,'天威视讯','002238.XSHE',0),(751,'奥特佳','002239.XSHE',0),(752,'威华股份','002240.XSHE',0),(753,'歌尔股份','002241.XSHE',0),(754,'九阳股份','002242.XSHE',0),(755,'通产丽星','002243.XSHE',0),(756,'滨江集团','002244.XSHE',0),(757,'澳洋顺昌','002245.XSHE',0),(758,'北化股份','002246.XSHE',0),(759,'聚力文化','002247.XSHE',0),(760,'华东数控','002248.XSHE',0),(761,'大洋电机','002249.XSHE',0),(762,'联化科技','002250.XSHE',0),(763,'步步高','002251.XSHE',0),(764,'上海莱士','002252.XSHE',0),(765,'川大智胜','002253.XSHE',0),(766,'泰和新材','002254.XSHE',0),(767,'海陆重工','002255.XSHE',0),(768,'兆新股份','002256.XSHE',0),(769,'利尔化学','002258.XSHE',0),(770,'*ST升达','002259.XSHE',0),(771,'*ST德奥','002260.XSHE',0),(772,'拓维信息','002261.XSHE',0),(773,'恩华药业','002262.XSHE',0),(774,'*ST东南','002263.XSHE',0),(775,'新华都','002264.XSHE',0),(776,'西仪股份','002265.XSHE',0),(777,'浙富控股','002266.XSHE',0),(778,'陕天然气','002267.XSHE',0),(779,'卫士通','002268.XSHE',0),(780,'美邦服饰','002269.XSHE',0),(781,'华明装备','002270.XSHE',0),(782,'东方雨虹','002271.XSHE',0),(783,'川润股份','002272.XSHE',0),(784,'水晶光电','002273.XSHE',0),(785,'华昌化工','002274.XSHE',0),(786,'桂林三金','002275.XSHE',0),(787,'万马股份','002276.XSHE',0),(788,'友阿股份','002277.XSHE',0),(789,'神开股份','002278.XSHE',0),(790,'久其软件','002279.XSHE',0),(791,'联络互动','002280.XSHE',0),(792,'光迅科技','002281.XSHE',0),(793,'博深股份','002282.XSHE',0),(794,'天润曲轴','002283.XSHE',0),(795,'亚太股份','002284.XSHE',0),(796,'世联行','002285.XSHE',0),(797,'保龄宝','002286.XSHE',0),(798,'奇正藏药','002287.XSHE',0),(799,'超华科技','002288.XSHE',0),(800,'*ST宇顺','002289.XSHE',0),(801,'*ST中科','002290.XSHE',0),(802,'星期六','002291.XSHE',0),(803,'奥飞娱乐','002292.XSHE',0),(804,'罗莱生活','002293.XSHE',0),(805,'信立泰','002294.XSHE',0),(806,'精艺股份','002295.XSHE',0),(807,'辉煌科技','002296.XSHE',0),(808,'博云新材','002297.XSHE',0),(809,'中电兴发','002298.XSHE',0),(810,'圣农发展','002299.XSHE',0),(811,'太阳电缆','002300.XSHE',0),(812,'齐心集团','002301.XSHE',0),(813,'西部建设','002302.XSHE',0),(814,'美盈森','002303.XSHE',0),(815,'洋河股份','002304.XSHE',0),(816,'南国置业','002305.XSHE',0),(817,'ST云网','002306.XSHE',0),(818,'北新路桥','002307.XSHE',0),(819,'威创股份','002308.XSHE',0),(820,'中利集团','002309.XSHE',0),(821,'东方园林','002310.XSHE',0),(822,'海大集团','002311.XSHE',0),(823,'三泰控股','002312.XSHE',0),(824,'日海智能','002313.XSHE',0),(825,'南山控股','002314.XSHE',0),(826,'焦点科技','002315.XSHE',0),(827,'亚联发展','002316.XSHE',0),(828,'众生药业','002317.XSHE',0),(829,'久立特材','002318.XSHE',0),(830,'乐通股份','002319.XSHE',0),(831,'海峡股份','002320.XSHE',0),(832,'华英农业','002321.XSHE',0),(833,'理工环科','002322.XSHE',0),(834,'*ST百特','002323.XSHE',0),(835,'普利特','002324.XSHE',0),(836,'洪涛股份','002325.XSHE',0),(837,'永太科技','002326.XSHE',0),(838,'富安娜','002327.XSHE',0),(839,'新朋股份','002328.XSHE',0),(840,'皇氏集团','002329.XSHE',0),(841,'得利斯','002330.XSHE',0),(842,'皖通科技','002331.XSHE',0),(843,'仙琚制药','002332.XSHE',0),(844,'*ST罗普','002333.XSHE',0),(845,'英威腾','002334.XSHE',0),(846,'科华恒盛','002335.XSHE',0),(847,'*ST人乐','002336.XSHE',0),(848,'赛象科技','002337.XSHE',0),(849,'奥普光电','002338.XSHE',0),(850,'积成电子','002339.XSHE',0),(851,'格林美','002340.XSHE',0),(852,'新纶科技','002341.XSHE',0),(853,'巨力索具','002342.XSHE',0),(854,'慈文传媒','002343.XSHE',0),(855,'海宁皮城','002344.XSHE',0),(856,'潮宏基','002345.XSHE',0),(857,'柘中股份','002346.XSHE',0),(858,'泰尔股份','002347.XSHE',0),(859,'高乐股份','002348.XSHE',0),(860,'精华制药','002349.XSHE',0),(861,'北京科锐','002350.XSHE',0),(862,'漫步者','002351.XSHE',0),(863,'顺丰控股','002352.XSHE',0),(864,'杰瑞股份','002353.XSHE',0),(865,'天神娱乐','002354.XSHE',0),(866,'兴民智通','002355.XSHE',0),(867,'*ST赫美','002356.XSHE',0),(868,'富临运业','002357.XSHE',0),(869,'森源电气','002358.XSHE',0),(870,'*ST北讯','002359.XSHE',0),(871,'同德化工','002360.XSHE',0),(872,'神剑股份','002361.XSHE',0),(873,'汉王科技','002362.XSHE',0),(874,'隆基机械','002363.XSHE',0),(875,'中恒电气','002364.XSHE',0),(876,'永安药业','002365.XSHE',0),(877,'台海核电','002366.XSHE',0),(878,'康力电梯','002367.XSHE',0),(879,'太极股份','002368.XSHE',0),(880,'卓翼科技','002369.XSHE',0),(881,'亚太药业','002370.XSHE',0),(882,'北方华创','002371.XSHE',0),(883,'伟星新材','002372.XSHE',0),(884,'千方科技','002373.XSHE',0),(885,'丽鹏股份','002374.XSHE',0),(886,'亚厦股份','002375.XSHE',0),(887,'新北洋','002376.XSHE',0),(888,'国创高新','002377.XSHE',0),(889,'章源钨业','002378.XSHE',0),(890,'宏创控股','002379.XSHE',0),(891,'科远智慧','002380.XSHE',0),(892,'双箭股份','002381.XSHE',0),(893,'蓝帆医疗','002382.XSHE',0),(894,'合众思壮','002383.XSHE',0),(895,'东山精密','002384.XSHE',0),(896,'大北农','002385.XSHE',0),(897,'天原集团','002386.XSHE',0),(898,'维信诺','002387.XSHE',0),(899,'新亚制程','002388.XSHE',0),(900,'航天彩虹','002389.XSHE',0),(901,'信邦制药','002390.XSHE',0),(902,'长青股份','002391.XSHE',0),(903,'北京利尔','002392.XSHE',0),(904,'力生制药','002393.XSHE',0),(905,'联发股份','002394.XSHE',0),(906,'双象股份','002395.XSHE',0),(907,'星网锐捷','002396.XSHE',0),(908,'梦洁股份','002397.XSHE',0),(909,'建研集团','002398.XSHE',0),(910,'海普瑞','002399.XSHE',0),(911,'省广集团','002400.XSHE',0),(912,'中远海科','002401.XSHE',0),(913,'和而泰','002402.XSHE',0),(914,'爱仕达','002403.XSHE',0),(915,'嘉欣丝绸','002404.XSHE',0),(916,'四维图新','002405.XSHE',0),(917,'远东传动','002406.XSHE',0),(918,'多氟多','002407.XSHE',0),(919,'齐翔腾达','002408.XSHE',0),(920,'雅克科技','002409.XSHE',0),(921,'广联达','002410.XSHE',0),(922,'延安必康','002411.XSHE',0),(923,'汉森制药','002412.XSHE',0),(924,'雷科防务','002413.XSHE',0),(925,'高德红外','002414.XSHE',0),(926,'海康威视','002415.XSHE',0),(927,'爱施德','002416.XSHE',0),(928,'深南股份','002417.XSHE',0),(929,'康盛股份','002418.XSHE',0),(930,'天虹股份','002419.XSHE',0),(931,'*ST毅昌','002420.XSHE',0),(932,'达实智能','002421.XSHE',0),(933,'科伦药业','002422.XSHE',0),(934,'中原特钢','002423.XSHE',0),(935,'贵州百灵','002424.XSHE',0),(936,'凯撒文化','002425.XSHE',0),(937,'胜利精密','002426.XSHE',0),(938,'*ST尤夫','002427.XSHE',0),(939,'云南锗业','002428.XSHE',0),(940,'兆驰股份','002429.XSHE',0),(941,'杭氧股份','002430.XSHE',0),(942,'棕榈股份','002431.XSHE',0),(943,'九安医疗','002432.XSHE',0),(944,'太安堂','002433.XSHE',0),(945,'万里扬','002434.XSHE',0),(946,'长江润发','002435.XSHE',0),(947,'兴森科技','002436.XSHE',0),(948,'誉衡药业','002437.XSHE',0),(949,'江苏神通','002438.XSHE',0),(950,'启明星辰','002439.XSHE',0),(951,'闰土股份','002440.XSHE',0),(952,'众业达','002441.XSHE',0),(953,'龙星化工','002442.XSHE',0),(954,'金洲管道','002443.XSHE',0),(955,'巨星科技','002444.XSHE',0),(956,'ST中南','002445.XSHE',0),(957,'盛路通信','002446.XSHE',0),(958,'晨鑫科技','002447.XSHE',0),(959,'中原内配','002448.XSHE',0),(960,'国星光电','002449.XSHE',0),(961,'*ST康得','002450.XSHE',0),(962,'摩恩电气','002451.XSHE',0),(963,'长高集团','002452.XSHE',0),(964,'华软科技','002453.XSHE',0),(965,'松芝股份','002454.XSHE',0),(966,'百川股份','002455.XSHE',0),(967,'欧菲光','002456.XSHE',0),(968,'青龙管业','002457.XSHE',0),(969,'益生股份','002458.XSHE',0),(970,'天业通联','002459.XSHE',0),(971,'赣锋锂业','002460.XSHE',0),(972,'珠江啤酒','002461.XSHE',0),(973,'嘉事堂','002462.XSHE',0),(974,'沪电股份','002463.XSHE',0),(975,'众应互联','002464.XSHE',0),(976,'海格通信','002465.XSHE',0),(977,'天齐锂业','002466.XSHE',0),(978,'二六三','002467.XSHE',0),(979,'申通快递','002468.XSHE',0),(980,'三维工程','002469.XSHE',0),(981,'金正大','002470.XSHE',0),(982,'中超控股','002471.XSHE',0),(983,'双环传动','002472.XSHE',0),(984,'圣莱达','002473.XSHE',0),(985,'榕基软件','002474.XSHE',0),(986,'立讯精密','002475.XSHE',0),(987,'宝莫股份','002476.XSHE',0),(988,'雏鹰退','002477.XSHE',0),(989,'常宝股份','002478.XSHE',0),(990,'富春环保','002479.XSHE',0),(991,'新筑股份','002480.XSHE',0),(992,'双塔食品','002481.XSHE',0),(993,'广田集团','002482.XSHE',0),(994,'润邦股份','002483.XSHE',0),(995,'江海股份','002484.XSHE',0),(996,'希努尔','002485.XSHE',0),(997,'嘉麟杰','002486.XSHE',0),(998,'大金重工','002487.XSHE',0),(999,'金固股份','002488.XSHE',0),(1000,'浙江永强','002489.XSHE',0),(1001,'山东墨龙','002490.XSHE',0),(1002,'通鼎互联','002491.XSHE',0),(1003,'恒基达鑫','002492.XSHE',0),(1004,'荣盛石化','002493.XSHE',0),(1005,'华斯股份','002494.XSHE',0),(1006,'佳隆股份','002495.XSHE',0),(1007,'辉丰股份','002496.XSHE',0),(1008,'雅化集团','002497.XSHE',0),(1009,'汉缆股份','002498.XSHE',0),(1010,'*ST科林','002499.XSHE',0),(1011,'山西证券','002500.XSHE',0),(1012,'*ST利源','002501.XSHE',0),(1013,'鼎龙文化','002502.XSHE',0),(1014,'搜于特','002503.XSHE',0),(1015,'弘高创意','002504.XSHE',0),(1016,'大康农业','002505.XSHE',0),(1017,'协鑫集成','002506.XSHE',0),(1018,'涪陵榨菜','002507.XSHE',0),(1019,'老板电器','002508.XSHE',0),(1020,'天广中茂','002509.XSHE',0),(1021,'天汽模','002510.XSHE',0),(1022,'中顺洁柔','002511.XSHE',0),(1023,'达华智能','002512.XSHE',0),(1024,'蓝丰生化','002513.XSHE',0),(1025,'宝馨科技','002514.XSHE',0),(1026,'金字火腿','002515.XSHE',0),(1027,'旷达科技','002516.XSHE',0),(1028,'恺英网络','002517.XSHE',0),(1029,'科士达','002518.XSHE',0),(1030,'银河电子','002519.XSHE',0),(1031,'日发精机','002520.XSHE',0),(1032,'齐峰新材','002521.XSHE',0),(1033,'浙江众成','002522.XSHE',0),(1034,'天桥起重','002523.XSHE',0),(1035,'光正集团','002524.XSHE',0),(1036,'山东矿机','002526.XSHE',0),(1037,'新时达','002527.XSHE',0),(1038,'英飞拓','002528.XSHE',0),(1039,'海源复材','002529.XSHE',0),(1040,'金财互联','002530.XSHE',0),(1041,'天顺风能','002531.XSHE',0),(1042,'新界泵业','002532.XSHE',0),(1043,'金杯电工','002533.XSHE',0),(1044,'杭锅股份','002534.XSHE',0),(1045,'林州重机','002535.XSHE',0),(1046,'飞龙股份','002536.XSHE',0),(1047,'海联金汇','002537.XSHE',0),(1048,'司尔特','002538.XSHE',0),(1049,'云图控股','002539.XSHE',0),(1050,'亚太科技','002540.XSHE',0),(1051,'鸿路钢构','002541.XSHE',0),(1052,'中化岩土','002542.XSHE',0),(1053,'万和电气','002543.XSHE',0),(1054,'杰赛科技','002544.XSHE',0),(1055,'东方铁塔','002545.XSHE',0),(1056,'新联电子','002546.XSHE',0),(1057,'春兴精工','002547.XSHE',0),(1058,'金新农','002548.XSHE',0),(1059,'凯美特气','002549.XSHE',0),(1060,'千红制药','002550.XSHE',0),(1061,'尚荣医疗','002551.XSHE',0),(1062,'宝鼎科技','002552.XSHE',0),(1063,'南方轴承','002553.XSHE',0),(1064,'惠博普','002554.XSHE',0),(1065,'三七互娱','002555.XSHE',0),(1066,'辉隆股份','002556.XSHE',0),(1067,'洽洽食品','002557.XSHE',0),(1068,'巨人网络','002558.XSHE',0),(1069,'亚威股份','002559.XSHE',0),(1070,'通达股份','002560.XSHE',0),(1071,'徐家汇','002561.XSHE',0),(1072,'兄弟科技','002562.XSHE',0),(1073,'森马服饰','002563.XSHE',0),(1074,'天沃科技','002564.XSHE',0),(1075,'顺灏股份','002565.XSHE',0),(1076,'益盛药业','002566.XSHE',0),(1077,'唐人神','002567.XSHE',0),(1078,'百润股份','002568.XSHE',0),(1079,'*ST步森','002569.XSHE',0),(1080,'贝因美','002570.XSHE',0),(1081,'德力股份','002571.XSHE',0),(1082,'索菲亚','002572.XSHE',0),(1083,'清新环境','002573.XSHE',0),(1084,'明牌珠宝','002574.XSHE',0),(1085,'群兴玩具','002575.XSHE',0),(1086,'通达动力','002576.XSHE',0),(1087,'雷柏科技','002577.XSHE',0),(1088,'闽发铝业','002578.XSHE',0),(1089,'中京电子','002579.XSHE',0),(1090,'圣阳股份','002580.XSHE',0),(1091,'未名医药','002581.XSHE',0),(1092,'好想你','002582.XSHE',0),(1093,'海能达','002583.XSHE',0),(1094,'西陇科学','002584.XSHE',0),(1095,'双星新材','002585.XSHE',0),(1096,'ST围海','002586.XSHE',0),(1097,'奥拓电子','002587.XSHE',0),(1098,'史丹利','002588.XSHE',0),(1099,'瑞康医药','002589.XSHE',0),(1100,'万安科技','002590.XSHE',0),(1101,'恒大高新','002591.XSHE',0),(1102,'八菱科技','002592.XSHE',0),(1103,'日上集团','002593.XSHE',0),(1104,'比亚迪','002594.XSHE',0),(1105,'豪迈科技','002595.XSHE',0),(1106,'海南瑞泽','002596.XSHE',0),(1107,'金禾实业','002597.XSHE',0),(1108,'山东章鼓','002598.XSHE',0),(1109,'盛通股份','002599.XSHE',0),(1110,'领益智造','002600.XSHE',0),(1111,'龙蟒佰利','002601.XSHE',0),(1112,'世纪华通','002602.XSHE',0),(1113,'以岭药业','002603.XSHE',0),(1114,'*ST龙力','002604.XSHE',0),(1115,'姚记科技','002605.XSHE',0),(1116,'大连电瓷','002606.XSHE',0),(1117,'中公教育','002607.XSHE',0),(1118,'江苏国信','002608.XSHE',0),(1119,'捷顺科技','002609.XSHE',0),(1120,'爱康科技','002610.XSHE',0),(1121,'东方精工','002611.XSHE',0),(1122,'朗姿股份','002612.XSHE',0),(1123,'北玻股份','002613.XSHE',0),(1124,'奥佳华','002614.XSHE',0),(1125,'哈尔斯','002615.XSHE',0),(1126,'长青集团','002616.XSHE',0),(1127,'露笑科技','002617.XSHE',0),(1128,'丹邦科技','002618.XSHE',0),(1129,'艾格拉斯','002619.XSHE',0),(1130,'瑞和股份','002620.XSHE',0),(1131,'美吉姆','002621.XSHE',0),(1132,'融钰集团','002622.XSHE',0),(1133,'亚玛顿','002623.XSHE',0),(1134,'完美世界','002624.XSHE',0),(1135,'光启技术','002625.XSHE',0),(1136,'金达威','002626.XSHE',0),(1137,'宜昌交运','002627.XSHE',0),(1138,'成都路桥','002628.XSHE',0),(1139,'*ST仁智','002629.XSHE',0),(1140,'华西能源','002630.XSHE',0),(1141,'德尔未来','002631.XSHE',0),(1142,'道明光学','002632.XSHE',0),(1143,'申科股份','002633.XSHE',0),(1144,'棒杰股份','002634.XSHE',0),(1145,'安洁科技','002635.XSHE',0),(1146,'金安国纪','002636.XSHE',0),(1147,'赞宇科技','002637.XSHE',0),(1148,'勤上股份','002638.XSHE',0),(1149,'雪人股份','002639.XSHE',0),(1150,'跨境通','002640.XSHE',0),(1151,'永高股份','002641.XSHE',0),(1152,'*ST荣联','002642.XSHE',0),(1153,'万润股份','002643.XSHE',0),(1154,'佛慈制药','002644.XSHE',0),(1155,'华宏科技','002645.XSHE',0),(1156,'青青稞酒','002646.XSHE',0),(1157,'仁东控股','002647.XSHE',0),(1158,'卫星石化','002648.XSHE',0),(1159,'博彦科技','002649.XSHE',0),(1160,'加加食品','002650.XSHE',0),(1161,'利君股份','002651.XSHE',0),(1162,'扬子新材','002652.XSHE',0),(1163,'海思科','002653.XSHE',0),(1164,'万润科技','002654.XSHE',0),(1165,'共达电声','002655.XSHE',0),(1166,'摩登大道','002656.XSHE',0),(1167,'中科金财','002657.XSHE',0),(1168,'雪迪龙','002658.XSHE',0),(1169,'凯文教育','002659.XSHE',0),(1170,'茂硕电源','002660.XSHE',0),(1171,'克明面业','002661.XSHE',0),(1172,'京威股份','002662.XSHE',0),(1173,'普邦股份','002663.XSHE',0),(1174,'长鹰信质','002664.XSHE',0),(1175,'首航节能','002665.XSHE',0),(1176,'德联集团','002666.XSHE',0),(1177,'鞍重股份','002667.XSHE',0),(1178,'奥马电器','002668.XSHE',0),(1179,'康达新材','002669.XSHE',0),(1180,'国盛金控','002670.XSHE',0),(1181,'龙泉股份','002671.XSHE',0),(1182,'东江环保','002672.XSHE',0),(1183,'西部证券','002673.XSHE',0),(1184,'兴业科技','002674.XSHE',0),(1185,'东诚药业','002675.XSHE',0),(1186,'顺威股份','002676.XSHE',0),(1187,'浙江美大','002677.XSHE',0),(1188,'珠江钢琴','002678.XSHE',0),(1189,'福建金森','002679.XSHE',0),(1190,'*ST长生','002680.XSHE',0),(1191,'奋达科技','002681.XSHE',0),(1192,'龙洲股份','002682.XSHE',0),(1193,'宏大爆破','002683.XSHE',0),(1194,'*ST猛狮','002684.XSHE',0),(1195,'华东重机','002685.XSHE',0),(1196,'亿利达','002686.XSHE',0),(1197,'乔治白','002687.XSHE',0),(1198,'金河生物','002688.XSHE',0),(1199,'远大智能','002689.XSHE',0),(1200,'美亚光电','002690.XSHE',0),(1201,'冀凯股份','002691.XSHE',0),(1202,'ST远程','002692.XSHE',0),(1203,'双成药业','002693.XSHE',0),(1204,'顾地科技','002694.XSHE',0),(1205,'煌上煌','002695.XSHE',0),(1206,'百洋股份','002696.XSHE',0),(1207,'红旗连锁','002697.XSHE',0),(1208,'博实股份','002698.XSHE',0),(1209,'美盛文化','002699.XSHE',0),(1210,'新疆浩源','002700.XSHE',0),(1211,'奥瑞金','002701.XSHE',0),(1212,'海欣食品','002702.XSHE',0),(1213,'浙江世宝','002703.XSHE',0),(1214,'新宝股份','002705.XSHE',0),(1215,'良信电器','002706.XSHE',0),(1216,'众信旅游','002707.XSHE',0),(1217,'光洋股份','002708.XSHE',0),(1218,'天赐材料','002709.XSHE',0),(1219,'*ST欧浦','002711.XSHE',0),(1220,'思美传媒','002712.XSHE',0),(1221,'东易日盛','002713.XSHE',0),(1222,'牧原股份','002714.XSHE',0),(1223,'登云股份','002715.XSHE',0),(1224,'金贵银业','002716.XSHE',0),(1225,'岭南股份','002717.XSHE',0),(1226,'友邦吊顶','002718.XSHE',0),(1227,'麦趣尔','002719.XSHE',0),(1228,'金一文化','002721.XSHE',0),(1229,'金轮股份','002722.XSHE',0),(1230,'金莱特','002723.XSHE',0),(1231,'海洋王','002724.XSHE',0),(1232,'跃岭股份','002725.XSHE',0),(1233,'龙大肉食','002726.XSHE',0),(1234,'一心堂','002727.XSHE',0),(1235,'特一药业','002728.XSHE',0),(1236,'好利来','002729.XSHE',0),(1237,'电光科技','002730.XSHE',0),(1238,'萃华珠宝','002731.XSHE',0),(1239,'燕塘乳业','002732.XSHE',0),(1240,'雄韬股份','002733.XSHE',0),(1241,'利民股份','002734.XSHE',0),(1242,'王子新材','002735.XSHE',0),(1243,'国信证券','002736.XSHE',0),(1244,'葵花药业','002737.XSHE',0),(1245,'中矿资源','002738.XSHE',0),(1246,'万达电影','002739.XSHE',0),(1247,'爱迪尔','002740.XSHE',0),(1248,'光华科技','002741.XSHE',0),(1249,'三圣股份','002742.XSHE',0),(1250,'富煌钢构','002743.XSHE',0),(1251,'木林森','002745.XSHE',0),(1252,'仙坛股份','002746.XSHE',0),(1253,'埃斯顿','002747.XSHE',0),(1254,'世龙实业','002748.XSHE',0),(1255,'国光股份','002749.XSHE',0),(1256,'龙津药业','002750.XSHE',0),(1257,'易尚展示','002751.XSHE',0),(1258,'昇兴股份','002752.XSHE',0),(1259,'永东股份','002753.XSHE',0),(1260,'奥赛康','002755.XSHE',0),(1261,'永兴材料','002756.XSHE',0),(1262,'南兴股份','002757.XSHE',0),(1263,'华通医药','002758.XSHE',0),(1264,'天际股份','002759.XSHE',0),(1265,'凤形股份','002760.XSHE',0),(1266,'多喜爱','002761.XSHE',0),(1267,'金发拉比','002762.XSHE',0),(1268,'汇洁股份','002763.XSHE',0),(1269,'蓝黛传动','002765.XSHE',0),(1270,'*ST索菱','002766.XSHE',0),(1271,'先锋电子','002767.XSHE',0),(1272,'国恩股份','002768.XSHE',0),(1273,'普路通','002769.XSHE',0),(1274,'科迪乳业','002770.XSHE',0),(1275,'真视通','002771.XSHE',0),(1276,'众兴菌业','002772.XSHE',0),(1277,'康弘药业','002773.XSHE',0),(1278,'快意电梯','002774.XSHE',0),(1279,'文科园林','002775.XSHE',0),(1280,'柏堡龙','002776.XSHE',0),(1281,'久远银海','002777.XSHE',0),(1282,'高科石化','002778.XSHE',0),(1283,'中坚科技','002779.XSHE',0),(1284,'三夫户外','002780.XSHE',0),(1285,'奇信股份','002781.XSHE',0),(1286,'可立克','002782.XSHE',0),(1287,'凯龙股份','002783.XSHE',0),(1288,'万里石','002785.XSHE',0),(1289,'银宝山新','002786.XSHE',0),(1290,'华源控股','002787.XSHE',0),(1291,'鹭燕医药','002788.XSHE',0),(1292,'建艺集团','002789.XSHE',0),(1293,'瑞尔特','002790.XSHE',0),(1294,'坚朗五金','002791.XSHE',0),(1295,'通宇通讯','002792.XSHE',0),(1296,'东音股份','002793.XSHE',0),(1297,'永和智控','002795.XSHE',0),(1298,'世嘉科技','002796.XSHE',0),(1299,'第一创业','002797.XSHE',0),(1300,'帝欧家居','002798.XSHE',0),(1301,'环球印务','002799.XSHE',0),(1302,'天顺股份','002800.XSHE',0),(1303,'微光股份','002801.XSHE',0),(1304,'洪汇新材','002802.XSHE',0),(1305,'吉宏股份','002803.XSHE',0),(1306,'丰元股份','002805.XSHE',0),(1307,'华锋股份','002806.XSHE',0),(1308,'江阴银行','002807.XSHE',0),(1309,'恒久科技','002808.XSHE',0),(1310,'红墙股份','002809.XSHE',0),(1311,'山东赫达','002810.XSHE',0),(1312,'亚泰国际','002811.XSHE',0),(1313,'恩捷股份','002812.XSHE',0),(1314,'路畅科技','002813.XSHE',0),(1315,'崇达技术','002815.XSHE',0),(1316,'和科达','002816.XSHE',0),(1317,'黄山胶囊','002817.XSHE',0),(1318,'富森美','002818.XSHE',0),(1319,'东方中科','002819.XSHE',0),(1320,'桂发祥','002820.XSHE',0),(1321,'凯莱英','002821.XSHE',0),(1322,'中装建设','002822.XSHE',0),(1323,'凯中精密','002823.XSHE',0),(1324,'和胜股份','002824.XSHE',0),(1325,'纳尔股份','002825.XSHE',0),(1326,'易明医药','002826.XSHE',0),(1327,'高争民爆','002827.XSHE',0),(1328,'贝肯能源','002828.XSHE',0),(1329,'星网宇达','002829.XSHE',0),(1330,'名雕股份','002830.XSHE',0),(1331,'裕同科技','002831.XSHE',0),(1332,'比音勒芬','002832.XSHE',0),(1333,'弘亚数控','002833.XSHE',0),(1334,'同为股份','002835.XSHE',0),(1335,'新宏泽','002836.XSHE',0),(1336,'英维克','002837.XSHE',0),(1337,'道恩股份','002838.XSHE',0),(1338,'张家港行','002839.XSHE',0),(1339,'华统股份','002840.XSHE',0),(1340,'视源股份','002841.XSHE',0),(1341,'翔鹭钨业','002842.XSHE',0),(1342,'泰嘉股份','002843.XSHE',0),(1343,'同兴达','002845.XSHE',0),(1344,'英联股份','002846.XSHE',0),(1345,'盐津铺子','002847.XSHE',0),(1346,'高斯贝尔','002848.XSHE',0),(1347,'威星智能','002849.XSHE',0),(1348,'科达利','002850.XSHE',0),(1349,'麦格米特','002851.XSHE',0),(1350,'道道全','002852.XSHE',0),(1351,'皮阿诺','002853.XSHE',0),(1352,'捷荣技术','002855.XSHE',0),(1353,'美芝股份','002856.XSHE',0),(1354,'三晖电气','002857.XSHE',0),(1355,'力盛赛车','002858.XSHE',0),(1356,'洁美科技','002859.XSHE',0),(1357,'星帅尔','002860.XSHE',0),(1358,'瀛通通讯','002861.XSHE',0),(1359,'实丰文化','002862.XSHE',0),(1360,'今飞凯达','002863.XSHE',0),(1361,'盘龙药业','002864.XSHE',0),(1362,'钧达股份','002865.XSHE',0),(1363,'传艺科技','002866.XSHE',0),(1364,'周大生','002867.XSHE',0),(1365,'绿康生化','002868.XSHE',0),(1366,'金溢科技','002869.XSHE',0),(1367,'香山股份','002870.XSHE',0),(1368,'伟隆股份','002871.XSHE',0),(1369,'*ST天圣','002872.XSHE',0),(1370,'新天药业','002873.XSHE',0),(1371,'安奈儿','002875.XSHE',0),(1372,'三利谱','002876.XSHE',0),(1373,'智能自控','002877.XSHE',0),(1374,'元隆雅图','002878.XSHE',0),(1375,'长缆科技','002879.XSHE',0),(1376,'卫光生物','002880.XSHE',0),(1377,'美格智能','002881.XSHE',0),(1378,'金龙羽','002882.XSHE',0),(1379,'中设股份','002883.XSHE',0),(1380,'凌霄泵业','002884.XSHE',0),(1381,'京泉华','002885.XSHE',0),(1382,'沃特股份','002886.XSHE',0),(1383,'绿茵生态','002887.XSHE',0),(1384,'惠威科技','002888.XSHE',0),(1385,'东方嘉盛','002889.XSHE',0),(1386,'弘宇股份','002890.XSHE',0),(1387,'中宠股份','002891.XSHE',0),(1388,'科力尔','002892.XSHE',0),(1389,'华通热力','002893.XSHE',0),(1390,'川恒股份','002895.XSHE',0),(1391,'中大力德','002896.XSHE',0),(1392,'意华股份','002897.XSHE',0),(1393,'赛隆药业','002898.XSHE',0),(1394,'英派斯','002899.XSHE',0),(1395,'哈三联','002900.XSHE',0),(1396,'大博医疗','002901.XSHE',0),(1397,'铭普光磁','002902.XSHE',0),(1398,'宇环数控','002903.XSHE',0),(1399,'金逸影视','002905.XSHE',0),(1400,'华阳集团','002906.XSHE',0),(1401,'华森制药','002907.XSHE',0),(1402,'德生科技','002908.XSHE',0),(1403,'集泰股份','002909.XSHE',0),(1404,'庄园牧场','002910.XSHE',0),(1405,'佛燃股份','002911.XSHE',0),(1406,'中新赛克','002912.XSHE',0),(1407,'奥士康','002913.XSHE',0),(1408,'中欣氟材','002915.XSHE',0),(1409,'深南电路','002916.XSHE',0),(1410,'金奥博','002917.XSHE',0),(1411,'蒙娜丽莎','002918.XSHE',0),(1412,'名臣健康','002919.XSHE',0),(1413,'德赛西威','002920.XSHE',0),(1414,'联诚精密','002921.XSHE',0),(1415,'伊戈尔','002922.XSHE',0),(1416,'润都股份','002923.XSHE',0),(1417,'盈趣科技','002925.XSHE',0),(1418,'华西证券','002926.XSHE',0),(1419,'泰永长征','002927.XSHE',0),(1420,'华夏航空','002928.XSHE',0),(1421,'润建股份','002929.XSHE',0),(1422,'宏川智慧','002930.XSHE',0),(1423,'锋龙股份','002931.XSHE',0),(1424,'明德生物','002932.XSHE',0),(1425,'新兴装备','002933.XSHE',0),(1426,'天奥电子','002935.XSHE',0),(1427,'郑州银行','002936.XSHE',0),(1428,'兴瑞科技','002937.XSHE',0),(1429,'鹏鼎控股','002938.XSHE',0),(1430,'长城证券','002939.XSHE',0),(1431,'昂利康','002940.XSHE',0),(1432,'新疆交建','002941.XSHE',0),(1433,'新农股份','002942.XSHE',0),(1434,'宇晶股份','002943.XSHE',0),(1435,'华林证券','002945.XSHE',0),(1436,'新乳业','002946.XSHE',0),(1437,'恒铭达','002947.XSHE',0),(1438,'青岛银行','002948.XSHE',0),(1439,'华阳国际','002949.XSHE',0),(1440,'奥美医疗','002950.XSHE',0),(1441,'金时科技','002951.XSHE',0),(1442,'亚世光电','002952.XSHE',0),(1443,'日丰股份','002953.XSHE',0),(1444,'鸿合科技','002955.XSHE',0),(1445,'西麦食品','002956.XSHE',0),(1446,'科瑞技术','002957.XSHE',0),(1447,'青农商行','002958.XSHE',0),(1448,'小熊电器','002959.XSHE',0),(1449,'青鸟消防','002960.XSHE',0),(1450,'瑞达期货','002961.XSHE',0),(1451,'五方光电','002962.XSHE',0),(1452,'苏州银行','002966.XSHE',0),(1453,'中国广核','003816.XSHE',0),(1454,'浦发银行','600000.XSHG',0),(1455,'邯郸钢铁','600001.XSHG',0),(1456,'齐鲁石化','600002.XSHG',0),(1457,'ST东北高','600003.XSHG',0),(1458,'白云机场','600004.XSHG',0),(1459,'武钢股份','600005.XSHG',0),(1460,'东风汽车','600006.XSHG',0),(1461,'中国国贸','600007.XSHG',0),(1462,'首创股份','600008.XSHG',0),(1463,'上海机场','600009.XSHG',0),(1464,'包钢股份','600010.XSHG',0),(1465,'华能国际','600011.XSHG',0),(1466,'皖通高速','600012.XSHG',0),(1467,'华夏银行','600015.XSHG',0),(1468,'民生银行','600016.XSHG',0),(1469,'日照港','600017.XSHG',0),(1470,'上港集团','600018.XSHG',0),(1471,'宝钢股份','600019.XSHG',0),(1472,'中原高速','600020.XSHG',0),(1473,'上海电力','600021.XSHG',0),(1474,'山东钢铁','600022.XSHG',0),(1475,'浙能电力','600023.XSHG',0),(1476,'华能水电','600025.XSHG',0),(1477,'中远海能','600026.XSHG',0),(1478,'华电国际','600027.XSHG',0),(1479,'中国石化','600028.XSHG',0),(1480,'南方航空','600029.XSHG',0),(1481,'中信证券','600030.XSHG',0),(1482,'三一重工','600031.XSHG',0),(1483,'福建高速','600033.XSHG',0),(1484,'楚天高速','600035.XSHG',0),(1485,'招商银行','600036.XSHG',0),(1486,'歌华有线','600037.XSHG',0),(1487,'中直股份','600038.XSHG',0),(1488,'四川路桥','600039.XSHG',0),(1489,'保利地产','600048.XSHG',0),(1490,'中国联通','600050.XSHG',0),(1491,'宁波联合','600051.XSHG',0),(1492,'浙江广厦','600052.XSHG',0),(1493,'九鼎投资','600053.XSHG',0),(1494,'黄山旅游','600054.XSHG',0),(1495,'万东医疗','600055.XSHG',0),(1496,'中国医药','600056.XSHG',0),(1497,'厦门象屿','600057.XSHG',0),(1498,'五矿发展','600058.XSHG',0),(1499,'古越龙山','600059.XSHG',0),(1500,'海信电器','600060.XSHG',0),(1501,'国投资本','600061.XSHG',0),(1502,'华润双鹤','600062.XSHG',0),(1503,'皖维高新','600063.XSHG',0),(1504,'南京高科','600064.XSHG',0),(1505,'*ST联谊','600065.XSHG',0),(1506,'宇通客车','600066.XSHG',0),(1507,'冠城大通','600067.XSHG',0),(1508,'葛洲坝','600068.XSHG',0),(1509,'银鸽投资','600069.XSHG',0),(1510,'浙江富润','600070.XSHG',0),(1511,'凤凰光学','600071.XSHG',0),(1512,'中船科技','600072.XSHG',0),(1513,'上海梅林','600073.XSHG',0),(1514,'*ST保千','600074.XSHG',0),(1515,'新疆天业','600075.XSHG',0),(1516,'康欣新材','600076.XSHG',0),(1517,'宋都股份','600077.XSHG',0),(1518,'澄星股份','600078.XSHG',0),(1519,'人福医药','600079.XSHG',0),(1520,'金花股份','600080.XSHG',0),(1521,'东风科技','600081.XSHG',0),(1522,'海泰发展','600082.XSHG',0),(1523,'博信股份','600083.XSHG',0),(1524,'*ST中葡','600084.XSHG',0),(1525,'同仁堂','600085.XSHG',0),(1526,'东方金钰','600086.XSHG',0),(1527,'退市长油','600087.XSHG',0),(1528,'中视传媒','600088.XSHG',0),(1529,'特变电工','600089.XSHG',0),(1530,'同济堂','600090.XSHG',0),(1531,'ST明科','600091.XSHG',0),(1532,'S*ST精密','600092.XSHG',0),(1533,'易见股份','600093.XSHG',0),(1534,'大名城','600094.XSHG',0),(1535,'哈高科','600095.XSHG',0),(1536,'云天化','600096.XSHG',0),(1537,'开创国际','600097.XSHG',0),(1538,'广州发展','600098.XSHG',0),(1539,'林海股份','600099.XSHG',0),(1540,'同方股份','600100.XSHG',0),(1541,'明星电力','600101.XSHG',0),(1542,'莱钢股份','600102.XSHG',0),(1543,'青山纸业','600103.XSHG',0),(1544,'上汽集团','600104.XSHG',0),(1545,'永鼎股份','600105.XSHG',0),(1546,'重庆路桥','600106.XSHG',0),(1547,'美尔雅','600107.XSHG',0),(1548,'亚盛集团','600108.XSHG',0),(1549,'国金证券','600109.XSHG',0),(1550,'诺德股份','600110.XSHG',0),(1551,'北方稀土','600111.XSHG',0),(1552,'ST天成','600112.XSHG',0),(1553,'浙江东日','600113.XSHG',0),(1554,'东睦股份','600114.XSHG',0),(1555,'东方航空','600115.XSHG',0),(1556,'三峡水利','600116.XSHG',0),(1557,'西宁特钢','600117.XSHG',0),(1558,'中国卫星','600118.XSHG',0),(1559,'*ST长投','600119.XSHG',0),(1560,'浙江东方','600120.XSHG',0),(1561,'郑州煤电','600121.XSHG',0),(1562,'宏图高科','600122.XSHG',0),(1563,'兰花科创','600123.XSHG',0),(1564,'铁龙物流','600125.XSHG',0),(1565,'杭钢股份','600126.XSHG',0),(1566,'金健米业','600127.XSHG',0),(1567,'弘业股份','600128.XSHG',0),(1568,'太极集团','600129.XSHG',0),(1569,'波导股份','600130.XSHG',0),(1570,'岷江水电','600131.XSHG',0),(1571,'重庆啤酒','600132.XSHG',0),(1572,'东湖高新','600133.XSHG',0),(1573,'乐凯胶片','600135.XSHG',0),(1574,'当代明诚','600136.XSHG',0),(1575,'浪莎股份','600137.XSHG',0),(1576,'中青旅','600138.XSHG',0),(1577,'西部资源','600139.XSHG',0),(1578,'兴发集团','600141.XSHG',0),(1579,'金发科技','600143.XSHG',0),(1580,'*ST新亿','600145.XSHG',0),(1581,'商赢环球','600146.XSHG',0),(1582,'长春一东','600148.XSHG',0),(1583,'ST坊展','600149.XSHG',0),(1584,'中国船舶','600150.XSHG',0),(1585,'航天机电','600151.XSHG',0),(1586,'维科技术','600152.XSHG',0),(1587,'建发股份','600153.XSHG',0),(1588,'华创阳安','600155.XSHG',0),(1589,'华升股份','600156.XSHG',0),(1590,'永泰能源','600157.XSHG',0),(1591,'中体产业','600158.XSHG',0),(1592,'大龙地产','600159.XSHG',0),(1593,'巨化股份','600160.XSHG',0),(1594,'天坛生物','600161.XSHG',0),(1595,'香江控股','600162.XSHG',0),(1596,'中闽能源','600163.XSHG',0),(1597,'新日恒力','600165.XSHG',0),(1598,'福田汽车','600166.XSHG',0),(1599,'联美控股','600167.XSHG',0),(1600,'武汉控股','600168.XSHG',0),(1601,'太原重工','600169.XSHG',0),(1602,'上海建工','600170.XSHG',0),(1603,'上海贝岭','600171.XSHG',0),(1604,'黄河旋风','600172.XSHG',0),(1605,'卧龙地产','600173.XSHG',0),(1606,'美都能源','600175.XSHG',0),(1607,'中国巨石','600176.XSHG',0),(1608,'雅戈尔','600177.XSHG',0),(1609,'东安动力','600178.XSHG',0),(1610,'ST安通','600179.XSHG',0),(1611,'瑞茂通','600180.XSHG',0),(1612,'S*ST云大','600181.XSHG',0),(1613,'S佳通','600182.XSHG',0),(1614,'生益科技','600183.XSHG',0),(1615,'光电股份','600184.XSHG',0),(1616,'格力地产','600185.XSHG',0),(1617,'*ST莲花','600186.XSHG',0),(1618,'国中水务','600187.XSHG',0),(1619,'兖州煤业','600188.XSHG',0),(1620,'吉林森工','600189.XSHG',0),(1621,'锦州港','600190.XSHG',0),(1622,'华资实业','600191.XSHG',0),(1623,'长城电工','600192.XSHG',0),(1624,'ST创兴','600193.XSHG',0),(1625,'中牧股份','600195.XSHG',0),(1626,'复星医药','600196.XSHG',0),(1627,'伊力特','600197.XSHG',0),(1628,'大唐电信','600198.XSHG',0),(1629,'金种子酒','600199.XSHG',0),(1630,'江苏吴中','600200.XSHG',0),(1631,'生物股份','600201.XSHG',0),(1632,'哈空调','600202.XSHG',0),(1633,'福日电子','600203.XSHG',0),(1634,'S山东铝','600205.XSHG',0),(1635,'有研新材','600206.XSHG',0),(1636,'安彩高科','600207.XSHG',0),(1637,'新湖中宝','600208.XSHG',0),(1638,'ST罗顿','600209.XSHG',0),(1639,'紫江企业','600210.XSHG',0),(1640,'西藏药业','600211.XSHG',0),(1641,'江泉实业','600212.XSHG',0),(1642,'亚星客车','600213.XSHG',0),(1643,'长春经开','600215.XSHG',0),(1644,'浙江医药','600216.XSHG',0),(1645,'中再资环','600217.XSHG',0),(1646,'全柴动力','600218.XSHG',0),(1647,'南山铝业','600219.XSHG',0),(1648,'江苏阳光','600220.XSHG',0),(1649,'海航控股','600221.XSHG',0),(1650,'太龙药业','600222.XSHG',0),(1651,'鲁商发展','600223.XSHG',0),(1652,'天津松江','600225.XSHG',0),(1653,'瀚叶股份','600226.XSHG',0),(1654,'圣济堂','600227.XSHG',0),(1655,'ST昌九','600228.XSHG',0),(1656,'城市传媒','600229.XSHG',0),(1657,'沧州大化','600230.XSHG',0),(1658,'凌钢股份','600231.XSHG',0),(1659,'金鹰股份','600232.XSHG',0),(1660,'圆通速递','600233.XSHG',0),(1661,'*ST山水','600234.XSHG',0),(1662,'民丰特纸','600235.XSHG',0),(1663,'桂冠电力','600236.XSHG',0),(1664,'铜峰电子','600237.XSHG',0),(1665,'ST椰岛','600238.XSHG',0),(1666,'云南城投','600239.XSHG',0),(1667,'*ST华业','600240.XSHG',0),(1668,'时代万恒','600241.XSHG',0),(1669,'中昌数据','600242.XSHG',0),(1670,'青海华鼎','600243.XSHG',0),(1671,'万通地产','600246.XSHG',0),(1672,'ST成城','600247.XSHG',0),(1673,'延长化建','600248.XSHG',0),(1674,'两面针','600249.XSHG',0),(1675,'南纺股份','600250.XSHG',0),(1676,'冠农股份','600251.XSHG',0),(1677,'中恒集团','600252.XSHG',0),(1678,'天方药业','600253.XSHG',0),(1679,'梦舟股份','600255.XSHG',0),(1680,'广汇能源','600256.XSHG',0),(1681,'大湖股份','600257.XSHG',0),(1682,'首旅酒店','600258.XSHG',0),(1683,'广晟有色','600259.XSHG',0),(1684,'凯乐科技','600260.XSHG',0),(1685,'阳光照明','600261.XSHG',0),(1686,'北方股份','600262.XSHG',0),(1687,'路桥建设','600263.XSHG',0),(1688,'ST景谷','600265.XSHG',0),(1689,'北京城建','600266.XSHG',0),(1690,'海正药业','600267.XSHG',0),(1691,'国电南自','600268.XSHG',0),(1692,'赣粤高速','600269.XSHG',0),(1693,'外运发展','600270.XSHG',0),(1694,'航天信息','600271.XSHG',0),(1695,'开开实业','600272.XSHG',0),(1696,'嘉化能源','600273.XSHG',0),(1697,'ST昌鱼','600275.XSHG',0),(1698,'恒瑞医药','600276.XSHG',0),(1699,'亿利洁能','600277.XSHG',0),(1700,'东方创业','600278.XSHG',0),(1701,'重庆港九','600279.XSHG',0),(1702,'中央商场','600280.XSHG',0),(1703,'太化股份','600281.XSHG',0),(1704,'南钢股份','600282.XSHG',0),(1705,'钱江水利','600283.XSHG',0),(1706,'浦东建设','600284.XSHG',0),(1707,'羚锐制药','600285.XSHG',0),(1708,'S*ST国瓷','600286.XSHG',0),(1709,'江苏舜天','600287.XSHG',0),(1710,'大恒科技','600288.XSHG',0),(1711,'*ST信通','600289.XSHG',0),(1712,'华仪电气','600290.XSHG',0),(1713,'西水股份','600291.XSHG',0),(1714,'远达环保','600292.XSHG',0),(1715,'三峡新材','600293.XSHG',0),(1716,'鄂尔多斯','600295.XSHG',0),(1717,'S兰铝','600296.XSHG',0),(1718,'广汇汽车','600297.XSHG',0),(1719,'安琪酵母','600298.XSHG',0),(1720,'安迪苏','600299.XSHG',0),(1721,'维维股份','600300.XSHG',0),(1722,'ST南化','600301.XSHG',0),(1723,'标准股份','600302.XSHG',0),(1724,'曙光股份','600303.XSHG',0),(1725,'恒顺醋业','600305.XSHG',0),(1726,'商业城','600306.XSHG',0),(1727,'酒钢宏兴','600307.XSHG',0),(1728,'华泰股份','600308.XSHG',0),(1729,'万华化学','600309.XSHG',0),(1730,'桂东电力','600310.XSHG',0),(1731,'荣华实业','600311.XSHG',0),(1732,'平高电气','600312.XSHG',0),(1733,'农发种业','600313.XSHG',0),(1734,'上海家化','600315.XSHG',0),(1735,'洪都航空','600316.XSHG',0),(1736,'营口港','600317.XSHG',0),(1737,'新力金融','600318.XSHG',0),(1738,'亚星化学','600319.XSHG',0),(1739,'振华重工','600320.XSHG',0),(1740,'ST正源','600321.XSHG',0),(1741,'天房发展','600322.XSHG',0),(1742,'瀚蓝环境','600323.XSHG',0),(1743,'华发股份','600325.XSHG',0),(1744,'西藏天路','600326.XSHG',0),(1745,'大东方','600327.XSHG',0),(1746,'兰太实业','600328.XSHG',0),(1747,'中新药业','600329.XSHG',0),(1748,'天通股份','600330.XSHG',0),(1749,'宏达股份','600331.XSHG',0),(1750,'白云山','600332.XSHG',0),(1751,'长春燃气','600333.XSHG',0),(1752,'国机汽车','600335.XSHG',0),(1753,'澳柯玛','600336.XSHG',0),(1754,'美克家居','600337.XSHG',0),(1755,'西藏珠峰','600338.XSHG',0),(1756,'中油工程','600339.XSHG',0),(1757,'华夏幸福','600340.XSHG',0),(1758,'航天动力','600343.XSHG',0),(1759,'长江通信','600345.XSHG',0),(1760,'恒力石化','600346.XSHG',0),(1761,'阳泉煤业','600348.XSHG',0),(1762,'山东高速','600350.XSHG',0),(1763,'亚宝药业','600351.XSHG',0),(1764,'浙江龙盛','600352.XSHG',0),(1765,'旭光股份','600353.XSHG',0),(1766,'敦煌种业','600354.XSHG',0),(1767,'精伦电子','600355.XSHG',0),(1768,'恒丰纸业','600356.XSHG',0),(1769,'承德钒钛','600357.XSHG',0),(1770,'国旅联合','600358.XSHG',0),(1771,'新农开发','600359.XSHG',0),(1772,'华微电子','600360.XSHG',0),(1773,'华联综超','600361.XSHG',0),(1774,'江西铜业','600362.XSHG',0),(1775,'联创光电','600363.XSHG',0),(1776,'通葡股份','600365.XSHG',0),(1777,'宁波韵升','600366.XSHG',0),(1778,'红星发展','600367.XSHG',0),(1779,'五洲交通','600368.XSHG',0),(1780,'西南证券','600369.XSHG',0),(1781,'三房巷','600370.XSHG',0),(1782,'万向德农','600371.XSHG',0),(1783,'中航电子','600372.XSHG',0),(1784,'中文传媒','600373.XSHG',0),(1785,'华菱星马','600375.XSHG',0),(1786,'首开股份','600376.XSHG',0),(1787,'宁沪高速','600377.XSHG',0),(1788,'昊华科技','600378.XSHG',0),(1789,'宝光股份','600379.XSHG',0),(1790,'健康元','600380.XSHG',0),(1791,'青海春天','600381.XSHG',0),(1792,'广东明珠','600382.XSHG',0),(1793,'金地集团','600383.XSHG',0),(1794,'*ST金泰','600385.XSHG',0),(1795,'北巴传媒','600386.XSHG',0),(1796,'海越能源','600387.XSHG',0),(1797,'龙净环保','600388.XSHG',0),(1798,'江山股份','600389.XSHG',0),(1799,'五矿资本','600390.XSHG',0),(1800,'航发科技','600391.XSHG',0),(1801,'盛和资源','600392.XSHG',0),(1802,'粤泰股份','600393.XSHG',0),(1803,'盘江股份','600395.XSHG',0),(1804,'*ST金山','600396.XSHG',0),(1805,'安源煤业','600397.XSHG',0),(1806,'海澜之家','600398.XSHG',0),(1807,'ST抚钢','600399.XSHG',0),(1808,'红豆股份','600400.XSHG',0),(1809,'退市海润','600401.XSHG',0),(1810,'大有能源','600403.XSHG',0),(1811,'动力源','600405.XSHG',0),(1812,'国电南瑞','600406.XSHG',0),(1813,'ST安泰','600408.XSHG',0),(1814,'三友化工','600409.XSHG',0),(1815,'华胜天成','600410.XSHG',0),(1816,'小商品城','600415.XSHG',0),(1817,'湘电股份','600416.XSHG',0),(1818,'江淮汽车','600418.XSHG',0),(1819,'天润乳业','600419.XSHG',0),(1820,'现代制药','600420.XSHG',0),(1821,'*ST仰帆','600421.XSHG',0),(1822,'昆药集团','600422.XSHG',0),(1823,'*ST柳化','600423.XSHG',0),(1824,'青松建化','600425.XSHG',0),(1825,'华鲁恒升','600426.XSHG',0),(1826,'中远海特','600428.XSHG',0),(1827,'三元股份','600429.XSHG',0),(1828,'退市吉恩','600432.XSHG',0),(1829,'冠豪高新','600433.XSHG',0),(1830,'北方导航','600435.XSHG',0),(1831,'片仔癀','600436.XSHG',0),(1832,'通威股份','600438.XSHG',0),(1833,'瑞贝卡','600439.XSHG',0),(1834,'国机通用','600444.XSHG',0),(1835,'金证股份','600446.XSHG',0),(1836,'华纺股份','600448.XSHG',0),(1837,'宁夏建材','600449.XSHG',0),(1838,'涪陵电力','600452.XSHG',0),(1839,'博通股份','600455.XSHG',0),(1840,'宝钛股份','600456.XSHG',0),(1841,'时代新材','600458.XSHG',0),(1842,'贵研铂业','600459.XSHG',0),(1843,'士兰微','600460.XSHG',0),(1844,'洪城水业','600461.XSHG',0),(1845,'*ST九有','600462.XSHG',0),(1846,'空港股份','600463.XSHG',0),(1847,'蓝光发展','600466.XSHG',0),(1848,'好当家','600467.XSHG',0),(1849,'百利电气','600468.XSHG',0),(1850,'风神股份','600469.XSHG',0),(1851,'六国化工','600470.XSHG',0),(1852,'包头铝业','600472.XSHG',0),(1853,'华光股份','600475.XSHG',0),(1854,'湘邮科技','600476.XSHG',0),(1855,'杭萧钢构','600477.XSHG',0),(1856,'科力远','600478.XSHG',0),(1857,'千金药业','600479.XSHG',0),(1858,'凌云股份','600480.XSHG',0),(1859,'双良节能','600481.XSHG',0),(1860,'中国动力','600482.XSHG',0),(1861,'福能股份','600483.XSHG',0),(1862,'*ST信威','600485.XSHG',0),(1863,'扬农化工','600486.XSHG',0),(1864,'亨通光电','600487.XSHG',0),(1865,'天药股份','600488.XSHG',0),(1866,'中金黄金','600489.XSHG',0),(1867,'鹏欣资源','600490.XSHG',0),(1868,'龙元建设','600491.XSHG',0),(1869,'凤竹纺织','600493.XSHG',0),(1870,'晋西车轴','600495.XSHG',0),(1871,'精工钢构','600496.XSHG',0),(1872,'驰宏锌锗','600497.XSHG',0),(1873,'烽火通信','600498.XSHG',0),(1874,'科达洁能','600499.XSHG',0),(1875,'中化国际','600500.XSHG',0),(1876,'航天晨光','600501.XSHG',0),(1877,'安徽建工','600502.XSHG',0),(1878,'华丽家族','600503.XSHG',0),(1879,'西昌电力','600505.XSHG',0),(1880,'香梨股份','600506.XSHG',0),(1881,'方大特钢','600507.XSHG',0),(1882,'上海能源','600508.XSHG',0),(1883,'天富能源','600509.XSHG',0),(1884,'黑牡丹','600510.XSHG',0),(1885,'国药股份','600511.XSHG',0),(1886,'腾达建设','600512.XSHG',0),(1887,'联环药业','600513.XSHG',0),(1888,'海航基础','600515.XSHG',0),(1889,'方大炭素','600516.XSHG',0),(1890,'置信电气','600517.XSHG',0),(1891,'ST康美','600518.XSHG',0),(1892,'贵州茅台','600519.XSHG',0),(1893,'文一科技','600520.XSHG',0),(1894,'华海药业','600521.XSHG',0),(1895,'中天科技','600522.XSHG',0),(1896,'贵航股份','600523.XSHG',0),(1897,'长园集团','600525.XSHG',0),(1898,'*ST菲达','600526.XSHG',0),(1899,'江南高纤','600527.XSHG',0),(1900,'中铁工业','600528.XSHG',0),(1901,'山东药玻','600529.XSHG',0),(1902,'交大昂立','600530.XSHG',0),(1903,'豫光金铅','600531.XSHG',0),(1904,'宏达矿业','600532.XSHG',0),(1905,'栖霞建设','600533.XSHG',0),(1906,'天士力','600535.XSHG',0),(1907,'中国软件','600536.XSHG',0),(1908,'亿晶光电','600537.XSHG',0),(1909,'国发股份','600538.XSHG',0),(1910,'ST狮头','600539.XSHG',0),(1911,'新赛股份','600540.XSHG',0),(1912,'莫高股份','600543.XSHG',0),(1913,'卓郎智能','600545.XSHG',0),(1914,'山煤国际','600546.XSHG',0),(1915,'山东黄金','600547.XSHG',0),(1916,'深高速','600548.XSHG',0),(1917,'厦门钨业','600549.XSHG',0),(1918,'保变电气','600550.XSHG',0),(1919,'时代出版','600551.XSHG',0),(1920,'凯盛科技','600552.XSHG',0),(1921,'太行水泥','600553.XSHG',0),(1922,'海航创新','600555.XSHG',0),(1923,'ST慧球','600556.XSHG',0),(1924,'康缘药业','600557.XSHG',0),(1925,'大西洋','600558.XSHG',0),(1926,'老白干酒','600559.XSHG',0),(1927,'金自天正','600560.XSHG',0),(1928,'江西长运','600561.XSHG',0),(1929,'国睿科技','600562.XSHG',0),(1930,'法拉电子','600563.XSHG',0),(1931,'迪马股份','600565.XSHG',0),(1932,'济川药业','600566.XSHG',0),(1933,'山鹰纸业','600567.XSHG',0),(1934,'中珠医疗','600568.XSHG',0),(1935,'安阳钢铁','600569.XSHG',0),(1936,'恒生电子','600570.XSHG',0),(1937,'信雅达','600571.XSHG',0),(1938,'康恩贝','600572.XSHG',0),(1939,'惠泉啤酒','600573.XSHG',0),(1940,'淮河能源','600575.XSHG',0),(1941,'祥源文化','600576.XSHG',0),(1942,'精达股份','600577.XSHG',0),(1943,'京能电力','600578.XSHG',0),(1944,'天华院','600579.XSHG',0),(1945,'卧龙电驱','600580.XSHG',0),(1946,'八一钢铁','600581.XSHG',0),(1947,'天地科技','600582.XSHG',0),(1948,'海油工程','600583.XSHG',0),(1949,'长电科技','600584.XSHG',0),(1950,'海螺水泥','600585.XSHG',0),(1951,'金晶科技','600586.XSHG',0),(1952,'新华医疗','600587.XSHG',0),(1953,'用友网络','600588.XSHG',0),(1954,'广东榕泰','600589.XSHG',0),(1955,'泰豪科技','600590.XSHG',0),(1956,'*ST上航','600591.XSHG',0),(1957,'龙溪股份','600592.XSHG',0),(1958,'大连圣亚','600593.XSHG',0),(1959,'益佰制药','600594.XSHG',0),(1960,'*ST中孚','600595.XSHG',0),(1961,'新安股份','600596.XSHG',0),(1962,'光明乳业','600597.XSHG',0),(1963,'北大荒','600598.XSHG',0),(1964,'熊猫金控','600599.XSHG',0),(1965,'青岛啤酒','600600.XSHG',0),(1966,'方正科技','600601.XSHG',0),(1967,'云赛智联','600602.XSHG',0),(1968,'广汇物流','600603.XSHG',0),(1969,'市北高新','600604.XSHG',0),(1970,'汇通能源','600605.XSHG',0),(1971,'绿地控股','600606.XSHG',0),(1972,'上实医药','600607.XSHG',0),(1973,'ST沪科','600608.XSHG',0),(1974,'金杯汽车','600609.XSHG',0),(1975,'*ST毅达','600610.XSHG',0),(1976,'大众交通','600611.XSHG',0),(1977,'老凤祥','600612.XSHG',0),(1978,'神奇制药','600613.XSHG',0),(1979,'*ST鹏起','600614.XSHG',0),(1980,'ST丰华','600615.XSHG',0),(1981,'金枫酒业','600616.XSHG',0),(1982,'国新能源','600617.XSHG',0),(1983,'氯碱化工','600618.XSHG',0),(1984,'海立股份','600619.XSHG',0),(1985,'天宸股份','600620.XSHG',0),(1986,'华鑫股份','600621.XSHG',0),(1987,'光大嘉宝','600622.XSHG',0),(1988,'华谊集团','600623.XSHG',0),(1989,'复旦复华','600624.XSHG',0),(1990,'PT水仙','600625.XSHG',0),(1991,'申达股份','600626.XSHG',0),(1992,'上电股份','600627.XSHG',0),(1993,'新世界','600628.XSHG',0),(1994,'华建集团','600629.XSHG',0),(1995,'龙头股份','600630.XSHG',0),(1996,'百联股份','600631.XSHG',0),(1997,'华联商厦','600632.XSHG',0),(1998,'浙数文化','600633.XSHG',0),(1999,'*ST富控','600634.XSHG',0),(2000,'大众公用','600635.XSHG',0),(2001,'三爱富','600636.XSHG',0),(2002,'东方明珠','600637.XSHG',0),(2003,'新黄浦','600638.XSHG',0),(2004,'浦东金桥','600639.XSHG',0),(2005,'号百控股','600640.XSHG',0),(2006,'万业企业','600641.XSHG',0),(2007,'申能股份','600642.XSHG',0),(2008,'爱建集团','600643.XSHG',0),(2009,'乐山电力','600644.XSHG',0),(2010,'中源协和','600645.XSHG',0),(2011,'ST国嘉','600646.XSHG',0),(2012,'同达创业','600647.XSHG',0),(2013,'外高桥','600648.XSHG',0),(2014,'城投控股','600649.XSHG',0),(2015,'锦江投资','600650.XSHG',0),(2016,'飞乐音响','600651.XSHG',0),(2017,'*ST游久','600652.XSHG',0),(2018,'申华控股','600653.XSHG',0),(2019,'*ST中安','600654.XSHG',0),(2020,'豫园股份','600655.XSHG',0),(2021,'退市博元','600656.XSHG',0),(2022,'信达地产','600657.XSHG',0),(2023,'电子城','600658.XSHG',0),(2024,'*ST花雕','600659.XSHG',0),(2025,'福耀玻璃','600660.XSHG',0),(2026,'昂立教育','600661.XSHG',0),(2027,'强生控股','600662.XSHG',0),(2028,'陆家嘴','600663.XSHG',0),(2029,'哈药股份','600664.XSHG',0),(2030,'天地源','600665.XSHG',0),(2031,'*ST瑞德','600666.XSHG',0),(2032,'太极实业','600667.XSHG',0),(2033,'尖峰集团','600668.XSHG',0),(2034,'*ST鞍成','600669.XSHG',0),(2035,'*ST斯达','600670.XSHG',0),(2036,'天目药业','600671.XSHG',0),(2037,'*ST华圣','600672.XSHG',0),(2038,'东阳光','600673.XSHG',0),(2039,'川投能源','600674.XSHG',0),(2040,'中华企业','600675.XSHG',0),(2041,'交运股份','600676.XSHG',0),(2042,'航天通信','600677.XSHG',0),(2043,'四川金顶','600678.XSHG',0),(2044,'上海凤凰','600679.XSHG',0),(2045,'*ST上普','600680.XSHG',0),(2046,'百川能源','600681.XSHG',0),(2047,'南京新百','600682.XSHG',0),(2048,'京投发展','600683.XSHG',0),(2049,'珠江实业','600684.XSHG',0),(2050,'中船防务','600685.XSHG',0),(2051,'金龙汽车','600686.XSHG',0),(2052,'*ST刚泰','600687.XSHG',0),(2053,'上海石化','600688.XSHG',0),(2054,'上海三毛','600689.XSHG',0),(2055,'海尔智家','600690.XSHG',0),(2056,'阳煤化工','600691.XSHG',0),(2057,'亚通股份','600692.XSHG',0),(2058,'东百集团','600693.XSHG',0),(2059,'大商股份','600694.XSHG',0),(2060,'绿庭投资','600695.XSHG',0),(2061,'ST岩石','600696.XSHG',0),(2062,'欧亚集团','600697.XSHG',0),(2063,'*ST天雁','600698.XSHG',0),(2064,'均胜电子','600699.XSHG',0),(2065,'*ST数码','600700.XSHG',0),(2066,'*ST工新','600701.XSHG',0),(2067,'舍得酒业','600702.XSHG',0),(2068,'三安光电','600703.XSHG',0),(2069,'物产中大','600704.XSHG',0),(2070,'中航资本','600705.XSHG',0),(2071,'曲江文旅','600706.XSHG',0),(2072,'彩虹股份','600707.XSHG',0),(2073,'光明地产','600708.XSHG',0),(2074,'ST生态','600709.XSHG',0),(2075,'苏美达','600710.XSHG',0),(2076,'盛屯矿业','600711.XSHG',0),(2077,'南宁百货','600712.XSHG',0),(2078,'南京医药','600713.XSHG',0),(2079,'金瑞矿业','600714.XSHG',0),(2080,'文投控股','600715.XSHG',0),(2081,'凤凰股份','600716.XSHG',0),(2082,'天津港','600717.XSHG',0),(2083,'东软集团','600718.XSHG',0),(2084,'大连热电','600719.XSHG',0),(2085,'祁连山','600720.XSHG',0),(2086,'*ST百花','600721.XSHG',0),(2087,'金牛化工','600722.XSHG',0),(2088,'首商股份','600723.XSHG',0),(2089,'宁波富达','600724.XSHG',0),(2090,'ST云维','600725.XSHG',0),(2091,'*ST华源','600726.XSHG',0),(2092,'鲁北化工','600727.XSHG',0),(2093,'佳都科技','600728.XSHG',0),(2094,'重庆百货','600729.XSHG',0),(2095,'中国高科','600730.XSHG',0),(2096,'湖南海利','600731.XSHG',0),(2097,'ST新梅','600732.XSHG',0),(2098,'北汽蓝谷','600733.XSHG',0),(2099,'实达集团','600734.XSHG',0),(2100,'新华锦','600735.XSHG',0),(2101,'苏州高新','600736.XSHG',0),(2102,'中粮糖业','600737.XSHG',0),(2103,'兰州民百','600738.XSHG',0),(2104,'辽宁成大','600739.XSHG',0),(2105,'山西焦化','600740.XSHG',0),(2106,'华域汽车','600741.XSHG',0),(2107,'一汽富维','600742.XSHG',0),(2108,'华远地产','600743.XSHG',0),(2109,'华银电力','600744.XSHG',0),(2110,'闻泰科技','600745.XSHG',0),(2111,'江苏索普','600746.XSHG',0),(2112,'*ST大控','600747.XSHG',0),(2113,'上实发展','600748.XSHG',0),(2114,'西藏旅游','600749.XSHG',0),(2115,'江中药业','600750.XSHG',0),(2116,'海航科技','600751.XSHG',0),(2117,'*ST哈慈','600752.XSHG',0),(2118,'东方银星','600753.XSHG',0),(2119,'锦江酒店','600754.XSHG',0),(2120,'厦门国贸','600755.XSHG',0),(2121,'浪潮软件','600756.XSHG',0),(2122,'长江传媒','600757.XSHG',0),(2123,'红阳能源','600758.XSHG',0),(2124,'洲际油气','600759.XSHG',0),(2125,'中航沈飞','600760.XSHG',0),(2126,'安徽合力','600761.XSHG',0),(2127,'S*ST金荔','600762.XSHG',0),(2128,'通策医疗','600763.XSHG',0),(2129,'中国海防','600764.XSHG',0),(2130,'中航重机','600765.XSHG',0),(2131,'园城黄金','600766.XSHG',0),(2132,'ST运盛','600767.XSHG',0),(2133,'宁波富邦','600768.XSHG',0),(2134,'祥龙电业','600769.XSHG',0),(2135,'综艺股份','600770.XSHG',0),(2136,'广誉远','600771.XSHG',0),(2137,'S*ST龙昌','600772.XSHG',0),(2138,'西藏城投','600773.XSHG',0),(2139,'汉商集团','600774.XSHG',0),(2140,'南京熊猫','600775.XSHG',0),(2141,'东方通信','600776.XSHG',0),(2142,'新潮能源','600777.XSHG',0),(2143,'友好集团','600778.XSHG',0),(2144,'水井坊','600779.XSHG',0),(2145,'通宝能源','600780.XSHG',0),(2146,'ST辅仁','600781.XSHG',0),(2147,'新钢股份','600782.XSHG',0),(2148,'鲁信创投','600783.XSHG',0),(2149,'鲁银投资','600784.XSHG',0),(2150,'新华百货','600785.XSHG',0),(2151,'东方锅炉','600786.XSHG',0),(2152,'中储股份','600787.XSHG',0),(2153,'*ST达曼','600788.XSHG',0),(2154,'鲁抗医药','600789.XSHG',0),(2155,'轻纺城','600790.XSHG',0),(2156,'京能置业','600791.XSHG',0),(2157,'云煤能源','600792.XSHG',0),(2158,'宜宾纸业','600793.XSHG',0),(2159,'保税科技','600794.XSHG',0),(2160,'国电电力','600795.XSHG',0),(2161,'钱江生化','600796.XSHG',0),(2162,'浙大网新','600797.XSHG',0),(2163,'宁波海运','600798.XSHG',0),(2164,'*ST龙科','600799.XSHG',0),(2165,'天津磁卡','600800.XSHG',0),(2166,'华新水泥','600801.XSHG',0),(2167,'福建水泥','600802.XSHG',0),(2168,'新奥股份','600803.XSHG',0),(2169,'鹏博士','600804.XSHG',0),(2170,'悦达投资','600805.XSHG',0),(2171,'退市昆机','600806.XSHG',0),(2172,'ST天业','600807.XSHG',0),(2173,'马钢股份','600808.XSHG',0),(2174,'山西汾酒','600809.XSHG',0),(2175,'神马股份','600810.XSHG',0),(2176,'东方集团','600811.XSHG',0),(2177,'华北制药','600812.XSHG',0),(2178,'ST鞍一工','600813.XSHG',0),(2179,'杭州解百','600814.XSHG',0),(2180,'*ST厦工','600815.XSHG',0),(2181,'安信信托','600816.XSHG',0),(2182,'ST宏盛','600817.XSHG',0),(2183,'中路股份','600818.XSHG',0),(2184,'耀皮玻璃','600819.XSHG',0),(2185,'隧道股份','600820.XSHG',0),(2186,'津劝业','600821.XSHG',0),(2187,'上海物贸','600822.XSHG',0),(2188,'世茂股份','600823.XSHG',0),(2189,'益民集团','600824.XSHG',0),(2190,'新华传媒','600825.XSHG',0),(2191,'兰生股份','600826.XSHG',0),(2192,'百联股份','600827.XSHG',0),(2193,'茂业商业','600828.XSHG',0),(2194,'人民同泰','600829.XSHG',0),(2195,'香溢融通','600830.XSHG',0),(2196,'广电网络','600831.XSHG',0),(2197,'东方明珠','600832.XSHG',0),(2198,'第一医药','600833.XSHG',0),(2199,'申通地铁','600834.XSHG',0),(2200,'上海机电','600835.XSHG',0),(2201,'界龙实业','600836.XSHG',0),(2202,'海通证券','600837.XSHG',0),(2203,'上海九百','600838.XSHG',0),(2204,'四川长虹','600839.XSHG',0),(2205,'新湖创业','600840.XSHG',0),(2206,'上柴股份','600841.XSHG',0),(2207,'中西药业','600842.XSHG',0),(2208,'上工申贝','600843.XSHG',0),(2209,'丹化科技','600844.XSHG',0),(2210,'宝信软件','600845.XSHG',0),(2211,'同济科技','600846.XSHG',0),(2212,'万里股份','600847.XSHG',0),(2213,'上海临港','600848.XSHG',0),(2214,'上药转换','600849.XSHG',0),(2215,'华东电脑','600850.XSHG',0),(2216,'海欣股份','600851.XSHG',0),(2217,'*ST中川','600852.XSHG',0),(2218,'龙建股份','600853.XSHG',0),(2219,'春兰股份','600854.XSHG',0),(2220,'航天长峰','600855.XSHG',0),(2221,'ST中天','600856.XSHG',0),(2222,'宁波中百','600857.XSHG',0),(2223,'银座股份','600858.XSHG',0),(2224,'王府井','600859.XSHG',0),(2225,'京城股份','600860.XSHG',0),(2226,'北京城乡','600861.XSHG',0),(2227,'中航高科','600862.XSHG',0),(2228,'内蒙华电','600863.XSHG',0),(2229,'哈投股份','600864.XSHG',0),(2230,'百大集团','600865.XSHG',0),(2231,'星湖科技','600866.XSHG',0),(2232,'通化东宝','600867.XSHG',0),(2233,'梅雁吉祥','600868.XSHG',0),(2234,'智慧能源','600869.XSHG',0),(2235,'ST厦华','600870.XSHG',0),(2236,'石化油服','600871.XSHG',0),(2237,'中炬高新','600872.XSHG',0),(2238,'梅花生物','600873.XSHG',0),(2239,'创业环保','600874.XSHG',0),(2240,'东方电气','600875.XSHG',0),(2241,'洛阳玻璃','600876.XSHG',0),(2242,'*ST嘉陵','600877.XSHG',0),(2243,'*ST北科','600878.XSHG',0),(2244,'航天电子','600879.XSHG',0),(2245,'博瑞传播','600880.XSHG',0),(2246,'亚泰集团','600881.XSHG',0),(2247,'妙可蓝多','600882.XSHG',0),(2248,'博闻科技','600883.XSHG',0),(2249,'杉杉股份','600884.XSHG',0),(2250,'宏发股份','600885.XSHG',0),(2251,'国投电力','600886.XSHG',0),(2252,'伊利股份','600887.XSHG',0),(2253,'新疆众和','600888.XSHG',0),(2254,'南京化纤','600889.XSHG',0),(2255,'中房股份','600890.XSHG',0),(2256,'*ST秋林','600891.XSHG',0),(2257,'大晟文化','600892.XSHG',0),(2258,'航发动力','600893.XSHG',0),(2259,'广日股份','600894.XSHG',0),(2260,'张江高科','600895.XSHG',0),(2261,'览海投资','600896.XSHG',0),(2262,'厦门空港','600897.XSHG',0),(2263,'国美通讯','600898.XSHG',0),(2264,'*ST信联','600899.XSHG',0),(2265,'长江电力','600900.XSHG',0),(2266,'江苏租赁','600901.XSHG',0),(2267,'贵州燃气','600903.XSHG',0),(2268,'无锡银行','600908.XSHG',0),(2269,'华安证券','600909.XSHG',0),(2270,'重庆燃气','600917.XSHG',0),(2271,'江苏银行','600919.XSHG',0),(2272,'杭州银行','600926.XSHG',0),(2273,'西安银行','600928.XSHG',0),(2274,'湖南盐业','600929.XSHG',0),(2275,'爱柯迪','600933.XSHG',0),(2276,'广西广电','600936.XSHG',0),(2277,'重庆建工','600939.XSHG',0),(2278,'东方证券','600958.XSHG',0),(2279,'江苏有线','600959.XSHG',0),(2280,'渤海汽车','600960.XSHG',0),(2281,'株冶集团','600961.XSHG',0),(2282,'国投中鲁','600962.XSHG',0),(2283,'岳阳林纸','600963.XSHG',0),(2284,'福成股份','600965.XSHG',0),(2285,'博汇纸业','600966.XSHG',0),(2286,'内蒙一机','600967.XSHG',0),(2287,'海油发展','600968.XSHG',0),(2288,'郴电国际','600969.XSHG',0),(2289,'中材国际','600970.XSHG',0),(2290,'恒源煤电','600971.XSHG',0),(2291,'宝胜股份','600973.XSHG',0),(2292,'新五丰','600975.XSHG',0),(2293,'健民集团','600976.XSHG',0),(2294,'中国电影','600977.XSHG',0),(2295,'宜华生活','600978.XSHG',0),(2296,'广安爱众','600979.XSHG',0),(2297,'北矿科技','600980.XSHG',0),(2298,'汇鸿集团','600981.XSHG',0),(2299,'宁波热电','600982.XSHG',0),(2300,'惠而浦','600983.XSHG',0),(2301,'建设机械','600984.XSHG',0),(2302,'淮北矿业','600985.XSHG',0),(2303,'科达股份','600986.XSHG',0),(2304,'航民股份','600987.XSHG',0),(2305,'赤峰黄金','600988.XSHG',0),(2306,'宝丰能源','600989.XSHG',0),(2307,'四创电子','600990.XSHG',0),(2308,'广汽长丰','600991.XSHG',0),(2309,'贵绳股份','600992.XSHG',0),(2310,'马应龙','600993.XSHG',0),(2311,'文山电力','600995.XSHG',0),(2312,'贵广网络','600996.XSHG',0),(2313,'开滦股份','600997.XSHG',0),(2314,'九州通','600998.XSHG',0),(2315,'招商证券','600999.XSHG',0),(2316,'唐山港','601000.XSHG',0),(2317,'大同煤业','601001.XSHG',0),(2318,'晋亿实业','601002.XSHG',0),(2319,'柳钢股份','601003.XSHG',0),(2320,'重庆钢铁','601005.XSHG',0),(2321,'大秦铁路','601006.XSHG',0),(2322,'金陵饭店','601007.XSHG',0),(2323,'连云港','601008.XSHG',0),(2324,'南京银行','601009.XSHG',0),(2325,'文峰股份','601010.XSHG',0),(2326,'宝泰隆','601011.XSHG',0),(2327,'隆基股份','601012.XSHG',0),(2328,'陕西黑猫','601015.XSHG',0),(2329,'节能风电','601016.XSHG',0),(2330,'宁波港','601018.XSHG',0),(2331,'山东出版','601019.XSHG',0),(2332,'华钰矿业','601020.XSHG',0),(2333,'春秋航空','601021.XSHG',0),(2334,'玉龙股份','601028.XSHG',0),(2335,'一拖股份','601038.XSHG',0),(2336,'赛轮轮胎','601058.XSHG',0),(2337,'中信建投','601066.XSHG',0),(2338,'中铝国际','601068.XSHG',0),(2339,'西部黄金','601069.XSHG',0),(2340,'渝农商行','601077.XSHG',0),(2341,'国芳集团','601086.XSHG',0),(2342,'中国神华','601088.XSHG',0),(2343,'中南传媒','601098.XSHG',0),(2344,'太平洋','601099.XSHG',0),(2345,'恒立液压','601100.XSHG',0),(2346,'昊华能源','601101.XSHG',0),(2347,'中国一重','601106.XSHG',0),(2348,'四川成渝','601107.XSHG',0),(2349,'财通证券','601108.XSHG',0),(2350,'中国国航','601111.XSHG',0),(2351,'华鼎股份','601113.XSHG',0),(2352,'三江购物','601116.XSHG',0),(2353,'中国化学','601117.XSHG',0),(2354,'海南橡胶','601118.XSHG',0),(2355,'四方股份','601126.XSHG',0),(2356,'小康股份','601127.XSHG',0),(2357,'常熟银行','601128.XSHG',0),(2358,'博威合金','601137.XSHG',0),(2359,'工业富联','601138.XSHG',0),(2360,'深圳燃气','601139.XSHG',0),(2361,'新城控股','601155.XSHG',0),(2362,'重庆水务','601158.XSHG',0),(2363,'天风证券','601162.XSHG',0),(2364,'三角轮胎','601163.XSHG',0),(2365,'兴业银行','601166.XSHG',0),(2366,'西部矿业','601168.XSHG',0),(2367,'北京银行','601169.XSHG',0),(2368,'杭齿前进','601177.XSHG',0),(2369,'中国西电','601179.XSHG',0),(2370,'中国铁建','601186.XSHG',0),(2371,'龙江交通','601188.XSHG',0),(2372,'东兴证券','601198.XSHG',0),(2373,'江南水务','601199.XSHG',0),(2374,'上海环境','601200.XSHG',0),(2375,'东材科技','601208.XSHG',0),(2376,'国泰君安','601211.XSHG',0),(2377,'白银有色','601212.XSHG',0),(2378,'君正集团','601216.XSHG',0),(2379,'吉鑫科技','601218.XSHG',0),(2380,'林洋能源','601222.XSHG',0),(2381,'陕西煤业','601225.XSHG',0),(2382,'华电重工','601226.XSHG',0),(2383,'广州港','601228.XSHG',0),(2384,'上海银行','601229.XSHG',0),(2385,'环旭电子','601231.XSHG',0),(2386,'桐昆股份','601233.XSHG',0),(2387,'红塔证券','601236.XSHG',0),(2388,'广汽集团','601238.XSHG',0),(2389,'*ST庞大','601258.XSHG',0),(2390,'*ST二重','601268.XSHG',0),(2391,'农业银行','601288.XSHG',0),(2392,'青岛港','601298.XSHG',0),(2393,'中国北车','601299.XSHG',0),(2394,'骆驼股份','601311.XSHG',0),(2395,'江南嘉捷','601313.XSHG',0),(2396,'中国平安','601318.XSHG',0),(2397,'中国人保','601319.XSHG',0),(2398,'秦港股份','601326.XSHG',0),(2399,'交通银行','601328.XSHG',0),(2400,'绿色动力','601330.XSHG',0),(2401,'广深铁路','601333.XSHG',0),(2402,'新华保险','601336.XSHG',0),(2403,'百隆东方','601339.XSHG',0),(2404,'三六零','601360.XSHG',0),(2405,'利群股份','601366.XSHG',0),(2406,'绿城水务','601368.XSHG',0),(2407,'陕鼓动力','601369.XSHG',0),(2408,'中原证券','601375.XSHG',0),(2409,'兴业证券','601377.XSHG',0),(2410,'怡球资源','601388.XSHG',0),(2411,'中国中铁','601390.XSHG',0),(2412,'工商银行','601398.XSHG',0),(2413,'通用股份','601500.XSHG',0),(2414,'东风股份','601515.XSHG',0),(2415,'吉林高速','601518.XSHG',0),(2416,'大智慧','601519.XSHG',0),(2417,'东吴证券','601555.XSHG',0),(2418,'ST锐电','601558.XSHG',0),(2419,'九牧王','601566.XSHG',0),(2420,'三星医疗','601567.XSHG',0),(2421,'长沙银行','601577.XSHG',0),(2422,'会稽山','601579.XSHG',0),(2423,'北辰实业','601588.XSHG',0),(2424,'上海电影','601595.XSHG',0),(2425,'中国外运','601598.XSHG',0),(2426,'鹿港文化','601599.XSHG',0),(2427,'中国铝业','601600.XSHG',0),(2428,'中国太保','601601.XSHG',0),(2429,'长城军工','601606.XSHG',0),(2430,'上海医药','601607.XSHG',0),(2431,'中信重工','601608.XSHG',0),(2432,'中国核建','601611.XSHG',0),(2433,'明阳智能','601615.XSHG',0),(2434,'广电电气','601616.XSHG',0),(2435,'中国中冶','601618.XSHG',0),(2436,'嘉泽新能','601619.XSHG',0),(2437,'中国人寿','601628.XSHG',0),(2438,'长城汽车','601633.XSHG',0),(2439,'旗滨集团','601636.XSHG',0),(2440,'平煤股份','601666.XSHG',0),(2441,'中国建筑','601668.XSHG',0),(2442,'中国电建','601669.XSHG',0),(2443,'明泰铝业','601677.XSHG',0),(2444,'滨化股份','601678.XSHG',0),(2445,'华泰证券','601688.XSHG',0),(2446,'拓普集团','601689.XSHG',0),(2447,'中国卫通','601698.XSHG',0),(2448,'潞安环能','601699.XSHG',0),(2449,'风范股份','601700.XSHG',0),(2450,'郑煤机','601717.XSHG',0),(2451,'际华集团','601718.XSHG',0),(2452,'上海电气','601727.XSHG',0),(2453,'中国中车','601766.XSHG',0),(2454,'力帆股份','601777.XSHG',0),(2455,'光大证券','601788.XSHG',0),(2456,'宁波建工','601789.XSHG',0),(2457,'ST蓝科','601798.XSHG',0),(2458,'星宇股份','601799.XSHG',0),(2459,'中国交建','601800.XSHG',0),(2460,'皖新传媒','601801.XSHG',0),(2461,'中海油服','601808.XSHG',0),(2462,'新华文轩','601811.XSHG',0),(2463,'光大银行','601818.XSHG',0),(2464,'美凯龙','601828.XSHG',0),(2465,'成都银行','601838.XSHG',0),(2466,'中国石油','601857.XSHG',0),(2467,'中国科传','601858.XSHG',0),(2468,'紫金银行','601860.XSHG',0),(2469,'福莱特','601865.XSHG',0),(2470,'中远海发','601866.XSHG',0),(2471,'长飞光纤','601869.XSHG',0),(2472,'招商轮船','601872.XSHG',0),(2473,'正泰电器','601877.XSHG',0),(2474,'浙商证券','601878.XSHG',0),(2475,'大连港','601880.XSHG',0),(2476,'中国银河','601881.XSHG',0),(2477,'海天精工','601882.XSHG',0),(2478,'江河集团','601886.XSHG',0),(2479,'中国国旅','601888.XSHG',0),(2480,'亚星锚链','601890.XSHG',0),(2481,'中煤能源','601898.XSHG',0),(2482,'紫金矿业','601899.XSHG',0),(2483,'南方传媒','601900.XSHG',0),(2484,'方正证券','601901.XSHG',0),(2485,'京运通','601908.XSHG',0),(2486,'新集能源','601918.XSHG',0),(2487,'中远海控','601919.XSHG',0),(2488,'凤凰传媒','601928.XSHG',0),(2489,'吉视传媒','601929.XSHG',0),(2490,'永辉超市','601933.XSHG',0),(2491,'建设银行','601939.XSHG',0),(2492,'中国出版','601949.XSHG',0),(2493,'苏垦农发','601952.XSHG',0),(2494,'金钼股份','601958.XSHG',0),(2495,'中国汽研','601965.XSHG',0),(2496,'玲珑轮胎','601966.XSHG',0),(2497,'宝钢包装','601968.XSHG',0),(2498,'海南矿业','601969.XSHG',0),(2499,'招商南油','601975.XSHG',0),(2500,'中国核电','601985.XSHG',0),(2501,'中国银行','601988.XSHG',0),(2502,'中国重工','601989.XSHG',0),(2503,'南京证券','601990.XSHG',0),(2504,'大唐发电','601991.XSHG',0),(2505,'金隅集团','601992.XSHG',0),(2506,'丰林集团','601996.XSHG',0),(2507,'贵阳银行','601997.XSHG',0),(2508,'中信银行','601998.XSHG',0),(2509,'出版传媒','601999.XSHG',0),(2510,'人民网','603000.XSHG',0),(2511,'奥康国际','603001.XSHG',0),(2512,'宏昌电子','603002.XSHG',0),(2513,'龙宇燃油','603003.XSHG',0),(2514,'晶方科技','603005.XSHG',0),(2515,'联明股份','603006.XSHG',0),(2516,'花王股份','603007.XSHG',0),(2517,'喜临门','603008.XSHG',0),(2518,'北特科技','603009.XSHG',0),(2519,'万盛股份','603010.XSHG',0),(2520,'合锻智能','603011.XSHG',0),(2521,'创力集团','603012.XSHG',0),(2522,'亚普股份','603013.XSHG',0),(2523,'弘讯科技','603015.XSHG',0),(2524,'新宏泰','603016.XSHG',0),(2525,'中衡设计','603017.XSHG',0),(2526,'中设集团','603018.XSHG',0),(2527,'中科曙光','603019.XSHG',0),(2528,'爱普股份','603020.XSHG',0),(2529,'山东华鹏','603021.XSHG',0),(2530,'新通联','603022.XSHG',0),(2531,'威帝股份','603023.XSHG',0),(2532,'大豪科技','603025.XSHG',0),(2533,'石大胜华','603026.XSHG',0),(2534,'千禾味业','603027.XSHG',0),(2535,'赛福天','603028.XSHG',0),(2536,'天鹅股份','603029.XSHG',0),(2537,'全筑股份','603030.XSHG',0),(2538,'安德利','603031.XSHG',0),(2539,'德新交运','603032.XSHG',0),(2540,'三维股份','603033.XSHG',0),(2541,'常熟汽饰','603035.XSHG',0),(2542,'如通股份','603036.XSHG',0),(2543,'凯众股份','603037.XSHG',0),(2544,'华立股份','603038.XSHG',0),(2545,'泛微网络','603039.XSHG',0),(2546,'新坐标','603040.XSHG',0),(2547,'美思德','603041.XSHG',0),(2548,'华脉科技','603042.XSHG',0),(2549,'广州酒家','603043.XSHG',0),(2550,'福达合金','603045.XSHG',0),(2551,'科林电气','603050.XSHG',0),(2552,'台华新材','603055.XSHG',0),(2553,'德邦股份','603056.XSHG',0),(2554,'永吉股份','603058.XSHG',0),(2555,'倍加洁','603059.XSHG',0),(2556,'国检集团','603060.XSHG',0),(2557,'禾望电气','603063.XSHG',0),(2558,'音飞储存','603066.XSHG',0),(2559,'振华股份','603067.XSHG',0),(2560,'博通集成','603068.XSHG',0),(2561,'海汽集团','603069.XSHG',0),(2562,'乐惠国际','603076.XSHG',0),(2563,'和邦生物','603077.XSHG',0),(2564,'江化微','603078.XSHG',0),(2565,'圣达生物','603079.XSHG',0),(2566,'新疆火炬','603080.XSHG',0),(2567,'大丰实业','603081.XSHG',0),(2568,'剑桥科技','603083.XSHG',0),(2569,'天成自控','603085.XSHG',0),(2570,'先达股份','603086.XSHG',0),(2571,'宁波精达','603088.XSHG',0),(2572,'正裕工业','603089.XSHG',0),(2573,'宏盛股份','603090.XSHG',0),(2574,'南华期货','603093.XSHG',0),(2575,'新经典','603096.XSHG',0),(2576,'森特股份','603098.XSHG',0),(2577,'长白山','603099.XSHG',0),(2578,'川仪股份','603100.XSHG',0),(2579,'汇嘉时代','603101.XSHG',0),(2580,'横店影视','603103.XSHG',0),(2581,'芯能科技','603105.XSHG',0),(2582,'恒银金融','603106.XSHG',0),(2583,'润达医疗','603108.XSHG',0),(2584,'东方材料','603110.XSHG',0),(2585,'康尼机电','603111.XSHG',0),(2586,'金能科技','603113.XSHG',0),(2587,'海星股份','603115.XSHG',0),(2588,'红蜻蜓','603116.XSHG',0),(2589,'万林物流','603117.XSHG',0),(2590,'共进股份','603118.XSHG',0),(2591,'华培动力','603121.XSHG',0),(2592,'翠微股份','603123.XSHG',0),(2593,'中材节能','603126.XSHG',0),(2594,'昭衍新药','603127.XSHG',0),(2595,'华贸物流','603128.XSHG',0),(2596,'春风动力','603129.XSHG',0),(2597,'上海沪工','603131.XSHG',0),(2598,'碳元科技','603133.XSHG',0),(2599,'天目湖','603136.XSHG',0),(2600,'海量数据','603138.XSHG',0),(2601,'康惠制药','603139.XSHG',0),(2602,'养元饮品','603156.XSHG',0),(2603,'拉夏贝尔','603157.XSHG',0),(2604,'腾龙股份','603158.XSHG',0),(2605,'上海亚虹','603159.XSHG',0),(2606,'汇顶科技','603160.XSHG',0),(2607,'科华控股','603161.XSHG',0),(2608,'荣晟环保','603165.XSHG',0),(2609,'福达股份','603166.XSHG',0),(2610,'渤海轮渡','603167.XSHG',0),(2611,'莎普爱思','603168.XSHG',0),(2612,'兰石重装','603169.XSHG',0),(2613,'德创环保','603177.XSHG',0),(2614,'圣龙股份','603178.XSHG',0),(2615,'新泉股份','603179.XSHG',0),(2616,'金牌厨柜','603180.XSHG',0),(2617,'皇马科技','603181.XSHG',0),(2618,'建研院','603183.XSHG',0),(2619,'上机数控','603185.XSHG',0),(2620,'华正新材','603186.XSHG',0),(2621,'海容冷链','603187.XSHG',0),(2622,'ST亚邦','603188.XSHG',0),(2623,'网达软件','603189.XSHG',0),(2624,'汇得科技','603192.XSHG',0),(2625,'日播时尚','603196.XSHG',0),(2626,'保隆科技','603197.XSHG',0),(2627,'迎驾贡酒','603198.XSHG',0),(2628,'九华旅游','603199.XSHG',0),(2629,'上海洗霸','603200.XSHG',0),(2630,'快克股份','603203.XSHG',0),(2631,'江山欧派','603208.XSHG',0),(2632,'爱婴室','603214.XSHG',0),(2633,'元利科技','603217.XSHG',0),(2634,'日月股份','603218.XSHG',0),(2635,'中贝通信','603220.XSHG',0),(2636,'济民制药','603222.XSHG',0),(2637,'恒通股份','603223.XSHG',0),(2638,'新凤鸣','603225.XSHG',0),(2639,'菲林格尔','603226.XSHG',0),(2640,'雪峰科技','603227.XSHG',0),(2641,'景旺电子','603228.XSHG',0),(2642,'奥翔药业','603229.XSHG',0),(2643,'格尔软件','603232.XSHG',0),(2644,'大参林','603233.XSHG',0),(2645,'移远通信','603236.XSHG',0),(2646,'诺邦股份','603238.XSHG',0),(2647,'浙江仙通','603239.XSHG',0),(2648,'宏和科技','603256.XSHG',0),(2649,'电魂网络','603258.XSHG',0),(2650,'药明康德','603259.XSHG',0),(2651,'合盛硅业','603260.XSHG',0),(2652,'天龙股份','603266.XSHG',0),(2653,'鸿远电子','603267.XSHG',0),(2654,'松发股份','603268.XSHG',0),(2655,'海鸥股份','603269.XSHG',0),(2656,'银都股份','603277.XSHG',0),(2657,'大业股份','603278.XSHG',0),(2658,'景津环保','603279.XSHG',0),(2659,'赛腾股份','603283.XSHG',0),(2660,'日盈电子','603286.XSHG',0),(2661,'海天味业','603288.XSHG',0),(2662,'泰瑞机器','603289.XSHG',0),(2663,'永新光学','603297.XSHG',0),(2664,'杭叉集团','603298.XSHG',0),(2665,'苏盐井神','603299.XSHG',0),(2666,'华铁科技','603300.XSHG',0),(2667,'振德医疗','603301.XSHG',0),(2668,'得邦照明','603303.XSHG',0),(2669,'旭升股份','603305.XSHG',0),(2670,'华懋科技','603306.XSHG',0),(2671,'应流股份','603308.XSHG',0),(2672,'维力医疗','603309.XSHG',0),(2673,'金海环境','603311.XSHG',0),(2674,'梦百合','603313.XSHG',0),(2675,'福鞍股份','603315.XSHG',0),(2676,'诚邦股份','603316.XSHG',0),(2677,'天味食品','603317.XSHG',0),(2678,'派思股份','603318.XSHG',0),(2679,'湘油泵','603319.XSHG',0),(2680,'迪贝电气','603320.XSHG',0),(2681,'梅轮电梯','603321.XSHG',0),(2682,'超讯通信','603322.XSHG',0),(2683,'苏农银行','603323.XSHG',0),(2684,'我乐家居','603326.XSHG',0),(2685,'福蓉科技','603327.XSHG',0),(2686,'依顿电子','603328.XSHG',0),(2687,'上海雅仕','603329.XSHG',0),(2688,'上海天洋','603330.XSHG',0),(2689,'百达精工','603331.XSHG',0),(2690,'苏州龙杰','603332.XSHG',0),(2691,'尚纬股份','603333.XSHG',0),(2692,'迪生力','603335.XSHG',0),(2693,'宏辉果蔬','603336.XSHG',0),(2694,'杰克股份','603337.XSHG',0),(2695,'浙江鼎力','603338.XSHG',0),(2696,'四方科技','603339.XSHG',0),(2697,'安井食品','603345.XSHG',0),(2698,'文灿股份','603348.XSHG',0),(2699,'威尔药业','603351.XSHG',0),(2700,'莱克电气','603355.XSHG',0),(2701,'华菱精工','603356.XSHG',0),(2702,'设计总院','603357.XSHG',0),(2703,'华达科技','603358.XSHG',0),(2704,'东珠生态','603359.XSHG',0),(2705,'百傲化学','603360.XSHG',0),(2706,'傲农生物','603363.XSHG',0),(2707,'水星家纺','603365.XSHG',0),(2708,'日出东方','603366.XSHG',0),(2709,'辰欣药业','603367.XSHG',0),(2710,'柳药股份','603368.XSHG',0),(2711,'今世缘','603369.XSHG',0),(2712,'东方时尚','603377.XSHG',0),(2713,'亚士创能','603378.XSHG',0),(2714,'三美股份','603379.XSHG',0),(2715,'易德龙','603380.XSHG',0),(2716,'顶点软件','603383.XSHG',0),(2717,'惠达卫浴','603385.XSHG',0),(2718,'广东骏亚','603386.XSHG',0),(2719,'基蛋生物','603387.XSHG',0),(2720,'元成股份','603388.XSHG',0),(2721,'亚振家居','603389.XSHG',0),(2722,'新天然气','603393.XSHG',0),(2723,'金辰股份','603396.XSHG',0),(2724,'邦宝益智','603398.XSHG',0),(2725,'吉翔股份','603399.XSHG',0),(2726,'信捷电气','603416.XSHG',0),(2727,'鼎信通讯','603421.XSHG',0),(2728,'集友股份','603429.XSHG',0),(2729,'吉比特','603444.XSHG',0),(2730,'九洲药业','603456.XSHG',0),(2731,'勘设股份','603458.XSHG',0),(2732,'风语筑','603466.XSHG',0),(2733,'振静股份','603477.XSHG',0),(2734,'科沃斯','603486.XSHG',0),(2735,'展鹏科技','603488.XSHG',0),(2736,'恒为科技','603496.XSHG',0),(2737,'翔港科技','603499.XSHG',0),(2738,'祥和实业','603500.XSHG',0),(2739,'韦尔股份','603501.XSHG',0),(2740,'金石资源','603505.XSHG',0),(2741,'南都物业','603506.XSHG',0),(2742,'振江股份','603507.XSHG',0),(2743,'思维列控','603508.XSHG',0),(2744,'欧普照明','603515.XSHG',0),(2745,'淳中科技','603516.XSHG',0),(2746,'绝味食品','603517.XSHG',0),(2747,'锦泓集团','603518.XSHG',0),(2748,'立霸股份','603519.XSHG',0),(2749,'司太立','603520.XSHG',0),(2750,'众源新材','603527.XSHG',0),(2751,'多伦科技','603528.XSHG',0),(2752,'神马电力','603530.XSHG',0),(2753,'掌阅科技','603533.XSHG',0),(2754,'嘉诚国际','603535.XSHG',0),(2755,'惠发食品','603536.XSHG',0),(2756,'美诺华','603538.XSHG',0),(2757,'贵人鸟','603555.XSHG',0),(2758,'海兴电力','603556.XSHG',0),(2759,'起步股份','603557.XSHG',0),(2760,'健盛集团','603558.XSHG',0),(2761,'中通国脉','603559.XSHG',0),(2762,'普莱柯','603566.XSHG',0),(2763,'珍宝岛','603567.XSHG',0),(2764,'伟明环保','603568.XSHG',0),(2765,'长久物流','603569.XSHG',0),(2766,'汇金通','603577.XSHG',0),(2767,'三星新材','603578.XSHG',0),(2768,'荣泰健康','603579.XSHG',0),(2769,'艾艾精工','603580.XSHG',0),(2770,'捷昌驱动','603583.XSHG',0),(2771,'苏利股份','603585.XSHG',0),(2772,'金麒麟','603586.XSHG',0),(2773,'地素时尚','603587.XSHG',0),(2774,'高能环境','603588.XSHG',0),(2775,'口子窖','603589.XSHG',0),(2776,'康辰药业','603590.XSHG',0),(2777,'东尼电子','603595.XSHG',0),(2778,'伯特利','603596.XSHG',0),(2779,'引力传媒','603598.XSHG',0),(2780,'广信股份','603599.XSHG',0),(2781,'永艺股份','603600.XSHG',0),(2782,'再升科技','603601.XSHG',0),(2783,'纵横通信','603602.XSHG',0),(2784,'博天环境','603603.XSHG',0),(2785,'珀莱雅','603605.XSHG',0),(2786,'东方电缆','603606.XSHG',0),(2787,'京华激光','603607.XSHG',0),(2788,'天创时尚','603608.XSHG',0),(2789,'禾丰牧业','603609.XSHG',0),(2790,'诺力股份','603611.XSHG',0),(2791,'索通发展','603612.XSHG',0),(2792,'国联股份','603613.XSHG',0),(2793,'茶花股份','603615.XSHG',0),(2794,'韩建河山','603616.XSHG',0),(2795,'君禾股份','603617.XSHG',0),(2796,'杭电股份','603618.XSHG',0),(2797,'中曼石油','603619.XSHG',0),(2798,'科森科技','603626.XSHG',0),(2799,'清源股份','603628.XSHG',0),(2800,'利通电子','603629.XSHG',0),(2801,'拉芳家化','603630.XSHG',0),(2802,'徕木股份','603633.XSHG',0),(2803,'南威软件','603636.XSHG',0),(2804,'镇海股份','603637.XSHG',0),(2805,'艾迪精密','603638.XSHG',0),(2806,'海利尔','603639.XSHG',0),(2807,'畅联股份','603648.XSHG',0),(2808,'彤程新材','603650.XSHG',0),(2809,'朗博科技','603655.XSHG',0),(2810,'泰禾光电','603656.XSHG',0),(2811,'春光科技','603657.XSHG',0),(2812,'安图生物','603658.XSHG',0),(2813,'璞泰来','603659.XSHG',0),(2814,'苏州科达','603660.XSHG',0),(2815,'恒林股份','603661.XSHG',0),(2816,'柯力传感','603662.XSHG',0),(2817,'三祥新材','603663.XSHG',0),(2818,'康隆达','603665.XSHG',0),(2819,'亿嘉和','603666.XSHG',0),(2820,'五洲新春','603667.XSHG',0),(2821,'天马科技','603668.XSHG',0),(2822,'灵康药业','603669.XSHG',0),(2823,'卫信康','603676.XSHG',0),(2824,'奇精机械','603677.XSHG',0),(2825,'火炬电子','603678.XSHG',0),(2826,'华体科技','603679.XSHG',0),(2827,'今创集团','603680.XSHG',0),(2828,'永冠新材','603681.XSHG',0),(2829,'晶华新材','603683.XSHG',0),(2830,'晨丰科技','603685.XSHG',0),(2831,'龙马环卫','603686.XSHG',0),(2832,'大胜达','603687.XSHG',0),(2833,'石英股份','603688.XSHG',0),(2834,'皖天然气','603689.XSHG',0),(2835,'至纯科技','603690.XSHG',0),(2836,'江苏新能','603693.XSHG',0),(2837,'安记食品','603696.XSHG',0),(2838,'有友食品','603697.XSHG',0),(2839,'航天工程','603698.XSHG',0),(2840,'纽威股份','603699.XSHG',0),(2841,'宁波水表','603700.XSHG',0),(2842,'德宏股份','603701.XSHG',0),(2843,'盛洋科技','603703.XSHG',0),(2844,'东方环宇','603706.XSHG',0),(2845,'健友股份','603707.XSHG',0),(2846,'家家悦','603708.XSHG',0),(2847,'中源家居','603709.XSHG',0),(2848,'香飘飘','603711.XSHG',0),(2849,'七一二','603712.XSHG',0),(2850,'密尔克卫','603713.XSHG',0),(2851,'塞力斯','603716.XSHG',0),(2852,'天域生态','603717.XSHG',0),(2853,'海利生物','603718.XSHG',0),(2854,'中广天择','603721.XSHG',0),(2855,'阿科力','603722.XSHG',0),(2856,'天安新材','603725.XSHG',0),(2857,'朗迪集团','603726.XSHG',0),(2858,'博迈科','603727.XSHG',0),(2859,'鸣志电器','603728.XSHG',0),(2860,'龙韵股份','603729.XSHG',0),(2861,'岱美股份','603730.XSHG',0),(2862,'仙鹤股份','603733.XSHG',0),(2863,'三棵树','603737.XSHG',0),(2864,'泰晶科技','603738.XSHG',0),(2865,'蔚蓝生物','603739.XSHG',0),(2866,'日辰股份','603755.XSHG',0),(2867,'大元泵业','603757.XSHG',0),(2868,'秦安股份','603758.XSHG',0),(2869,'隆鑫通用','603766.XSHG',0),(2870,'中马传动','603767.XSHG',0),(2871,'常青股份','603768.XSHG',0),(2872,'沃格光电','603773.XSHG',0),(2873,'永安行','603776.XSHG',0),(2874,'来伊份','603777.XSHG',0),(2875,'乾景园林','603778.XSHG',0),(2876,'威龙股份','603779.XSHG',0),(2877,'科博达','603786.XSHG',0),(2878,'新日股份','603787.XSHG',0),(2879,'宁波高发','603788.XSHG',0),(2880,'星光农机','603789.XSHG',0),(2881,'雅运股份','603790.XSHG',0),(2882,'联泰环保','603797.XSHG',0),(2883,'康普顿','603798.XSHG',0),(2884,'华友钴业','603799.XSHG',0),(2885,'道森股份','603800.XSHG',0),(2886,'志邦家居','603801.XSHG',0),(2887,'瑞斯康达','603803.XSHG',0),(2888,'福斯特','603806.XSHG',0),(2889,'歌力思','603808.XSHG',0),(2890,'豪能股份','603809.XSHG',0),(2891,'ST丰山','603810.XSHG',0),(2892,'诚意药业','603811.XSHG',0),(2893,'原尚股份','603813.XSHG',0),(2894,'交建股份','603815.XSHG',0),(2895,'顾家家居','603816.XSHG',0),(2896,'海峡环保','603817.XSHG',0),(2897,'曲美家居','603818.XSHG',0),(2898,'神力股份','603819.XSHG',0),(2899,'嘉澳环保','603822.XSHG',0),(2900,'百合花','603823.XSHG',0),(2901,'华扬联众','603825.XSHG',0),(2902,'坤彩科技','603826.XSHG',0),(2903,'柯利达','603828.XSHG',0),(2904,'洛凯股份','603829.XSHG',0),(2905,'欧派家居','603833.XSHG',0),(2906,'四通股份','603838.XSHG',0),(2907,'安正时尚','603839.XSHG',0),(2908,'正平股份','603843.XSHG',0),(2909,'好太太','603848.XSHG',0),(2910,'华荣股份','603855.XSHG',0),(2911,'东宏股份','603856.XSHG',0),(2912,'步长制药','603858.XSHG',0),(2913,'能科股份','603859.XSHG',0),(2914,'中公高科','603860.XSHG',0),(2915,'白云电器','603861.XSHG',0),(2916,'松炀资源','603863.XSHG',0),(2917,'桃李面包','603866.XSHG',0),(2918,'新化股份','603867.XSHG',0),(2919,'飞科电器','603868.XSHG',0),(2920,'新智认知','603869.XSHG',0),(2921,'嘉友国际','603871.XSHG',0),(2922,'鼎胜新材','603876.XSHG',0),(2923,'太平鸟','603877.XSHG',0),(2924,'武进不锈','603878.XSHG',0),(2925,'永悦科技','603879.XSHG',0),(2926,'南卫股份','603880.XSHG',0),(2927,'数据港','603881.XSHG',0),(2928,'金域医学','603882.XSHG',0),(2929,'老百姓','603883.XSHG',0),(2930,'吉祥航空','603885.XSHG',0),(2931,'元祖股份','603886.XSHG',0),(2932,'城地股份','603887.XSHG',0),(2933,'新华网','603888.XSHG',0),(2934,'新澳股份','603889.XSHG',0),(2935,'春秋电子','603890.XSHG',0),(2936,'天永智能','603895.XSHG',0),(2937,'寿仙谷','603896.XSHG',0),(2938,'长城科技','603897.XSHG',0),(2939,'好莱客','603898.XSHG',0),(2940,'晨光文具','603899.XSHG',0),(2941,'莱绅通灵','603900.XSHG',0),(2942,'永创智能','603901.XSHG',0),(2943,'中持股份','603903.XSHG',0),(2944,'龙蟠科技','603906.XSHG',0),(2945,'牧高笛','603908.XSHG',0),(2946,'合诚股份','603909.XSHG',0),(2947,'佳力图','603912.XSHG',0),(2948,'国茂股份','603915.XSHG',0),(2949,'苏博特','603916.XSHG',0),(2950,'合力科技','603917.XSHG',0),(2951,'金桥信息','603918.XSHG',0),(2952,'金徽酒','603919.XSHG',0),(2953,'世运电路','603920.XSHG',0),(2954,'金鸿顺','603922.XSHG',0),(2955,'铁流股份','603926.XSHG',0),(2956,'中科软','603927.XSHG',0),(2957,'兴业股份','603928.XSHG',0),(2958,'亚翔集成','603929.XSHG',0),(2959,'睿能科技','603933.XSHG',0),(2960,'博敏电子','603936.XSHG',0),(2961,'丽岛新材','603937.XSHG',0),(2962,'三孚股份','603938.XSHG',0),(2963,'益丰药房','603939.XSHG',0),(2964,'大千生态','603955.XSHG',0),(2965,'威派格','603956.XSHG',0),(2966,'哈森股份','603958.XSHG',0),(2967,'百利科技','603959.XSHG',0),(2968,'克来机电','603960.XSHG',0),(2969,'大理药业','603963.XSHG',0),(2970,'法兰泰克','603966.XSHG',0),(2971,'中创物流','603967.XSHG',0),(2972,'醋化股份','603968.XSHG',0),(2973,'银龙股份','603969.XSHG',0),(2974,'中农立华','603970.XSHG',0),(2975,'正川股份','603976.XSHG',0),(2976,'国泰集团','603977.XSHG',0),(2977,'深圳新星','603978.XSHG',0),(2978,'金诚信','603979.XSHG',0),(2979,'吉华集团','603980.XSHG',0),(2980,'泉峰汽车','603982.XSHG',0),(2981,'丸美股份','603983.XSHG',0),(2982,'恒润股份','603985.XSHG',0),(2983,'兆易创新','603986.XSHG',0),(2984,'康德莱','603987.XSHG',0),(2985,'中电电机','603988.XSHG',0),(2986,'艾华集团','603989.XSHG',0),(2987,'麦迪科技','603990.XSHG',0),(2988,'至正股份','603991.XSHG',0),(2989,'松霖科技','603992.XSHG',0),(2990,'洛阳钼业','603993.XSHG',0),(2991,'ST中新','603996.XSHG',0),(2992,'继峰股份','603997.XSHG',0),(2993,'方盛制药','603998.XSHG',0),(2994,'读者传媒','603999.XSHG',0),(2995,'啊啊啊啊？','601991',99);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `for_stock`
--

LOCK TABLES `for_stock` WRITE;
/*!40000 ALTER TABLE `for_stock` DISABLE KEYS */;
INSERT INTO `for_stock` VALUES (1,'阿这','123123',12),(2,'啊这','123321',23);
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
  `order_time` float NOT NULL,
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
