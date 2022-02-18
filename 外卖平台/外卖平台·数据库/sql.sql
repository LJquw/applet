/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : 外卖平台

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-08-19 10:44:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `advertisement`
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `imageid` bigint(11) DEFAULT NULL COMMENT '广告图片id',
  `foodid` bigint(11) DEFAULT NULL COMMENT '关联餐品id',
  `busid` bigint(11) DEFAULT NULL COMMENT '关联商家id',
  `adname` varchar(255) DEFAULT NULL COMMENT '广告名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of advertisement
-- ----------------------------
INSERT INTO `advertisement` VALUES ('1', '70', '46', '1', '肯德基原神联动桶');
INSERT INTO `advertisement` VALUES ('2', '71', '1', '1', '肯德基香辣鸡腿堡');
INSERT INTO `advertisement` VALUES ('3', '72', '27', '10', '豪客来至尊牛排');
INSERT INTO `advertisement` VALUES ('4', '73', '19', '12', '海底捞鸳鸯锅');
INSERT INTO `advertisement` VALUES ('5', '74', '13', '8', '兰州拉面');
INSERT INTO `advertisement` VALUES ('6', '75', '38', '6', '蜜雪冰城缤纷果汁');
INSERT INTO `advertisement` VALUES ('7', '76', '29', '14', '水果捞至尊水果拼盘');

-- ----------------------------
-- Table structure for `businesss`
-- ----------------------------
DROP TABLE IF EXISTS `businesss`;
CREATE TABLE `businesss` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `busname` varchar(255) DEFAULT NULL COMMENT '商家名称',
  `busaddress` varchar(255) DEFAULT NULL COMMENT '商家地址',
  `busexplain` varchar(255) DEFAULT NULL COMMENT '商家简介',
  `bustell` varchar(20) DEFAULT NULL COMMENT '商家电话',
  `busimgid` bigint(11) DEFAULT NULL COMMENT '图片id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of businesss
-- ----------------------------
INSERT INTO `businesss` VALUES ('1', '肯德基(KFC)', '四川省成都市成华区神奇路神奇一号商场二楼南部', '全国著名快餐店', '028-68698996', '10');
INSERT INTO `businesss` VALUES ('2', '麦当劳', '四川省成都市成华区神奇路神奇一号商场二楼北部', '全国著名快餐店', '028-89967411', '11');
INSERT INTO `businesss` VALUES ('3', '华莱士', '四川省成都市金牛区万一路万达广场一楼', '全国著名快餐店', '028-77777777', '12');
INSERT INTO `businesss` VALUES ('4', '避风塘', '四川省成都市武侯区千万路273号', '提供好喝且便宜的饮品', '028-66666666', '23');
INSERT INTO `businesss` VALUES ('5', '都可(coco)', '四川省成都市金牛区万泉路龙湖商场一楼', '提供多种多样的奶茶', '028-58964712', '24');
INSERT INTO `businesss` VALUES ('6', '蜜雪冰城', '四川省成都市成华区神奇路神奇一号商场一楼', '提供许多划算的饮品', '028-54612378', '22');
INSERT INTO `businesss` VALUES ('7', '老友记面馆', '四川省成都市青羊区超级路286号', '提供美味的面食', '028-11111111', '13');
INSERT INTO `businesss` VALUES ('8', '兰州拉面', '四川省成都市武侯区隆兴路156号', '提供美味的面食', '028-22222222', '14');
INSERT INTO `businesss` VALUES ('9', '阿香米线', '四川省成都市成华区神奇路神奇一号商场地下一层', '提供美味的面食', '028-33333333', '15');
INSERT INTO `businesss` VALUES ('10', '豪客来', '四川省成都市成华区神奇路神奇一号商场五楼', '提供美味的牛排', '028-55555555', '16');
INSERT INTO `businesss` VALUES ('11', '烤匠', '四川省成都市金牛区万一路万达广场五楼', '提供美味的烤鱼', '028-44444444', '17');
INSERT INTO `businesss` VALUES ('12', '海底捞', '四川省成都市成华区神奇路神奇一号商场四楼', '提供美味的火锅和服务', '028-88888888', '18');
INSERT INTO `businesss` VALUES ('13', '百果园', '四川省成都市成华区神奇路神奇一号商场', '提供美味的水果', '028-99999999', '19');
INSERT INTO `businesss` VALUES ('14', '水果捞', '四川省成都市金牛区万泉路龙湖商场低下一楼', '提供美味的水果', '028-10101010', '20');
INSERT INTO `businesss` VALUES ('15', '蔬东坡', '四川省成都市金牛区万泉路龙湖商场四楼', '提供美味的水果', '028-12121212', '21');

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '餐品id',
  `proexplain` varchar(255) DEFAULT NULL COMMENT '餐品介绍',
  `proprice` double(8,2) DEFAULT '0.00' COMMENT '餐品价格',
  `protypeid` bigint(11) DEFAULT NULL COMMENT '关联类型id',
  `proname` varchar(255) DEFAULT NULL COMMENT '餐品名称',
  `imageid` bigint(11) DEFAULT NULL COMMENT '关联图片id',
  `prostatus` varchar(20) DEFAULT NULL COMMENT '餐品状态',
  `busid` bigint(11) DEFAULT NULL COMMENT '关联商家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '炸鸡腿汉堡', '15.00', '2', '香辣鸡腿堡', '25', '正常', '1');
