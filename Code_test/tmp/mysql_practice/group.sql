-- GROUP BY 구문 연습

-- programmers
-- level 2, 성분으로 구분한 아이스크림 총 주문량
-- 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정
select i.ingredient_type, sum(h.total_order) as total_order
from first_half h join icecream_info i on h.flavor=i.flavor
group by i.ingredient_type order by total_order;



-- level 2, 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
-- '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가 자동차 종류 별로 몇 대인지 출력
-- 자동차 수에 대한 컬럼명은 CARS로 지정, 자동차 종류를 기준으로 오름차순 정렬
SELECT car_type, count(*) as cars from car_rental_company_car
where options like '%통풍시트%' or options like '%열선시트%' or options like '%가죽시트%'
group by car_type order by car_type;


-- 정규식 사용
SELECT CAR_TYPE, COUNT(car_id) AS cars FROM CAR_RENTAL_COMPANY_CAR
WHERE REGEXP_LIKE(OPTIONS,'통풍시트|열선시트|가죽시트')
GROUP BY 1 ORDER BY 1

-- WHERE 칼럼명 IN (조건1, 조건2...)는 이 문제에서 사용할 수 없습니다. 하나씩 존재할 수도 있지만, 다른 옵션과도 함께 존재할 수 있기 때문


-- level 2, 진료과별 총 예약 횟수 출력하기
-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회, 컬럼명은 '진료과 코드', '5월예약건수'로 지정
-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬 -> 같다면 진료과 코드를 기준으로 오름차순
SELECT MCDP_CD AS 진료과코드, COUNT(APNT_NO) AS 5월예약건수 FROM appointment
where apnt_ymd like '2022-05%'
group by MCDP_CD order by 5월예약건수, mcdp_cd;

-- SELECT MCDP_CD AS '진료과 코드', COUNT(APNT_NO) AS '5월예약건수' 오류 코드 ' '로 컬럼명을 묶으면 안됨.


-- level 3, 즐겨찾기가 가장 많은 식당 정보 출력하기
-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문
-- 음식 종류를 기준으로 내림차순 정렬
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN
      (SELECT FOOD_TYPE, MAX(FAVORITES) FROM REST_INFO GROUP BY FOOD_TYPE)
ORDER BY 1 DESC;


-- level 3, 조건에 맞는 사용자와 총 거래금액 조회하기
-- 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성
-- 총거래금액을 기준으로 오름차순 정렬
SELECT u.user_id, u.nickname, sum(b.price) as TOTAL_SALES
from used_goods_board b join used_goods_user u on b.writer_id = u.user_id
where b.status ='DONE'
group by 1 having TOTAL_SALES >= 700000 order by 3;


-- level 3, 카테고리 별 도서 판매량 집계하기
-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
-- 카테고리명을 기준으로 오름차순 정렬
SELECT a.category, sum(b.sales) as total_sales
from book a join book_sales b on a.book_id=b.book_id
where b.sales_date like '2022-01%'
group by category order by 1


-- level 2, 고양이와 개는 몇 마리 있을까
-- 고양이와 개가 각각 몇 마리인지 조회하는 SQL문, 고양이를 개보다 먼저 조회
SELECT ANIMAL_TYPE, COUNT(*) as count from animal_ins group by 1 order by 1;


-- level 3, 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시
-- 컬럼명: AVAILABILITY, 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문
-- 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시, 자동차 ID를 기준으로 내림차순 정렬
SELECT CAR_ID, CASE WHEN SUM(IF('2022-10-16' BETWEEN START_DATE AND END_DATE, 1, 0)) = 0
then "대여 가능" else "대여중" end AS AVAILBILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY GROUP BY CAR_ID ORDER BY CAR_ID DESC;

-- level 2, 동명 동물 수 찾기
-- 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회
-- 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회
SELECT NAME, COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_INS where name is not null
group by 1 having COUNT >= 2 order by name;
-- count(*)로 할 경우 where name is not null을 꼭 넣어야 함

SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS group by 1 having COUNT >= 2 order by name;
-- count(NAME)으로 할 경우 where name is not null이 없어도 됨.


