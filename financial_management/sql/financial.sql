/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-01 09:46:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
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

-- ----------------------------
-- Records of article
-- ----------------------------

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

-- ----------------------------
-- Records of bond
-- ----------------------------

-- ----------------------------
-- Table structure for bond_and_fund
-- ----------------------------
DROP TABLE IF EXISTS `bond_and_fund`;
CREATE TABLE `bond_and_fund` (
  `fund_id` bigint(255) DEFAULT NULL,
  `bond_id` bigint(255) DEFAULT NULL,
  `investment_proportion` float DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_and_fund
-- ----------------------------

-- ----------------------------
-- Table structure for bond_foundation
-- ----------------------------
DROP TABLE IF EXISTS `bond_foundation`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_foundation
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
  `payment_password` varchar(255) DEFAULT NULL,
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
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit_product
-- ----------------------------

-- ----------------------------
-- Table structure for deposit_recommend
-- ----------------------------
DROP TABLE IF EXISTS `deposit_recommend`;
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

-- ----------------------------
-- Records of deposit_recommend
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
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

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '为什么不开大？', '1', '喂，老板，他刚才又没开大；我没骂他，我上局就没骂他；这个人应该是思想出了问题', '2019-08-27 23:27:58', '1', null, null, '123456@789.com', '', '7', '2019-08-27 23:27:58', '对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区');
INSERT INTO `feedback` VALUES ('2', '一个数学问题', '1', '1+1=?', '2019-08-27 23:27:58', '1', null, null, '123456@789.com', '\0', '0', null, null);

-- ----------------------------
-- Table structure for fortune
-- ----------------------------
DROP TABLE IF EXISTS `fortune`;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fortune
-- ----------------------------
INSERT INTO `fortune` VALUES ('1', '2019-08-21', '2500', '2600', '2400', '2500', '200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-22', '2600', '2600', '2400', '2500', '400', '500', '1500');
INSERT INTO `fortune` VALUES ('2', '2019-08-28', '3000', '2600', '2400', '2500', '800', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-28', '8000', '2600', '2400', '2500', '1600', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-29', '2600', '9600', '2400', '2500', '3200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-30', '2600', '9800', '2400', '2800', '3200', '500', '1500');

-- ----------------------------
-- Table structure for for_stock
-- ----------------------------
DROP TABLE IF EXISTS `for_stock`;
CREATE TABLE `for_stock` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Records of gold
-- ----------------------------

