/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-08 21:22:03
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
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `latest_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond
-- ----------------------------
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券1', '019613', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券2', '9802', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券3', '019320', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券4', '019587', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券5', '101801146', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券6', '1880025', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券7', '101751041', '500');
INSERT INTO `bond` (name, code, latest_price) VALUES ('债券8', '101800345', '500');

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
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (1,1,0.25,100);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (1,2,0.25,100);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (1,3,0.25,100);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (1,4,0.25,100);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (2,5,0.25,50);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (2,6,0.25,50);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (2,7,0.25,50);
insert into bond_and_fund (fund_id, bond_id, investment_proportion, amount) VALUES (2,8,0.25,50);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_foundation
-- ----------------------------
INSERT INTO `bond_foundation` VALUES ('1', 'national', '1000', '200000', '200', '0.2', '2019-09-01 16:55:49', '1000');
INSERT INTO `bond_foundation` VALUES ('2', 'corporate', '1000', '100000', '100', '0.2', '2019-09-01 16:55:49', '1000');

-- ----------------------------
-- Table structure for bond_rate_log
-- ----------------------------
DROP TABLE IF EXISTS `bond_rate_log`;
CREATE TABLE `bond_rate_log` (
  `fund_id` bigint(255) DEFAULT NULL,
  `fund_name` varchar(45) DEFAULT NULL,
  `net_worth` double DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (1, 'national', 30, '2019-09-10');
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (1, 'national', 35 '2019-09-11');
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (1, 'national', 40, '2019-09-12');
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (2, 'corporate', 30, '2019-09-10');
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (2, 'corporate', 35 '2019-09-11');
INSERT INTO `financial`.`bond_rate_log` (`fund_id`, `fund_name`, `net_worth`, `time`) VALUES (2, 'corporate', 40, '2019-09-12');

-- ----------------------------
-- Records of bond_rate_log
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dom_stock
-- ----------------------------
INSERT INTO `dom_stock` VALUES ('1', '啊啊啊啊？', '601991', '99');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fortune
-- ----------------------------
INSERT INTO `fortune` VALUES ('1', '2019-08-21', '2500', '2600', '2400', '2500', '200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-22', '2600', '2600', '2400', '2500', '400', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-28', '8000', '2600', '2400', '2500', '1600', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-29', '2600', '9600', '2400', '2500', '3200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-30', '2600', '9800', '2400', '2800', '3200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-08-31', '2600', '9800', '2400', '2800', '3200', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-09-01', '2600', '9800', '2400', '2800', '3300', '500', '1500');
INSERT INTO `fortune` VALUES ('2', '2019-09-01', '2600', '9800', '2400', '2800', '3300', '500', '1500');
INSERT INTO `fortune` VALUES ('1', '2019-09-02', '200', '50', '30', '999', '999', '66', '0');
INSERT INTO `fortune` VALUES ('2', '2019-09-02', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `fortune` VALUES ('3', '2019-09-02', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `fortune` VALUES ('1', '2019-09-05', '200', '50', '30', '999', '999', '66', '0');
INSERT INTO `fortune` VALUES ('2', '2019-09-05', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `fortune` VALUES ('3', '2019-09-05', '0', '0', '0', '0', '0', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of for_stock
-- ----------------------------
INSERT INTO `for_stock` VALUES ('1', '阿这', '123123', '12');

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `name` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table fund
	add seven_annualized float default 0 null;

alter table fund
	add fourteen_annualized float default 0 null;

alter table fund
	add twentyeight_annualized float default 0 null;

alter table fund
	add thirty_yield_rate float default 0 null;

alter table fund
	add ninty_yield_rate float default 0 null;

alter table fund
	add since_yield_rate float default 0 null;

-- ----------------------------
-- Records of fund
-- ----------------------------
INSERT INTO `fund`(`name`,`time`) VALUES ('国投瑞银钱多宝货币A','2019-09-08');

-- ----------------------------
-- Table structure for funds_and_invest_out_platform
-- ----------------------------
DROP TABLE IF EXISTS `funds_and_invest_out_platform`;
CREATE TABLE `funds_and_invest_out_platform` (
  `user_id` bigint(255) NOT NULL,
  `funds` double DEFAULT NULL,
  `invest` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of funds_and_invest_out_platform
-- ----------------------------
INSERT INTO `funds_and_invest_out_platform` VALUES ('1', '800', '500');

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
  `person_role` varchar(255) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `permiun` float DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES ('1', 'husband', '寿险', '100000', '251');
INSERT INTO `insurance` VALUES ('1', 'wife', '寿险', '100000', '251');
INSERT INTO `insurance` VALUES ('1', 'husband', '重疾险', '500000', '251');
INSERT INTO `insurance` VALUES ('1', 'wife', '重疾险', '50000', '251');
INSERT INTO `insurance` VALUES ('1', 'child_1', '寿险', '50000', '251');
INSERT INTO `insurance` VALUES ('1', 'child_2', '寿险', '50000', '251');
INSERT INTO `insurance` VALUES ('1', 'old_1', '寿险', '50000', '251');
INSERT INTO `insurance` VALUES ('1', 'old_2', '寿险', '150000', '251');
INSERT INTO `insurance` VALUES ('1', 'whole family', '车险', '50000', '251');

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
  `purchase_quantity` int(11) DEFAULT NULL,
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
  `pay_password` varchar(255) DEFAULT NULL,
  `accuring_amount` float DEFAULT 0,
  `last_revenue` float default 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_fund
-- ----------------------------
INSERT INTO `my_fund` VALUES ('1', '200', '2019-08-30', '888888', '0','0');

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
  `kind` varchar(255) DEFAULT NULL,
  `maturity` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `premiun` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_ins
-- ----------------------------

-- ----------------------------
-- Table structure for my_qdii
-- ----------------------------
DROP TABLE IF EXISTS `my_qdii`;
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

-- ----------------------------
-- Records of my_qdii
-- ----------------------------
INSERT INTO `my_qdii` VALUES ('1', '123123', '99.9', '100', '999', '-1', '-0.001');

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
  `profit` float NOT NULL DEFAULT '0',
  `profit_rate` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_stock
-- ----------------------------
INSERT INTO `my_stock` VALUES ('1', '601991', '1', '1000', '1000', '99.9', '100', '999', '-1', '-0.001');

-- ----------------------------
-- Table structure for overseas_bond_recommend
-- ----------------------------
DROP TABLE IF EXISTS `overseas_bond_recommend`;
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

-- ----------------------------
-- Records of overseas_bond_recommend
-- ----------------------------
INSERT INTO `overseas_bond_recommend` VALUES ('2', '116CN', '2.625', '2027/11/2', '20', '国债', '美元', 'CHINA GOVT INTL BOND2', '一年2次，5月2日/11月2日', 'NA/NA', '亚太(不含日本)/新\n兴市场债券', '$50,000以下：债券剩余期限<2年，0.75%；债券剩余期限>2年，1% / %50,000以上：0.5%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('3', '115CN', '2.125', '2022/11/2', '20', '国债', '美元', 'CHINA GOVT INTL BOND2', '一年2次，5月2日/11月2日', 'NA/NA', '亚太(不含日本)/新\n兴市场债券', '$50,000以下：债券剩余期限<2年，0.75%；债券剩余期限>2年，1% / %50,000以上：0.5%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('4', '118AG', '3.4', '2027/12/6\n(Callable)', '20', '高级债', '美元', 'ALIBABA GROUP HOLDING2', '一年2次，6月6日/12月6日', 'A1/A+', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('5', '117AG', '2.8', '2023/6/6\n(Callable)', '20', '高级债', '美元', 'ALIBABA GROUP HOLDING2', '一年2次，6月6日/12月6日', 'A1/A+', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('6', 'MS017', '3.95', '2027/4/23', '2', '从属债', '美元', 'MORGAN STANLEY3', '一年2次，4月23日/10月23日', 'Baa2/BBB', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('7', '361AB', '4.1', '2027/9/6', '2', '高级债', '澳元', 'FBG FINANCE PTY LTD2', '一年2次，3月6日/9月6日', 'Baa1/A-', '亚太(不含日本)/新\n兴市场债券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('8', '362LO', '4.25', '2027/11/22', '2', '高级债', '澳元', 'LLOYDS BANKING GROUP PLC3', '一年2次，5月22日/11月22日', 'A3/BBB+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('9', 'CTG01', '3M LIBOR\n+143bps', '2023/9/1\n(Callable)', '2', '高级债', '美元', 'CITIGROUP INC2', '一年4次，3月1日/6月1日/9月1日/12月1日', 'A3/BBB+', '美国/全球投资级债\n券', '$50,000以下：1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('10', 'BOC02', '3M LIBOR\n+88bps', '2022/11/22', '20', '高级债', '美元', 'BANK OF CHINA/PARIS2', '一年4次，2月22日/5月22日/8月22日/11月22日', 'A1/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下：1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('11', '101MB', '3.9', '2026/1/15', '2', '高级债', '美元', '麦格理银行MACQUARIE BANK\nLTD', '一年2次，1月15日/7月15日', 'A2/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('12', '102AG', '3.6', '2024/11/28\n(Callable)', '20', '高级债', '美元', '阿里巴巴集团控股有限公司AL IBABA GROUP HOLDING', '一年2次，5月28日/11月28日', 'A1/A+', '亚太(不含日本)/新兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('13', '103HP', '4.9', '2025/10/15\n(Callable)', '2', '高级债', '美元', '惠普企业HP ENTERPRISE CO', '一年2次，4月15日/10月15日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('14', '104FD', '4.134', '2025/8/4', '20', '高级债', '美元', '福特汽车信贷有限责任公司F ORD MOTOR CREDIT CO LLC', '一年2次，2月4日/8月4日', 'Baa3/BBB', '美国/全球投资级债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('15', '105AG', '3.75', '2025/7/10\n(Callable)', '2', '高级债', '美元', '美国国际集团AMERICAN INTL\nGROUP', '一年2次，1月10日/7月10日', 'Baa1/BBB+', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('16', '107HP', '3.6', '2020/10/15\n(Callable)', '2', '高级债', '美元', '惠普企业HP ENTERPRISE CO', '一年2次，4月15日/10月15日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('17', '108JD', '3.125', '2021/4/29', '20', '高级债', '美元', '京东JD.COM INC', '一年2次，4月29日/10月29日', 'Baa2/BBB', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('18', '109HR', '4.875', '2026/11/22', '20', '高级债', '美元', '华融HUARONG FINANCE II', '一年2次，5月22日/11月22日', 'NA/BBB+', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '3');
INSERT INTO `overseas_bond_recommend` VALUES ('19', '110CH', '4.25', '2025/4/1\n(Callable)', '2', '高级债', '美元', 'COACH INC', '一年2次，3月1日/6月1日/9月1日/12月1日', 'Baa2/BBB-', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('20', '113GS', '2.35', '2021/11/15\n(Callable)', '2', '高级债', '美元', '高盛GOLDMAN SACHS GROUP\nINC', '一年2次，3月1日/6月1日/9月1日/12月1日', 'A3/BBB+', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('21', '112EB', '2.875', '2021/8/1\n(Callable)', '2', '高级债', '美元', 'EBAY INC', '一年2次，3月1日/6月1日/9月1日/12月1日', 'Baa1/BBB+', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('22', '173LF', '5.25', '2020/5/13', '10', '高级债', '美元', '利丰有限公司LI & FUNG LTD', '一年2次，5月13日/11月13日', 'Baa3/BBB', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('23', '175MG', '6', '2020/1/14', '2', '高级债', '美元', '麦格理集团有限公司MACQUA\nRIE GROUP LTD', '一年2次，1月14日/7月14日', 'A3/BBB', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('24', '183HA', '3.625', '2020/2/7', '20', '高级债', '美元', '海南航空HAINAN AIRLINE HK', '一年2次，2月7日/8月7日', 'A1/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('25', '186CP', '3.95', '2022/4/19', '20', '高级债', '美元', '中石油CNPC GENERAL CAPITAL', '一年2次，4月19日/10月19日', 'A2/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('26', '187GS', '3.625', '2023/1/22', '2', '高级债', '美元', '高盛GOLDMAN SACHS GROUP\nINC', '一年2次，1月22日/7月22日', 'A3/BBB+', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('27', '188GE', '3.15', '2022/9/7', '2', '高级债', '美元', '通用电气GENERAL ELEC CAP\nCORP', '一年2次，3月7日/9月7日', 'Baa1/BBB+', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('28', '189DB', '3.7', '2024/5/30', '2', '高级债', '美元', '德意志银行（伦敦）DEUTSCH\nE BANK AG LONDON', '一年2次，5月30日/11月30日', 'Baa3/BBB-', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('29', '190CO', '3.95', '2022/11/15', '20', '高级债', '美元', '中国海外发展CHINA\nOVERSEAS FINANCE C', '一年2次，5月15日/11月15日', 'Baa1/BBB+', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('30', '192SO', '6', '2024/7/30', '20', '高级债', '美元', '远洋地产宝财I有限公司SINO\nOCEAN LND TRS FIN I', '一年2次，1月30日/7月30日', 'Baa3/NR', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '3');
INSERT INTO `overseas_bond_recommend` VALUES ('31', '193CD', '4.25', '2025/4/23', '20', '高级债', '美元', '中国信达融资CHINA CINDA\nFINANCE 2015', '一年2次，4月23日/10月23日', 'Baa1/A-', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('32', '195CD', '3.125', '2020/4/23', '20', '高级债', '美元', '中国信达融资CHINA CINDA\nFINANCE 2015', '一年2次，4月23日/10月23日', 'Baa1/A-', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('33', '196BD', '3', '2020/6/30', '20', '高级债', '美元', '百度BAIDU INC', '一年2次，6月30日/12月30日', 'A3/NA', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('34', '197BC', '2.875', '2020/6/30', '20', '高级债', '美元', '中国银行（香港）BANK OF\nCHINA HONG KONG', '一年2次，6月30日/12月30日', 'A1/NA', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('35', '356CC', '4.25', '2021/8/12', '3', '高级债', '澳元', '可口可乐阿马提尔有限公司C\nOCA-COLA AMATIL LTD', '一年1次，43689', 'A3/BBB+', '亚太(不含日本)/新\n兴市场债券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('36', '357AP', '3.7', '2022/8/28', '2', '高级债', '澳元', '苹果公司APPLE INC', '一年2次，2月28日/8月28日', 'Aa1/AA+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('37', '358IT', '4', '2022/12/1', '2', '高级债', '澳元', '英特尔公司INTEL CORP', '一年2次，6月1日/12月1日', 'A1/A+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('38', '359CS', '4', '2021/3/9', '2', '高级债', '澳元', '瑞士信贷银行/悉尼CREDIT\nSUISSE/SYDNEY', '一年2次，3月9日/9月9日', 'A1/A+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('39', '360CT', '3.75', '2023/10/27', '2', '高级债', '澳元', '花旗集团CITIGROUP INC', '一年2次，4月27日/10月27日', 'A3/BBB+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('40', 'BA013', '3.95', '2025/4/21', '2', '从属债', '美元', '美国银行BANK OF AMERICA\nCORP', '一年2次，4月21日/10月21日', 'Baa1/BBB+', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('41', 'BO007', '5.55', '2020/2/11', '10', '从属债', '美元', '中国银行（香港）BANK OF\nCHINA HONG KONG', '一年2次，2月11日/8月11日', 'A3/A', '亚太(不含日本)/新\n兴市场债券', '0.02', '0.005', '0.005', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('42', 'C012U', '4.05', '2022/7/30', '2', '从属债', '美元', '花旗集团CITIGROUP INC', '一年2次，1月30日/7月30日', 'Baa2/BBB', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('43', 'CT014', '3.875', '2025/3/26', '2', '从属债', '美元', '花旗集团CITIGROUP INC', '一年2次，3月26日/9月26日', 'Baa2/BBB', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('44', 'CT016', '4.3', '2026/11/20', '2', '从属债', '美元', '花旗集团CITIGROUP INC', '一年2次，5月20日/11月20日', 'Baa2/BBB', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('45', 'EA008', '6.125', '2020/7/16', '10', '从属债', '美元', '东亚银行BANK OF EAST ASIA\nLTD', '一年2次，1月16日/7月16日', 'Baa3/BBB', '亚太(不含日本)/新\n兴市场债券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('46', 'HS015', '4.25', '2024/3/14', '20', '从属债', '美元', '汇丰控股HSBC HOLDINGS PLC', '一年2次，3月14日/9月14日', 'A3/BBB+', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('47', 'MG010', '6.625', '2021/4/7', '2', '从属债', '美元', '麦格理银行MACQUARIE BANK\nLTD', '一年2次，4月7日/10月7日', 'Baa2/BBB', '亚太(不含日本)/新\n兴市场债券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('48', 'SC011', '3.95', '2023/1/11', '20', '从属债', '美元', '渣打集团STANDARD\nCHARTERED PLC', '一年2次，1月11日/7月11日', 'Baa2/BBB-', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('49', 'SG012', '4.25', '2025/4/14', '20', '从属债', '美元', '法国兴业银行SOCIETE\nGENERALE', '一年2次，4月14日/10月14日', 'Baa3/BBB', '美国/全球投资级债\n券', '0.02', '0.005', '0.005', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('50', '119BC', '2.375', '2020/2/14', '20', '高级债', '美元', '中国银行（香港）BANK OF\nCHINA/HONG KONG', '一年2次，2月14日/8月14日', 'A1/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('51', '120SC', '5.875', '2020/6/24', '10', '从属债', '美元', '渣打银行（香港）STANDARD\nCHARTERED BK HK', '一年2次，6月24日/12月24日', 'Baa1/A-', '亚太(不含日本)/新\n兴市场债券', '0.02', '0.005', '0.005', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('52', '121MB', '2.85', '2020/7/29', '2', '高级债', '美元', '麦格理银行MACQUARIE BANK\nLTD', '一年2次，1月29日/7月29日', 'A2/A', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('53', 'MQG03', '3M Libor\n+135bps', '3/27/2024\n(callable)', '2', '高级债', '美元', '麦格理集团MACQUARIE\nGROUP LTD', '一年4次，3月27日/6月27日/9月27日/12月27日', 'A3/BBB', '亚太(不含日本)/新\n兴市场债券', '$50,000以下：1.5% / $50,000以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('54', 'VOD04', '3M  Libor\n+99bps', '2024/1/16', '2', '高级债', '美元', '沃达丰集团VODAFONE\nGROUP PLC', '一年4次，4月16日/7月16日/10月16日/1月16日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下：1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('55', '122VG', '4.375', '2028/5/30', '2', '高级债', '美元', '沃达丰集团VODAFONE\nGROUP PLC', '一年2次，5月30日/11月30日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('56', '123VG', '4.125', '2025/5/30', '2', '高级债', '美元', '沃达丰集团VODAFONE\nGROUP PLC', '一年2次，5月30日/11月30日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('57', '124VG', '3.75', '2024/1/16', '2', '高级债', '美元', '沃达丰集团VODAFONE\nGROUP PLC', '一年2次，1月16日/7月16日', 'Baa2/BBB', '美国/全球投资级债\n券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '5');
INSERT INTO `overseas_bond_recommend` VALUES ('58', '125WB', '2.7', '2026/8/19', '2', '高级债', '美元', '西太平洋银行WESTPAC\nBANKING CORP', '一年2次，2月19日/8月19日', 'Aa3/AA-', '亚太(不含日本)/新\n兴市场债券', '$50,000以下，1.5% / $50,000以上，1%', '0.005', '0.0025', '4');
INSERT INTO `overseas_bond_recommend` VALUES ('59', '126DF', '4.5', '2021/9/21', '100', '高级债', '人民\n币', '戴姆勒国际金融公司 DAIMLER\nINTL FINANCE BV', '一年1次，43729', 'A2/A', '美国/全球投资级债\n券', '0.01', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('60', '127BC', '4.65', '2021/3/5', '100', '高级债', '人民\n币', '中国银行（澳门）\nBANK OF CHINA/MACAU', '一年2次，3月5日/9月5日', 'A1/A', '亚太(不含日本)/新\n兴市场债券', '0.01', '0.005', '0.0025', '1');
INSERT INTO `overseas_bond_recommend` VALUES ('61', '363LO', '4', '2025/3/7', '2', '高级债', '澳元', '劳埃德银行集团LLOYDS\nBANKING GROUP PLC', '一年2次，3月7日/9月7日', 'A3/BBB+', '美国/全球投资级债\n券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '2');
INSERT INTO `overseas_bond_recommend` VALUES ('62', '364SG', '3.925', '2023/9/20', '20', '高级债 (非优先）', '澳元', '法国兴业银行\nSOCIETE GENERALE', '一年2次，3月20日/9月20日', 'Baa2/BBB+', '美国/全球投资级债券', 'A$50,000（不含）以下，1.5% / A$50,000（含）以上，1%', '0.005', '0.0025', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal_trade
-- ----------------------------
INSERT INTO `personal_trade` VALUES ('1', null, '2019-09-01 17:09:09', '2019-09-01 17:09:20', 'DOMSTOCK', '1', '100', '12.3', '0', '1230', '1', '1', '\0');
INSERT INTO `personal_trade` VALUES ('2', null, '2019-09-01 17:09:09', '2019-09-01 17:09:20', 'GOLD', '1', '1', '100', '1', '101', '1', '1', '\0');

-- ----------------------------
-- Table structure for platform_bond_fund
-- ----------------------------
DROP TABLE IF EXISTS `platform_bond_fund`;
CREATE TABLE `platform_bond_fund` (
  `bond_property` float DEFAULT NULL,
  `residual_property` float DEFAULT NULL,
  `return_rate_seven` float DEFAULT '0',
  `return_rate_thirty` float DEFAULT '0',
  `return_rate_ninety` float DEFAULT '0',
  `commission_rate_one` float DEFAULT '0',
  `commission_rate_two` float default '0',
  `commission_rate_three` float default '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_bond_fund
-- ----------------------------
INSERT INTO `platform_bond_fund`(bond_property,residual_property) VALUES ( '300000', '10000');

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
-- Table structure for qdii_adjustment
-- ----------------------------
DROP TABLE IF EXISTS `qdii_adjustment`;
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

-- ----------------------------
-- Records of qdii_adjustment
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
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

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
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

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('1', null, null, null, null, null, null, '保守型', null, null, null, null, null, null);

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
-- Table structure for stock_adjustment
-- ----------------------------
DROP TABLE IF EXISTS `stock_adjustment`;
CREATE TABLE `stock_adjustment` (
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stock_code` varchar(6) NOT NULL,
  `stockname` varchar(50) NOT NULL,
  `account_deployed_change` int(11) NOT NULL,
  `m_already_deployed` float NOT NULL,
  `price_deployed` float NOT NULL,
  PRIMARY KEY (`date`,`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock_adjustment
-- ----------------------------

-- ----------------------------
-- Table structure for transfer_record
-- ----------------------------
DROP TABLE IF EXISTS `transfer_record`;
CREATE TABLE `transfer_record` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(255) NOT NULL,
  `is_checked` bit(1) NOT NULL DEFAULT b'0',
  `is_denied` bit(1) NOT NULL DEFAULT b'0',
  `is_customize` bit(1) NOT NULL DEFAULT b'0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------

DROP TABLE IF EXISTS `transfer_message`;
CREATE TABLE `transfer_message` (
    `trans_id` bigint(255) NOT NULL,
    `message_id` bigint(255) NOT NULL,
    CONSTRAINT `fk_transfer` FOREIGN KEY (`trans_id`) REFERENCES `financial`.`transfer_record` (`id`)
        ON DELETE CASCADE,
    CONSTRAINT `fk_message` FOREIGN KEY (`message_id`) REFERENCES `financial`.`message` (`id`)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user`
--

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', null, 'admin', 'admin', null, '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'admin', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-27 07:28:19', 'https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg');
INSERT INTO `user` VALUES ('1', '320684199809070018', 'xyh', '153604998@qq.com', '18951899427', '9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc', null, 'xyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-17 09:58:08', 'xxx');
INSERT INTO `user` VALUES ('2', '320684199809070019', 'xxyh', '153604998@qq.comm', null, null, null, 'xxyhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 14:46:34', null);
INSERT INTO `user` VALUES ('3', '320684199809070020', 'xyh', '153604998@qq.commm', null, null, null, 'xyhhhhhh', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '2019-08-20 14:47:10', null);
UPDATE `user` SET `user_id` = '0' WHERE `email` = 'admin';

-- ----------------------------
-- Table structure for user_bond_fund
-- ----------------------------
DROP TABLE IF EXISTS `user_bond_fund`;
CREATE TABLE `user_bond_fund` (
  `user_id` bigint(255) DEFAULT NULL,
  `fund_name` varchar(255) DEFAULT NULL,
  `bond_proportion` double DEFAULT NULL,
  `fund_share` double DEFAULT NULL,
  `net_worth` double DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `inject` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_bond_fund
-- ----------------------------
