-- IS NULL 연습

-- programmers
-- level 1, 경기도에 위치한 식품창고 목록 출력하기
-- 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회, 냉동시설 여부가 NULL인 경우, 'N'으로 출력
-- 창고 ID를 기준으로 오름차순 정렬
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기%' ORDER BY WAREHOUSE_ID;


-- level 1, 이름이 없는 동물의 아이디
-- 이름이 없는 채로 들어온 동물의 ID를 조회하는 SQL 문을 작성, ID는 오름차순 정렬
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL ORDER BY ANIMAL_ID;



-- level 1, 이름이 있는 동물의 아이디
-- 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성, ID는 오름차순 정렬
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NOT NULL ORDER BY ANIMAL_ID;



-- level 2, NULL 처리하기
-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문, 이름이 없는 동물의 이름은 "No name"으로 표시
SELECT ANIMAL_TYPE, if(NAME is null, 'No name', name) as NAME, SEX_UPON_INTAKE from animal_ins order by animal_id;



-- level 1, 나이 정보가 없는 회원 수 구하기
-- 나이 정보가 없는 회원이 몇 명인지 출력, 컬럼명은 USERS
SELECT COUNT(*) AS USERS FROM USER_INFO WHERE AGE IS NULL;


