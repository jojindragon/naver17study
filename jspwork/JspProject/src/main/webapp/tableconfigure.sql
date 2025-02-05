create table sawon (
	num smallint auto_increment primary key,
    sname varchar(20),
    sphoto varchar(30),
    ipsaday varchar(20),
    sbirth smallint,
    sblood varchar(3),
    writeday datetime
);

show tables;

select * from sawon;

create table simpleboard (
	num smallint auto_increment primary key,
    writer varchar(20),
    subject varchar(1000),
    content varchar(2000),
    readcnt smallint default 0,
    writeday datetime
);

select * from simpleboard;

create table simpleanswer(
	idx smallint auto_increment primary key,
    num smallint,
    nickname varchar(30),
    content varchar(1000),
    writeday datetime,
    -- 외부키 설정
    constraint fk_answer_num foreign key(num) 
		references simpleboard(num) on delete cascade
);

alter table simpleboard modify readcnt int;

# ajaxmemo - 02월 03일 월 생성
create table ajaxmemo (
	idx smallint auto_increment primary key,
    nickname varchar(30),
    avata varchar(50),
    message varchar(1000),
    writeday datetime
);

# 02월 04일 화 생성
create table shop(
	num smallint auto_increment primary key,
    sangpum varchar(50),
    scolor varchar(20),
    sprice int,
    sphoto varchar(50),
    ipgoday varchar(20),
    scnt smallint,
    writeday datetime
);

# 02월 06일 목 수업용 table 미리 작성
create table shopreple(
	idx smallint auto_increment primary key,
    num smallint,
    star smallint,
    message varchar(300),
    writeday datetime,
    foreign key(num) references shop(num) on delete cascade
);