-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO R
WHERE FAVORITES = 
    (SELECT MAX(FAVORITES)
    FROM REST_INFO
    WHERE R.FOOD_TYPE = FOOD_TYPE)
ORDER BY FOOD_TYPE DESC;