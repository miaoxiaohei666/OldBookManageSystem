drop table if exists PUBLISH;

create table PUBLISH
	(Uno numeric(10,0) not null,
	 Bno varchar(255) not null,
	 foreign key (Uno) references USER(Uno),
	 foreign key (Bno) references BOOK(Bno)
	 );