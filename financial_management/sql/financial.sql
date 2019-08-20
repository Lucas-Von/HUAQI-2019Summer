/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-18 10:17:33
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
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `category` int(11) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for bond
-- ----------------------------
DROP TABLE IF EXISTS `bond`;
CREATE TABLE `bond` (
  `id` bigint(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

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
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit_product
-- ----------------------------

-- ----------------------------
-- Table structure for dom_stock
-- ----------------------------
DROP TABLE IF EXISTS `dom_stock`;
CREATE TABLE `dom_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dom_stock
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) NOT NULL,
  `type` int(10) NOT NULL DEFAULT 1,
  `detail` text DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_ID` bigint(255) NOT NULL,
  `phone` varchar(30) NULL,
  `QQ` varchar(15) NULL,
  `email` varchar(100) NULL,
  `solved` bit NOT NULL DEFAULT 0,
  `solver_ID` bigint(255) NOT NULL,
  `solve_time` timestamp NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for for_stock
-- ----------------------------
DROP TABLE IF EXISTS `for_stock`;
CREATE TABLE `for_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of for_stock
-- ----------------------------

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `name` varchar(45) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fund
-- ----------------------------

-- ----------------------------
-- Table structure for gold
-- ----------------------------
DROP TABLE IF EXISTS `gold`;
CREATE TABLE `gold` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `compensation` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `is_read` bit DEFAULT NULL,
  `is_delete` bit DEFAULT NULL,
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
  `code` varchar(45) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `update_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_fund
-- ----------------------------

-- ----------------------------
-- Table structure for my_gold
-- ----------------------------
DROP TABLE IF EXISTS `my_gold`;
CREATE TABLE `my_gold` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_gold
-- ----------------------------

-- ----------------------------
-- Table structure for my_ins
-- ----------------------------
DROP TABLE IF EXISTS `my_ins`;
CREATE TABLE `my_ins` (
  `user_id` bigint(255) NOT NULL,
  `beneficiary` varchar(45) DEFAULT NULL,
  `product_id` bigint(255) DEFAULT NULL,
  `maturity` date DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_ins
-- ----------------------------

-- ----------------------------
-- Table structure for my_stock
-- ----------------------------
DROP TABLE IF EXISTS `my_stock`;
CREATE TABLE `my_stock` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `purchase_price` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `is_customize` bit DEFAULT NULL,
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
  `is_customize` bit DEFAULT NULL,
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
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '320684199809070018', 'xyh', '153604998@qq.com', '18951899427', '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'xyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-17 17:58:08');
