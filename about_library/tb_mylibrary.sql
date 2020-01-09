-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema tb_mylibrary
--

CREATE DATABASE IF NOT EXISTS tb_mylibrary;
USE tb_mylibrary;

--
-- Definition of table `tb_bad`
--

DROP TABLE IF EXISTS `tb_bad`;
CREATE TABLE `tb_bad` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `username` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `studentid` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_bad`
--

/*!40000 ALTER TABLE `tb_bad` DISABLE KEYS */;
INSERT INTO `tb_bad` (`id`,`username`,`type`,`studentid`,`phone`) VALUES 
 (1,'安倍晋三','书籍破损','20140404444','4354');
/*!40000 ALTER TABLE `tb_bad` ENABLE KEYS */;


--
-- Definition of table `tb_books`
--

DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `book` varchar(45) default NULL,
  `author` varchar(45) default NULL,
  `price` int(11) unsigned default NULL,
  `press` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `number` int(11) unsigned default NULL,
  `have` int(11) unsigned default NULL,
  `unhave` int(11) unsigned default NULL,
  `location` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_books`
--

/*!40000 ALTER TABLE `tb_books` DISABLE KEYS */;
INSERT INTO `tb_books` (`id`,`book`,`author`,`price`,`press`,`type`,`number`,`have`,`unhave`,`location`) VALUES 
 (1,'JSP应用开发与实践','王冲',52,'高等教育出版社','计算机类',5,4,1,'A_1_7'),
 (2,'毛概','高英',25,'人民邮电出版社','科学类',4,2,2,'B_2_6'),
 (3,'OC入门教程','范博涛',34,'中国工信出版集团','计算机类',3,1,2,'A_2_1'),
 (4,'神雕侠侣','金庸',67,'清华大学出版社','小说类',3,2,1,'A_3_6'),
 (5,'天龙八部','金庸',47,'清华大学出版社','小说类',4,3,1,'A_2_4'),
 (6,'鬼吹灯','天下霸唱',43,'北京人民出版社','小说类',5,4,1,'B_4_9'),
 (7,'十万个为什么','钟朝良',25,'高等教育出版社','科学类',8,6,2,'B_3_3'),
 (8,'安徒生故事集','安徒生',78,'人民邮电出版社','儿童类',9,6,3,'C_1_6'),
 (9,'阿里巴巴怪盗','马云',10,'松山学院出版社','儿童类',4,2,2,'B_1_3'),
 (10,'霍金理论','霍金',88,'高等教育出版社','科学类',5,3,2,'C_3_2'),
 (11,'未解之谜','徐佳欣',11,'新青年出版社','科学类',6,5,1,'A_1_5'),
 (12,'计算机英语','盘锦源',36,'新青年出版社','计算机类',7,3,4,'A_3_2'),
 (13,'青年文摘','布置到',4,'中国工信出版集团','杂志类',8,5,3,'C_4_8'),
 (14,'读者','艾水水',4,'中工信出版集团','杂志类',9,2,7,'C_1_9'),
 (15,'装男人','戴德聘',6,'新潮流出版社','杂志类',3,2,1,'D_1_10');
/*!40000 ALTER TABLE `tb_books` ENABLE KEYS */;


--
-- Definition of table `tb_people`
--

DROP TABLE IF EXISTS `tb_people`;
CREATE TABLE `tb_people` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `number` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_people`
--

/*!40000 ALTER TABLE `tb_people` DISABLE KEYS */;
INSERT INTO `tb_people` (`id`,`number`,`name`,`password`) VALUES 
 (1,'20170303204','czx','123456'),
 (2,'20170303220','szn','123456');
/*!40000 ALTER TABLE `tb_people` ENABLE KEYS */;


--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `username` varchar(45) default NULL,
  `bookname` varchar(45) default NULL,
  `studentid` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `number` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`username`,`bookname`,`studentid`,`phone`,`time`,`number`) VALUES 
 (1,'张三','JSP应用开发与实践','20170303000','10086','2018年11月24日','1'),
 (2,'李四','毛概','20170303001','10086','2018年11月24日','2'),
 (3,'王五','OC入门教程','20170303002','10086','2018年11月24日','2'),
 (4,'赵柳','神雕侠侣','20170303003','10086','2018年11月24日','1'),
 (5,'张起','天龙八部','20170303004','10086','2018年11月24日','1'),
 (6,'赖久','鬼吹灯','20170303005','10086','2018年11月24日','1'),
 (7,'王大锤','十万个为什么','20170303006','10086','2018年11月24日','2'),
 (8,'树小美','安徒生故事集','20170303008','10086','2018年11月24日','3'),
 (9,'蘑菇头','阿里巴巴怪盗','20170303009','10086','2018年11月24日','2'),
 (10,'大鹏','霍金理论','20170303010','10086','2018年11月24日','2'),
 (11,'刘德华','未解之谜','20170303011','10086','2018年11月24日','1'),
 (12,'张学友','计算机英语','20170303012','10086','2018年11月24日','4'),
 (13,'黎明','青年文摘','20170303013','10086','2018年11月24日','3'),
 (14,'郭富城','读者','20170303014','10086','2018年11月24日','7'),
 (15,NULL,NULL,NULL,NULL,NULL,'1'),
 (16,NULL,NULL,NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
