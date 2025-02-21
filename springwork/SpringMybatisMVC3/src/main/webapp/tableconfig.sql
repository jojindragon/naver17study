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

# 02월 20일
create table bootshopreple(
	idx smallint auto_increment primary key,
    num smallint,
    photo varchar(50),
    message varchar(300),
    likes smallint default 0,
    writetime datetime default now(),
    foreign key(num) references bootshop(num) on delete cascade
);

# 02월 21일
create table member (
    num smallint auto_increment primary key,
    mname varchar(20),
    mpass varchar(20),
    myid varchar(20),
    mhp varchar(20),
    maddr varchar(300),
    mphoto varchar(100),
    gaipday datetime
);