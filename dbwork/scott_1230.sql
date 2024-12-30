-- emp 테이블 연습
-- job 컬럼의 데이터 중 중복되는 데이터 1번만 출력
SELECT job FROM emp; -- 중복 데이터까지 출력
SELECT DISTINCT job FROM emp;
SELECT DISTINCT job, ename FROM emp; -- 다른 컬럼하고 같이 쓸 경우 미적용 or 오류

SELECT * FROM emp; -- 전체 컬럼 출력
SELECT ename, job FROM emp; -- 일부 컬럼만 출력

-- ename 오름차순 및 내림차순 정렬(default: ASC)
SELECT ename, job FROM emp ORDER BY ename; 
SELECT ename, job FROM emp ORDER BY ename DESC;

-- job의 오름차순, 같은 job일 경우 ename의 내림차순 조회
SELECT job, ename FROM emp ORDER BY job, ename DESC;
-- job의 오름차순, 같은 job일 경우 ename도 오름차순 조회
SELECT job, ename FROM emp ORDER BY job, ename;

-- 순서를 정할 때 컬럼명이 아닌 컬럼 번호로 대신해도 된다(출력되는 1번째 컬럼: 1)
SELECT job, ename FROM emp ORDER BY 1, 2; -- job(1) / ename(2)
-- sal의 오름차순 정렬
SELECT * FROM emp ORDER BY 6;
SELECT * FROM emp ORDER BY sal;

-- 다음 출력문에서 empno의 오름차순
SELECT ename, sal, comm, job, empno FROM emp ORDER BY 5;
SELECT ename, sal, comm, job, empno FROM emp ORDER BY empno;
-- ename 내림차순
SELECT ename, sal, comm, job, empno FROM emp ORDER BY 1 DESC;
SELECT ename, sal, comm, job, empno FROM emp ORDER BY ename DESC;


-- WHERE 조건문
SELECT ename, sal, comm FROM emp WHERE sal >= 1500;
SELECT ename, sal, comm FROM emp WHERE ename = 'allen'; -- 컬럼명은 상관 없는데 데이터는 대소문자 구분
SELECT ename, sal, comm FROM emp WHERE ename = 'ALLEN';

-- ename이 A로 시작하는 데이터 조회
SELECT ename, sal, comm FROM emp WHERE ename LIKE 'A%';
-- ename에 A가 포함된 모든 데이터 조회
SELECT ename, sal, comm FROM emp WHERE ename LIKE '%A%';

-- ename: A로 시작하는 사람과 S로 시작하는 사람을 조회
SELECT ename, sal, comm FROM emp WHERE ename LIKE 'A%' OR ename LIKE 'S%';
-- A와 S를 모두 포함하는 데이터만 출력
SELECT ename, sal, comm FROM emp WHERE ename LIKE '%A%' AND ename LIKE '%S%';

-- ename: 두번째 글자가 A인 사람만 조회: _는 1글자만 의미
SELECT ename, sal, comm FROM emp WHERE ename LIKE '_A%';
-- ename: 두번째 글자가 A이거나 세번째가 A인 사람만 조회
SELECT ename, sal, comm FROM emp WHERE ename LIKE '_A%' OR ename LIKE '__A%';

-- ename: N이나 K로 끝나는 사람만 조회
SELECT ename, sal, comm FROM emp WHERE ename LIKE '%N' OR ename LIKE '%K';

-- JOB이 ANALYST이면서 SAL이 1500 이상인 사람
SELECT ename, job, sal, comm FROM emp WHERE job = 'ANALYST' AND sal >= 1500;
-- SAL이 1200~2000 사이 값 조회
SELECT ename, job, sal, comm FROM emp WHERE sal >= 1200 AND sal <= 2000;
SELECT ename, job, sal, comm FROM emp WHERE sal BETWEEN 1200 AND 2000;

-- JOB이 MANAGER, SALESMAN, ANALYST 3가지 직업의 사람을 조회
SELECT ename, job, sal, comm FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'ANALYST';
SELECT ename, job, sal, comm FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'ANALYST');

-- empno: 7654, 7844, 7788, 7902 사람 조회
SELECT empno, ename, job, sal, comm FROM emp WHERE empno IN (7654, 7844, 7788, 7902);

-- comm: NULL 값인 것만 또는 아닌 것 출력
SELECT ename, job, sal, comm FROM emp WHERE comm IS NULL;
SELECT ename, job, sal, comm FROM emp WHERE comm IS NOT NULL;

