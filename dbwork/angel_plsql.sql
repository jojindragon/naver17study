-- PL/SQL: SQL 언어에 절차적 언어 요소를 추가해서 프로그래밍한 것
-- 형식
/*
DECLARE
    변수, 커서 선언
BEGIN
    SQL 구문 or PL/SQL문으로 코딩
END;
/ (실행)
*/

-- 스크립트 출력창에 결과가 출력되도록 설정
SET SERVEROUTPUT ON; -- 켜기
SET serveroutput OFF; -- 끄기

-- 예제 1
DECLARE
    v_no NUMBER(4, 1); -- 변수 선언(4자리 수에 소숫점 이하 1자리)
BEGIN
    v_no:=12.7;  -- Oracle 대입 연산자 ':=', 비교 연산자 '='
    dbms_output.put_line(v_no); -- 콘솔창에 출력 put, put_line
END;
/

-- 예제 2
DECLARE 
    vcolor VARCHAR2(20);
    vprice NUMBER(10);
    vsangpum VARCHAR2(20);
BEGIN
    vcolor := '오랜지색';
    vprice := 35000;
    vsangpum := '모직코트';
    
    dbms_output.put_line('상품명 : ' || vsangpum);
    dbms_output.put_line('가 격 : ' || vprice);
    dbms_output.put_line('색 상 : ' || vcolor);
end;
/

-- 예제 3
DECLARE 
    vscode VARCHAR2(20);
    vsprice NUMBER(10);
    vsangpum VARCHAR2(30);
BEGIN
    vscode := 'A300';
    
    -- vscode에 해당하는 상품 데이터 가져오기
    SELECT sangprice, sangname
    INTO vsprice, vsangpum -- INTO 문으로 가져오기
    FROM shop
    WHERE sangcode = vscode;
    
    dbms_output.put_line('상품명 : ' || vsangpum);
    dbms_output.put_line('가 격 : ' || vsprice || '원');
    dbms_output.put_line('코드번호 : ' || vscode);
end;
/

-- 예제 4 if문: 년도에 따라서 띠 구하기
-- 자축인묘진사오미신유술해
ACCEPT year prompt '년도를 입력'; -- 키보드 값 입력

DECLARE 
    v_year number(4) :=  '&year'; -- 사용자 입력받기
    v_mod number(2) :=  mod(v_year, 12); -- 서기 1년: 닭띠 .. 12년 원숭이
    v_ddi varchar2(20); -- 띠를 저장할 변수
BEGIN
    if v_mod = 0 then v_ddi := '원숭이띠';
    elsif v_mod = 1 then v_ddi := '닭띠';
    elsif v_mod = 2 then v_ddi := '개띠';
    elsif v_mod = 3 then v_ddi := '돼지띠';
    elsif v_mod = 4 then v_ddi := '쥐띠';
    elsif v_mod = 5 then v_ddi := '소띠';
    elsif v_mod = 6 then v_ddi := '호랑이띠';
    elsif v_mod = 7 then v_ddi := '토끼띠';
    elsif v_mod = 8 then v_ddi := '용띠';
    elsif v_mod = 9 then v_ddi := '뱀띠';
    elsif v_mod = 10 then v_ddi := '말띠';
    elsif v_mod = 11 then v_ddi := '양띠';
    end if;
    
    dbms_output.put_line(v_year||'년도: '||v_ddi);
end;
/

-- 예제 5
-- 상품코드, 상품명, 가격을 입력받아 shop 테이블에 추가
ACCEPT scode prompt 'A로 시작하는 상품코드를 입력';
ACCEPT ssang prompt '상품명 입력';
ACCEPT sprice prompt '가격 입력';

DECLARE
    v_code VARCHAR2(20) := '&scode';
    v_sang VARCHAR2(30) := '&ssang';
    v_price NUMBER(10) := '&sprice';
BEGIN
    INSERT INTO shop (sangcode, sangname, sangprice)
    VALUES (v_code, v_sang, v_price);
    
    dbms_output.put_line(v_sang||' 상품정보 테이블에 추가');    
END;
/

-- 예제 6
-- Cursor와 for문으로 shop 데이터 읽기
DECLARE
    -- 커서 객체에 SELECT 문 이용해서 넣기
    CURSOR s1
    IS
    SELECT * FROM shop;
BEGIN
    for s in s1 loop -- record 단위로 s가 가져옴
        dbms_output.put_line(s.sangcode||'  '||s.sangname||'  '||s.sangprice);
        exit when s1%notfound; -- 더 이상 데이터가 없으면 for문을 빠져나가라
    end loop;
END;
/

-- 응용
-- join sql 문을 이용해 cartnum, sangcode, sangname, sangprice, cntnum, cartday 출력
DECLARE    
    CURSOR s1
    IS
    SELECT 
        c.cartnum, s.sangcode, s.sangname, s.sangprice, cntnum,
        TO_CHAR(cartday, 'yyyy-mm-dd') cartday
        FROM shop s, cart c
        WHERE s.sangcode = c.sangcode;
BEGIN
    for s in s1 loop
        dbms_output.put_line(s.cartnum||' '||s.sangcode||' '||s.sangname||
            ' '||s.sangprice||s.cntnum||' '||s.cartday);
        exit when s1%notfound;
    end loop;
END;
/

-- 상품코드와 상품명 가격을 ACCEPT로 받고 
-- shop에 해당 상품 코드가 존재할 경우 update로 수정을 하고
-- 존재하지 않을경우 insert로 추가
ACCEPT scode prompt 'A로 시작하는 상품코드 입력';
ACCEPT sname prompt '상품명 입력';
ACCEPT sprice prompt '상품 가격';

DECLARE
    v_code VARCHAR2(20) := '&scode';
    v_name VARCHAR2(30) := '&sname';
    v_price NUMBER(10) := '&sprice'; 
    v_cnt NUMBER(3);
BEGIN
    SELECT COUNT(*)
    INTO v_cnt
    FROM shop 
    WHERE sangcode = v_code;

    IF v_cnt = 0 THEN
        INSERT INTO shop (sangcode, sangname, sangprice)
        VALUES(v_code, v_name, v_price);
        COMMIT;
        dbms_output.put_line('상품 추가 완료');
    ELSE
        UPDATE shop
        SET sangname = v_name, sangprice = v_price
        WHERE sangcode = v_code;
        COMMIT;
        dbms_output.put_line('상품 업데이트 완료');
    end if;
END;
/

-- 상품명을 입력하면 shop 테이블에서 그 이름을 포함한 데이터를 모두 출력
ACCEPT sname prompt '상품명 입력';

DECLARE
    v_name VARCHAR2(30) := '&sname';
    v_cnt NUMBER(3);
    CURSOR s1
    IS
    SELECT * FROM shop WHERE sangname LIKE '%'||v_name||'%';
    
BEGIN
    SELECT COUNT(*)
    INTO v_cnt
    FROM shop 
    WHERE sangname LIKE '%'||v_name||'%';

    IF v_cnt = 0 THEN        
        dbms_output.put_line(v_name || '상품 없음');
    ELSE
        dbms_output.put_line('상품 코드   상품명   상품가격');
        dbms_output.put_line('========================');
        for s in s1 loop
            dbms_output.put_line(s.sangcode||'   '||s.sangname||'   '||s.sangprice);
            exit when s1%notfound;
        end loop;
    end if;
END;
/
