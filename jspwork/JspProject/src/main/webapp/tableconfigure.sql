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