-- mgr: NULL 아닌 경우 조회
SELECT * FROM emp WHERE mgr IS NOT NULL;

-- comm: NULL 인 경우 0, mgr: NULL인 경우 100으로 치환해 출력
SELECT ename, job, sal, NVL(mgr, 100), NVL(comm, 0) FROM emp;
 
SELECT sal, comm, sal+comm FROM emp; -- comm이 null인 경우 sal+comm 도 null
-- sal+comm: comm이 null이면 0으로 바꿔 계산
SELECT sal, comm, sal+NVL(comm, 0) FROM emp;

-- 컬럼 별칭 주기: alias
SELECT ename as "사원명", sal as "월급여" FROM emp;
SELECT ename "사원명", sal "월급여" FROM emp; -- as 생략 가능
SELECT ename 사원명, sal 월급여 FROM emp; -- 별칭에 공백이 없는 경우 "" 생략 가능
SELECT ename "사원 이름", sal 월급여 FROM emp;

-- 총 레코드 개수(데이터 개수)
SELECT count(*) FROM emp; -- 컬럼명 count(*)
SELECT count(*) count FROM emp; -- 컬럼명 count
SELECT count(*) 총갯수 FROM emp; -- 컬럼명 총갯수

-- sal+NVL(comm, 0) 컬럼명 => sum
SELECT sal, comm, sal+NVL(comm, 0) sum FROM emp;
SELECT sal 월급여, comm 커미션, sal+NVL(comm, 0) 총금액 FROM emp;

-- 문자열을 컬럼에 추가시 || 연산자 사용
SELECT '내 이름은'||ename||'입니다' 자기소개 FROM emp;

-- 내 직업은 salesman이고 내 월 급여는 1600입니다 - 자기소개 컬럼으로 출력
SELECT '내 직업은 '||job||'이고, 내 월 급여는 '||sal||'입니다.' 자기소개 FROM emp;

-- NOT: ~가 아닐 때
-- sal이 1500~2000 사이가 아닌 경우만 조회
SELECT * FROM emp WHERE sal NOT BETWEEN 1500 AND 2000;
-- NOT IN으로 job이 salesman, clerk가 아닌 경우
SELECT * FROM emp WHERE job NOT IN('SALESMAN', 'CLERK');

-- GROUP 함수: Count, Sum, Max, Min, Stddev
SELECT COUNT(*) FROM emp; -- 데이터 개수
SELECT SUM(sal) FROM emp; -- 총 합계
SELECT AVG(sal) FROM emp; -- 평균, 소숫점 이하가 너무 많이 나온다.
SELECT ROUND(AVG(sal), 2) FROM emp; -- 소숫점 이하 2자리
SELECT MAX(sal) FROM emp; -- 최댓값
SELECT MIN(sal) FROM emp; -- 최솟값
SELECT STDDEV(sal) FROM emp;

-- 평균 급여 보다 sal이 더 높은 사람 조회 => 서브 쿼리 필요: 쿼리 문 내의 쿼리문
SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);

-- SCOTT의 직업과 같은 직업을 가진 사람 조회
SELECT * FROM emp WHERE job = (SELECT job FROM emp WHERE ename = 'SCOTT');

-- SCOTT의 mgr과 같은 mgr을 가진 사람
SELECT * FROM emp WHERE mgr = (SELECT mgr FROM emp WHERE ename = 'SCOTT');

-- GROUP BY 절
SELECT job FROM emp GROUP BY job; -- job이 그룹별로 나열
-- 그룹별 인원수까지
SELECT job, count(*) 인원수 FROM emp GROUP BY job;

-- Having으로 조건까지 부여: 인원이 3명 이상인 경우
SELECT job, count(*) 인원수 FROM emp GROUP BY job HAVING count(job) >= 3;
SELECT job, count(*) 인원수 FROM emp GROUP BY job HAVING count(*) >= 3;

-- 인원순으로 출력(오름차순)
SELECT job, count(*) 인원수 FROM emp GROUP BY job HAVING count(*) >= 3 ORDER BY 인원수;
SELECT job, count(*) 인원수 FROM emp GROUP BY job HAVING count(*) >= 3 ORDER BY 2;

