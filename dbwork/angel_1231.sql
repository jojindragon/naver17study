-- Sequence(시퀀스)
-- 데이터 관리를 편리하게 하기위해 고유 값을 주는 것 >> 게시판의 글들, 회원 정보 등등

-- 시퀀스 생성
CREATE SEQUENCE SEQ1; -- 1부터 1씩 자동증가하는 시퀀스 객체 생성(default 값)
CREATE SEQUENCE SEQ2 START WITH 1 INCREMENT BY 1; -- 위와 동일 결과
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 1 NOCACHE; -- CACHE 사이즈가 20 -> 0으로 변경
CREATE SEQUENCE SEQ4 MAXVALUE 100 NOCACHE; -- MAX 값을 100까지만
CREATE SEQUENCE SEQ5 START WITH 5 INCREMENT BY 5 NOCACHE; -- 5로 시작해서 5의 배수로 들어감

-- 시퀀스 전체 정보 출력
SELECT * FROM SEQ;

-- 시퀀스 값 발생시키기: 1번 발생한 값들은 2번 다시 안 나온다
SELECT SEQ1.NEXTVAL, SEQ2.NEXTVAL, SEQ3.NEXTVAL, SEQ4.NEXTVAL, SEQ5.NEXTVAL FROM DUAL;

-- 시퀀스 제거
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;
DROP SEQUENCE SEQ4;
DROP SEQUENCE SEQ5;

-- Table 생성
CREATE TABLE TEST1 (
    NUM NUMBER(3) PRIMARY KEY,  -- NUM: 숫자형(최대 3자리) 기본키
    NAME VARCHAR2(20) NOT NULL,  -- NAME: 문자형(최대 20자리) NULL 허용 X
    TODAY DATE  -- TODAY: 날짜 타입(DATE)
);

-- 구조 확인
DESC TEST1;

-- 데이터 추가
INSERT INTO test1 VALUES (1, 'CANDY', SYSDATE); -- 컬럼명 생략 시 모든 컬럼은 순서대로 값을 입력
-- PRIMARY KEY에 같은 값을 넣을 경우 나오는 오류
INSERT INTO test1 VALUES (1, 'MIRA', SYSDATE);
-- 이름을 뺴고(NULL 값) 입력할 경우 나오는 오류
INSERT INTO test1 (NUM, TODAY) VALUES (2, SYSDATE);

-- 전체 데이터 입력 - 단, 순서를 바꿔서
INSERT INTO test1 (NUM, TODAY, NAME) VALUES (2, '2024-11-20', 'MIRA');

-- INSERT 2개 추가한 상태에서 ROLLBACK 해보기 <= DML 관련만 작동: INSERT UPDATE DELETE
ROLLBACK;
-- 다시 INSERT 하고 넣은 후 COMMIT
-- COMMIT 이후 ROLLBACK: 취소 안 됨
COMMIT;

-- 데이터 확인
SELECT * FROM test1;


-- Test2: Test1과 같은데 제약조건 이름을 추가
CREATE TABLE TEST2 (
    NUM NUMBER(3) CONSTRAINT PK_TEST2_NUM PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT NN_TEST2_NAME NOT NULL,
    TODAY DATE
);

-- 오류 발생시켜보기
INSERT INTO test2 VALUES (1, '이영자', SYSDATE); -- 정상 추가
INSERT INTO test2 VALUES (1, '김말자', SYSDATE); -- 기본키 위배

SELECT * FROM test2;


-- 테이블 구조 변경: ALTER TABLE
-- 컬럼 추가: ADD, 컬럼 삭제: DROP, 컬럼 수정: MODIFY, 컬럼명 변경: RENAME COLUMN

-- TEST1에 AGE NUMBER(3) 컬럼 추가
ALTER TABLE test1 ADD AGE NUMBER(3); -- 나중에 추가하면 기존 값들은 NULL 값으로 입력됨
-- TEST1: ADDR VARCHAR2(30) 컬럼을 추가 - 기본값 SEOUL로 설정
ALTER TABLE test1 ADD ADDR VARCHAR2(30) DEFAULT 'SEOUL';
-- TEST1: GAIPDAY DATE 컬럼 추가 - 기본값 현재 날짜
ALTER TABLE test1 ADD GAIPDAY DATE DEFAULT SYSDATE;

-- TEST1의 Today 컬럼 삭제하기 - DROP 이용
ALTER TABLE test1 DROP COLUMN TODAY;
-- TEST1의 NAME 길이를 20에서 30으로 수정
ALTER TABLE test1 MODIFY name VARCHAR(30);

