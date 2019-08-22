/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-21 20:56:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `md_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `html_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `category` int(11) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `pageviews` bigint(255) unsigned DEFAULT '0',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '标题1', '摘要1', null, '内容1', '1', '金融,理财', '1', '2019-08-21 20:16:15');
INSERT INTO `article` VALUES ('2', '标题2', '摘要2', null, '内容2', '1', '金融', '5', '2019-08-21 20:16:26');
INSERT INTO `article` VALUES ('3', '标题3', '摘要3', null, '内容3', '2', '科技', '3', '2019-08-21 20:16:29');
INSERT INTO `article` VALUES ('7', 'hhh', '3206841998090700', 'aDSaaaa', '153604998@qq.com', '1', '', '0', '2019-08-21 20:31:53');

-- ----------------------------
-- Table structure for bond
-- ----------------------------
DROP TABLE IF EXISTS `bond`;
CREATE TABLE `bond` (
  `id` bigint(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `bond` values ('1','19国债10','019620','100.0');
insert into `bond` values ('2','19国债20','019621','1000.0');

-- ----------------------------
-- Records of bond
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `user_id` varchar(45) DEFAULT NULL,
  `cardnum` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for cash
-- ----------------------------
DROP TABLE IF EXISTS `cash`;
CREATE TABLE `cash` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `payment_password` varchar(255),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cash
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `user_id` bigint(255) NOT NULL,
  `article_id` bigint(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('5', '1');
INSERT INTO `collection` VALUES ('5', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) DEFAULT NULL,
  `article_id` bigint(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '5', '1', '评论！！！', '2019-08-18 23:08:17');
INSERT INTO `comment` VALUES ('2', '5', '1', '评论？？？', '2019-08-18 23:08:41');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of deposit
-- ----------------------------

-- ----------------------------
-- Table structure for deposit_product
-- ----------------------------
DROP TABLE IF EXISTS `deposit_product`;
CREATE TABLE `deposit_product` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `deposit_product` values ('1','产品1','类型1','0.0575','365');
insert into `deposit_product` values ('2','产品2','克苏鲁','0.0175','200');
insert into `deposit_product` values ('3','产品3','花旗杯','0.025','365');

-- ----------------------------
-- Records of deposit_product
-- ----------------------------

-- ----------------------------
-- Table structure for dom_stock
-- ----------------------------
DROP TABLE IF EXISTS `dom_stock`;
CREATE TABLE `dom_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `dom_stock` values ('1','大唐发电','601991','4.06');
insert into `dom_stock` values ('2','东方财富','300059','13.82');

-- ----------------------------
-- Records of dom_stock
-- ----------------------------

-- ----------------------------
-- Table structure for for_stock
-- ----------------------------
DROP TABLE IF EXISTS `for_stock`;
CREATE TABLE `for_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `for_stock` values ('1','外唐发电','613991','14.06');
insert into `for_stock` values ('2','外方财富','000000','113.82');

-- ----------------------------
-- Records of for_stock
-- ----------------------------

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `name` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `fund` values ('并夕夕','0.0548','2019-03-02');

-- ----------------------------
-- Records of fund
-- ----------------------------

-- ----------------------------
-- Table structure for gold
-- ----------------------------
DROP TABLE IF EXISTS `gold`;
CREATE TABLE `gold` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `gold` values ('1','国际现货黄金','XAUUSD','1513.26');

-- ----------------------------
-- Records of gold
-- ----------------------------

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------

-- ----------------------------
-- Table structure for ins_product
-- ----------------------------
DROP TABLE IF EXISTS `ins_product`;
CREATE TABLE `ins_product` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `compensation` float DEFAULT NULL,
  `length` int ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `ins_product` values ('1','金盛人寿','分红险','30000','2000','365');
insert into `ins_product` values ('2','英大泰和','全能险','25000','1400','365');


-- ----------------------------
-- Records of ins_product
-- ----------------------------

-- ----------------------------
-- Table structure for investment
-- ----------------------------
DROP TABLE IF EXISTS `investment`;
CREATE TABLE `investment` (
  `user_id` bigint(255) NOT NULL,
  `amount` float DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of investment
-- ----------------------------

-- ----------------------------
-- Table structure for light
-- ----------------------------
DROP TABLE IF EXISTS `light`;
CREATE TABLE `light` (
  `user_id` bigint(255) NOT NULL,
  `comment_id` bigint(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of light
-- ----------------------------
INSERT INTO `light` VALUES ('5', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `is_read` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for my_bond
-- ----------------------------
DROP TABLE IF EXISTS `my_bond`;
CREATE TABLE `my_bond` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_bond` values ('5','019620','30000','100','0.003','23000','234234');

-- ----------------------------
-- Records of my_bond
-- ----------------------------

-- ----------------------------
-- Table structure for my_depo
-- ----------------------------
DROP TABLE IF EXISTS `my_depo`;
CREATE TABLE `my_depo` (
  `user_id` bigint(255) NOT NULL,
  `product_id` bigint(255) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `maturity` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_depo` values ('5','1','20000','2019-08-19');
insert into `my_depo` values ('5','2','1000','2019-08-19');

-- ----------------------------
-- Records of my_depo
-- ----------------------------

-- ----------------------------
-- Table structure for my_fund
-- ----------------------------
DROP TABLE IF EXISTS `my_fund`;
CREATE TABLE `my_fund` (
  `user_id` bigint(255) NOT NULL,
  `balance` float DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `pay_password` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_fund` values ('5','2000.0','2019-08-22','123456');

-- ----------------------------
-- Records of my_fund
-- ----------------------------

-- ----------------------------
-- Table structure for my_gold
-- ----------------------------
DROP TABLE IF EXISTS `my_gold`;
CREATE TABLE `my_gold` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_gold` values('5','XAUUSD','20000','200','0.03','2000','23123');

-- ----------------------------
-- Records of my_gold
-- ----------------------------

-- ----------------------------
-- Table structure for my_ins
-- ----------------------------
DROP TABLE IF EXISTS `my_ins`;
CREATE TABLE `my_ins` (
  `user_id` bigint(255) NOT NULL,
  `beneficiary` varchar(255) DEFAULT NULL,
  `product_id` bigint(255) DEFAULT NULL,
  `maturity` date DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_ins` values ('5','cxk','1','2019-02-12','20000');

-- ----------------------------
-- Records of my_ins
-- ----------------------------

-- ----------------------------
-- Table structure for my_stock
-- ----------------------------
DROP TABLE IF EXISTS `my_stock`;
CREATE TABLE `my_stock` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `my_stock` values ('5','601991','20003','2123','0.043','200','23133');
insert into `my_stock` values ('5','000000','123123','2333','0.013','200','23133');
-- ----------------------------
-- Records of my_stock
-- ----------------------------

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `user_id` bigint(255) NOT NULL,
  `admin_id` bigint(255) NOT NULL,
  `view_type` varchar(45) DEFAULT NULL,
  `pro_or_invest` varchar(45) DEFAULT NULL,
  `asset_type` varchar(45) DEFAULT NULL,
  `prefers` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property
-- ----------------------------

-- ----------------------------
-- Table structure for trade_record
-- ----------------------------
DROP TABLE IF EXISTS `trade_record`;
CREATE TABLE `trade_record` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `trade_id` bigint(255) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `complete_time` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_customize` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_record
-- ----------------------------

-- ----------------------------
-- Table structure for transfer_record
-- ----------------------------
DROP TABLE IF EXISTS `transfer_record`;
CREATE TABLE `transfer_record` (
  `id` bigint(255) NOT NULL,
  `create_time` date DEFAULT NULL,
  `complete_time` date DEFAULT NULL,
  `sell_type` int(11) DEFAULT NULL,
  `buy_type` int(11) DEFAULT NULL,
  `user_id` bigint(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_customize` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `identity_num` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_num` varchar(45) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `perms` varchar(45) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `status` int(255) unsigned zerofill DEFAULT '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `profile_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '320684199809070018', 'xyh', '153604998@qq.com', '18951899427', '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'xyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-17 17:58:08', 'xxx');
INSERT INTO `user` VALUES ('6', '320684199809070019', 'xxyh', '153604998@qq.comm', null, null, null, 'xxyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 22:46:34', null);
INSERT INTO `user` VALUES ('7', '320684199809070020', 'xyh', '153604998@qq.commm', null, null, null, 'xyhhhhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 22:47:10', null);
