-- JOIN 구문 연습
SELECT a.dong, a.nm, a.size, a.price,
       b.gu, b.dong FROM apt_list a, area_cd b
WHERE a.area_cd=b.area_cd; -- WHERE을 통해 a와 b 테이블의 연결고리

-- 양쪽 테이블에 전부 데이터가 존재하는 INNER JOIN

-- 하나의 테이블에만 데이터가 존재하는 OUTER JOIN
SELECT a.gu, a.dong,
      b.nm, b.size, b.price,FROM area_cd a
LEFT OUTER JOIN ant_list b on a.area_cd=b.area_cd AND b.con_year=2020;



-- programmers
-- level 2, 조건에 맞는 도서와 저자 리스트 출력하기
-- '경제' 카테고리에 속하는 도서는 도서 ID가 2, 3인 도서이고, 출판일을 기준으로 오름차순으로 정렬
SELECT A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK A JOIN AUTHOR B on a.author_id=b.author_id WHERE CATEGORY = '경제' ORDER BY 3;



-- level 2, 상품 별 오프라인 매출 구하기 ❌
-- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성
-- 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
SELECT A.PRODUCT_CODE, A.PRICE * SUM(B.SALES_AMOUNT) AS SALES
FROM PRODUCT AS A JOIN OFFLINE_SALE AS B ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_CODE
ORDER BY SALES DESC,A.PRODUCT_CODE ASC