# 02월 19일
create table bootshop (
	num smallint auto_increment primary key,
    sangpum varchar(30),
    scolor varchar(20),
    sprice int,
    scnt smallint,
    sphoto varchar(1000),
    ipgoday varchar(30),
    writeday datetime
);