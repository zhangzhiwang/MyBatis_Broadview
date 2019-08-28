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

 Date: 26/08/2019 20:42:17
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
-- Table structure for t_female_health
-- ----------------------------
DROP TABLE IF EXISTS `t_female_health`;
CREATE TABLE `t_female_health` (
  `id` int(20) NOT NULL,
  `stu_num` int(20) DEFAULT NULL,
  `health_female` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stu_num` (`stu_num`),
  CONSTRAINT `fk_stu_num` FOREIGN KEY (`stu_num`) REFERENCES `t_student` (`student_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stu_course
-- ----------------------------
DROP TABLE IF EXISTS `t_stu_course`;
CREATE TABLE `t_stu_course` (
  `id` int(20) NOT NULL,
  `stu_card_num` int(20) DEFAULT NULL,
  `course_id` int(20) DEFAULT NULL,
  `score` decimal(16,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stu` (`stu_card_num`),
  KEY `fk_course` (`course_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`),
  CONSTRAINT `fk_stu` FOREIGN KEY (`stu_card_num`) REFERENCES `t_student` (`student_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(20) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `student_card_num` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_card_num` (`student_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_card
-- ----------------------------
DROP TABLE IF EXISTS `t_student_card`;
CREATE TABLE `t_student_card` (
  `id` int(20) NOT NULL,
  `number` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_num` (`number`),
  CONSTRAINT `fk_num` FOREIGN KEY (`number`) REFERENCES `t_student` (`student_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `t_male_health`;
CREATE TABLE `t_male_health` (
  `id` int(20) NOT NULL,
  `stu_num` int(20) DEFAULT NULL,
  `male_health` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stu_num2` (`stu_num`),
  CONSTRAINT `fk_stu_num2` FOREIGN KEY (`stu_num`) REFERENCES `t_student` (`student_card_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
