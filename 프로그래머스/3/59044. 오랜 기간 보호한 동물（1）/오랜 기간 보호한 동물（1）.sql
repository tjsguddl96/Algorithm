-- 코드를 입력하세요
SELECT I.NAME,I.DATETIME AS DATETIME
FROM ANIMAL_INS AS I LEFT JOIN ANIMAL_OUTS AS O
    ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
ORDER BY DATETIME ASC
LIMIT 3;
