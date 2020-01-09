/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2019-06-10 15:41:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(255) NOT NULL,
  `userCode` varchar(255) character set gbk NOT NULL,
  `userName` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `telephone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `userPwd` varchar(255) NOT NULL,
  `createUser` varchar(255) default NULL,
  `createDate` datetime default NULL,
  `updateUser` varchar(255) default NULL,
  `updateDate` datetime default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0', 'sys', '管理员', null, null, null, '123', null, null, null, null);
INSERT INTO `t_user` VALUES ('123', 'sys1', '张三hhhh', null, null, null, '123', null, null, null, null);
INSERT INTO `t_user` VALUES ('456', 'sys2', '李四', null, null, null, '123', null, null, null, null);
INSERT INTO `t_user` VALUES ('789', 'sys3', '王二', null, null, null, '123', null, null, null, null);