INSERT INTO `food` VALUES ('2', '牛肉+芝士', '15.00', '2', '牛肉芝士堡', '32', '正常', '2');
INSERT INTO `food` VALUES ('3', '双层牛肉饼+芝士', '15.00', '2', '双层牛肉堡', '31', '正常', '3');
INSERT INTO `food` VALUES ('4', '炸土豆条', '10.00', '2', '薯条', '26', '售罄', '1');
INSERT INTO `food` VALUES ('5', '炸鸡翅', '15.00', '2', '香辣鸡翅', '28', '正常', '1');
INSERT INTO `food` VALUES ('6', '烤鸡翅', '20.00', '2', '奥尔良鸡翅', '33', '正常', '2');
INSERT INTO `food` VALUES ('7', '炸鸡肉块', '20.00', '2', '甜辣鸡块', '29', '售罄', '2');
INSERT INTO `food` VALUES ('8', '炸鸡米花', '20.00', '2', '劲爆鸡米花', '30', '正常', '3');
INSERT INTO `food` VALUES ('9', '可乐', '7.00', '2', '可乐', '27', '正常', '3');
INSERT INTO `food` VALUES ('10', '较为清淡、吃法新奇的米线', '25.00', '4', '过桥米线', '37', '正常', '9');
INSERT INTO `food` VALUES ('11', '口味偏重的米线', '25.00', '4', '火锅米线', '38', '正常', '9');
INSERT INTO `food` VALUES ('12', '牛肉和米线', '15.00', '4', '牛肉米线', '39', '正常', '9');
INSERT INTO `food` VALUES ('13', '特色拉面', '20.00', '4', '兰州拉面', '34', '正常', '8');
INSERT INTO `food` VALUES ('14', '卤蛋青菜和面', '15.00', '4', '特色卤蛋面', '42', '正常', '7');
INSERT INTO `food` VALUES ('15', '鸡汤鸡肉和面', '15.00', '4', '特色炖鸡面', '41', '正常', '7');
INSERT INTO `food` VALUES ('16', '牛肉和面', '15.00', '4', '牛肉面', '35', '正常', '7');
INSERT INTO `food` VALUES ('17', '宽面', '15.00', '4', '刀削面', '40', '正常', '7');
INSERT INTO `food` VALUES ('18', '特色酱料和面', '15.00', '4', '杂酱面', '36', '正常', '7');
INSERT INTO `food` VALUES ('19', '淡味和辣味', '105.00', '1', '鸳鸯火锅', '43', '正常', '12');
INSERT INTO `food` VALUES ('20', '九宫格辣味', '105.00', '1', '九宫格辣味火锅', '44', '正常', '12');
INSERT INTO `food` VALUES ('21', '浓汤和麻辣', '110.00', '1', '浓汤麻辣火锅', '45', '正常', '12');
INSERT INTO `food` VALUES ('22', '特色烤鱼', '78.00', '1', '麻辣烤鱼', '46', '售罄', '11');
INSERT INTO `food` VALUES ('23', '特色烤鱼', '69.00', '1', '香辣烤鱼', '47', '正常', '11');
INSERT INTO `food` VALUES ('24', '特色烤肉', '120.00', '1', '至尊烤肉', '48', '正常', '11');
INSERT INTO `food` VALUES ('25', '特色牛排', '55.00', '1', '蒜香牛排', '49', '正常', '10');
INSERT INTO `food` VALUES ('26', '特色牛排', '60.00', '1', '香辣牛排', '50', '售罄', '10');
INSERT INTO `food` VALUES ('27', '最受欢迎的牛排', '70.00', '1', '至尊牛排', '51', '正常', '10');
INSERT INTO `food` VALUES ('28', '芒果葡萄草莓', '30.00', '5', '水果沙拉1', '52', '正常', '14');
INSERT INTO `food` VALUES ('29', '猕猴桃火龙果草莓蓝莓哈密瓜小番茄', '50.00', '5', '至尊水果拼盘', '53', '正常', '14');
INSERT INTO `food` VALUES ('30', '小番茄西瓜蓝莓', '20.00', '5', '水果沙拉2', '54', '正常', '14');
INSERT INTO `food` VALUES ('31', '苹果', '10.00', '5', '苹果', '55', '正常', '13');
INSERT INTO `food` VALUES ('32', '香蕉', '20.00', '5', '香蕉', '56', '正常', '13');
INSERT INTO `food` VALUES ('33', '橘子', '17.00', '5', '橘子', '57', '正常', '13');
INSERT INTO `food` VALUES ('34', '猕猴桃', '26.00', '5', '猕猴桃', '58', '正常', '15');
INSERT INTO `food` VALUES ('35', '草莓', '15.00', '5', '草莓', '59', '正常', '15');
INSERT INTO `food` VALUES ('36', '小番茄', '20.00', '5', '小番茄', '60', '正常', '15');
INSERT INTO `food` VALUES ('37', '咖啡奶茶冰激凌', '9.00', '3', '咖啡奶茶冰激凌', '61', '售罄', '6');
INSERT INTO `food` VALUES ('38', '西瓜橙汁火龙果', '8.00', '3', '缤纷果汁', '62', '正常', '6');
INSERT INTO `food` VALUES ('39', '草莓柠檬', '6.00', '3', '草莓柠檬汁', '63', '正常', '6');
INSERT INTO `food` VALUES ('40', '珍珠奶茶', '15.00', '3', '经典珍珠奶茶', '64', '正常', '4');
INSERT INTO `food` VALUES ('41', '橙汁', '10.00', '3', '鲜榨橙汁', '65', '正常', '4');
INSERT INTO `food` VALUES ('42', '菠萝+奶茶', '15.00', '3', '菠萝果粒奶茶', '66', '正常', '4');
INSERT INTO `food` VALUES ('43', '橙汁+柠檬', '15.00', '3', '鲜榨柠檬橙汁', '67', '正常', '5');
INSERT INTO `food` VALUES ('44', '冰激凌', '15.00', '3', '特色冰激凌', '68', '正常', '5');
INSERT INTO `food` VALUES ('45', '珍珠奶茶', '15.00', '3', '特色珍珠奶茶', '69', '正常', '5');
INSERT INTO `food` VALUES ('46', '肯德基原神联动桶', '50.00', '2', '联动珍享桶', '78', '正常', '1');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `imageurl` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `imagetitle` varchar(50) DEFAULT NULL COMMENT '图片标题',
  `imagetype` varchar(50) DEFAULT NULL COMMENT '图片类型 banner：首页轮播图 nav：菜单 head：头像 pro：餐品 bus:商家',
  `imagestate` varchar(10) DEFAULT NULL COMMENT '图片状态  1：可用  0：不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', 'banner_01.png', 'banner', 'banner', '1');
