/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-29 10:07:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` bigint(255) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_admin_id_uindex` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('888');

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

-- ----------------------------
-- Records of bond
-- ----------------------------
INSERT INTO `bond` VALUES ('1', '19国债10', '019620', '100');
INSERT INTO `bond` VALUES ('2', '19国债20', '019621', '1000');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit_product
-- ----------------------------
INSERT INTO `deposit_product` VALUES ('1', '产品1', '类型1', '0.0575', '365');
INSERT INTO `deposit_product` VALUES ('2', '产品2', '克苏鲁', '0.0175', '200');
INSERT INTO `deposit_product` VALUES ('3', '产品3', '花旗杯', '0.025', '365');

-- ----------------------------
-- Table structure for deposit_recommend
-- ----------------------------
DROP TABLE IF EXISTS `deposit_recommend`;
CREATE TABLE `deposit_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `rate` double(5,0) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `
start_amount` double(2,0) DEFAULT NULL,
  `
risk_level` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dom_stock
-- ----------------------------
INSERT INTO `dom_stock` VALUES ('1', '大唐发电', '601991', '4.06');
INSERT INTO `dom_stock` VALUES ('2', '东方财富', '300059', '13.82');

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
INSERT INTO `feedback` VALUES ('1', '为什么不开大？', '1', '喂，老板，他刚才又没开大；我没骂他，我上局就没骂他；这个人应该是思想出了问题', '2019-08-27 15:27:58', '1', null, null, '123456@789.com', '', '7', '2019-08-27 15:27:58', '对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区');
INSERT INTO `feedback` VALUES ('2', '一个数学问题', '1', '1+1=?', '2019-08-27 15:27:58', '1', null, null, '123456@789.com', '\0', '0', null, null);

-- ----------------------------
-- Table structure for fortune
-- ----------------------------
DROP TABLE IF EXISTS `fortune`;
CREATE TABLE `fortune` (
  `user_id` bigint(255) NOT NULL,
  `record_date` date NOT NULL,
  `funds` float DEFAULT NULL,
  `saving` float DEFAULT NULL,
  `insurance` float DEFAULT NULL,
  `stocks` float DEFAULT NULL,
  `gold` float DEFAULT NULL,
  `bond` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fortune
-- ----------------------------
INSERT INTO `fortune` VALUES ('1', '2019-08-01', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-02', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-03', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-04', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-05', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-22', '25', '30', '25', '50', '60', '80');
INSERT INTO `fortune` VALUES ('1', '2019-08-23', '28', '30', '25', '80', '60', '80');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of for_stock
-- ----------------------------
INSERT INTO `for_stock` VALUES ('1', '外唐发电', '613991', '14.06');
INSERT INTO `for_stock` VALUES ('2', '外方财富', '000000', '113.82');

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
INSERT INTO `fund` VALUES ('并夕夕', '0.0548', '2019-03-02');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gold
-- ----------------------------
INSERT INTO `gold` VALUES ('1', '国际现货黄金', 'XAUUSD', '1513.26');

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
INSERT INTO `if_changed_email` VALUES ('153604998@qq.com', '3', '2019-08-22 22:38:45');

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
INSERT INTO `if_changed_password` VALUES ('153604998@qq.com', '3', '2019-08-22 22:39:17');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ins_product
-- ----------------------------
INSERT INTO `ins_product` VALUES ('1', '金盛人寿', '分红险', '30000', '2000', '365');
INSERT INTO `ins_product` VALUES ('2', '英大泰和', '全能险', '25000', '1400', '365');

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
INSERT INTO `message` VALUES ('1', '2019-08-26 15:27:58', '1', '1', '尊敬的用户，您的账户有新的调仓操作，请确认', '', '\0');
INSERT INTO `message` VALUES ('2', '2019-08-27 15:27:58', '1', '4', '尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区', '\0', '\0');
INSERT INTO `message` VALUES ('3', '2019-08-27 15:56:53', '0', null, '文章：《标题1》下的评论：“评论？？？”被一举报，请去确认情况是否属实！', '\0', '\0');

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
INSERT INTO `my_bond` VALUES ('5', '019620', '30000', '100', '0.003', '23000', '234234');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_depo
-- ----------------------------
INSERT INTO `my_depo` VALUES ('1', '5', '1', '20000', null, null, '2019-08-19', null);
INSERT INTO `my_depo` VALUES ('2', '5', '2', '1000', null, null, '2019-08-19', null);
INSERT INTO `my_depo` VALUES ('3', '1', '0', '10000', '个人储蓄产品', '0.00000', '2019-01-02', '0.2857142857142857');
INSERT INTO `my_depo` VALUES ('4', '1', '0', '10000', '个人储蓄产品', '0.00000', '2019-01-02', '0.2857142857142857');
INSERT INTO `my_depo` VALUES ('5', '1', '1', '5000', '个人储蓄产品5', '0.38000', '2019-01-02', '0.14285714285714285');
INSERT INTO `my_depo` VALUES ('6', '1', '0', '10000', '个人储蓄产品', '1.00000', '2019-01-02', '0.2857142857142857');

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
INSERT INTO `my_fund` VALUES ('5', '2000', '2019-08-22', '123456');

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

-- ----------------------------
-- Records of my_gold
-- ----------------------------
INSERT INTO `my_gold` VALUES ('5', 'XAUUSD', '20000', '200', '0.03', '2000', '23123');

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
INSERT INTO `my_ins` VALUES ('5', 'cxk', '1', '2019-02-12', '20000');

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

-- ----------------------------
-- Records of my_stock
-- ----------------------------
INSERT INTO `my_stock` VALUES ('5', '601991', '20003', '2123', '0.043', '200', '23133');
INSERT INTO `my_stock` VALUES ('5', '000000', '123123', '2333', '0.013', '200', '23133');

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
  `funds` float DEFAULT NULL,
  `saving` float DEFAULT NULL,
  `insurance` float DEFAULT NULL,
  `stocks` float DEFAULT NULL,
  `gold` float DEFAULT NULL,
  `bond` float DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `questionnaire_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '20', '500', '30', '15', '35', '26', '6～12个月(中长期或长期)');
INSERT INTO `questionnaire` VALUES ('2', '56', '500', '30', '25', '35', '26', '6～12个月(中长期或长期)');
INSERT INTO `questionnaire` VALUES ('3', '56', '500', '30', '25', '35', '26', '6～12个月(中长期或长期)');
INSERT INTO `questionnaire` VALUES ('4', '56', '500', '30', '25', '35', '26', '6～12个月(中长期或长期)');
INSERT INTO `questionnaire` VALUES ('5', '56', '500', '30', '25', '35', '26', '6～12个月(中长期或长期)');

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
-- Table structure for personal_trade
-- ----------------------------
DROP TABLE IF EXISTS `trade_record`;

DROP TABLE IF EXISTS `personal_trade`;
CREATE TABLE `personal_trade` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `trans_id` bigint(255) NOT NULL,
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
-- Records of trade_record
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '320684199809070018', 'xyh', '153604998@qq.com', '18951899427', '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'xyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-17 17:58:08', 'xxx');
INSERT INTO `user` VALUES ('2', '320684199809070019', 'xxyh', '153604998@qq.comm', null, null, null, 'xxyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 22:46:34', null);
INSERT INTO `user` VALUES ('3', '320684199809070020', 'xyh', '153604998@qq.commm', null, null, null, 'xyhhhhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 22:47:10', null);
INSERT INTO `user` VALUES ('5', null, 'admin', 'admin', null, '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'admin', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-27 15:28:19', 'https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg');
