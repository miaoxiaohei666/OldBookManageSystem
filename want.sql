drop table if exists WANT;

create table WANT
	(Bno varchar(255) not null,
	 Uno numeric(10,0) not null,
	 foreign key (Bno) references BOOK(Bno),
	 foreign key (Uno) references USER(Uno)
	 );