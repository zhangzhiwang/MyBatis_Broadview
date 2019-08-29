/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 29/08/2019 13:29:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(20) NOT NULL,
  `course_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
BEGIN;
INSERT INTO `t_course` VALUES (1, '数学');
INSERT INTO `t_course` VALUES (2, '语文');
COMMIT;

-- ----------------------------
-- Table structure for t_female_health
-- ----------------------------
DROP TABLE IF EXISTS `t_female_health`;
CREATE TABLE `t_female_health` (
  `id` int(20) NOT NULL,
  `stu_id` int(20) DEFAULT NULL,
  `female_health` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stu_id` (`stu_id`),
  CONSTRAINT `fk_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_male_health
-- ----------------------------
DROP TABLE IF EXISTS `t_male_health`;
CREATE TABLE `t_male_health` (
  `id` int(20) NOT NULL,
  `stu_id` int(20) DEFAULT NULL,
  `male_health` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stu_id2` (`stu_id`),
  CONSTRAINT `fk_stu_id2` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stu_course
-- ----------------------------
DROP TABLE IF EXISTS `t_stu_course`;
CREATE TABLE `t_stu_course` (
  `id` int(20) NOT NULL,
  `stu_id` int(20) DEFAULT NULL,
  `course_id` int(20) DEFAULT NULL,
  `score` decimal(16,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course` (`course_id`),
  KEY `fk_stu` (`stu_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`),
  CONSTRAINT `fk_stu` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu_course
-- ----------------------------
BEGIN;
INSERT INTO `t_stu_course` VALUES (1, 1, 1, 99.00);
INSERT INTO `t_stu_course` VALUES (2, 1, 2, 98.50);
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(20) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, 'a', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_student_card
-- ----------------------------
DROP TABLE IF EXISTS `t_student_card`;
CREATE TABLE `t_student_card` (
  `id` int(20) NOT NULL,
  `number` varchar(20) NOT NULL,
  `stu_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_num` (`number`),
  KEY `fk_stu_id` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_card
-- ----------------------------
BEGIN;
INSERT INTO `t_student_card` VALUES (1, 'S001', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
