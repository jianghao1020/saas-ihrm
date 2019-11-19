/*
 Navicat Premium Data Transfer

 Source Server         : mariaDB-localhost
 Source Server Type    : MariaDB
 Source Server Version : 100408
 Source Host           : localhost:3306
 Source Schema         : ihrm

 Target Server Type    : MariaDB
 Target Server Version : 100408
 File Encoding         : 65001

 Date: 19/11/2019 15:54:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for co_company
-- ----------------------------
DROP TABLE IF EXISTS `co_company`;
CREATE TABLE `co_company`  (
  `id` bigint(255) NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `manager_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业登录账号ID',
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前版本',
  `renewal_date` datetime(0) NULL DEFAULT NULL COMMENT '续期时间',
  `expiration_date` datetime(0) NULL DEFAULT NULL COMMENT '到期时间',
  `company_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地区',
  `company_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `business_license_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照-图片ID',
  `legal_representative` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人代表',
  `company_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  `mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `company_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司规模',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业',
  `remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `audit_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态',
  `state` tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态',
  `balance` double NOT NULL COMMENT '当前余额',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of co_company
-- ----------------------------
INSERT INTO `co_company` VALUES (1189059632535048192, '牛逼的公司', 'A1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 100000000, '2019-10-29 14:01:22');

SET FOREIGN_KEY_CHECKS = 1;
