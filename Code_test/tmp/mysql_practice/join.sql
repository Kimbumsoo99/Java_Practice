-- JOIN 구문 연습
SELECT a.dong, a.nm, a.size, a.price,
       b.gu, b.dong FROM apt_list a, area_cd b
WHERE a.area_cd=b.area_cd; -- WHERE을 통해 a와 b 테이블의 연결고리

-- 양쪽 테이블에 전부 데이터가 존재하는 INNER JOIN

-- 하나의 테이블에만 데이터가 존재하는 OUTER JOIN
SELECT a.gu, a.dong,
      b.nm, b.size, b.price,FROM area_cd a
LEFT OUTER JOIN ant_list b on a.area_cd=b.area_cd AND b.con_year=2020;