INSERT INTO `image` VALUES ('2', 'banner_02.png', 'banner', 'banner', '1');
INSERT INTO `image` VALUES ('3', 'banner_03.png', 'banner', 'banner', '1');
INSERT INTO `image` VALUES ('4', 'banner_04.png', 'banner', 'banner', '1');
INSERT INTO `image` VALUES ('5', 'nav_icon_01.png', '推荐', 'nav', '1');
INSERT INTO `image` VALUES ('6', 'nav_icon_02.png', '快餐', 'nav', '1');
INSERT INTO `image` VALUES ('7', 'nav_icon_03.png', '饮品', 'nav', '1');
INSERT INTO `image` VALUES ('8', 'nav_icon_04.png', '面食', 'nav', '1');
INSERT INTO `image` VALUES ('9', 'nav_icon_05.png', '水果', 'nav', '1');
INSERT INTO `image` VALUES ('10', 'kuaicandian1.png', 'KFC', 'bus', '1');
INSERT INTO `image` VALUES ('11', 'kuaicandian2.png', '麦当劳', 'bus', '1');
INSERT INTO `image` VALUES ('12', 'kuaicandian3.png', '华莱士', 'bus', '1');
INSERT INTO `image` VALUES ('13', 'mianguan1.png', '老友记面馆', 'bus', '1');
INSERT INTO `image` VALUES ('14', 'mianguan2.png', '兰州拉面', 'bus', '1');
INSERT INTO `image` VALUES ('15', 'mianguan3.png', '阿香米线', 'bus', '1');
INSERT INTO `image` VALUES ('16', 'qitadian1.png', '豪客来', 'bus', '1');
INSERT INTO `image` VALUES ('17', 'qitadian2.png', '烤匠', 'bus', '1');
INSERT INTO `image` VALUES ('18', 'qitadian3.png', '海底捞', 'bus', '1');
INSERT INTO `image` VALUES ('19', 'shuiguodian1.png', '百果园', 'bus', '1');
INSERT INTO `image` VALUES ('20', 'shuiguodian2.png', '水果捞', 'bus', '1');
INSERT INTO `image` VALUES ('21', 'shuiguodian3.png', '蔬东坡', 'bus', '1');
INSERT INTO `image` VALUES ('22', 'yinpindian1.png', '蜜雪冰城', 'bus', '1');
INSERT INTO `image` VALUES ('23', 'yinpindian2.png', '避风塘', 'bus', '1');
INSERT INTO `image` VALUES ('24', 'yinpindian3.png', 'Coco', 'bus', '1');
INSERT INTO `image` VALUES ('25', 'kuaican1.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('26', 'kuaican2.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('27', 'kuaican3.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('28', 'kuaican4.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('29', 'kuaican5.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('30', 'kuaican6.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('31', 'kuaican7.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('32', 'kuaican8.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('33', 'kuaican9.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('34', 'mian1.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('35', 'mian2.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('36', 'mian3.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('37', 'mian4.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('38', 'mian5.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('39', 'mian6.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('40', 'mian7.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('41', 'mian8.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('42', 'mian9.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('43', 'qita1.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('44', 'qita2.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('45', 'qita3.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('46', 'qita4.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('47', 'qita5.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('48', 'qita6.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('49', 'qita7.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('50', 'qita8.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('51', 'qita9.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('52', 'shuiguo1.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('53', 'shuiguo2.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('54', 'shuiguo3.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('55', 'shuiguo4.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('56', 'shuiguo5.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('57', 'shuiguo6.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('58', 'shuiguo7.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('59', 'shuiguo8.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('60', 'shuiguo9.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('61', 'yinpin1.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('62', 'yinpin2.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('63', 'yinpin3.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('64', 'yinpin4.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('65', 'yinpin5.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('66', 'yinpin6.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('67', 'yinpin7.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('68', 'yinpin8.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('69', 'yinpin9.png', '产品', 'pro', '1');
INSERT INTO `image` VALUES ('70', 'ad_KFC1.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('71', 'ad_KFC2.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('72', 'ad_haokelai.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('73', 'ad_Hidilao.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('74', 'ad_lanzhoulamian.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('75', 'ad_mixuebingcheng.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('76', 'ad_shuiguolao.png', '广告', 'ad', '1');
INSERT INTO `image` VALUES ('77', 'login.png', '开屏动画', 'login', '1');
INSERT INTO `image` VALUES ('78', 'kuaican10.png', '产品', 'pro', '1');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL COMMENT '打开的id',
  `userid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `foodname` varchar(255) DEFAULT NULL COMMENT '餐品名称',
  `makedata` varchar(255) DEFAULT NULL COMMENT '下单时间',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `ordertype` varchar(10) DEFAULT NULL COMMENT '餐品状态',
  `usertell` varchar(50) DEFAULT NULL COMMENT '用户电话',
  `information` varchar(255) DEFAULT NULL COMMENT '备注留言',
  `busid` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `recommend`
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '导航栏推荐类型id',
  `name` varchar(50) DEFAULT NULL COMMENT '导航栏推荐类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('1', '推荐');
INSERT INTO `recommend` VALUES ('2', '快餐');
INSERT INTO `recommend` VALUES ('3', '饮品');
INSERT INTO `recommend` VALUES ('4', '面食');
INSERT INTO `recommend` VALUES ('5', '水果');

-- ----------------------------
-- Table structure for `sysuser`
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户id',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `imageid` bigint(11) DEFAULT NULL COMMENT '关联图片id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sysuser
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(100) DEFAULT '' COMMENT '昵称',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信用户唯一标识',
  `imageurl` varchar(255) DEFAULT NULL COMMENT '微信头像路径',
  `sessionkey` varchar(255) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
