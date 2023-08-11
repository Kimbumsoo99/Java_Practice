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



-- level 3, 대여 기록이 존재하는 자동차 리스트 구하기
-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 자동차 종류가 '세단'인
-- 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성
-- 자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬
SELECT distinct (A.CAR_ID) as car_id
FROM CAR_RENTAL_COMPANY_CAR A
    join car_rental_company_Rental_history B on a.car_id=b.car_id
                                     where b.start_date like '%-10-%' and a.car_type = '세단'
                                     order by car_id desc;



-- level 4, 취소되지 않은 진료 예약 조회하기 ⭕
-- PATIENT, DOCTOR 그리고 APPOINTMENT 테이블에서
-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회하는 SQL문을 작성
-- 결과는 진료예약일시를 기준으로 오름차순 정렬
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
    join patient p on a.pt_no=p.pt_no
    join doctor d on d.dr_id=a.mddr_id
where a.mcdp_cd='CS' and apnt_ymd like '2022-04-13%' and apnt_cncl_yn='n' order by a.apnt_ymd;



-- level 3, 조건별로 분류하여 주문상태 출력하기 ❌
-- FOOD_ORDER 테이블에서 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문
-- 출고여부는 5월 1일까지 출고완료로 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고,
-- 결과는 주문 ID를 기준으로 오름차순 정렬
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d') as out_date,
case
WHEN out_date IS NULL THEN '출고미정'
WHEN DATEDIFF('2022-05-01', out_date) >= 0 THEN '출고완료'
WHEN DATEDIFF('2022-05-01', out_date) < 0 THEN '출고대기'
    END AS 출고여부
from food_order order by 1;



-- level 3, 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기 ❌ (CONCAT 처음 봤음)
-- USED_GOODS_BOARD와 USED_GOODS_FILE 테이블에서 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회하는 SQL문
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬해주세요. 기본적인 파일경로는 /home/grep/src/
-- 게시글 ID를 기준으로 디렉토리가 구분되고, 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력해주세요.
-- 조회수가 가장 높은 게시물은 하나만 존재
SELECT CONCAT('/home/grep/src/', b.board_id, '/', file_id, file_name, f.file_ext) AS FILE_PATH
from used_goods_board b join used_goods_file f on b.board_id=f.board_id
where
    b.views=(select views from used_goods_board order by views desc limit 1)
order by file_id desc;



-- level 2, 루시와 엘라 찾기 ⭕
-- 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL 문
-- 아이디 순으로 조회
SELECT ANIMAL_id, name, sex_upon_intake
from animal_ins where name in('Lucy','Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty') order by 1;


-- level 2, 이름에 el이 들어가는 동물 찾기 ⭕
-- 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회하는 SQL문
-- 이름 순으로 조회
SELECT animal_id, name from animal_ins where name like '%el%' and animal_type='Dog' order by name;




-- level 2, 중성화 여부 파악하기 ⭕
-- 중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있다.
-- 중성화가 되어있다면 'O', 아니라면 'X'라고 표시
SELECT animal_id, name,
       case when sex_upon_intake like '%Spayed%' or sex_upon_intake like '%Neutered%'
    then 'O' else 'X' end as 중성화 from animal_ins order by 1;
-- 정규식 활용
SELECT ANIMAL_ID, NAME,
       IF(SEX_UPON_INTAKE REGEXP 'Neutered|Spayed', 'O', 'X') 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;




-- level 2, DATETIME에서 DATE로 형 변환 ⭕
-- 동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문을 작성해주세요. 이때 결과는 아이디 순으로 조회
SELECT animal_id, name, Date_format(datetime, '%Y-%m-%d') as 날짜 from animal_ins order by 1;






-- level 2, 카테고리 별 상품 개수 구하기 ❌
-- 상품 카테고리 코드(PRODUCT_CODE 앞 2자리) 별 상품 개수를 출력
SELECT LEFT(product_code, 2), COUNT(*) AS PRODUCTs  FROM product GROUP BY 1;
-- RIGHT() 도 존재함.




-- level 3, 조건에 맞는 사용자 정보 조회하기 ⭕
-- 중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성
-- 시, 도로명 주소, 상세 주소가 함께 출력, 전화번호의 경우 xxx-xxxx-xxxx 같은 형태
-- 회원 ID를 기준으로 내림차순 정렬
SELECT u.user_id, u.nickname,
       concat(u.city, ' ', u.street_address1, ' ', u.street_address2) as 전체주소,
       concat(left(u.tlno, 3), '-', mid(u.tlno,4, 4), '-', right(u.tlno,4)) as 전화번호
from used_goods_board as b join used_goods_user as u on b.writer_id=u.user_id
group by writer_id having count(writer_id) >=3 order by 1 desc;

-- 다른 정답 concat_ws와 substr 사용
SELECT
    u2.user_id,
    u2.nickname,
    CONCAT_WS(' ', u2.city, u2.street_address1, u2.street_address2) 전체주소,
    CONCAT_WS('-',
              SUBSTR(u2.tlno, 1, 3),
              SUBSTR(u2.tlno, 4, LENGTH(u2.tlno) - 7),
              SUBSTR(u2.tlno, -4, 4)) 전화번호
FROM used_goods_board u1
         JOIN used_goods_user u2
              ON u1.writer_id = u2.user_id
GROUP BY u2.user_id
HAVING count(u1.writer_id) >= 3
ORDER BY u2.user_id desc;



-- level 3, 오랜 기간 보호한 동물(2) ❌
-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성
-- 보호 기간이 긴 순으로 조회
SELECT a.animal_id, a.name from animal_ins a
    join animal_outs b on a.ANIMAL_ID=b.ANIMAL_ID
                           order by DATEDIFF(a.DATETIME, b.DATETIME) limit 2;



-- level 4, 자동차 대여 기록 별 대여 금액 구하기 ❌(포기)
SELECT HISTORY_ID,
       ROUND(DAILY_FEE*(DATEDIFF(END_DATE, START_DATE)+1)
                 *(100-IF(DISCOUNT_RATE IS NULL, 0, DISCOUNT_RATE))/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A
         JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B
              ON A.CAR_ID = B.CAR_ID
         LEFT OUTER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C
                         ON A.CAR_TYPE = C.CAR_TYPE
                             AND C.DURATION_TYPE = (CASE WHEN DATEDIFF(END_DATE,START_DATE)+1>='90' THEN '90일 이상'
                                                         WHEN DATEDIFF(END_DATE,START_DATE)+1>='30' THEN '30일 이상'
                                                         WHEN DATEDIFF(END_DATE,START_DATE)+1>='7' THEN '7일 이상'
                                                         ELSE NULL END)
WHERE 1=1
  AND A.CAR_TYPE = '트럭'
ORDER BY FEE DESC, B.HISTORY_ID DESC;
