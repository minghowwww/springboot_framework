/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50173
Source Host           : 192.168.2.66:3306
Source Database       : FI-manager

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-23 10:32:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `age` varchar(3) NOT NULL,
  `school` varchar(255) NOT NULL,
  `score` varchar(1) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `is_deleted` int(1) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'robin', '12', '清华f大学', 'A', '', '1', '2017-12-15 00:00:00', '2017-12-22 00:00:00');
INSERT INTO `student` VALUES ('2', 'abc', '12', '撒旦', '', '', '1', '2017-12-15 00:00:00', '2017-12-15 00:00:00');
INSERT INTO `student` VALUES ('3', 'a\'s\'d', '12', '撒旦撒', 'C', '', '1', '2017-12-18 00:00:00', '2017-12-18 00:00:00');
INSERT INTO `student` VALUES ('4', '的撒旦', '12', '但是21', 'D', '8881', '1', '2017-12-18 00:00:00', '2017-12-22 00:00:00');
INSERT INTO `student` VALUES ('5', '的撒旦', '12', '但是', 'C', '', '1', '2017-12-18 00:00:00', '2017-12-18 00:00:00');
INSERT INTO `student` VALUES ('6', 'admin', '12', '', 'B', '啥事', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('7', 'jbb', '11', '11', 'B', '11211', '1', '2017-12-19 00:00:00', '2017-12-22 00:00:00');
INSERT INTO `student` VALUES ('8', 'byy', '12', 'dalian', 'D', 'aaa', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('9', 'jack', '12', '清华', 'B', '2f', '1', '2017-12-19 00:00:00', '2017-12-23 00:00:00');
INSERT INTO `student` VALUES ('10', '阿斯达', '12', '阿德萨苏', 'C', '阿萨德', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('11', '1', '1', '1', 'B', '1', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('12', '2', '2', '2', 'A', '', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('13', '3', '3', '3', 'A', '', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('14', '4', '4', '4', 'B', '', '1', '2017-12-19 00:00:00', '2017-12-19 00:00:00');
INSERT INTO `student` VALUES ('15', '892543969@qq.com', '120', '1', 'D', '', '1', '2017-12-20 00:00:00', '2017-12-20 00:00:00');
INSERT INTO `student` VALUES ('16', '1', '1', '1', 'D', '', '1', '2017-12-20 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('17', 'ad', '13', 'awd', 'A', '', '1', '2017-12-20 00:00:00', '2017-12-20 00:00:00');
INSERT INTO `student` VALUES ('18', '1', '1', '1', 'C', '', '1', '2017-12-20 00:00:00', '2017-12-20 00:00:00');
INSERT INTO `student` VALUES ('19', 'abc', '12', '1', 'C', '', '1', '2017-12-20 00:00:00', '2017-12-28 00:00:00');
INSERT INTO `student` VALUES ('20', '1', '1', '1', 'C', '', '1', '2017-12-20 00:00:00', '2017-12-20 00:00:00');
INSERT INTO `student` VALUES ('21', '阿瑟', '12', '阿萨德', 'C', '', '1', '2017-12-20 00:00:00', '2017-12-20 00:00:00');
INSERT INTO `student` VALUES ('22', 'Vince Carter', '40', '北卡罗来纳大学', 'A', '', '1', '2017-12-20 00:00:00', '2018-01-04 00:00:00');
INSERT INTO `student` VALUES ('23', '小李子', '23', '清华', 'C', '3', '1', '2017-12-21 00:00:00', '2017-12-21 00:00:00');
INSERT INTO `student` VALUES ('24', '阿卡丽', '3', '北京大学', 'D', '', '1', '2017-12-21 00:00:00', '2017-12-21 00:00:00');
INSERT INTO `student` VALUES ('25', '武器', '3', '北京大学', 'A', '3', '1', '2017-12-21 00:00:00', '2017-12-21 00:00:00');
INSERT INTO `student` VALUES ('26', '哈哈', '3', '北京大学', 'C', '45', '1', '2017-12-21 00:00:00', '2017-12-21 00:00:00');
INSERT INTO `student` VALUES ('27', 'wangyigggg', '31', '北京大学', 'B', 'awd奥数辅导', '1', '2017-12-21 00:00:00', '2017-12-23 00:00:00');
INSERT INTO `student` VALUES ('28', '2', '2', '2', 'B', '1121', '1', '2017-12-22 00:00:00', '2017-12-22 00:00:00');
INSERT INTO `student` VALUES ('29', '??', '23', '??????', 'A', null, '1', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('30', '???', '12', '???', 'A', null, '1', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('31', 'jhlkjh', '89', '2014-02-01 12:00:00', 'A', 'sa', '0', '2017-12-27 00:00:00', '2018-03-23 00:00:00');
INSERT INTO `student` VALUES ('32', '阿斯顿', '12', '阿斯顿', 'D', '啊实打实的', '0', '2017-12-27 00:00:00', '2018-03-22 00:00:00');
INSERT INTO `student` VALUES ('33', 'abc', '15', '撒旦', 'A', null, '1', '2017-12-27 00:00:00', '2018-03-21 00:00:00');
INSERT INTO `student` VALUES ('34', '啊萨达', '12', '阿三的', 'B', '啊萨121', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('36', '阿萨德', '12', '阿萨德啊', 'B', '阿萨德', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('37', 'asd', '12', 'asd', 'A', 'asd sa', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('38', 'as', '121', 'sa', 'A', 'as', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('39', 'asd', '12', 'weq', 'A', 'asd', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('44', 'a', '1', 'a', 'A', 'a', '0', '2017-12-27 00:00:00', '2017-12-27 00:00:00');
INSERT INTO `student` VALUES ('45', '金斌斌', '12', '大连', 'A', '的额外', '0', '2017-12-28 00:00:00', '2017-12-28 00:00:00');
INSERT INTO `student` VALUES ('46', '魏无羡', '3', '阿瓦达', 'C', '爱的味道', '0', '2017-12-28 00:00:00', '2017-12-28 00:00:00');
INSERT INTO `student` VALUES ('51', '阿斯', '11', '撒', 'A', '撒旦', '0', '2018-01-02 00:00:00', '2018-03-21 00:00:00');
INSERT INTO `student` VALUES ('52', '阿斯顿撒', '11', '撒', 'A', '撒旦', '0', '2018-01-02 00:00:00', '2018-01-02 00:00:00');
INSERT INTO `student` VALUES ('53', '请问', '1', '器', 'A', '我企鹅完全', '0', '2018-01-02 00:00:00', '2018-01-02 00:00:00');
INSERT INTO `student` VALUES ('54', '而我却', '1', '器', 'A', '撒旦撒', '0', '2018-01-02 00:00:00', '2018-01-02 00:00:00');
INSERT INTO `student` VALUES ('55', '的', '1', '额', 'A', '撒旦撒旦', '0', '2018-01-02 00:00:00', '2018-01-02 00:00:00');
INSERT INTO `student` VALUES ('56', '阿萨德', '12', '撒旦', 'A', '阿萨德', '0', '2018-03-21 00:00:00', '2018-03-21 00:00:00');
INSERT INTO `student` VALUES ('57', '啪啪啪', '23', 'IIS', 'D', null, '0', '2018-03-22 00:00:00', '2018-03-22 00:00:00');
INSERT INTO `student` VALUES ('58', '啪啪啪啪啪', '223', 'iio', 'A', null, '0', '2018-03-22 00:00:00', '2018-03-22 00:00:00');
