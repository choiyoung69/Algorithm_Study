-- 코드를 작성해주세요
SELECT I.ID ID, NI.FISH_NAME FISH_NAME, I.LENGTH LENGTH
FROM FISH_INFO I
JOIN FISH_NAME_INFO NI ON I.FISH_TYPE = NI.FISH_TYPE
WHERE (I.FISH_TYPE, I.LENGTH) IN
        (SELECT FISH_TYPE, MAX(LENGTH)
        FROM FISH_INFO
        GROUP BY FISH_TYPE)
ORDER BY I.ID;