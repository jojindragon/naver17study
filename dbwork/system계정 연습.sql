-- system 등록된 table 확인
-- 커서가 있는 곳의 sql문 실행 단축키: Ctrl + Enter
select * from tab;

-- 등록된 user(계정) 확인: username column만 확인
select username from dba_users;

-- dba_users 테이블의 column 확인
desc dba_users; -- 기본 구조만 확인(데이터 확인 X)
select username, account_status from dba_users; -- 계정과 lock 상태 알아보기

-- scott 계정 생성: 비번(tiger) >> 연습용 계정
create user scott IDENTIFIED by tiger; -- 12버전부터 오류 발생

-- 12버전~ >> user 명에 공통문자열 C##이 들어가야 함
create user c##scott IDENTIFIED by tiger;

-- c##scott 계정 삭제, 이후 공통문자열 없이 생성하는 법
drop user c##scott;

alter SESSION set "_ORACLE_SCRIPT" = TRUE; -- SESSION 변경
create user scott IDENTIFIED by tiger; -- 공통문자열 없이 생성

CREATE USER angel IDENTIFIED by a1234;

select username, account_status from dba_users; -- 계정&lock 상태 보기

-- angel 계정 lock 설정 및 해제: lock 상태면 아무것도 못한다는 의미
alter user angel ACCOUNT lock;
alter user angel ACCOUNT UNLOCK;

-- scott & angel 계정에 기본 권한 부여
-- connect: 연결 권한(접속할 수 있는 권한)
-- resource: 데이터 관리 권한
grant connect, resource to angel;
grant connect, resource to scott;

-- 생성된 계정에서 테이블을 생성 후 데이터 추가 시도 > table space에 대한 오류 발생
-- table space를 unlimit로 설정(system 계정만 가능)
alter user angel DEFAULT TABLESPACE users QUOTA UNLIMITED on users;
alter user scott DEFAULT TABLESPACE users QUOTA UNLIMITED on users;

-- angel 비번: a1234 -> pw1234로 변경
alter user angel IDENTIFIED by pw1234;
