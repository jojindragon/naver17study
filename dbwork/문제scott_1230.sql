-- 12월 30일 Oracle 문제
-- 이용 테이블: EMP
-- 1. 어떤 종류의 직업이 있는지 job을 1번씩 출력 - 단, 오름차순 출력
SELECT job FROM emp GROUP BY job ORDER BY job;

-- 2. ENAME에 대소문자 상관없이 's'를 포함하고 있는 데이터 출력
--    => 출력 컬럼: ename, job, sal
SELECT ename, job, sal FROM emp WHERE LOWER(ename) LIKE '%s%';

-- 3. ENAME의 3번째 글자가 L인 사람을 조회
--    => 출력 컬럼: ename, sal, comm
SELECT ename, sal, comm FROM emp WHERE UPPER(ename) LIKE '__L%';

-- 4. COMM이 null이 아닌 사람 중에 sal이 1500 이상인 사람 출력
--    => 출력 컬럼: ename, sal, comm
SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL AND sal >= 1500;

-- 5. HIREDATE 입사일이 5월인 사람은 모두 출력
--    => 출력 컬럼: ename, hiredate, sal
SELECT ename, to_char(hiredate, 'yyyy-mm-dd') 입사일, sal FROM emp
WHERE to_char(hiredate, 'mm') = 5;

-- 6. HIREDATE 입사일이 1985-01-01 이후에 입사한 사람 출력
--    => 출력 컬럼: ename, hiredate, sal
SELECT ename, to_char(hiredate, 'yyyy-mm-dd') 입사일, sal FROM emp
WHERE to_char(hiredate, 'yyyy-mm-dd') > '1985-01-01';

-- 7. sal이 1500~3000 사이인 사람 출력 - 단, 관계연산자와 and를 이용
--    => 출력 컬럼: ename, sal, mgr
SELECT ename, sal, mgr FROM emp WHERE sal >= 1500 AND sal <= 3000;

-- 8. 7번 결과를 between 이용해서 출력
--    => 출력 컬럼: ename, sal, mgr
SELECT ename, sal, mgr FROM emp WHERE sal BETWEEN 1500 AND 3000;

-- 9. IN을 이용해 job이 clerk, president, manger인 사람의 전체 컬럼 출력
SELECT * FROM emp WHERE LOWER(job) IN ('clerk', 'president', 'manager');

-- 10. ENAME, SAL, COMM, SAL*COMM 출력 - 단, comm이 null인 경우 1로 변경해서 계산하고 출력
SELECT ename, sal, NVL(comm, 1) comm, sal*NVL(comm, 1) 계산값 FROM emp;

-- 11. ENAME이 ADAMS인 사람의 SAL보다 더 많이 받는 사람 출력
--    => 출력 컬럼: ename, job, sal
SELECT ename, job, sal FROM emp 
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ADAMS');

-- 12. 평균 SAL보다 작은 사람의 전체 컬럼 출력
SELECT * FROM emp WHERE sal < (SELECT AVG(sal) FROM emp);

-- 13. ENAME이 A나 S나 M으로 시작하는 모든 사람 출력 
--    => 출력 컬럼: ename, job, sal
SELECT ename, job, sal FROM emp 
WHERE ename LIKE 'A%' OR ename LIKE 'S%' OR ename LIKE 'M%';

-- 14. MGR을 GROUP으로 인원수와 평균 SAL을 구하시오 - 단, 평균은 무조건 올림으로
SELECT mgr, CEIL(AVG(sal)) 평균 FROM emp
GROUP BY mgr;

-- 15. SCOTT의 SAL과 같은 SAL을 받는 사람 조회
--    => 출력 컬럼: ename, sal
SELECT ename, sal FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- 16. ENAME의 글자길이가 4글자인 사람만 조회
--    => 출력 컬럼: ename, job
SELECT ename, job FROM emp WHERE LENGTH(ename) = 4;

-- 17. ENAME의 3번째 글자가 R이거나 A인 사람 조회
--    => 출력 컬럼: ename, job
SELECT ename, job FROM emp WHERE ename LIKE '__R%' OR ename LIKE '__A%';

-- 18. JOB 직업 별로 인원수와 최고연봉 출력 - 단, 직업의 오름차순 출력
SELECT job 직업, COUNT(*) 인원수, MAX(sal) 최고연봉 FROM emp
GROUP BY job ORDER BY 직업;

-- 19. || 연산자를 이용해 다음과 같이 하나의 컬럼으로 출력 - 컬럼명: 자기소개
--    => (예) SCOTT의 직업은 CLERK이며 입사년도는 1989년 05월입니다.
SELECT ename||'의 직업은 '||job||'이며 입사년도는 '||to_char(hiredate, 'yyyy')||'년 '||to_char(hiredate, 'mm')||'월입니다.' 자기소개
FROM emp;
