#创建用户表
CREATE TABLE member (
                        id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
                        user_id BIGINT(20)  NOT NULl COMMENT '用户id',
                        name VARCHAR(30) DEFAULT '' COMMENT '姓名',
                        age INT(11) DEFAULT 0 COMMENT '年龄',
                        email VARCHAR(50) DEFAULT '' COMMENT '邮箱',
                        manager_id BIGINT(20) DEFAULT 0 COMMENT '直属上级id',
                        create_time DATETIME DEFAULT '1920-01-01 00:00:00' COMMENT '创建时间'
)  ENGINE=INNODB CHARSET=UTF8;


#创建学生表
CREATE TABLE student (
                        id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
                        name VARCHAR(30) DEFAULT '' COMMENT '姓名',
                        age INT(11) DEFAULT 0 COMMENT '年龄',
                        class_id BIGINT(20)  NOT NULl COMMENT '班级id',
                        create_time DATETIME DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间'
)  ENGINE=INNODB CHARSET=UTF8;

INSERT INTO `mp`.`student` (`id`, `name`, `age`, `class_id`, `create_time`) VALUES ('1', '李雷', '12', '1', '1988-01-01 00:00:00');
INSERT INTO `mp`.`student` (`id`, `name`, `age`, `class_id`, `create_time`) VALUES ('2', '韩梅梅', '11', '1', '1989-01-01 00:00:00');
INSERT INTO `mp`.`student` (`id`, `name`, `age`, `class_id`, `create_time`) VALUES ('3', '王小明', '11', '1', '1988-01-02 00:00:00');
INSERT INTO `mp`.`student` (`id`, `name`, `age`, `class_id`, `create_time`) VALUES ('4', '李小帅', '12', '2', '1990-01-01 00:00:00');


#创建班级表
CREATE TABLE student_class (
                        class_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
                        class_name VARCHAR(30) DEFAULT '' COMMENT '姓名',
                        create_time DATETIME DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间'
)  ENGINE=INNODB CHARSET=UTF8;

# alter table student_class change  className class_name VARCHAR(30) DEFAULT '' COMMENT '姓名';
INSERT INTO `mp`.`student_class` (`class_id`, `class_name`, `create_time`) VALUES ('1', '一班', '1988-01-01 00:00:00');
INSERT INTO `mp`.`student_class` (`class_id`, `class_name`, `create_time`) VALUES ('2', '二班', '1988-01-01 00:00:00');