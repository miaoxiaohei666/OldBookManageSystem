-- ----------------------------
-- insert user
-- ----------------------------
INSERT INTO users VALUES(2020213724,2020,'gzw','ppx',12345678910,'135313545','4531365645','12345678',0,0,0);
INSERT INTO users VALUES(2019213726,2020,'lbr','ppt',13215646568,'231356546','4564545656','12345678',0,0,0);
INSERT INTO users VALUES(2020213673,2020,'xxy','miaoxiaohei',15892603115,'15892603115','1521260640',12345678,0,0,0);
-- ----------------------------
-- insert sort
-- ----------------------------
INSERT INTO sort(sgrade,sname) VALUES('大一上','高数A上');
INSERT INTO sort(sgrade,sname) VALUES('大一下','高数A下');
INSERT INTO sort(sgrade,sname) VALUES('大二上','数字逻辑');
INSERT INTO sort(sgrade,sname) VALUES('大二下','数据库原理');
INSERT INTO sort(sgrade,sname) VALUES('大三上','操作系统');
INSERT INTO sort(sgrade,sname) VALUES('大三下','计算机网络');
INSERT INTO sort(sgrade,sname) VALUES('大四上','云计算');
-- ----------------------------
-- insert book
-- ----------------------------
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(1,'高数A上','2022-06-24 10:53:38',20,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(3,'数字逻辑','2022-06-25 10:53:38',25,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(4,'数据库原理','2022-06-26 10:53:38',30,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(2,'高数A下','2022-06-27 10:53:38',20,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(1,'高数A上','2022-06-25 10:53:38',20,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(5,'操作系统','2022-06-28 10:53:38',25,'很重要',0);
INSERT INTO book(sno,bname,create_time,bprice,bdescribe,bstate) VALUES(4,'数据库原理','2022-06-27 10:53:38',25,'很重要',0);
-- ----------------------------
-- insert publish
-- ----------------------------
INSERT INTO publish VALUES(2020213724,1);
INSERT INTO publish VALUES(2019213726,2);
INSERT INTO publish VALUES(2019213726,3);
INSERT INTO publish VALUES(2020213724,4);
INSERT INTO publish VALUES(2020213673,5);
INSERT INTO publish VALUES(2020213673,6);
INSERT INTO publish VALUES(2019213726,7);
-- ----------------------------
-- insert want
-- ----------------------------
INSERT INTO want VALUES(4,2019213726);
INSERT INTO want VALUES(7,2020213673);
INSERT INTO want VALUES(5,2020213724);