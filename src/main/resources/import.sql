USE  mh;
# DROP TABLE IF EXISTS `user`;
# CREATE TABLE `assistant_user` (`userid` bigint(20) NOT NULL AUTO_INCREMENT,`email` varchar(255) NOT NULL,`nick_name` varchar(255) DEFAULT NULL,`pass_word` varchar(255) NOT NULL,  `reg_time` varchar(255) NOT NULL,`user_name` varchar(255) NOT NULL,PRIMARY KEY (`userid`),UNIQUE KEY `UK_o77ap0bvrxaxwxw47n1hyt45w` (`email`),UNIQUE KEY `UK_83y7vvenwcl1jp0wy1s3xvtnw` (`user_name`),UNIQUE KEY `UK_np9hoj3ubl5wjjs3wuf1ec6oq` (`nick_name`)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of assistant_user
-- ----------------------------
INSERT INTO `user` (id,name,age)VALUES(1, 'admin', 18),(2, 'ceo', 19),(3, 'dev', 20),(4, 'bui', 21);
INSERT INTO `user` (id,name,age)VALUES(5, 'flower', 18);