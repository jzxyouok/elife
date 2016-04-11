/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.17 : Database - elife
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`elife` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `elife`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT 'true=男；false=女',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  `addressgeneral` varchar(30) DEFAULT NULL COMMENT '大概地址（精确到市）',
  `addressexact` varchar(30) DEFAULT NULL COMMENT '详细地址',
  `status` tinyint(4) DEFAULT NULL COMMENT '收货地址状态（是否为默认地址）',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '所属用户',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `address` */

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `level` tinyint(4) DEFAULT NULL COMMENT '管理员等级',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `classfirst` varchar(30) DEFAULT NULL COMMENT '轮播图的一级分类',
  `classsecond` varchar(30) DEFAULT NULL COMMENT '轮播图的二级分类',
  `imgaddress` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `url` varchar(50) DEFAULT NULL COMMENT '图片链接的地址',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `identity` tinyint(4) DEFAULT NULL COMMENT '身份类型',
  `storename` varchar(30) DEFAULT NULL COMMENT '商店名称',
  `address` varchar(50) DEFAULT NULL COMMENT '商家地址',
  `status` tinyint(4) DEFAULT NULL COMMENT '商家状态',
  `verify` varchar(8) DEFAULT NULL COMMENT '验证码',
  `lasttime` varchar(30) DEFAULT NULL COMMENT '上次登录时间',
  `stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `business` */

/*Table structure for table `businessclass` */

DROP TABLE IF EXISTS `businessclass`;

CREATE TABLE `businessclass` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `business` int(10) unsigned DEFAULT NULL COMMENT '商家id',
  `classoneid` int(10) unsigned DEFAULT NULL COMMENT '一级分类表',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `business` (`business`),
  KEY `classoneid` (`classoneid`),
  CONSTRAINT `businessclass_ibfk_1` FOREIGN KEY (`business`) REFERENCES `business` (`id`),
  CONSTRAINT `businessclass_ibfk_2` FOREIGN KEY (`classoneid`) REFERENCES `classone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `businessclass` */

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `addtime` varchar(30) DEFAULT NULL COMMENT '加入时间',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '所属用户id',
  `goodsid` int(10) unsigned DEFAULT NULL COMMENT '商品id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `goodsid` (`goodsid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

/*Table structure for table `classone` */

DROP TABLE IF EXISTS `classone`;

CREATE TABLE `classone` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '一级分类名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classone` */

/*Table structure for table `classsecond` */

DROP TABLE IF EXISTS `classsecond`;

CREATE TABLE `classsecond` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '二级分类名称',
  `classoneid` int(10) unsigned DEFAULT NULL COMMENT '一级分类id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `classoneid` (`classoneid`),
  CONSTRAINT `classsecond_ibfk_1` FOREIGN KEY (`classoneid`) REFERENCES `classone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classsecond` */

/*Table structure for table `classthree` */

DROP TABLE IF EXISTS `classthree`;

CREATE TABLE `classthree` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '三级分类id',
  `classsecondid` int(10) unsigned DEFAULT NULL COMMENT '二级分类id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `classsecondid` (`classsecondid`),
  CONSTRAINT `classthree_ibfk_1` FOREIGN KEY (`classsecondid`) REFERENCES `classsecond` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classthree` */

/*Table structure for table `commentreply` */

DROP TABLE IF EXISTS `commentreply`;

CREATE TABLE `commentreply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `time` varchar(30) DEFAULT NULL COMMENT '回复时间',
  `identity` varchar(30) DEFAULT NULL COMMENT '回复者身份',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '回复者id（可能是用户也可能是商家）',
  `commentid` int(10) unsigned DEFAULT NULL COMMENT '商品评论id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `commentid` (`commentid`),
  CONSTRAINT `commentreply_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `commentreply_ibfk_2` FOREIGN KEY (`commentid`) REFERENCES `goodscomment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `commentreply` */

/*Table structure for table `coupon` */

DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `no` varchar(50) DEFAULT NULL COMMENT '优惠券编号',
  `time` varchar(30) DEFAULT NULL COMMENT '优惠券创建时间',
  `founder` int(10) unsigned DEFAULT NULL COMMENT '创建人的id（外键，参照管理员表id）',
  `value` double DEFAULT NULL COMMENT '优惠券的价值',
  `status` tinyint(4) DEFAULT NULL COMMENT '优惠券的状态',
  `usetime` varchar(30) DEFAULT NULL COMMENT '使用时间',
  `endtime` varchar(30) DEFAULT NULL COMMENT '优惠券截止使用时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `founder` (`founder`),
  CONSTRAINT `coupon_ibfk_1` FOREIGN KEY (`founder`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coupon` */

/*Table structure for table `favorite` */

DROP TABLE IF EXISTS `favorite`;

CREATE TABLE `favorite` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `favoriteid` int(10) unsigned DEFAULT NULL COMMENT '可以是商品也可以是商家',
  `identity` int(10) unsigned DEFAULT NULL COMMENT '区别收藏的商家还是商品',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '收藏的用户的id',
  `remark` varchar(50) DEFAULT NULL COMMENT 'remark',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `favorite` */

/*Table structure for table `gcommentimg` */

DROP TABLE IF EXISTS `gcommentimg`;

CREATE TABLE `gcommentimg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `imgaddress` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `gcommentid` int(10) unsigned DEFAULT NULL COMMENT '商品评论id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `gcommentid` (`gcommentid`),
  CONSTRAINT `gcommentimg_ibfk_1` FOREIGN KEY (`gcommentid`) REFERENCES `goodscomment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gcommentimg` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '商品名称',
  `description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `price` double DEFAULT NULL COMMENT '商品价格',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `oldprice` double DEFAULT NULL COMMENT '商品原价',
  `sale` int(11) DEFAULT NULL COMMENT '销售量',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `businessid` int(10) unsigned DEFAULT NULL COMMENT '所属商家',
  `threeclassid` int(10) unsigned DEFAULT NULL COMMENT '所属三级分类的id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `商家` (`businessid`),
  CONSTRAINT `商家` FOREIGN KEY (`businessid`) REFERENCES `business` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goodsclass` */

DROP TABLE IF EXISTS `goodsclass`;

CREATE TABLE `goodsclass` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `goodsid` int(10) unsigned DEFAULT NULL COMMENT '商品id',
  `classthreeid` int(10) unsigned DEFAULT NULL COMMENT '三级分类id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `goodsid` (`goodsid`),
  KEY `classthreeid` (`classthreeid`),
  CONSTRAINT `goodsclass_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`),
  CONSTRAINT `goodsclass_ibfk_2` FOREIGN KEY (`classthreeid`) REFERENCES `classthree` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsclass` */

/*Table structure for table `goodscomment` */

DROP TABLE IF EXISTS `goodscomment`;

CREATE TABLE `goodscomment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '评论内容',
  `goodsgrade` tinyint(4) DEFAULT NULL COMMENT '商品等级',
  `businessgrade` tinyint(4) DEFAULT NULL COMMENT '商家等级',
  `expressgrade` tinyint(4) DEFAULT NULL COMMENT '快递等级',
  `time` varchar(30) DEFAULT NULL COMMENT '评论时间',
  `goodsid` int(10) unsigned DEFAULT NULL COMMENT '商品id',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '评论人id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `goodsid` (`goodsid`),
  KEY `userid` (`userid`),
  CONSTRAINT `goodscomment_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`),
  CONSTRAINT `goodscomment_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodscomment` */

/*Table structure for table `goodsimg` */

DROP TABLE IF EXISTS `goodsimg`;

