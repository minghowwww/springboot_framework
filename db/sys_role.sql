/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50173
Source Host           : 192.168.2.66:3306
Source Database       : FI-manager

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-23 10:32:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(3) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('10', 'ROLE_DEAD_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_CAR_ADMIN');
INSERT INTO `sys_role` VALUES ('3', 'ROLE_STAFF_ADMIN');
INSERT INTO `sys_role` VALUES ('4', 'ROLE_REF_ADMIN');
INSERT INTO `sys_role` VALUES ('5', 'ROLE_COSMETIC_ADMIN');
INSERT INTO `sys_role` VALUES ('6', 'ROLE_FARWELL_ADMIN');
INSERT INTO `sys_role` VALUES ('7', 'ROLE_CREMATION_ADMIN');
INSERT INTO `sys_role` VALUES ('8', 'ROLE_DEPOSIT_ADMIN');
INSERT INTO `sys_role` VALUES ('9', 'ROLE_SETTLEMENT_ADMIN');
