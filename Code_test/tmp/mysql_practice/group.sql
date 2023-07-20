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