-- 직업별 인원수, 최저연봉, 최고연봉, 평균연봉(소숫점 X) 출력
SELECT job 직업, count(*) "직업별 인원수", min(sal) 최저연봉, max(sal) 최고연봉, round(avg(sal), 0) 평균연봉 
FROM emp GROUP BY job
ORDER BY 직업;

-- 숫자함수
SELECT ABS(-5), ABS(5) FROM DUAL; -- 절대값
 -- 반올림, 올림, 내림
SELECT ROUND(3.6, 0), CEIL(3.6), FLOOR(3.6) FROM DUAL;
SELECT ROUND(3.4, 0), CEIL(3.4), FLOOR(3.4) FROM DUAL;
SELECT ROUND(328947, -2) FROM DUAL;
SELECT ROUND(328957, -2) FROM DUAL;

SELECT ROUND(AVG(sal), 0), CEIL(AVG(sal)), FLOOR(AVG(sal)) FROM emp;

-- 지수 계산: Power(m, n) = m^n
-- 나머지 값: Mod(m, n) = m % n
SELECT POWER(3, 3), MOD(10, 3) FROM DUAL;

-- 문자열 처리 함수: CONCAT(결합), LOWER(소문자), UPPER(대문자), INITCAP(첫 글자만 대문자)
-- concat() : mysql은 3개 이상 가능한데 oracle은 2개 밖에 안 되어서 || 연산자를 더 많이 쓴다.
SELECT ename, CONCAT(ename, '님'), LOWER(ename), UPPER(ename), INITCAP(ename) FROM emp;

-- LPAD(문자열, n, 문자열2): n자리 중 남는 부분 왼쪽에 문자열2를 끼워 넣음
-- RPAD(문자열, n, 문자열2): n자리 중 남는 부분 오른쪽에 문자열2를 끼워 넣음
SELECT LPAD(sal, 10, '*'), RPAD(sal, 10, '*') FROM emp;
-- n이 더 큰 경우 잘리게 된다.(무조건 왼쪽부터 출력)
SELECT sal, LPAD(sal, 3, '*'), RPAD(sal, 3, '*') FROM emp;

-- SUBSTR()
SELECT SUBSTR('Happy Day', 7, 3) FROM DUAL; -- 7번 글자부터 3글자 추출
SELECT SUBSTR('Happy Day', -6, 3) FROM DUAL; -- 뒤에서 6번째 글자부터 3글자 추출

-- emp 테이블의 ename에서 왼쪽에서 3글자 추출 후 총 7자리 중 우측 빈공간은 *으로 채우기
SELECT RPAD(SUBSTR(ename, 1, 3), 7, '*') FROM emp;

-- LENGTH: 길이 구하기
SELECT ename 이름, LENGTH(ename) 문자길이 FROM emp;

-- REPLACE: 문자 대체(변경)
SELECT REPLACE('Happy Day', 'Happy', 'Good') FROM DUAL;
-- TRIM: 앞뒤 공백 제거 - 중간 공백 제거 불가(데이터 취급)
SELECT '*'||'  Lee SU JI '||'*' ,'*'||TRIM('  Lee SU JI ')||'*' FROM DUAL;

-- 날짜 처리 함수
-- 현재 날짜를 나타내는 sysdate
SELECT sysdate FROM DUAL;
SELECT sysdate+7 FROM DUAL; -- 7일 뒤 날짜
SELECT sysdate+1 FROM DUAL;-- 내일 날짜

-- to_char 함수로 원하는 날짜 모양으로 출력
-- mm: 월, mi: 분, hh: 12시간 표시, am/pm: 오전/오후 표시(자동), hh24: 24시간 표시
SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd am hh:mi') FROM dual;
SELECT to_char(sysdate, 'yyyy-mm-dd hh24:mi') FROM dual;

SELECT to_char(sysdate, 'month') FROM dual; -- 지역화에 따라 다르게 나와 사용 X

-- 현재 년도 4자리만 추출
SELECT to_char(sysdate, 'yyyy') FROM dual;
-- 현재 월 추출
SELECT to_char(sysdate, 'mm') FROM dual;
SELECT to_char(to_date('2024-5-10'), 'mm') FROM dual; -- 05로 출력

-- emp의 hiredate는 날짜 타입
SELECT to_char(hiredate, 'yyyy-mm-dd') 입사일 FROM emp;
SELECT to_char(hiredate, 'yyyy년mm월') 입사일 FROM emp; -- 오류 발생

