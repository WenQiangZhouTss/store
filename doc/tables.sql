-- NOTE! 执行以下sql语句前确保你已经在数据库中建立了store数据库
-- create database store;
use store;

-- 创建用户表
DROP TABLE `user` if exists;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,  #用户编号
  `username` varchar(20) DEFAULT NULL,		#用户名
  `password` varchar(20) DEFAULT NULL,		#密码
  `name` varchar(20) DEFAULT NULL,			#昵称
  `email` varchar(30) DEFAULT NULL,			#电子邮箱
  `telephone` varchar(20) DEFAULT NULL,		#电话
  `birthday` date DEFAULT NULL,				#生日
  `sex` varchar(10) DEFAULT NULL,			#性别
  `state` int(11) DEFAULT 0,				#状态：0=未激活，1=已激活
  `code` varchar(64) DEFAULT NULL,			#激活码
  PRIMARY KEY (`uid`)
) ;

INSERT INTO `user` 
VALUES
('373eb242933b4f5ca3bd43503c34668b','ccc','ccc','aaa','bbb@store.com','15723689921','2015-11-04','男',0,'9782f3e837ff422b9aee8b6381ccf927bdd9d2ced10d48f4ba4b9f187edf7738'),
('3ca76a75e4f64db2bacd0974acc7c897','bb','bb','张三','bbb@store.com','15723689921','1990-02-01','男',0,'1258e96181a9457987928954825189000bae305094a042d6bd9d2d35674684e6'),
('62145f6e66ea4f5cbe7b6f6b954917d3','cc','cc','张三','bbb@store.com','15723689921','2015-11-03','男',0,'19f100aa81184c03951c4b840a725b6a98097aa1106a4a38ba1c29f1a496c231'),
('c95b15a864334adab3d5bb6604c6e1fc','bbb','bbb','老王','bbb@store.com','15712344823','2000-02-01','男',0,'71a3a933353347a4bcacff699e6baa9c950a02f6b84e4f6fb8404ca06febfd6f'),
('f55b7d3a352a4f0782c910b2c70f1ea4','test','test','灭霸一号','aaa@store.com','15712344823','2000-02-01','男',1,NULL);