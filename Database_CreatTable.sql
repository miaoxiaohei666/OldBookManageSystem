-- ----------------------------
-- drop table
-- ----------------------------
drop table if exists want;
drop table if exists publish;
drop table if exists book;
drop table if exists sort;
drop table if exists users;
-- ----------------------------
-- USER
-- ----------------------------
create table users
(uno numeric(10,0) not null primary key,
 ugrade numeric(4,0) not null,
 uname varchar(255) not null,
 unickname varchar(255) not null,
 utel numeric(11,0) not null,
 uwechat varchar(255) default null,
 uqq varchar(255) default null,
 upassword varchar(255) not null,
 ustate bit default null,
 ulike int default null,
 unlike int default null
);


-- ----------------------------
-- SORT
-- ----------------------------
create table sort
(sno int not null primary key AUTO_INCREMENT,
sgrade varchar(255) not null ,
 sname varchar(255) not null
);

-- ----------------------------
-- BOOK
-- ----------------------------
create table book
(bno int not null primary key AUTO_INCREMENT,
 sno int not null,
 bname varchar(255) not null,
 create_time varchar(255) not null,
 bpicture varchar(255) default null,
 bprice int not null,
 bdescribe text not null,
 bstate bit default null,
 foreign key (sno) references sort(sno)
);

-- ----------------------------
-- PUBLISH
-- ----------------------------
create table publish
(uno numeric(10,0) not null,
 bno int not null,
 foreign key (uno) references users(uno),
 foreign key (bno) references book(bno)
);

-- ----------------------------
-- WANT
-- ----------------------------
create table want
(bno int not null,
 uno numeric(10,0) not null,
 foreign key (bno) references book(bno),
 foreign key (uno) references users(uno)
);
