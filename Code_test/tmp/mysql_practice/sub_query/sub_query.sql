SELECT * FROM
    (SELECT dong, COUNT(*) cnt FROM apt_list GROUP BY dong) a WHERE cnt > 100;

SELECT FLAVOR FROM FIRST_HALF
WHERE TOTAL_ORDER > 3000 AND FLAVOR IN(SELECT FLAVOR FROM ICECREAM_INFO WHERE INGREDIENT_TYPE='fruit_based');