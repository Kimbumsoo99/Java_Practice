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

