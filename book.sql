drop table if exists BOOK;

create table BOOK
	(Bno varchar(255) not null primary key,
	 Bname varchar(255) not null,
	 Sno numeric(3,0) not null,
	 Create_time varchar(255) not null,
	 Bpicture varchar(255) not null,
	 Bprice int not null,
	 Bdescribe varchar(255) not null,
	 Bstate bit default null,
	 );
	 
 alter table book
 add constraint
 foreign key (Sno) references SORT(Sno)
 