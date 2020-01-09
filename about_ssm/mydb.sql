/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 14/10/2019 12:35:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_item
-- ----------------------------
DROP TABLE IF EXISTS `basic_item`;
CREATE TABLE `basic_item`  (
  `itemid` int(11) NOT NULL,
  `itemcode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemname` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemunit` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemspec` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `itemdrawno` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `itemweight` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `highprice` decimal(10, 0) DEFAULT 0,
  `newprice` decimal(10, 0) DEFAULT 0,
  `lowprice` decimal(10, 0) DEFAULT 0,
  `useflag` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemDescription` varchar(405) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_item
-- ----------------------------
INSERT INTO `basic_item` VALUES (1, '38411051201', '生产用减速机', '套', '湖南株洲减速剂制造有限公司', '图号/888888-999999', '2000t', 50000, 48000, 45000, '0', NULL);

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `dormitory_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dormitory_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`dormitory_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('01101', '1栋', '101号');
INSERT INTO `dormitory` VALUES ('01102', '1栋', '102号');
INSERT INTO `dormitory` VALUES ('02101', '2栋', '101号');
INSERT INTO `dormitory` VALUES ('02102', '2栋', '102号');
INSERT INTO `dormitory` VALUES ('GA101', '桂圆A栋', '101号');
INSERT INTO `dormitory` VALUES ('GA102', '桂圆B栋', '102号');
INSERT INTO `dormitory` VALUES ('NA101', '楠园A栋', '101号');
INSERT INTO `dormitory` VALUES ('NA102', '楠园A栋', '102号');
INSERT INTO `dormitory` VALUES ('NB101', '楠园B栋', '101号');
INSERT INTO `dormitory` VALUES ('NB102', '楠园B栋', '102号');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `productname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productspec` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productnum` decimal(10, 0) NOT NULL,
  `productprice` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`productid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2707977 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1856588, '苹果（Apple）1111', 'iPhone 6S 玫瑰金色', 1, 5399);
INSERT INTO `product` VALUES (2350836, '小米（MI）', '红米Note3', 4, 1099);
INSERT INTO `product` VALUES (2707976, '乐视（Letv）', 'X620 金色', 2, 1099);

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `profession_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profession_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系别',
  `profession_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  PRIMARY KEY (`profession_id`) USING BTREE,
  INDEX `profession_id`(`profession_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('0101', '计算机系', '软件技术');
INSERT INTO `profession` VALUES ('0102', '计算机系', '网络开发');
INSERT INTO `profession` VALUES ('0103', '计算机系', '数字媒体');
INSERT INTO `profession` VALUES ('0104', '计算机系', '网站开发');
INSERT INTO `profession` VALUES ('0201', '外语系', '商务英语');
INSERT INTO `profession` VALUES ('0202', '外语系', '旅游英语');
INSERT INTO `profession` VALUES ('0301', '经管系', '会计');
INSERT INTO `profession` VALUES ('0302', '经管系', '酒店管理');
INSERT INTO `profession` VALUES ('0303', '经管系', '人力资源');
INSERT INTO `profession` VALUES ('0304', '经管系', '国际经济与贸易');
INSERT INTO `profession` VALUES ('0401', '机械系', '工业设计');
INSERT INTO `profession` VALUES ('0402', '机械系', '车辆工程');
INSERT INTO `profession` VALUES ('0403', '机械系', '材料成型及控制工程');
INSERT INTO `profession` VALUES ('0501', '机电系', '电机拖动与技术');
INSERT INTO `profession` VALUES ('0502', '机电系', '单片机原理');
INSERT INTO `profession` VALUES ('0503', '机电系', '机电设备故障与维修');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profession_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外键（专业）',
  `dormitory_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外键（宿舍）',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `kf_stu_prof`(`profession_id`) USING BTREE,
  INDEX `kf_stu_doem`(`dormitory_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`dormitory_id`) REFERENCES `dormitory` (`dormitory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`profession_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20170303201', '曾劲铭', '0', '0101', '01101');
INSERT INTO `student` VALUES ('20170303202', '陈锦新', '0', '0101', '01101');
INSERT INTO `student` VALUES ('20170303203', '陈丽萍', '1', '0101', 'GA101');
INSERT INTO `student` VALUES ('20170303204', '陈再旭', '0', '0101', '01101');
INSERT INTO `student` VALUES ('20170303205', '郭锦洪', '0', '0101', '01101');
INSERT INTO `student` VALUES ('20170303206', '黄镜桥', '0', '0101', '01101');
INSERT INTO `student` VALUES ('20170303207', '黄俊儒', '0', '0101', '01102');
INSERT INTO `student` VALUES ('20170303208', '江佳霖', '0', '0101', '01102');
INSERT INTO `student` VALUES ('20170303209', '江宇', '0', '0101', '01102');
INSERT INTO `student` VALUES ('20170303210', '孔德钊', '0', '0101', '01102');
INSERT INTO `student` VALUES ('20170303211', '赖志森', '0', '0101', '01102');
INSERT INTO `student` VALUES ('20170303212', '李瑞婷', '1', '0101', 'GA101');
INSERT INTO `student` VALUES ('20170303213', '梁曦', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303214', '梁育强', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303215', '林恩拓', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303216', '林俊豪', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303217', '林秀婷', '1', '0101', 'GA101');
INSERT INTO `student` VALUES ('20170303218', '刘梦彬', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303219', '罗金龙', '0', '0101', '02101');
INSERT INTO `student` VALUES ('20170303220', '施镇楠', '0', '0101', '02102');
INSERT INTO `student` VALUES ('20170303221', '汤招剑', '0', '0101', '02102');
INSERT INTO `student` VALUES ('20170303222', '唐梓健', '0', '0101', '02102');
INSERT INTO `student` VALUES ('20170303223', '王景良', '0', '0101', '02102');
INSERT INTO `student` VALUES ('20170303224', '吴泽鑫', '0', '0101', '02102');
INSERT INTO `student` VALUES ('20170303225', '杨天琪', '1', '0101', 'GA101');
INSERT INTO `student` VALUES ('20170303226', '杨潇翔', '0', '0101', 'NA101');
INSERT INTO `student` VALUES ('20170303227', '杨允东', '0', '0101', 'NA101');
INSERT INTO `student` VALUES ('20170303228', '姚晓玲', '1', '0101', 'GA101');
INSERT INTO `student` VALUES ('20170303229', '叶宝雄', '0', '0101', 'NA101');
INSERT INTO `student` VALUES ('20170303230', '袁孟蛟', '0', '0101', 'NA101');
INSERT INTO `student` VALUES ('20170303231', '张金业', '0', '0101', 'NA101');
INSERT INTO `student` VALUES ('20170303232', '周炜正', '0', '0101', 'NB101');
INSERT INTO `student` VALUES ('20170303233', '朱炜涛', '0', '0101', 'NB101');
INSERT INTO `student` VALUES ('20170303234', '测试哥1', '0', '0102', 'NB101');
INSERT INTO `student` VALUES ('20170303235', '测试哥2', '0', '0102', 'NB101');
INSERT INTO `student` VALUES ('20170303236', '测试姐1', '1', '0103', 'GA102');
INSERT INTO `student` VALUES ('20170303237', '测试姐2', '1', '0103', 'GA102');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menuid` int(50) NOT NULL,
  `menuname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menuurl` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menugrade` int(10) NOT NULL,
  `menuparentid` int(10) NOT NULL,
  `menuislastnode` int(10) NOT NULL,
  `menustatus` int(10) NOT NULL,
  `menuorder` int(10) NOT NULL,
  `menutarget` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'desktop',
  PRIMARY KEY (`menuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (100, '系统管理', '/', 1, -1, 1, 0, 100, 'desktop');
INSERT INTO `sys_menu` VALUES (200, '基准管理', '/', 1, -1, 0, 0, 200, 'desktop');
INSERT INTO `sys_menu` VALUES (1005, '用户管理', '/SpringMVCMybatisDemo/user.do?action=sysUserIndex&curPage=1&pageRows=12', 2, 100, 0, 0, 1005, 'desktop');
INSERT INTO `sys_menu` VALUES (1006, '角色管理', '/SpringMVCMybatisDemo/sysRole.do?action=sysRoleIndex&curPage=1&pageRows=12', 2, 100, 0, 0, 1006, 'desktop');
INSERT INTO `sys_menu` VALUES (1007, '菜单管理', '/SpringMVCMybatisDemo/sysMenu.do?action=sysMenuIndex&curPage=1&pageRows=12', 2, 100, 0, 0, 1007, 'desktop');
INSERT INTO `sys_menu` VALUES (2001, '物料管理', '/SpringMVCMybatisDemo/item.do?action=basItemIndex&curPage=1&pageRows=12', 2, 200, 0, 0, 2001, 'desktop');
INSERT INTO `sys_menu` VALUES (2002, '测试测试', '/SpringMVCMybatisDemo/Myitem.do?action=basItemIndex', 2, 200, 0, 0, 2002, 'desktop');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `rolecode` int(50) UNSIGNED NOT NULL,
  `rolename` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleremark` varchar(145) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rolemenus` varchar(415) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rolestatus` int(11) NOT NULL,
  PRIMARY KEY (`rolecode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (100, '系统管理员', '系统管理员', '-1,100,1005,1006,1007,200,2001,2002', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uuid` int(50) NOT NULL,
  `usercode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usernickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usertype` int(11) NOT NULL,
  `userpwd` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usercreatedate` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userstatus` int(10) NOT NULL,
  `userremark` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usertel` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `useremail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usersourcecode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '1000', 'admin', 0, '8345d72c1cb59c5bb89a849fe04e6628', '2015-07-01 14:12:00', 0, '管理员', '13922590600', '3756505@qq.com', '-1', '');
INSERT INTO `sys_user` VALUES (2, '1001', 'asdfads', 0, '8345d72c1cb59c5bb89a849fe04e6628', '2017-03-04 21:02:45', 1, '', '', '', '-1', 'adsfds');
INSERT INTO `sys_user` VALUES (3, '1002', 'kkkk', 0, '8345d72c1cb59c5bb89a849fe04e6628', '2017-03-04 21:03:53', 0, '', '', '', '-1', 'kkk');

-- ----------------------------
-- Table structure for sys_userrole
-- ----------------------------
DROP TABLE IF EXISTS `sys_userrole`;
CREATE TABLE `sys_userrole`  (
  `useruuid` int(50) UNSIGNED NOT NULL,
  `rolecode` int(50) UNSIGNED NOT NULL,
  PRIMARY KEY (`useruuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_userrole
-- ----------------------------
INSERT INTO `sys_userrole` VALUES (1, 100);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `userid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `usercode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userpwd` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '1', '');

SET FOREIGN_KEY_CHECKS = 1;