-- level 3, 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
-- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서
-- 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력하는 SQL문을 작성
-- 월을 기준으로 오름차순 정렬 -> 같다면 자동차 ID를 기준으로 내림차순 정렬
-- 월의 총 대여 횟수가 0인 경우에는 결과에서 제외
SELECT month(start_date) month, car_id, count(*) records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date < '2022-11-01'
  and car_id in (SELECT car_id
      from CAR_RENTAL_COMPANY_RENTAL_HISTORY
      where start_date >= '2022-08-01' and start_date < '2022-11-01'
      group by car_id
      having count(car_id) >= 5)
group by month, car_id
having records > 0
order by month, car_id desc;


-- level 2, 입양 시각 구하기(1)
-- 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회 시간대 순으로 정렬
SELECT hour(dateTime) as hour, count(*) from animal_outs
where hour(dateTime) between 9 and 20 group by hour order by hour;

SELECT  DATE_FORMAT(DATETIME, '%H') AS HOUR,
       COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H') BETWEEN 9 AND 20
GROUP BY  DATE_FORMAT(DATETIME, '%H')
ORDER BY HOUR ASC;

SELECT HOUR(DATETIME) AS HOUR, COUNT(HOUR(DATETIME)) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR > 8 AND HOUR < 20
ORDER BY HOUR


-- level 2, 가격대 별 상품 개수 구하기
-- 만원 단위의 가격대 별로 상품 개수를 출력, 컬럼명은 PRICE_GROUP, PRODUCTS로 지정
-- 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시
-- 결과는 가격대를 기준으로 오름차순 정렬
SELECT (PRICE-PRICE%10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT GROUP BY PRICE_GROUP ORDER BY 1;

SELECT TRUNCATE(PRICE,-4) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY TRUNCATE(PRICE,-4)
ORDER BY PRICE_GROUP
-- TRUNCATE 버림, ROUND 평균



-- level 4, 저자 별 카테고리 별 매출액 집계하기 ❌ (풀 수 있었음)
-- 2022년 1월, 저자 별, 카테고리 별 매출액
-- 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬
SELECT a.author_id, a.author_name, b.category, sum(s.sales * b.price) as total_sales
from
    book_sales s
        join book b on s.book_id=b.book_id
        join author a on b.author_id=a.author_id
where s.sales_date like '2022-01%' group by a.author_name, b.category order by 1, 3 desc;



-- level 4,식품분류별 가장 비싼 식품의 정보 조회하기 ⭕
-- 식품분류별, 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회
-- 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력, 식품 가격을 기준으로 내림차순 정렬
SELECT category, price as max_price, product_name
from food_product
where price
          in (select max(price) from food_product group by category)
  and category in ('과자', '국', '김치', '식용유')
order by 2 desc;

-- level 4, 년, 월, 성별 별 상품 구매 회원 수 구하기 ❌
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계
-- 년, 월, 성별을 기준으로 오름차순 정렬, 이때, 성별 정보가 없는 경우 결과에서 제외
SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, U.GENDER, COUNT(DISTINCT O.USER_ID) AS USERS
FROM ONLINE_SALE O
    JOIN USER_INFO U ON O.USER_ID = U.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY 1,2,3
ORDER BY 1,2,3



-- level 4, 입양 시각 구하기(2) ❌ (포기)
-- 몇 시에 입양이 가장 활발하게 일어나는지 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
-- 결과는 시간대 순으로 정렬
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,
    (SELECT COUNT(HOUR(DATETIME))
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME)=@HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;
-- 이 문제에서는 SET 명령어를 사용
-- SET은 어떤 변수에 특정 값을 할당할때 쓰는 명령어
-- ❗주의를 해야 한다. SET 사용시 대입 연산자를 '='를 사용하고 그 외에는 := 를 사용
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR
FROM ANIMAL_OUTS
WHERE @HOUR < 23;

-- 틀린 코드 hour값이 존재하지 않는 경우에 count에 걸리지 않음
SELECT hour(datetime), count(datetime) from animal_outs group by 1 order by 1;
