drop table if exists USER;

create table USER
	(Uno numeric(10,0) not null primary key,
	 Ugrade numeric(4,0) not null,
	 Unme varchar(255) not null,
	 Unickname varchar(255) not null,
	 Utel numeric(11,0) not null,
	 Uwechat varchar(255) default null,
	 Uqq varchar(255) default null,
	 Upassword varchar(255) not null,
	 Ustate bit not null,
	 Ulike int not null,
	 Unlike int not null
	 );