-- TEST1의 ADDR을 ADDRESS로 컬럼명 변경
ALTER TABLE test1 RENAME COLUMN ADDR TO ADDRESS;
-- TEST1: GAIPDAY -> WRITEDAY로 변경
ALTER TABLE test1 RENAME COLUMN GAIPDAY TO WRITEDAY;


-- TEST1
-- 제약조건 중 SYS_C008317 제거
ALTER TABLE test1 DROP CONSTRAINT SYS_C008317;
-- 제약조건 추가(CHECK 속성 이용) - CK_TEST1_AGE AGE 나이범위가 10~30
ALTER TABLE test1 ADD CONSTRAINT CK_TEST1_AGE CHECK(AGE >= 10 AND AGE <= 30);

-- AGE 범위 값 오류 확인
INSERT INTO test1(NUM, NAME, AGE) VALUES(3, 'SON', 34);

-- 5분 문제 TEST2
-- 1. BLOOD VARCHAR2(10) 초기값 A로 추가
ALTER TABLE test2 ADD BLOOD VARCHAR2(10) DEFAULT 'A';
-- 2. TODAY 컬럼 제거
ALTER TABLE test2 DROP COLUMN TODAY;
-- 3. NAME을 SAWON_NAME으로 컬럼이름 변경
ALTER TABLE test2 RENAME COLUMN NAME TO SAWON_NAME;

-- 4. BLOOD에 제약조건 추가 - CK_TEST2_BLOOD: (A, B, O, AB 만 가능하도록 CHECK)
ALTER TABLE test2 ADD CONSTRAINT CK_TEST2_BLOOD CHECK(BLOOD IN('A', 'B', 'O', 'AB'));
-- 5. NN_TEST2_NAME 제약조건 제거
ALTER TABLE test2 DROP CONSTRAINT NN_TEST2_NAME;

-- 연습용 테이블 제거
DROP TABLE TEST1;
DROP TABLE TEST2;
-------------------------------------------------------------------
-- 시퀀스 생성
CREATE SEQUENCE SEQ1 NOCACHE; -- 캐시가 없는 시퀀스(1~ 1씩 증가)
-- 테이블 생성
CREATE TABLE SAWON (
    NUM NUMBER(3) CONSTRAINT PK_SAWON_NUM PRIMARY KEY,
    NAME VARCHAR2(20),
    BUSEO VARCHAR2(20),
    GENDER VARCHAR2(10) DEFAULT '남자',
    AGE NUMBER(3),
    HEIGHT NUMBER(5, 1), -- DOUBLE 형: 5자리 중 소숫점 1자리
    WRITEDAY DATE
);

-- 제약조건 추가
-- CK_SAWON_BUSEO(부서명: '홍보부', '교육부', '관리부' 만 가능)
-- CK_SAWON_GENDER(성별: '남자', '여자'만 가능)
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_BUSEO CHECK(BUSEO IN('홍보부', '교육부', '관리부'));
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_GENDER CHECK(GENDER IN('남자', '여자'));

-- 데이터 추가
INSERT INTO sawon VALUES (seq1.nextval, '이진', '홍보부', '여자', 29, 167.9, SYSDATE);
INSERT INTO sawon (num, name, buseo, age) VALUES (seq1.nextval, '강호동', '관리부', 35);
INSERT INTO sawon (num, name, buseo, height) VALUES (seq1.nextval, '유재석', '홍보부', 178.5);
INSERT INTO sawon VALUES (seq1.nextval, '송해나', '홍보부', '여자', 31, 159.9, SYSDATE);
INSERT INTO sawon (num, name, buseo, gender, age, writeday) VALUES (seq1.nextval, '이영자', '교육부', '여자', 42, sysdate);
COMMIT;

-- UPDATE 문: 수정
UPDATE sawon SET height = 186.5; -- where 절 없으면 전체 수정
-- 취소
ROLLBACK;

-- NUM = 3인 경우만 수정
UPDATE sawon SET height = 186.5 WHERE num = 3;
-- 여러 컬럼을 수정
UPDATE sawon SET buseo = '홍보부', age = 39, height = 162.1 WHERE name = '이영자';

-- WRITEDAY 가 NULL 인 경우 '2024-12-12'로 변경
UPDATE sawon SET writeday = '2024-12-12' WHERE writeday IS NULL;
COMMIT;

-- DELETE 문: 삭제
DELETE FROM sawon; -- where 절 없으면 전체 삭제
ROLLBACK;

-- AGE가 NULL인 데이터 모두 삭제
DELETE FROM sawon WHERE age IS NULL;


