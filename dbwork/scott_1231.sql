-- 두 테이블의 결합: EQUI JOIN 또는 INNER JOIN
-- emp 테이블& dept 테이블
-- 공통 행: deptno(외래키&기본키)

-- 방법 1: 컬럼명 앞에 테이블 명 또는 테이블 별칭 붙이기
SELECT e.ename, e.job, e.sal, d.dname, d.loc
FROM EMP e, DEPT d
WHERE e.deptno = d.deptno;

-- 방법 2: 조인할 테이블에 컬럼명이 겹치지 않으면 테이블명이나 별칭을 붙이지 않아도 된다.
SELECT e.deptno, ename, job, sal, dname, loc
FROM EMP e, DEPT d
WHERE e.deptno = d.deptno;

-- DECODE 함수: 다중 IF문과 유사한 함수
SELECT ename, deptno, DECODE(deptno, 10, '홍보부', 20, '교육부', 30, '인사부') 부서명 FROM emp;