-- 코드를 작성해주세요
SELECT 
    COUNT(*) AS FISH_COUNT,
    I.FISH_NAME
FROM FISH_INFO T
JOIN FISH_NAME_INFO I
ON T.FISH_TYPE = I.FISH_TYPE
GROUP BY I.FISH_NAME
ORDER BY FISH_COUNT DESC;