-- GROUP BY 연습
-- 부서별 인원수 & 평균 나이 구하기
SELECT buseo 부서명, COUNT(*) 인원수, ROUND(AVG(age), 0) 평균나이 FROM sawon GROUP BY buseo;
-- 성별 인원수 & 평균 나이 구하기
SELECT gender 성별, COUNT(*) 인원수, ROUND(AVG(age), 0) 평균나이 FROM sawon GROUP BY gender;

----------------
-- JOIN 연습용 테이블 생성
CREATE TABLE FOOD ( -- 음식 테이블
    foodnum NUMBER(3) PRIMARY KEY,
    foodname VARCHAR2(20),
    foodprice NUMBER(7),
    foodsize VARCHAR2(20)
);

CREATE TABLE BOOKING ( -- 주문 테이블
    bnum NUMBER(3) CONSTRAINT pk_booking_bnum PRIMARY KEY,
    bname VARCHAR2(20) CONSTRAINT nn_booking_bname NOT NULL,
    bhp VARCHAR2(20) CONSTRAINT uq_booking_bhp UNIQUE,
    foodnum NUMBER(3),
    bookingday DATE,
    CONSTRAINT fk_foodnum FOREIGN KEY(foodnum) REFERENCES food(foodnum) -- booking 테이블의 foodnum을 외래키로 설정하고 food 테이블의 것을 참조
);
-- 이러면 주문 테이블 데이터를 지워도 음식쪽은 안 지워지지만 역은 가능
-- 만약 외래키로 설정하지 않으면 서로 영향은 안 주지만 없는 메뉴를 주문하게 될 수도 있다.

-- 메뉴 등록
INSERT INTO food VALUES (100, '짜장면', 9000, '보통');
INSERT INTO food VALUES (101, '짜장면', 11000, '곱배기');
INSERT INTO food VALUES (200, '탕수육', 15000, '보통');
INSERT INTO food VALUES (201, '탕수육', 20000, '곱배기');
INSERT INTO food VALUES (300, '칠리새우', 15000, '소');
INSERT INTO food VALUES (301, '칠리새우', 30000, '대');
INSERT INTO food VALUES (400, '해물짬뽕', 11000, '보통');
COMMIT;

SELECT * FROM food;

-- 시퀀스 생성 => BOOKING을 위한 시퀀스
CREATE SEQUENCE seq_food START WITH 10 INCREMENT BY 10 NOCACHE;

-- 예약(주문)
INSERT INTO booking VALUES (seq_food.nextval, '이영자', '010-1234-5678', 200, '2024-12-24');
-- 오류 발생시켜보기
INSERT INTO booking VALUES (seq_food.nextval, '김말자', '010-7777-5678', 401, '2025-01-10');
-- 무결성 제약조건
INSERT INTO booking VALUES (seq_food.nextval, '김말자', '010-7777-5678', 301, '2025-01-10');
INSERT INTO booking VALUES (seq_food.nextval, '이효리', '010-2323-5656', 400, '2025-02-10');
INSERT INTO booking VALUES (seq_food.nextval, '손에진', '010-7878-9999', 201, '2024-12-31');
COMMIT;

-- INNER JOIN으로 예약 손님의 주문정보 확인
SELECT 
    bname, bhp, foodname, foodprice, foodsize, TO_CHAR(bookingday, 'yyyy-mm-dd') BOOKINGDAY
FROM food f, booking b
WHERE f.foodnum = b.foodnum;

-- 1번도 주문 안한 메뉴 찾기 - 외부 조인(OUTER JOIN)
-- 이러면 food의 것은 전체 출력 >> booking 테이블에 없는 데이터 즉, 주문하지 않은 경우의 메뉴는 주문자가 null로 표시되어 나온다.
SELECT
    f.foodnum, bname, foodname, foodprice, foodsize
FROM food f, booking b
WHERE f.foodnum = b.foodnum(+);

-- 결론적으로 위의 SQL문으로 주문자 이름을 뺴고 NULL인 경우만 출력하여 아무도 주문하지 않은 메뉴만 골라낼 수 있다.
SELECT
    f.foodnum, bname, foodname, foodprice, foodsize
FROM food f, booking b
WHERE f.foodnum = b.foodnum(+) AND bname IS NULL;

-- BOOKING(자식 테이블)에 추가된 메뉴를 FOOD(부모 테이블)에서 삭제 가능한가?
-- >> 자식 테이블 생성 시 ON DELETE CASCADE 설정을 안 한 경우 못 지운다.
DELETE FROM food WHERE foodnum = 200; -- 이영자가 예약주문 했고 설정이 안되었으므로 삭제 불가
DELETE FROM food WHERE foodnum = 300; -- 아무도 주문을 예약 안했으므로 삭제 가능
DROP TABLE food; -- 자식 테이블이 있으므로 삭제 불가, 자식 먼저 삭제 시 가능

