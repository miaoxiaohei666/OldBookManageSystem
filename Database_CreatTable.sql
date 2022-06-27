-- ----------------------------
-- USER
-- ----------------------------
drop table if exists USER;
create table USER
(Uno numeric(10,0) not null primary key,
 Ugrade numeric(4,0) not null,
 Uname varchar(255) not null,
 Unickname varchar(255) not null,
 Utel numeric(11,0) not null,
 Uwechat varchar(255) default null,
 Uqq varchar(255) default null,
 Upassword varchar(255) not null,
 Ustate bit default null,
 Ulike int default null,
 Unlike int default null
);


INSERT INTO USER VALUES (2020213673,2020,'xxy','miaoxiaohei',15892603115,'15892603115','1521260640',12345678,0,0,0);

-- ----------------------------
-- SORT
-- ----------------------------
drop table if exists SORT;
create table SORT
(Sno numeric(10,0) not null primary key,
 Sname varchar(255) not null
);

-- ----------------------------
-- BOOK
-- ----------------------------
drop table if exists BOOK;
create table BOOK
(Bno varchar(255) not null primary key,
 Sno numeric(3,0) not null,
 Bname varchar(255) not null,
 Create_time varchar(255) not null,
 Bpicture varchar(255) not null,
 Bprice int not null,
 Bdescribe text not null,
 Bstate bit default null,
 foreign key (Sno) references SORT(Sno)
);

-- ----------------------------
-- PUBLISH
-- ----------------------------
drop table if exists PUBLISH;
create table PUBLISH
(Uno numeric(10,0) not null,
 Bno varchar(255) not null,
 foreign key (Uno) references USER(Uno),
 foreign key (Bno) references BOOK(Bno)
);

-- ----------------------------
-- WANT
-- ----------------------------
drop table if exists WANT;
create table WANT
(Bno varchar(255) not null,
 Uno numeric(10,0) not null,
 foreign key (Bno) references BOOK(Bno),
 foreign key (Uno) references USER(Uno)
);