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
ORDER BY SALES DESC,A.PRODUCT_CODE ASC;


-- level 4, 그룹별 조건에 맞는 식당 목록 출력하기 ❌
-- MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
-- 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
SELECT m.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d')
from member_profile m
    join rest_review r on m.member_id=r.member_id
where
    m.member_id = (
select member_id from rest_review group by member_id order by count(*) desc limit 1
)
order by 3, 2;


-- level 4, 주문량이 많은 아이스크림들 조회하기 ⭕ (-- sum(f.TOTAL_ORDER+j.total_order) 이 부분 조심)
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회
SELECT f.flavor from
                    first_half f join july j on f.flavor=j.flavor
                group by 1
                order by sum(f.TOTAL_ORDER+j.total_order) desc limit 3;


-- level 4, 5월 식품들의 총매출 조회하기 ⭕
-- 2022년 5월인 식품, 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬
SELECT p.product_id, p.product_name, sum(p.price*o.amount) as total_sales
from food_product p join food_order o on p.product_id=o.product_id
where o.produce_date like '2022-05%'
group by 1
order by 3 desc, 1;


