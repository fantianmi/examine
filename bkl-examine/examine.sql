/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : examine

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2014-09-29 13:42:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `arctype`
-- ----------------------------
DROP TABLE IF EXISTS `arctype`;
CREATE TABLE `arctype` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `reid` smallint(5) NOT NULL,
  `sortrank` smallint(5) NOT NULL,
  `defaultname` char(30) NOT NULL,
  `issend` smallint(6) NOT NULL,
  `corank` smallint(6) NOT NULL,
  `description` char(150) NOT NULL,
  `keywords` varchar(60) NOT NULL,
  `siteurl` char(50) NOT NULL,
  `sitepath` char(60) NOT NULL,
  `channel` smallint(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arctype
-- ----------------------------
INSERT INTO `arctype` VALUES ('2', '0', '0', '金融类', '0', '0', 'Financial', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('3', '0', '0', '财会类', '0', '0', 'Accounting class', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('4', '0', '0', '工程类', '0', '0', 'Engineering', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('5', '0', '0', '医药类', '0', '0', 'Pharmaceutical', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('6', '0', '0', '资格类', '0', '0', 'Eligibility category', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('7', '0', '0', '外贸类', '0', '0', 'Trade Class', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('8', '0', '0', '计算机类', '0', '0', 'Computer classes', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('9', '0', '0', '其他类', '0', '0', 'Other categories', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('10', '4', '0', '一级建造师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('11', '4', '0', '二级建造师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('12', '4', '0', '安全工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('13', '4', '0', '结构工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('14', '4', '0', '造价工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('15', '4', '0', '环保工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('16', '4', '0', '质量工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('17', '11', '0', '建筑工程法规及相关知识', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('18', '11', '0', '建筑工程施工管理', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('19', '11', '0', '公路工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('20', '11', '0', '水利水电工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('21', '11', '0', '市政府公用管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('22', '11', '0', '机电工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('23', '11', '0', '矿业管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '0');
INSERT INTO `arctype` VALUES ('24', '0', '0', '金融类', '0', '0', 'Financial', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('25', '0', '0', '财会类', '0', '0', 'Accounting class', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('26', '0', '0', '工程类', '0', '0', 'Engineering', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('27', '0', '0', '医药类', '0', '0', 'Pharmaceutical', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('28', '0', '0', '资格类', '0', '0', 'Eligibility category', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('29', '0', '0', '外贸类', '0', '0', 'Trade Class', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('30', '0', '0', '计算机类', '0', '0', 'Computer classes', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('31', '0', '0', '其他类', '0', '0', 'Other categories', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('32', '4', '0', '一级建造师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('33', '4', '0', '二级建造师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('34', '4', '0', '安全工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('35', '4', '0', '结构工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('36', '4', '0', '造价工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('37', '4', '0', '环保工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('38', '4', '0', '质量工程师', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('39', '11', '0', '建筑工程法规及相关知识', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('40', '11', '0', '建筑工程施工管理', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('41', '11', '0', '公路工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('42', '11', '0', '水利水电工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('43', '11', '0', '市政府公用管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('44', '11', '0', '机电工程管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');
INSERT INTO `arctype` VALUES ('45', '11', '0', '矿业管理与务实', '0', '0', 'description', 'keywords', 'siteurl', 'sitepath', '1');

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1表示人民币充值，2表示人民币取现，3表示BTC充值，4表示BTC取现，5表示BTC买入，6表示BTC卖出',
  `ctime` int(11) DEFAULT NULL,
  `btc_amount` decimal(65,4) DEFAULT NULL COMMENT 'btc交易的金额',
  `rmb_amount` decimal(65,4) DEFAULT NULL COMMENT '人民币交易的金额',
  `btc_account` decimal(65,4) DEFAULT NULL COMMENT '用户btc余额',
  `rmb_account` decimal(65,4) DEFAULT NULL COMMENT '用户人民币余额',
  `trade_id` int(11) DEFAULT NULL COMMENT '交易id',
  `status` tinyint(4) DEFAULT NULL COMMENT '0表示未确认，1表示成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户帐户清单';

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('00000000002', '3', '1', '1411382922', '0.0000', '500.5100', '0.0000', '500.5100', '0', '0');
INSERT INTO `bill` VALUES ('00000000003', '3', '1', '1411382925', '0.0000', '22000.0000', '0.0000', '22500.5100', '0', '0');
INSERT INTO `bill` VALUES ('00000000004', '3', '2', '1411383079', '0.0000', '-2000.0000', '0.0000', '20500.5100', '0', '0');

-- ----------------------------
-- Table structure for `billdetail`
-- ----------------------------
DROP TABLE IF EXISTS `billdetail`;
CREATE TABLE `billdetail` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '1表示人民币充值，2表示人民币取现，3表示BTC充值，4表示BTC取现，5表示BTC买入委托,6表示BTC卖出委托，7表示BTC买入交易,8表示BTC卖出交易,9表示取消btc买入委托,10表示取消btc卖出委托,11表示保存人民币提现,12表示取消人民币取现,13表示保存btc提现,14表示取消btc取现',
  `typestring` varchar(255) DEFAULT NULL COMMENT 'type的中文显示',
  `user_id` int(20) DEFAULT NULL,
  `ctime` int(11) DEFAULT NULL,
  `rmb_amount` decimal(65,4) DEFAULT NULL COMMENT '可用人民币交易的金额',
  `rmb_frozen_amount` decimal(65,4) DEFAULT NULL COMMENT '冻结人民币交易的金额',
  `btc_amount` decimal(65,4) DEFAULT NULL COMMENT '可用btc交易的金额',
  `btc_frozen_amount` decimal(65,4) DEFAULT NULL COMMENT '冻结btc交易的金额',
  `rmb_account` decimal(65,4) DEFAULT NULL COMMENT '用户人民币可用余额',
  `rmb_frozen_account` decimal(65,4) DEFAULT NULL COMMENT '用户人民币冻结的余额',
  `btc_account` decimal(65,4) DEFAULT NULL COMMENT '用户btc可用余额',
  `btc_frozen_account` decimal(65,4) DEFAULT NULL COMMENT '用户btc冻结的余额',
  `refid` bigint(20) DEFAULT '0' COMMENT '1表示人民币充值(cash表id)，2表示人民币取现(cash表id)，3表示BTC充值(transfer表id)，4表示BTC取现(transfer表id)，5表示BTC买入委托(trade表id),6表示BTC卖出委托(trade表id)，7表示BTC买入交易(deal表id),8表示BTC卖出交易(deal表id),9表示取消btc买入委托(trade表id),10表示取消btc卖出委托(trade表id),11表示保存人民币提现(无),12表示取消人民币取现(cash表id),13表示保存btc提现(无),14表示取消btc取现(transfer表id)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统流水';

-- ----------------------------
-- Records of billdetail
-- ----------------------------
INSERT INTO `billdetail` VALUES ('00000000002', '1', '人民币充值', '3', '1411382922', '500.5100', '0.0000', '0.0000', '0.0000', '500.5100', '0.0000', '0.0000', '0.0000', '3');
INSERT INTO `billdetail` VALUES ('00000000003', '1', '人民币充值', '3', '1411382925', '22000.0000', '0.0000', '0.0000', '0.0000', '22500.5100', '0.0000', '0.0000', '0.0000', '2');
INSERT INTO `billdetail` VALUES ('00000000004', '5', 'BTC买入委托', '3', '1411382973', '-4000.0000', '4000.0000', '0.0000', '0.0000', '18500.5100', '4000.0000', '0.0000', '0.0000', '0');
INSERT INTO `billdetail` VALUES ('00000000005', '11', '人民币提现保存', '3', '1411383060', '-2000.0000', '2000.0000', '0.0000', '0.0000', '16500.5100', '6000.0000', '0.0000', '0.0000', '0');
INSERT INTO `billdetail` VALUES ('00000000006', '2', '人民币取现确认', '3', '1411383079', '0.0000', '-2000.0000', '0.0000', '0.0000', '16500.5100', '4000.0000', '0.0000', '0.0000', '4');

-- ----------------------------
-- Table structure for `cash`
-- ----------------------------
DROP TABLE IF EXISTS `cash`;
CREATE TABLE `cash` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `amount` decimal(65,4) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bank` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '银行',
  `card` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '卡号',
  `admin_id` int(11) NOT NULL COMMENT '卡号',
  `ctime` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '0表示未支付，1表示充值成功',
  `type` tinyint(4) DEFAULT NULL COMMENT '1表示人民币充值，2表示人民币取现',
  `fin_type` tinyint(4) DEFAULT '4',
  `bank_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='人民币充值';

-- ----------------------------
-- Records of cash
-- ----------------------------
INSERT INTO `cash` VALUES ('2', '3', '22000.0000', '', '', '', '1', '1411382816', '1', '1', '0', null, null);
INSERT INTO `cash` VALUES ('3', '3', '500.5100', '毛宜杰', '支付宝', 'airjordanmao@163.com', '1', '1411382863', '1', '1', '4', null, null);
INSERT INTO `cash` VALUES ('4', '3', '2000.0000', '毛宜杰', '建设银行', '1234 5612 3', '1', '1411383060', '1', '2', '4', '123123123', '18688164055');

-- ----------------------------
-- Table structure for `deal`
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_trade` int(11) NOT NULL,
  `sell_trade` int(11) NOT NULL,
  `ctime` int(11) NOT NULL,
  `amount` decimal(65,4) NOT NULL,
  `price` decimal(65,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of deal
-- ----------------------------

-- ----------------------------
-- Table structure for `extra_coin_ajust`
-- ----------------------------
DROP TABLE IF EXISTS `extra_coin_ajust`;
CREATE TABLE `extra_coin_ajust` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ctime` int(11) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `btc` decimal(64,4) DEFAULT NULL,
  `btc_extra` decimal(64,4) DEFAULT NULL,
  `btc_amount` decimal(64,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extra_coin_ajust
-- ----------------------------

-- ----------------------------
-- Table structure for `extra_rmb_ajust`
-- ----------------------------
DROP TABLE IF EXISTS `extra_rmb_ajust`;
CREATE TABLE `extra_rmb_ajust` (
  `id` int(11) NOT NULL,
  `ctime` int(11) DEFAULT NULL,
  `rmb` int(11) NOT NULL,
  `btc_extra` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extra_rmb_ajust
-- ----------------------------

-- ----------------------------
-- Table structure for `handout`
-- ----------------------------
DROP TABLE IF EXISTS `handout`;
CREATE TABLE `handout` (
  `id` mediumint(9) NOT NULL,
  `typeid` smallint(6) NOT NULL,
  `redirecturl` varchar(255) NOT NULL,
  `userip` char(15) NOT NULL,
  `sortrank` int(11) NOT NULL,
  `click` int(11) NOT NULL,
  `shorttitle` varchar(36) NOT NULL,
  `source` varchar(50) NOT NULL,
  `pubdate` int(11) NOT NULL,
  `senddate` int(11) NOT NULL,
  `keywords` varchar(60) DEFAULT NULL,
  `postnum` int(11) DEFAULT NULL,
  `likeid` varchar(240) DEFAULT NULL,
  `hid` mediumint(9) NOT NULL,
  `mid` mediumint(9) NOT NULL,
  `free` smallint(6) NOT NULL,
  `price` decimal(30,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of handout
-- ----------------------------
INSERT INTO `handout` VALUES ('1', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('2', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('3', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('4', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('5', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('6', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('7', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('8', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('9', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('10', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('11', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('12', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('13', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');
INSERT INTO `handout` VALUES ('14', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '3', '1', '0.00');

-- ----------------------------
-- Table structure for `help`
-- ----------------------------
DROP TABLE IF EXISTS `help`;
CREATE TABLE `help` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `body` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `ctime` int(11) DEFAULT NULL,
  `sort` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of help
-- ----------------------------

-- ----------------------------
-- Table structure for `media`
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(100) NOT NULL,
  `readURL` varchar(300) NOT NULL,
  `downloadURL` varchar(300) NOT NULL,
  `thumbnails` char(100) DEFAULT NULL,
  `uptime` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `duration` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES ('3', 'picdoc.doc', 'upload//transferFile/picdoc.htm', 'upload/picdoc.doc', 'img/icon/tdoc_default.jpg', '2014', '0', null);
INSERT INTO `media` VALUES ('4', 'test1.doc', 'upload//transferFile/test1.htm', 'upload/test1.doc', 'img/icon/tdoc_default.jpg', '2014', '0', null);
INSERT INTO `media` VALUES ('5', 'yingyutucao.mp4', 'upload/video/yingyutucao.mp4', 'upload/video/yingyutucao.mp4', 'img/icon/video_icon.jpg', '2014', '1', '4:39');
INSERT INTO `media` VALUES ('6', 'guozushugeitaiguo.mp4', 'upload/video/guozushugeitaiguo.mp4', 'upload/video/guozushugeitaiguo.mp4', 'img/icon/video_icon.jpg', '2014', '1', '4:39');

-- ----------------------------
-- Table structure for `plantrade`
-- ----------------------------
DROP TABLE IF EXISTS `plantrade`;
CREATE TABLE `plantrade` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` int(11) NOT NULL,
  `trade_type` int(2) NOT NULL,
  `deal_price` decimal(65,4) NOT NULL,
  `price` decimal(65,4) NOT NULL,
  `quantity` decimal(65,4) NOT NULL,
  `total_price` decimal(65,4) NOT NULL,
  `status` int(2) NOT NULL,
  `effective_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plantrade
-- ----------------------------

-- ----------------------------
-- Table structure for `recommend_detail`
-- ----------------------------
DROP TABLE IF EXISTS `recommend_detail`;
CREATE TABLE `recommend_detail` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `recommended_id` int(11) NOT NULL,
  `btc_amount` decimal(64,4) DEFAULT '0.0000',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0代表未支付;1代表已经支付.',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommend_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `subscribe`
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `price` decimal(65,4) DEFAULT NULL,
  `amount` decimal(65,4) DEFAULT NULL,
  `ctime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subscribe
-- ----------------------------

-- ----------------------------
-- Table structure for `systemconfig`
-- ----------------------------
DROP TABLE IF EXISTS `systemconfig`;
CREATE TABLE `systemconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `configKey` varchar(255) NOT NULL,
  `configValue` varchar(1000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemconfig
-- ----------------------------

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '1表示比特币买入，2表示比特币卖出',
  `amount` decimal(65,4) unsigned NOT NULL COMMENT '比特币数量',
  `price` decimal(65,4) NOT NULL COMMENT '比特币价格',
  `deal` decimal(65,4) NOT NULL DEFAULT '0.0000' COMMENT '已经成交的数量,deal=amount表示完全成交',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未成交，1表示全部成交,2表示撤单',
  `ctime` int(11) NOT NULL COMMENT '创建时间',
  `etime` int(11) NOT NULL COMMENT '结束时间',
  `user_id` int(11) NOT NULL,
  `deal_rmb` decimal(65,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='比特币买入卖出记录';

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('2', '1', '2.0000', '2000.0000', '0.0000', '0', '1411382972', '0', '3', '0.0000');

-- ----------------------------
-- Table structure for `transfer`
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txid` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '交易事务ID',
  `user_id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount` decimal(65,4) NOT NULL,
  `admin_id` int(11) NOT NULL DEFAULT '0',
  `ctime` int(11) NOT NULL,
  `type` int(10) DEFAULT NULL COMMENT '1是btc充值，2是btc取现',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未确认，1表示已确认，2表示已取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of transfer
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `reg_ip` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '注册ip',
  `pin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '昵称',
  `ctime` int(11) NOT NULL,
  `rmb` decimal(65,4) NOT NULL DEFAULT '0.0000' COMMENT '可用的rmb金额',
  `rmb_frozen` decimal(65,4) NOT NULL DEFAULT '0.0000' COMMENT '冻结的rmb金额',
  `email_validated` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示邮箱未验证，1表示邮箱已经验证',
  `realname_validated` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未进行实名验证，1表示已经实名验证，2表示实名认证不通过',
  `mobile_validated` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示手机未验证，1表示手机已经验证',
  `secret` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `received` decimal(65,4) NOT NULL DEFAULT '0.0000',
  `bank_account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `identity_type` tinyint(4) DEFAULT '0' COMMENT '证件类型',
  `identity_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件号',
  `frozen` tinyint(4) DEFAULT '0' COMMENT '1表示用户被冻结;0表示用户状态正常',
  `passwd_modify_overtime` int(11) DEFAULT NULL COMMENT '忘记密码的修改限期',
  `bank_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` mediumint(9) NOT NULL,
  `typeid` smallint(6) NOT NULL,
  `redirecturl` varchar(255) NOT NULL,
  `userip` char(15) NOT NULL,
  `sortrank` int(11) NOT NULL,
  `click` int(11) NOT NULL,
  `shorttitle` varchar(36) NOT NULL,
  `source` varchar(50) NOT NULL,
  `pubdate` int(11) NOT NULL,
  `senddate` int(11) NOT NULL,
  `keywords` varchar(60) NOT NULL,
  `postnum` int(11) NOT NULL,
  `likeid` varchar(240) NOT NULL,
  `hid` mediumint(9) NOT NULL,
  `mid` int(11) NOT NULL,
  `free` int(11) NOT NULL,
  `price` decimal(30,2) DEFAULT NULL,
  `description` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('2', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('3', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('4', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('5', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('6', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('7', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('8', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('9', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('10', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('11', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('12', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('13', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('14', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('15', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '5', '1', '0.00', '北大教授专业讲授');
INSERT INTO `video` VALUES ('16', '17', 'index.html', '0.0.0.0', '0', '10', '二级建造师法规及相关知识历年真题解析', '平台资源', '1411382816', '1411382816', '二级建造师', '10', '3 4', '10', '6', '1', '0.00', '北大教授专业讲授');
