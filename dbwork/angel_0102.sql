-- JOIN 테이블 연습 - on delete cascade로 자식 테이블 생성

-- 부모 테이블 shop 생성: 상품 등록 테이블
CREATE TABLE shop (
    sangcode VARCHAR2(10) CONSTRAINT pk_shop_sangcode PRIMARY KEY,
    sangname VARCHAR2(30),
    sangprice NUMBER(7)  
);

-- shop의 상품코드를 참조해 cart에 담을 수 있는 테이블 생성
-- 상품 삭제 시 cart 데이터도 자동으로 삭제하고록 설정 - on delete cascade로 생성
CREATE TABLE cart (
     cartnum NUMBER(3) CONSTRAINT pk_cart_cartnum  PRIMARY KEY,
     sangcode VARCHAR2(10),     
     cntnum NUMBER(3) DEFAULT 1,
     cartday DATE,
     CONSTRAINT fk_cart_sangcode FOREIGN KEY(sangcode) REFERENCES shop(sangcode)
     ON DELETE CASCADE
);

-- cart에 들어갈 시퀀스
CREATE SEQUENCE seqcart NOCACHE;

-- 상품 등록
INSERT INTO shop VALUES('A100', '체크블라우스', 23000);
INSERT INTO shop VALUES('A200', '브이넥티셔츠', 19000);
INSERT INTO shop VALUES('A300', '레이스블라우스', 34000);
INSERT INTO shop VALUES('A400', '블랙진바지', 56000);
INSERT INTO shop VALUES('A500', '실크스카프', 12000);
INSERT INTO shop VALUES('A600', '인견자켓', 59000);
INSERT INTO shop VALUES('A700', '롱오리털코트', 123000);
INSERT INTO shop VALUES('A800', '체크티셔츠', 35000);
INSERT INTO shop VALUES('A900', '실크블라우스', 89000);
COMMIT;
SELECT * FROM shop;

-- cart에 원하는 상품 담기
INSERT INTO cart(cartnum, sangcode, cartday) VALUES(seqcart.nextval, 'A500', sysdate);
INSERT INTO cart(cartnum, sangcode, cartday) VALUES(seqcart.nextval, 'A700', sysdate);
INSERT INTO cart(cartnum, sangcode, cntnum, cartday) VALUES(seqcart.nextval, 'A800', 3, sysdate);
INSERT INTO cart(cartnum, sangcode, cntnum, cartday) VALUES(seqcart.nextval, 'A100', 2, sysdate);
INSERT INTO cart(cartnum, sangcode, cntnum, cartday) VALUES(seqcart.nextval, 'A500', 1, sysdate);
INSERT INTO cart(cartnum, sangcode, cntnum, cartday) VALUES(seqcart.nextval, 'A400', 2, sysdate);
COMMIT;
SELECT * FROM cart;

-- JOIN SQL 문을 이용해 다음 순서로 출력
-- cartnum, sangcode, sangname, sangprice, cntnum, cartday(yyyy-mm-dd HH:mm)
SELECT cartnum, s.sangcode, sangname, sangprice, cntnum, TO_CHAR(cartday, 'yyyy-mm-dd HH:mi') cartday
FROM shop s, cart c
WHERE s.sangcode = c.sangcode;

-- OUTER JOIN을 이용해 아무도 카트에 담지 않은 상품 찾기
SELECT cartnum, s.sangcode, sangname, sangprice, cntnum, TO_CHAR(cartday, 'yyyy-mm-dd HH:mi') cartday
FROM shop s, cart c
WHERE s.sangcode = c.sangcode(+) AND cartnum IS NULL;

-- ON DELETE CASCADE 생성 >> cart에 담긴 데이터도 부모 테이블인 shop에서 삭제 가능
-- 상품 삭제 시 카트에 담긴 상품은 자동 삭제 - 아닌 경우 자식에 데이터 있다고 오류

-- shop 에서 A500 제거(현재 cart에 2개 담김)
DELETE FROM shop WHERE sangcode = 'A500';
-- join으로 카트 확인
SELECT cartnum, s.sangcode, sangname, sangprice, cntnum, TO_CHAR(cartday, 'yyyy-mm-dd HH:mi') cartday
FROM shop s, cart c
WHERE s.sangcode = c.sangcode;





