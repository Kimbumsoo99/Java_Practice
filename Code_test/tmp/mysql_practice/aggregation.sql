-- 집계함수 연습 SUM, MIN, MAX 등

-- programmers
-- level 2, 가격이 제일 비싼 식품의 정보 출력하기
-- 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문
SELECT * FROM FOOD_PRODUCT ORDER BY PRICE DESC LIMIT 1; -- 집계함수가 없는 풀이
SELECT * FROM FOOD_PRODUCT WHERE PRICE=(SELECT MAX(PRICE) FROM FOOD_PRODUCT); -- 집계 함수 + 서브 쿼리



-- level 1, 가장 비싼 상품 구하기
-- 상품 중 가장 높은 판매가를 출력, 컬럼명은 MAX_PRICE로 지정
SELECT MAX(PRICE) AS MAX_PRICE FROM PRODUCT;