-- ----------------------------
-- Table structure for gold_history_config
-- ----------------------------
DROP TABLE IF EXISTS `gold_history_config`;
CREATE TABLE `gold_history_config` (
  `user_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gold_history_config
-- ----------------------------
INSERT INTO `gold_history_config` VALUES ('1', '20', '4', '80', '2019-08-30 15:00:57', '0');
INSERT INTO `gold_history_config` VALUES ('1', '20', '4', '80', '2019-08-30 21:12:40', '0');
INSERT INTO `gold_history_config` VALUES ('1', '20', '4', '80', '2019-08-30 21:14:04', '0');
INSERT INTO `gold_history_config` VALUES ('1', '20', '4', '80', '2019-08-30 21:17:01', '0');
INSERT INTO `gold_history_config` VALUES ('1', '20', '20', '20', '2019-08-31 00:03:03', '0');

-- ----------------------------
-- Table structure for if_changed_email
-- ----------------------------
DROP TABLE IF EXISTS `if_changed_email`;
CREATE TABLE `if_changed_email` (
  `email` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of if_changed_email
-- ----------------------------

-- ----------------------------
-- Table structure for if_changed_password
-- ----------------------------
DROP TABLE IF EXISTS `if_changed_password`;
CREATE TABLE `if_changed_password` (
  `email` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of if_changed_password
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
  `length` int(11) DEFAULT NULL,
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
-- Table structure for max_invest
-- ----------------------------
DROP TABLE IF EXISTS `max_invest`;
CREATE TABLE `max_invest` (
  `user_id` bigint(255) NOT NULL,
  `type` varchar(45) NOT NULL,
  `max` float NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of max_invest
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
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

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '2019-08-26 23:27:58', '1', '1', '尊敬的用户，您的账户有新的调仓操作，请确认', '\0', '\0');
INSERT INTO `message` VALUES ('2', '2019-08-27 23:27:58', '1', '3', '尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区', '\0', '\0');
INSERT INTO `message` VALUES ('3', '2019-08-27 23:56:53', '2', '3', '文章：《标题1》下的评论：“评论？？？”被一举报，请去确认情况是否属实！', '\0', '\0');

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

-- ----------------------------
-- Records of my_bond
-- ----------------------------
INSERT INTO `my_bond` VALUES ('1', '8888', '200', '300', '1.5', '500', '6');

-- ----------------------------
-- Table structure for my_depo
-- ----------------------------
DROP TABLE IF EXISTS `my_depo`;
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

-- ----------------------------
-- Records of my_depo
-- ----------------------------
INSERT INTO `my_depo` VALUES ('1', '1', '1', '50', '长实储蓄', '0.56000', '2020-08-30', '2');

-- ----------------------------
-- Table structure for my_fund
-- ----------------------------
DROP TABLE IF EXISTS `my_fund`;
CREATE TABLE `my_fund` (
  `user_id` bigint(255) NOT NULL,
  `balance` float DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `pay_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_fund
-- ----------------------------
INSERT INTO `my_fund` VALUES ('1', '200', '2019-08-30', '888888');

-- ----------------------------
-- Table structure for my_gold
-- ----------------------------
DROP TABLE IF EXISTS `my_gold`;
CREATE TABLE `my_gold` (
  `user_id` bigint(255) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `diff` double DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `profit` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_gold
-- ----------------------------
INSERT INTO `my_gold` VALUES ('1', '50', '2', '66', '300');

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

-- ----------------------------
-- Records of my_ins
-- ----------------------------
INSERT INTO `my_ins` VALUES ('1', '20', '25', '2020-08-30', '30');

-- ----------------------------
-- Table structure for my_qdii
-- ----------------------------
DROP TABLE IF EXISTS `my_qdii`;
CREATE TABLE `my_qdii` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(45) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_amount` float NOT NULL,
  `purchase_total` float NOT NULL,
  `hold_price` float NOT NULL,
  `hold_amount` float NOT NULL,
  `hold_total` float NOT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_qdii
-- ----------------------------
INSERT INTO `my_qdii` VALUES ('1', '613991', '1', '1000', '1000', '99.9', '100', '999', '-1', '-0.001');

-- ----------------------------
-- Table structure for my_stock
-- ----------------------------
DROP TABLE IF EXISTS `my_stock`;
CREATE TABLE `my_stock` (
  `user_id` bigint(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `purchase_price` float NOT NULL,
  `purchase_amount` int(11) NOT NULL,
  `purchase_total` float NOT NULL,
  `hold_price` float NOT NULL,
  `hold_amount` int(11) NOT NULL,
  `hold_total` float NOT NULL,
  `profit` float DEFAULT NULL,
  `profit_rate` float DEFAULT NULL,
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_stock
-- ----------------------------
INSERT INTO `my_stock` VALUES ('1', '601991', '1', '1000', '1000', '99.9', '100', '999', '-1', '-0.001');

-- ----------------------------
-- Table structure for personal_trade
-- ----------------------------
DROP TABLE IF EXISTS `personal_trade`;
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

-- ----------------------------
-- Records of personal_trade
-- ----------------------------

-- ----------------------------
-- Table structure for platform_bond_fund
-- ----------------------------
DROP TABLE IF EXISTS `platform_bond_fund`;
CREATE TABLE `platform_bond_fund` (
  `handling_fee` float DEFAULT NULL,
  `bond_property` float DEFAULT NULL,
  `residual_property` float DEFAULT NULL,
  `return_rate_seven` float DEFAULT '0',
  `return_rate_thirty` float DEFAULT '0',
  `return_rate_ninety` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of platform_bond_fund
-- ----------------------------

-- ----------------------------
-- Table structure for platform_trade
-- ----------------------------
DROP TABLE IF EXISTS `platform_trade`;
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

-- ----------------------------
-- Records of platform_trade
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
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `user_id` bigint(255) NOT NULL,
  `funds` double DEFAULT NULL,
  `saving` double DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `stocks` double DEFAULT NULL,
  `gold` double DEFAULT NULL,
  `bond` double DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `record_time` date NOT NULL,
  `origin_assets` double NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `questionnaire_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '250', '250', '250', '250', '250', '250', '1～3个月(短期)', '2019-08-22', '1500');
INSERT INTO `questionnaire` VALUES ('2', '500', '500', '500', '500', '500', '500', '3～6个月(中期)', '2019-08-23', '3000');
INSERT INTO `questionnaire` VALUES ('3', '250', '250', '250', '250', '250', '250', '6～12个月(中长期或长期)', '2019-08-24', '1500');
INSERT INTO `questionnaire` VALUES ('4', '500', '500', '500', '500', '500', '500', '1年以上', '2019-08-29', '3000');

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `user_id` bigint(255) NOT NULL,
  `invest_analysis_tag` varchar(45) DEFAULT NULL,
  `volatility` double DEFAULT NULL,
  `yield` double DEFAULT NULL,
  `funds_rate` double DEFAULT NULL,
  `saving_rate` double DEFAULT NULL,
  `insurance_rate` double DEFAULT NULL,
  `investment_rate` double DEFAULT NULL,
  `stocks_rate` double DEFAULT NULL,
  `qdii_rate` double DEFAULT NULL,
  `gold_rate` double DEFAULT NULL,
  `bond_rate` double DEFAULT NULL,
  `total_volatility` double DEFAULT NULL,
  `total_yield` double DEFAULT NULL,
  `invest_prefer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `recommend_allocation_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('1', null, '0.5', '0.5', '0.25', '0.25', '0.25999999046325684', '0.23999999463558197', null, null, null, null, null, null, '保守型');
INSERT INTO `recommend` VALUES ('2', null, '0.5', '0.5', '0.25', '0.25', '0.25999999046325684', '0.23999999463558197', null, null, null, null, null, null, '稳健保守型');
INSERT INTO `recommend` VALUES ('3', null, '0.5', '0.5', '0.25', '0.25', '0.25999999046325684', '0.23999999463558197', null, null, null, null, null, null, '稳健型');
INSERT INTO `recommend` VALUES ('4', null, '0.5', '0.5', '0.25', '0.25', '0.25999999046325684', '0.23999999463558197', null, null, null, null, null, null, '稳健进取型');
INSERT INTO `recommend` VALUES ('5', null, '0.5', '0.5', '0.25', '0.25', '0.25999999046325684', '0.23999999463558197', null, null, null, null, null, null, '进取型');

-- ----------------------------
-- Table structure for rec_alloc
-- ----------------------------
DROP TABLE IF EXISTS `rec_alloc`;
CREATE TABLE `rec_alloc` (
  `user_id` bigint(255) NOT NULL,
  `funds_rate` float DEFAULT NULL,
  `saving_rate` float DEFAULT NULL,
  `insurance_rate` float DEFAULT NULL,
  `invest_rate` float DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `recommend_allocation_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rec_alloc
-- ----------------------------
INSERT INTO `rec_alloc` VALUES ('1', '0.5', '0.02', '0.08', '0.4');
INSERT INTO `rec_alloc` VALUES ('2', '0.8', '0.02', '0.08', '0.1');

-- ----------------------------
-- Table structure for transfer_record
-- ----------------------------
DROP TABLE IF EXISTS `transfer_record`;
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
  `password` varchar(255) DEFAULT NULL,
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
INSERT INTO `user` VALUES ('1', '320684199809070018', 'xyh', '153604998@qq.com', '18951899427', '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'xyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-17 09:58:08', 'xxx');
INSERT INTO `user` VALUES ('2', '320684199809070019', 'xxyh', '153604998@qq.comm', null, null, null, 'xxyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 14:46:34', null);
INSERT INTO `user` VALUES ('3', '320684199809070020', 'xyh', '153604998@qq.commm', null, null, null, 'xyhhhhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 14:47:10', null);
INSERT INTO `user` VALUES ('4', null, 'admin', 'admin', null, '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'admin', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-27 07:28:19', 'https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg');
UPDATE `user` SET `user_id` = '0' WHERE `email` = 'admin';

-- ----------------------------
-- Table structure for user_bond_fund
-- ----------------------------
DROP TABLE IF EXISTS `user_bond_fund`;
CREATE TABLE `user_bond_fund` (
  `user_id` bigint(255) DEFAULT NULL,
  `fund_name` varchar(255) DEFAULT NULL,
  `bond_proportion` float DEFAULT NULL,
  `fund_share` float DEFAULT NULL,
  `net_worth` float DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_bond_fund
-- ----------------------------
