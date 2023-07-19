-- SELECT 구문 연습

SELECT COLMN_NAME FROM TABLE_NAME;
SELECT * FROM apt_list WHERE dong='삼성동' OR DAY=1 LIMIT 100;

-- LIMIT을 활용한 개수 제한
SELECT * FROM vila_list LIMIT 10;

-- ORDER BY 정렬
SELECT * FROM apt_list ORDER BY price DESC; -- 내림차 DESC
SELECT * FROM apt_list ORDER BY YEAR, MONTH, DAY LIMIT 100; -- 오름차 ASC

-- 행의 개수
SELECT COUNT(*) FROM apt_list;
SELECT dong, COUNT(*) FROM apt_list GROUP BY dong; -- dong 별로 count 값 출력

-- CASE WHEN
SELECT price, YEAR, MONTH, DAY, nm, case
when price <= 10000 then '1억 이하'
when price <= 30000 then '1억~3억 이하'
ELSE '3억 초과'
end
FROM apt_list;

-- LIKE
SELECT * FROM apt_list WHERE nm LIKE '%자 이%'; --  nm 컬럼에서 자 이가 포함된 데이터
SELECT * FROM apt_list WHERE nm NOT LIKE '%자 이%'; --  NOT을 통해 자 이가 없는 데이터만 출력

-- 서브 쿼리
SELECT * FROM
(SELECT dong, COUNT(*) cnt FROM apt_list GROUP BY dong) a WHERE cnt > 100;

-- SUM, MIN, MAX, AVG
SELECT YEAR, SUM(price), MIN(price), MAX(price), AVG(price) FROM apt_list GROUP BY year;
SELECT YEAR, SUM(price), MIN(price), MAX(price), AVG(price) FROM apt_list WHERE YEAR=2020;


-- programmers
-- level 1, 강원도에 위치한 생산공장 목록 출력하기
-- 공장 ID, 공장 이름, 주소를 조회하는 SQL문, 공장 ID를 기준으로 오름차순 정렬
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE '강원도%' ORDER BY FACTORY_ID ASC;


-- level 1, 흉부외과 또는 일반외과 의사 목록 출력하기
-- 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문
-- 결과는 고용일자를 기준으로 내림차순 정렬
-- 고용일자가 같다면 이름을 기준으로 오름차순 정렬
-- 날짜 포맷 2020-03-01 00:00:00 -> 2020-03-01
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") AS HIRE_YMD FROM DOCTOR
WHERE MCDP_CD='CS' OR MCDP_CD='GS' ORDER BY HIRE_YMD DESC, DR_NAME ASC;


-- level 2, 3월에 태어난 여성 회원 목록 출력하기
-- 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문, 전화번호가 NULL인 경우는 출력대상에서 제외
-- 회원ID를 기준으로 오름차순 정렬, 날짜 포맷 1993-03-16 00:00:00 -> 1993-03-16
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") AS DATE_OF_BIRTH FROM MEMBER_PROFILE
WHERE DATE_OF_BIRTH LIKE "%-03-%" AND GENDER = 'W' AND TLNO IS NOT NULL ORDER BY MEMBER_ID;

SELECT MEMBER_ID
     ,MEMBER_NAME
     ,GENDER
     ,DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
from MEMBER_PROFILE
where MONTH(DATE_OF_BIRTH) = 3
  AND GENDER='W'
  and TLNO is not null
order by MEMBER_ID asc;
-- WHERE DATE_FORMAT(DATE_OF_BIRTH, '%m') = '03' 도 가능


-- level 1, 조건에 맞는 도서 리스트 출력하기
-- 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성
-- 출판일을 기준으로 오름차순 정렬, 데이트 포맷 1993-03-16 00:00:00 -> 1993-03-16
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE FROM BOOK
WHERE CATEGORY='인문' AND PUBLISHED_DATE LIKE '2021%' ORDER BY PUBLISHED_DATE;

-- level 1, 과일로 만든 아이스크림 고르기
-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회

-- 하위질의 풀이
SELECT FLAVOR FROM FIRST_HALF
WHERE TOTAL_ORDER > 3000 AND FLAVOR IN(SELECT FLAVOR FROM ICECREAM_INFO WHERE INGREDIENT_TYPE='fruit_based');

-- JOIN 풀이
SELECT f.FLAVOR FROM first_half f join icecream_info i
where f.flavor = i.flavor and f.total_order > 3000 and i.ingredient_type='fruit_based';

-- level 1, 12세 이하인 여자 환자 목록 출력하기
-- 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회
-- 전화번호가 없는 경우, 'NONE'으로 출력, 나이를 기준으로 내림차순 정렬 -> 같다면 환자이름을 기준으로 오름차순 정렬
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IF (TLNO IS NULL, 'NONE', TLNO) AS TLNO FROM PATIENT
WHERE GEND_CD='W' and AGE <= 12 ORDER BY AGE DESC, PT_NAME ASC;

SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, 'NONE') AS TLNO FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W' ORDER BY AGE DESC, PT_NAME ASC;


-- level 1, 조건에 부합하는 중고거래 댓글 조회하기
-- 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회
-- 댓글 작성일을 기준으로 오름차순 정렬 -> 같다면 게시글 제목을 기준으로 오름차순, 날짜 포맷
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, ('%Y-%m-%d')) AS CREATED_DATE
FROM USED_GOODS_BOARD b join USED_GOODS_REPLY r
WHERE b.BOARD_ID=r.BOARD_ID AND b.CREATED_DATE LIKE '2022-10%'
ORDER BY r.CREATED_DATE ASC, b.TITLE ASC;

SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, ('%Y-%m-%d')) AS CREATED_DATE
FROM USED_GOODS_BOARD b join USED_GOODS_REPLY r on b.BOARD_ID=r.BOARD_ID
WHERE b.CREATED_DATE LIKE '2022-10%'
ORDER BY r.CREATED_DATE, b.TITLE;

-- 게시판-게시글의 관계가 일반적으로는 1:1이 아니라 1:N 관계
-- FROM USED_GOODS_REPLY r LEFT OUTER JOIN USED_GOODS_BOARD b
-- WHERE YEAR(b.CREATED_DATE) = 2022 AND MONTH(b.CREATED_DATE) = 10


-- level 1, 평균 일일 대여 요금 구하기
-- 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금
-- 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림, 컬럼명 AVERAGE_FEE 지정
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE='SUV'; -- 일반적인 반올림

-- level 1, 인기있는 아이스크림
-- 총주문량을 기준으로 내림차순 정렬 -> 같다면 출하 번호를 기준으로 오름차순 정렬
SELECT FLAVOR FROM FIRST_HALF ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;


-- level 1, 모든 레코드 조회하기
-- ANIMAL_ID순으로 조회하는 SQL문
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID


-- level 1, 역순 정렬하기
-- 모든 동물의 이름과 보호 시작일을 조회, ANIMAL_ID 역순
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC;


-- level 1, 아픈 동물 찾기
-- 아픈 동물1의 아이디와 이름을 조회, 아이디 순으로 조회
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION='Sick' ORDER BY ANIMAL_ID;


-- level 1, 어린 동물 찾기
--  젊은 동물1의 아이디와 이름을 조회하는 SQL 문, 아이디 순으로 조회
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE NOT INTAKE_CONDITION='Aged' ORDER BY ANIMAL_ID;

SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE NOT INTAKE_CONDITION != 'Aged' ORDER BY ANIMAL_ID;

-- level 1, 동물의 아이디와 이름
-- 모든 동물의 아이디와 이름을 ANIMAL_ID순으로 조회
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS ORDER BY ANIMAL_ID;


-- level 1, 여러 기준으로 정렬하기
-- 아이디와 이름, 보호 시작일을 이름 순으로 조회, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME, DATETIME DESC;


-- level 1, 상위 n개 레코드
-- 가장 먼저 들어온 동물의 이름을 조회
SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME ASC LIMIT 1;

SELECT NAME FROM ANIMAL_INS WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS);


-- level 1, 조건에 맞는 회원수 구하기
-- 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력
SELECT COUNT(*) AS USERS FROM USER_INFO WHERE JOINED LIKE '2021%' AND AGE >= 20 AND AGE <= 29;
SELECT COUNT(*) AS USERS FROM USER_INFO WHERE YEAR(JOINED) = 2021 AND AGE BETWEEN 20 AND 29;

-- level 2, 재구매가 일어난 상품과 회원 리스트 구하기
-- 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성
-- 회원 ID를 기준으로 오름차순 정렬 -> 같다면 상품 ID를 기준으로 내림차순 정렬

-- GROUP BY 사용
SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID HAVING COUNT(*) > 1 ORDER BY USER_ID, PRODUCT_ID DESC;

-- SELF JOIN 사용
SELECT DISTINCT a.USER_ID, a.PRODUCT_ID
FROM ONLINE_SALE a JOIN ONLINE_SALE b ON a.USER_ID = b.USER_ID AND a.PRODUCT_ID = b.PRODUCT_ID
WHERE a.sales_date != b.sales_date
ORDER BY USER_ID, PRODUCT_ID DESC;


-- level 4, 서울에 위치한 식당 목록 출력하기
-- 서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
-- 리뷰 평균점수는 소수점 세 번째 자리에서 반올림, 평균점수를 기준으로 내림차순 정렬 -> 즐겨찾기수를 기준으로 내림차순 정렬
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, ROUND(AVG(r.REVIEW_SCORE), 2) AS SCORE
FROM REST_REVIEW r JOIN REST_INFO i ON r.REST_ID = i.REST_ID
WHERE i.ADDRESS LIKE '서울%'
GROUP BY i.REST_NAME
ORDER BY SCORE DESC, i.FAVORITES DESC;


-- level 4, 오프라인/온라인 판매 데이터 통합하기
-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문을 작성
-- OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 표시
-- 판매일을 기준으로 오름차순 정렬 -> 같다면 상품 ID를 기준으로 오름차순 -> 같다면 유저 ID를 기준으로 오름차순 정렬

-- DATE_FORMAT(onl.SALES_DATE, ('%Y-%m-%d')) AS SALES_DATE
(SELECT DATE_FORMAT(SALES_DATE, ('%Y-%m-%d')) AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
 FROM ONLINE_SALE WHERE SALES_DATE LIKE '2022-03%')
UNION ALL
(SELECT DATE_FORMAT(SALES_DATE, ('%Y-%m-%d')) AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
 FROM OFFLINE_SALE WHERE SALES_DATE LIKE '2022-03%')
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;

-- SALES_DATE LIKE '2022-03%' -> year(SALES_DATE) = 2022 AND month(SALES_DATE) = 3 정답 가능
