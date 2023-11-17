CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES (1,'Leo','leo@gmail.com','password');

UNLOCK TABLES;
