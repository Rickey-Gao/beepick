/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : mybdtisdemo

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 23/01/2021 18:05:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pharmacy
-- ----------------------------
DROP TABLE IF EXISTS `pharmacy`;
CREATE TABLE `pharmacy` (
  `id` varchar(255) NOT NULL COMMENT '店唯一编码',
  `name` varchar(1024) NOT NULL COMMENT '店名称',
  `description` varchar(2048) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '描述',
  `latitude` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '经度',
  `longitude` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '纬度',
  `startTime` datetime DEFAULT NULL COMMENT '开始营业时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束营业时间',
  `province` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `citi` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pharmacy
-- ----------------------------
BEGIN;
INSERT INTO `pharmacy` VALUES ('1', '测试', '测试描述', '110', '120', '2021-01-18 00:27:17', '2029-01-18 00:27:20', '上海', '上海', '浦东新区');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (2, 'xuqing', 'xq9527', '27', '男');
INSERT INTO `user` VALUES (3, 'shuaigao', '123456', '28', '男');
INSERT INTO `user` VALUES (4, '吴', '123', '18', '女');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
