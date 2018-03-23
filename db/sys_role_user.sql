/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50173
Source Host           : 192.168.2.66:3306
Source Database       : FI-manager

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-23 10:32:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` varchar(3) NOT NULL,
  `Sys_User_id` varchar(3) NOT NULL,
  `Sys_Role_id` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');
INSERT INTO `sys_role_user` VALUES ('3', '2', '3');
INSERT INTO `sys_role_user` VALUES ('4', '10', '1');
