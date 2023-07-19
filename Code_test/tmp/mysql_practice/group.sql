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