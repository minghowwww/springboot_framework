/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50173
Source Host           : 192.168.2.66:3306
Source Database       : FI-manager

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-23 10:32:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '784f90163f12616a901dc0935e726699');
INSERT INTO `sys_user` VALUES ('2', 'user', '1e7c083aa892f6b5591c1208f1e23f94');
INSERT INTO `sys_user` VALUES ('6', 'kaixin', '765c9dfa4bb6aa9f6b28525d0f4042b3');
INSERT INTO `sys_user` VALUES ('7', 'lele', '310a106ea2f492efaeea8ccfd15b370b');
INSERT INTO `sys_user` VALUES ('8', 'ojjbk', '391f0db3fad643846c3ee053b6f89764');
INSERT INTO `sys_user` VALUES ('9', 'qwe', '5a4f063482f8d77ccacbcb0a10f0c40b');
INSERT INTO `sys_user` VALUES ('10', 'wmh', '6c820046c0f2e422fdb158077dd3faa6');
INSERT INTO `sys_user` VALUES ('11', 'wjk', '13000f9f2484a75401b30e14fe6fd71d');
