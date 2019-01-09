/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : goodsmanage

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 08/01/2019 19:24:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT 0,
  `max` int(11) NULL DEFAULT 0,
  `min` int(11) NULL DEFAULT 0,
  `price` int(11) NULL DEFAULT 0,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '笔记本', '这是一台笔记本...', 1000, 1000, 1, 10000, '自然');
INSERT INTO `goods` VALUES (2, '手机', '这是一个手机', 1200, 100, 1, 4000, '宏涛');
INSERT INTO `goods` VALUES (7, '单车', '自行车la ', 0, 12222, 2, 100, '炊烟');
INSERT INTO `goods` VALUES (8, '火车', '12211', 1236, 11221, 121221, 12212, '炊烟');
INSERT INTO `goods` VALUES (9, '笔记本', '这是笔记本', 2121, 12, 1, 1200, '小明');
INSERT INTO `goods` VALUES (10, '手机', '这是手机', 212, 120, 1, 12434, '小明');
INSERT INTO `goods` VALUES (11, '单车', '这是单车', 100, 120, 1, 10000, '小明');
INSERT INTO `goods` VALUES (12, '火车', '这是火车', 500, 1000, 60, 100000, '小明');
INSERT INTO `goods` VALUES (13, '牙膏', '这是牙膏', 900, 1000, 60, 35, '小智');
INSERT INTO `goods` VALUES (14, '茶杯', '这是茶杯', 1500, 700, 100, 50, '小军');
INSERT INTO `goods` VALUES (15, '笔记本电脑', '这是笔记本电脑', 40, 1000, 10, 4500, '小军');
INSERT INTO `goods` VALUES (16, '椅子', '这是椅子', 40, 100, 10, 300, '小智');
INSERT INTO `goods` VALUES (17, '钱包', '这是钱包', 1000, 2000, 800, 50, '小六');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `number` int(11) NULL DEFAULT 0,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '入库',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '暂未处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (5, '电脑', '炊烟', 1223, '入库', '已处理');
INSERT INTO `record` VALUES (7, '单车', '炊烟', 122, '入库', '已批准');
INSERT INTO `record` VALUES (8, '火车', '炊烟', 12, '入库', '已批准');
INSERT INTO `record` VALUES (9, '单车', '炊烟', 732, '出库', '已批准');
INSERT INTO `record` VALUES (10, '茶杯', '小军', 100, '入库', '已批准');
INSERT INTO `record` VALUES (11, '茶杯', '小军', 400, '入库', '已批准');
INSERT INTO `record` VALUES (12, '笔记本电脑', '小军', 100, '入库', '暂未处理');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '宏涛', '涛涛', '123456', '男', '1234567998', '1231@qq.com', '金陵科技学院', 1);
INSERT INTO `user` VALUES (3, '自然', '世卿', '123456', '男', '1233456555', '12345@qq.com', '金陵科技学院', 1);
INSERT INTO `user` VALUES (6, '张俊逸', '老三', '123456', '女', '88888888', '12212', '12122', 1);
INSERT INTO `user` VALUES (7, '朱昱', '朱四', '123456', '女', '88888888', '12212', '12122', 1);
INSERT INTO `user` VALUES (8, '无名氏', '王二麻子', '123456', '女', '88888888', '12212', '12122', 0);
INSERT INTO `user` VALUES (10, '小明', '张三', '123456', '女', '88888888', '12212', '12122', 0);
INSERT INTO `user` VALUES (28, '炊烟', '炊烟', '123456', '女', '123456789', '123@123.com', '金科', 0);
INSERT INTO `user` VALUES (29, '胭脂扣', '胭脂扣', '123456', '男', '12345678901', '123@qq.com', 'jit', 0);
INSERT INTO `user` VALUES (30, '小军', '小军', '123456', '男', '13151063300', '197@163.com', '1041', 0);
INSERT INTO `user` VALUES (31, '小李', '小李', '123456', '女', '13151063329', '267@163.com', '043', 0);
INSERT INTO `user` VALUES (32, '小李刘', '小刘', '123456', '男', '13791063329', '267@1qq.com', '4043', 0);
INSERT INTO `user` VALUES (33, '小陈', '小陈', '123456', '女', '13791063303', '163@qq.com', '4043', 0);
INSERT INTO `user` VALUES (34, '小涛', '小涛', '123456', '男', '13791065609', '4396@qq.com', '南10a', 0);
INSERT INTO `user` VALUES (35, '小壮', '小壮', '123456', '男', '13791069906', '1433@qq.com', '南10a', 0);
INSERT INTO `user` VALUES (36, '小六', '小六', '123456', '女', '13793469906', '171@qq.com', '南10a', 0);
INSERT INTO `user` VALUES (37, '小平', '小平', '123456', '女', '13376969906', '1998@qq.com', '南10a', 0);
INSERT INTO `user` VALUES (38, '小豪', '小豪', '123456', '男', '13376964406', '0923@qq.com', '1061', 0);
INSERT INTO `user` VALUES (39, '小智', '小智', '123456', '男', '13376969306', '741@qq.com', '1062', 0);

SET FOREIGN_KEY_CHECKS = 1;
