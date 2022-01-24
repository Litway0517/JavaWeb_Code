/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.28-log : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) DEFAULT NULL,
  `book_price` decimal(11,2) DEFAULT NULL,
  `book_author` varchar(100) DEFAULT NULL,
  `book_sales` int(11) DEFAULT NULL,
  `book_stock` int(11) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0' COMMENT '0 显示 2 删除',
  `book_img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`book_name`,`book_price`,`book_author`,`book_sales`,`book_stock`,`del_flag`,`book_img_path`) values (1,'java从入门到放弃','80.00','国哥',278,593,'0','static/img/default.jpg'),(2,'数据结构与算法','78.50','严敏君',4262,394,'0','static/img/default.jpg'),(3,'怎样拐跑别人的媳妇','68.00','龙伍',388895,31,'0','static/img/default.jpg'),(4,'木虚肉盖饭','16.00','小胖',5556,32,'0','static/img/default.jpg'),(5,'C++编程思想','45.50','刚哥',14,95,'0','static/img/default.jpg'),(6,'蛋炒饭','9.90','周星星',12,53,'0','static/img/default.jpg'),(7,'赌神','66.50','龙伍',125,535,'2','static/img/default.jpg'),(8,'Java编程思想','99.50','阳哥',47,36,'0','static/img/default.jpg'),(9,'JavaScript从入门到精通','9.90','婷姐',85,95,'0','static/img/default.jpg'),(10,'cocos2d-x游戏编程入门','49.00','国哥',58,56,'0','static/img/default.jpg'),(11,'C语言程序设计','28.00','谭浩强',52,74,'0','static/img/default.jpg'),(12,'Lua语言程序设计','51.50','雷丰阳',48,82,'0','static/img/default.jpg'),(13,'大话西游','35.70','罗贯中',5926,3373,'0','static/img/default.jpg'),(14,'水浒传','33.05','华仔',22,88,'2','static/img/default.jpg'),(15,'操作系统原理','133.05','刘优',122,188,'2','static/img/default.jpg'),(16,'数据结构 java版','173.15','封大神',21,81,'0','static/img/default.jpg'),(17,'UNIX高级环境编程','99.15','乐天',210,810,'0','static/img/default.jpg'),(18,'javaScript高级编程','69.15','国哥',210,810,'0','static/img/default.jpg'),(19,'大话设计模式','89.15','国哥',20,10,'0','static/img/default.jpg'),(20,'人月神话','88.15','刚哥',22,78,'0','static/img/default.jpg'),(25,'国哥为什么那么帅?','32.00','国哥',353,11,'0','static/img/default.jpg'),(26,'国哥在手, 天下我有!','10151.00','ZIt',645,0,'0','static/img/default.jpg'),(29,'时间简史1','30.00','霍金',200,500,'0','static/img/default.jpg'),(30,'时间简史2','30.00','霍金',200,5555,'0','static/img/default.jpg'),(31,'JDBC宋红康主编','30.00','霍金',200,300,'0','static/img/default.jpg'),(32,'高效学习','30.00','霍金',200,3566,'0','static/img/default.jpg'),(33,'时间简史_终极版本','30.00','霍金',200,300,'0','static/img/default.jpg'),(34,'高级图书','565.00','112',3322,11,'0','static/img/default.jpg'),(35,'黑客帝国 卷土重来','59.00','litway',24,1,'0','static/img/default.jpg'),(36,'test1','59.00','Tom',23,6,'2','static/img/default.jpg'),(37,'测试点A','59.00','无名氏',23,2,'2','static/img/default.jpg'),(38,'爆破点','5599.00','litway',99999999,2,'0','static/img/default.jpg'),(39,'爆破点Plus','10999.00','litway',0,0,'0','static/img/default.jpg'),(40,'Spring','59.00','咕泡学院',99936,53,'0','static/img/default.jpg'),(41,'Spring5核心原理','119.00','谭德勇',56848,6318,'0','static/img/default.jpg'),(42,'测试的步骤','59.00','Tom',396,26,'2','static/img/default.jpg'),(43,'测试的步骤2','99.00','Tom',652,25,'0','static/img/default.jpg'),(44,'Java从入门到入土','1999.00','Job',251,25,'2','static/img/default.jpg'),(45,'Java从入门到入土','1999.00','J',0,0,'2','static/img/default.jpg'),(46,'Java从入门到入土','1999.00','Job',24245,6665,'2','static/img/default.jpg'),(47,'Java从入门到入土','1999.00','Job',265,22,'0','static/img/default.jpg'),(48,'Java从入门到入土','1999.00','Job',43,44,'2','static/img/default.jpg'),(49,'test',NULL,NULL,NULL,NULL,'2','static/img/default.jpg'),(50,'1','1.00','1',1,1,'2','static/img/default.jpg'),(51,'Hybris','399.00','litway2',55956,23,'2','static/img/default.jpg'),(52,'test','3.89','test',599,22,'2','static/img/default.jpg');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`order_id`,`create_time`,`price`,`status`,`user_id`) values ('16424076008221','2022-01-17 16:20:00','146.50',1,1),('16424095177521','2022-01-17 16:51:57','320.00',1,1),('16424143782521','2022-01-17 18:12:58','190.00',2,1),('16424146602661','2022-01-17 18:17:40','190.00',1,1),('16424234154841','2022-01-17 20:43:35','320.00',1,1),('164242888093220','2022-01-17 22:14:40','420.50',1,20),('164242903624920','2022-01-17 22:17:16','59.00',0,20),('164242904991020','2022-01-17 22:17:29','80.00',0,20),('164242905702620','2022-01-17 22:17:37','80.00',0,20),('164242906209820','2022-01-17 22:17:42','80.00',0,20),('164242906618320','2022-01-17 22:17:46','80.00',0,20),('164242907058320','2022-01-17 22:17:50','80.00',0,20),('164242909266120','2022-01-17 22:18:12','325.00',1,20),('164247158502420','2022-01-18 10:06:25','214.50',0,20),('16424749048121','2022-01-18 11:01:44','16.00',1,1),('164249715776910','2022-01-18 17:12:37','242.50',1,10),('164251005726923','2022-01-18 20:47:37','80.00',1,23),('164251010873024','2022-01-18 20:48:28','178.00',1,24),('164251012278224','2022-01-18 20:48:42','59.00',1,24),('16426024074961','2022-01-19 22:26:47','184.00',1,1),('16427355138571','2022-01-21 11:25:13','84.00',0,1),('16427551653381','2022-01-21 16:52:45','340.50',1,1),('16427552318791','2022-01-21 16:53:51','340.50',0,1),('16427554052861','2022-01-21 16:56:45','84.00',1,1),('16427726403251','2022-01-21 21:44:00','136.00',0,1),('16427727122141','2022-01-21 21:45:12','68.00',1,1),('16427729563781','2022-01-21 21:49:16','203.00',0,1),('16428230461451','2022-01-22 11:44:06','68.00',1,1),('164282364741920','2022-01-22 11:54:07','100.00',1,20),('164282366404420','2022-01-22 11:54:24','634.00',1,20),('16430096548831','2022-01-24 15:34:14','84.00',1,1),('16430101676202','2022-01-24 15:42:47','100.00',0,2),('164301190635615','2022-01-24 16:11:46','178.00',1,15);

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Data for the table `t_order_item` */

insert  into `t_order_item`(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values (22,'数据结构与算法',1,'78.50','78.50','16424076008221'),(23,'怎样拐跑别人的媳妇',1,'68.00','68.00','16424076008221'),(24,'java从入门到放弃',4,'80.00','320.00','16424095177521'),(25,'黑客帝国 矩阵',3,'30.00','90.00','16424143782521'),(26,'计算机网络',1,'100.00','100.00','16424143782521'),(27,'黑客帝国 矩阵',3,'30.00','90.00','16424146602661'),(28,'计算机网络',1,'100.00','100.00','16424146602661'),(29,'怎样拐跑别人的媳妇',4,'68.00','272.00','16424234154841'),(30,'木虚肉盖饭',3,'16.00','48.00','16424234154841'),(31,'java从入门到放弃',1,'80.00','80.00','164242888093220'),(32,'数据结构与算法',1,'78.50','78.50','164242888093220'),(33,'怎样拐跑别人的媳妇',1,'68.00','68.00','164242888093220'),(34,'木虚肉盖饭',1,'16.00','16.00','164242888093220'),(35,'Spring',1,'59.00','59.00','164242888093220'),(36,'Spring5核心原理',1,'119.00','119.00','164242888093220'),(37,'Spring',1,'59.00','59.00','164242903624920'),(38,'java从入门到放弃',1,'80.00','80.00','164242904991020'),(39,'java从入门到放弃',1,'80.00','80.00','164242905702620'),(40,'java从入门到放弃',1,'80.00','80.00','164242906209820'),(41,'java从入门到放弃',1,'80.00','80.00','164242906618320'),(42,'java从入门到放弃',1,'80.00','80.00','164242907058320'),(43,'数据结构与算法',2,'78.50','157.00','164242909266120'),(44,'怎样拐跑别人的媳妇',2,'68.00','136.00','164242909266120'),(45,'木虚肉盖饭',2,'16.00','32.00','164242909266120'),(46,'怎样拐跑别人的媳妇',2,'68.00','136.00','164247158502420'),(47,'数据结构与算法',1,'78.50','78.50','164247158502420'),(48,'木虚肉盖饭',1,'16.00','16.00','16424749048121'),(49,'怎样拐跑别人的媳妇',1,'68.00','68.00','164249715776910'),(50,'数据结构与算法',1,'78.50','78.50','164249715776910'),(51,'木虚肉盖饭',1,'16.00','16.00','164249715776910'),(52,'java从入门到放弃',1,'80.00','80.00','164249715776910'),(53,'java从入门到放弃',1,'80.00','80.00','164251005726923'),(54,'Spring',1,'59.00','59.00','164251010873024'),(55,'Spring5核心原理',1,'119.00','119.00','164251010873024'),(56,'黑客帝国 卷土重来',1,'59.00','59.00','164251012278224'),(57,'怎样拐跑别人的媳妇',2,'68.00','136.00','16426024074961'),(58,'木虚肉盖饭',3,'16.00','48.00','16426024074961'),(59,'木虚肉盖饭',1,'16.00','16.00','16427355138571'),(60,'怎样拐跑别人的媳妇',1,'68.00','68.00','16427355138571'),(61,'怎样拐跑别人的媳妇',2,'68.00','136.00','16427726403251'),(62,'怎样拐跑别人的媳妇',1,'68.00','68.00','16427727122141'),(63,'怎样拐跑别人的媳妇',1,'68.00','68.00','16427729563781'),(64,'木虚肉盖饭',1,'16.00','16.00','16427729563781'),(65,'Spring5核心原理',1,'119.00','119.00','16427729563781'),(66,'怎样拐跑别人的媳妇',1,'68.00','68.00','16428230461451'),(67,'怎样拐跑别人的媳妇',1,'68.00','68.00','164282364741920'),(68,'木虚肉盖饭',2,'16.00','32.00','164282364741920'),(69,'数据结构与算法',4,'78.50','314.00','164282366404420'),(70,'java从入门到放弃',4,'80.00','320.00','164282366404420'),(71,'木虚肉盖饭',1,'16.00','16.00','16430096548831'),(72,'怎样拐跑别人的媳妇',1,'68.00','68.00','16430096548831'),(73,'怎样拐跑别人的媳妇',1,'68.00','68.00','16430101676202'),(74,'木虚肉盖饭',2,'16.00','32.00','16430101676202'),(75,'Spring5核心原理',1,'119.00','119.00','164301190635615'),(76,'Spring',1,'59.00','59.00','164301190635615');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`) values (1,'admin','admin','admin@atguigu.com'),(2,'张三','zs123','zhangsan@126.com'),(5,'李四','ls123','lisi@126.com'),(6,'王五','ww123','wangwu@126.com'),(8,'李六','ww123','wangwu@126.com'),(10,'Litway','Litway123','Litway@126.com'),(11,'Litway1','Litway123','litway@gmail.com'),(12,'Litway2','Litway123','litway@gmail.com'),(13,'litway3','litway','litway@126.com'),(14,'Litway4','Litway','litway4@163.com'),(15,'litway5','litway5','litway5@126.com'),(16,'litway6','litway6','litway6@163.com'),(17,'litway7','litway7','litway7@gmail.com'),(18,'litway8','litway8','litway8@gmain.com'),(19,'litway11','litway11','litway11@gmail.com'),(20,'litway10','litway10','litway10@gmail.com'),(21,'litway111','litway111','litway11@gaiml.com'),(22,'test111','test559','test559@163.com'),(23,'testA','testA','test@163.com'),(24,'testB','testB','test@163.com'),(25,'testAccount','123456','2222@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
