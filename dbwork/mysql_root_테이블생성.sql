/* 데이터 타입
문자: char
	 varchar
숫자: tinyint		1byte
	 smallint		2byte
	 mediumint		3byte
     int			4byte
     bigint			8byte
     float	  실수	4byte
     double		"	8byte
     decimal(m, n)	m자리수, n 소숫점 자리수
     
날짜: date       CCYY-MM-DD 			- now()로 저장해도 날짜만 저장
     datetime	CCYY-MM-DD hh:mm:ss - now()로 저장 시 날짜와 시간 저장
     timestamp	"
     time		hh:mm:ss
     year		CCYY or YY
*/

create table person (
	num smallint auto_increment primary key, -- auto_increment: oracle의 default 시퀀스와 같은 역할
    name varchar(20),
    blood varchar(10) default 'B',
    age smallint,
    today date,
    writeday datetime
);

-- table 구조 확인
desc person; -- 테이블 형태
show create table person; -- 디테일한 구조확인(문장으로 보여줌)

-- 데이터 추가
insert into person (name, age, today, writeday) values ('이영자', 23, now(), now());
-- 모든 컬럼명 생략하고 순서대로 넣기
insert into person values (null, '강호동', 'AB', 45, now(), now()); -- num은 시퀀스 컬럼이므로 null로 줘도 숫자로 들어감
insert into person values (null, '유재석', 'O', 19, now(), now());
insert into person values (null, '고릴라', 'A', 22, now(), now());
insert into person values (null, '이효리', 'AB', 39, now(), now());
insert into person values (null, '손진아', 'B', 29, now(), now());

-- 각종 조회 연습
select num, name, age from person order by age asc; -- 나이 순 오름차순(asc 생략 가능)
select num, name, age from person order by age desc; -- 내림차순
select * from person where age >= 20 and age <=30;
select * from person where age between 20 and 30;
select * from person where blood = 'A' or blood = 'O' or blood = 'AB';
select * from person where blood in ('A', 'O', 'AB');
select * from person where name like '강%';
select * from person where name like '%영%';
select * from person where name like '_진%';
select * from person where name like '%석';

-- 그룹 함수: count, avg, sum, max, min
select count(*) from person;
select max(age) 최고령, min(age) 최연소, sum(age), round(avg(age), 0) from person;

-- group by: 혈액형 별 인원수 & 평균나이
select blood, count(*) 인원수, round(avg(age), 0) 평균나이
from person group by blood order by blood;

-- oracle에 없는 것: limit - 시작위치, 가져올 글의 갯수
select * from person limit 0, 3; -- 첫 행이 0번(index와 동일), 3개만 가져오기
select * from person limit 2, 3;

-- where 조건 & limit 사용
select * from person where age > 20 limit 1, 2; -- limit는 검색된 결과에서 순서로 책정

-- update
update person set blood = 'O', age = 18 where name = '고릴라';
-- delete
delete from person where name = '강호동';