CREATE TABLE `goodsimg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `imgaddress` varchar(100) DEFAULT NULL COMMENT '商品图片地址',
  `goodsid` int(10) unsigned DEFAULT NULL COMMENT '商品id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `goodsid` (`goodsid`),
  CONSTRAINT `goodsimg_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsimg` */

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '新闻内容',
  `praise` int(11) DEFAULT NULL COMMENT '点赞的数量',
  `commentnum` int(11) DEFAULT NULL COMMENT '评论的数量',
  `readnum` int(11) DEFAULT NULL COMMENT '浏览人数',
  `time` varchar(30) DEFAULT NULL COMMENT '发表时间',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '发表人id',
  `topicid` int(10) unsigned DEFAULT NULL COMMENT '所属话题的id',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（允不允许显示）',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `topicid` (`topicid`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`topicid`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `news` */

/*Table structure for table `newscomment` */

DROP TABLE IF EXISTS `newscomment`;

CREATE TABLE `newscomment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '评论的内容',
  `time` varchar(30) DEFAULT NULL COMMENT '评论的时间',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '评论人的id',
  `replyid` int(10) unsigned DEFAULT NULL COMMENT '回复的是哪个人',
  `newsid` int(10) unsigned DEFAULT NULL COMMENT '新闻的id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `replyid` (`replyid`),
  KEY `newsid` (`newsid`),
  CONSTRAINT `newscomment_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `newscomment_ibfk_2` FOREIGN KEY (`replyid`) REFERENCES `users` (`id`),
  CONSTRAINT `newscomment_ibfk_3` FOREIGN KEY (`newsid`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `newscomment` */

/*Table structure for table `newsimg` */

DROP TABLE IF EXISTS `newsimg`;

CREATE TABLE `newsimg` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `imgaddress` varchar(1000) DEFAULT NULL COMMENT '图片地址',
  `newsid` int(10) unsigned DEFAULT NULL COMMENT '新闻的id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `newsid` (`newsid`),
  CONSTRAINT `newsimg_ibfk_1` FOREIGN KEY (`newsid`) REFERENCES `news` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `newsimg` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `no` varchar(30) DEFAULT NULL COMMENT '订单编号',
  `time` varchar(30) DEFAULT NULL COMMENT '订单时间',
  `total` double DEFAULT NULL COMMENT '订单总价',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `messaage` varchar(255) DEFAULT NULL COMMENT '留言',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '所属用户id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(10) DEFAULT NULL COMMENT '数量',
  `total` double DEFAULT NULL COMMENT '单项总价',
  `goodsid` int(10) unsigned DEFAULT NULL COMMENT '商品id',
  `businessid` int(10) unsigned DEFAULT NULL COMMENT '商家id',
  `orderid` int(10) unsigned DEFAULT NULL COMMENT '订单id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `goodsid` (`goodsid`),
  KEY `businessid` (`businessid`),
  KEY `orderid` (`orderid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`businessid`) REFERENCES `business` (`id`),
  CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

/*Table structure for table `praise` */

DROP TABLE IF EXISTS `praise`;

CREATE TABLE `praise` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) DEFAULT NULL COMMENT '赞的状态（是否取消）',
  `newsid` int(10) unsigned DEFAULT NULL COMMENT '新闻的id',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '点赞用户的id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `newsid` (`newsid`),
  KEY `userid` (`userid`),
  CONSTRAINT `praise_ibfk_1` FOREIGN KEY (`newsid`) REFERENCES `news` (`id`),
  CONSTRAINT `praise_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `praise` */

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '话题名称',
  `number` int(11) DEFAULT NULL COMMENT '参与话题讨论的人数',
  `status` int(11) DEFAULT NULL COMMENT '话题状态（有没有通过审核）',
  `time` varchar(50) DEFAULT NULL COMMENT '话题创建时间',
  `userid` int(10) unsigned DEFAULT NULL COMMENT '创建人的id',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '无意义',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` char(11) DEFAULT NULL COMMENT '手机号？',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(1) DEFAULT NULL COMMENT 'true=男；false=女',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(30) DEFAULT NULL COMMENT '出生日期',
  `headimg` varchar(100) DEFAULT NULL COMMENT '头像',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `school` varchar(30) DEFAULT NULL COMMENT '所在学校',
  `verify` varchar(8) DEFAULT NULL COMMENT '验证码',
  `status` tinyint(11) DEFAULT NULL COMMENT '用户状态',
  `stamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `remark` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
