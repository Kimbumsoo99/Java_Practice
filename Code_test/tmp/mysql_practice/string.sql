-- String, Date 구문 연습

-- programmers
-- level 1, 자동차 대여 기록에서 장기/단기 대여 구분하기
-- 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시
-- 컬럼(컬럼명: RENT_TYPE)을 추가하여 대여기록을 출력하는 SQL문, 대여 기록 ID를 기준으로 내림차순 정렬
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
       CASE
           WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
           ELSE '단기 대여'
           END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09'
ORDER BY HISTORY_ID DESC;


-- level 1, 특정 옵션이 포함된 자동차 리스트 구하기
-- '네비게이션' 옵션이 포함된 자동차 리스트를 출력, 자동차 ID를 기준으로 내림차순 정렬
SELECT car_id, car_type, daily_fee, options from CAR_RENTAL_COMPANY_CAR
where options like '%네비게이션%' order by car_id desc;
-- 또는 정규식!


-- level 2, 조건에 부합하는 중고거래 상태 조회하기
-- 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회하는 SQL문
-- 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력
SELECT board_id, writer_id, title, price,
       case when status='DONE' then '거래완료' else
           case when status='SALE' then '판매중' else '예약중'
               end
           end as status
from used_goods_board where created_date='2022-10-05' order by board_id desc;

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
       CASE
           WHEN STATUS = 'SALE' THEN '판매중'
           WHEN STATUS = 'RESERVED' THEN '예약중'
           WHEN STATUS = 'DONE' THEN '거래완료'
           ELSE '알 수 없음'
           END AS STATUS
FROM USED_GOODS_BOARD
WHERE created_date = '2022-10-05'
order by board_id desc



-- level 1, 자동차 대여 기록에서 장기/단기 대여 구분하기
-- 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시
-- 컬럼명: RENT_TYPE, 대여 기록 ID를 기준으로 내림차순 정렬, 데이트 포맷과 동일
SELECT history_id, car_id,
       date_format(start_date, ('%Y-%m-%d')) as start_date,
       date_format(end_date, ('%Y-%m-%d')) as end_date,
       case
           when datediff(end_date, start_date) + 1 >= 30
               then '장기 대여'
           else '단기 대여'
           end as rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date like '2022-09%' order by history_id desc;
-- 날짜에서는 DATEDIFF 사용하기


-- level 2, 자동차 평균 대여 기간 구하기
-- 평균 대여 기간이 7일 이상인 자동차들의 자동차 ID와 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림 
-- 결과는 평균 대여 기간을 기준으로 내림차순 정렬 -> 같으면 자동차 ID를 기준으로 내림차순 정렬
SELECT CAR_ID, round(avg(DATEDIFF(end_date, start_date) +1), 1) AS AVERAGE_DURATION 
from car_rental_company_rental_history group by car_id having avg(DATEDIFF(end_date, start_date) +1) >= 7 
order by 2 desc, car_id desc;
