# 02월 19일 (수)
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

# 02월 20일 (목)
create table bootshopreple(
	idx smallint auto_increment primary key,
    num smallint,
    photo varchar(50),
    message varchar(300),
    likes smallint default 0,
    writetime datetime default now(),
    foreign key(num) references bootshop(num) on delete cascade
);

# 02월 21일 (금)
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

# 02월 26일 (수)
create table board (
	idx smallint auto_increment primary key,
    myid varchar(30),
    writer varchar(30),
    subject varchar(300),
    content varchar(2000),
    readcount smallint default 0,
    regroup smallint,
    relevel smallint,
    restep smallint,
    writeday datetime default now()
);

create table boardfile(
	num smallint auto_increment primary key,
    idx smallint,
    filename varchar(50),
    foreign key(idx) references board(idx) on delete cascade
);

# 02월 28일 (금)
create table boardreple(
	num smallint auto_increment primary key,
    idx smallint,
    myid varchar(30),
    message varchar(1000),
    photo varchar(50),
    writeday datetime default now(),
    foreign key(idx) references board(idx) on delete cascade
);