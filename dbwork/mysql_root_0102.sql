-- 전체 테이블 확인
show tables;
-- 현재 날짜&시간 구하기
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜 함수: 숫자로 반환
select year(now()) from dual; -- year(날짜): 년도
select month(now()) from dual; -- month(날짜): 월
select day(now()) from dual; -- day(날짜), dayofmonth(날짜): 일
select dayofmonth(now()) from dual;
select monthname(now()) from dual; -- 월을 영어로
select dayname(now()); -- 요일을 영어로

--  date_format(날짜, '형식') -> oracle의 to_char
-- %Y(년도 4자리), %M(월을 영어로), %d(날짜)
-- %y(년도 2자리), %m(월을 숫자로)
select date_format(now(), '%Y-%M-%d') from dual;
select date_format(now(), '%y-%m-%d') from dual;
-- %H(24시간), %h(12시간), %i(분 - 대소문자 무관), 
select date_format(now(), '%Y-%m-%d %H:%i') from dual;
select date_format(now(), '%Y년 %m월 %d일 %H시 %i분') from dual; -- 오라클과 다르게 됨

-- 문자 함수
-- concat(a, b): 문자열 결합 - oracle과 다르게 3개 이상 가능
select concat('Happy', 'Day', '!!') from dual;
-- replace('str', 'str1', 'str2'): 문자열 변경
select replace('bitcamp', 'bit', '비트') from dual;
-- instr('str', 'str1'): str1 위치 반환 -> 몇번째에 있느냐 반환
select instr('김숙영희란', '영희') from dual; -- 3
select instr('김숙영희란', '철수') from dual; -- 0

-- left('str', n): 왼쪽에서 추출
-- right('str', n): 오른쪽에서 추출
-- mid('str', a, n): a번째에서 n만큼 추출
-- substring('str', a, n): a번째에서 n만큼 추출alter
select left('123456789abcdef', 4), right('123456789abcdef', 4) from dual;
select mid('123456789abcdef', 8, 4), substring('123456789abcdef', 8, 4) from dual;

-- ltrim, rtrim, trim: 공백 제거(왼쪽 or 오른쪽 or 양쪽 모두)
select concat('*', '    Happy    ', '*') from dual;
select concat('*', ltrim('    Happy    '), '*') from dual;
select concat('*', rtrim('    Happy    '), '*') from dual;
select concat('*', trim('    Happy    '), '*') from dual;

-- 대/소문자 변환/거꾸로: upper, ucase / lower, lcase / reverse
select upper('HappY dAy HahA') from dual;
select ucase('HappY dAy HahA') from dual;
select lower('HappY dAy HahA') from dual;
select lcase('HappY dAy HahA') from dual;
select reverse('HappY dAy HahA') from dual;

-- 조건 함수: if(조건식, '참 문장', '거짓 문장')
select if(100>200, '맞음', '틀림') from dual;
select if(100>200, '맞음', '틀림') result from dual; -- 컬럼 제목 변경: oracle과 동일

-- ifnull(컬럼 값, NULL일 때의 대치 값)
select ifnull(null, 1) from dual; -- 1
select ifnull('a', 1) from dual; -- a

-- 숫자함수
-- abs: 절대값
select abs(6), abs(-6) from dual;
-- ceiling, ceil: 올림 - java(Math.ceil), oracle(ceil)
-- floor: 내림, round: 반올림
select ceiling(3.1), ceil(3.1), floor(3.9), round(3.1), round(3.9) from dual;
select round(3.16, 1) from dual; -- 소숫점 1자리까지 반올림
select round(567892, -2) from dual; -- 567900

-- pow: 지수, mod: 나머지
select pow(3, 2), mod(10, 3) from dual;

-- greatest(num1, num2...): 최댓값 구하기
-- least(num1, num2...): 최솟값 구하기
select greatest(100, 32, 49, 56, 70), least(100, 32, 49, 56, 70) from dual; -- oracle에도 존재



