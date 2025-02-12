#02월 12일 수업 - 게시글 및 답글
create table reboard(
	num smallint auto_increment primary key,
    writer varchar(30),
    photo varchar(200), #writer, photo - 카카오에서 API로 얻기
    passwd varchar(20),
    subject varchar(500),
    content varchar(2000),
    readcount smallint default 0,
    writeday datetime,
    regroup smallint, #group에 대한 변수 (원글 그룹 번호)
    relevel smallint, #들여쓰기 - 답글 레벨(원글: 0, 답글: 1, 답글의 답글: 2...)
    restep smallint #출력순서 - 최근 답글이 기준(같은 그룹, 같은 레벨의 기준)
);