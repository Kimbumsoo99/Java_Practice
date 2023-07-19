-- 집계함수 연습 SUM, MIN, MAX 등

-- programmers
-- level 2, 가격이 제일 비싼 식품의 정보 출력하기
-- 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문
SELECT * FROM FOOD_PRODUCT ORDER BY PRICE DESC LIMIT 1; -- 집계함수가 없는 풀이
SELECT * FROM FOOD_PRODUCT WHERE PRICE=(SELECT MAX(PRICE) FROM FOOD_PRODUCT); -- 집계 함수 + 서브 쿼리



-- level 1, 가장 비싼 상품 구하기
-- 상품 중 가장 높은 판매가를 출력, 컬럼명은 MAX_PRICE로 지정
SELECT MAX(PRICE) AS MAX_PRICE FROM PRODUCT;



-- level 1, 최댓값 구하기
-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회
SELECT MAX(DATETIME) AS 시간 FROM ANIMAL_INS;

SELECT DATETIME AS 시간 FROM ANIMAL_INS WHERE DATETIME = (SELECT MAX(DATETIME) FROM ANIMAL_INS)



-- level 2, 최솟값 구하기
-- 가장 먼저 들어온 동물은 언제 들어왔는지 조회
SELECT MIN(DATETIME) AS 시간 FROM ANIMAL_INS;



-- level 2, 동물 수 구하기
-- 동물이 몇 마리 들어왔는지 조회
SELECT COUNT(*) AS COUNT FROM ANIMAL_INS;


-- level 2, 중복 제거하기
-- 동물의 이름은 몇 개인지 조회하는 SQL 문, 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나
SELECT COUNT(DISTINCT NAME) AS COUNT FROM ANIMAL_INS;
SELECT COUNT(NAME) FROM (SELECT DISTINCT NAME FROM ANIMAL_INS);