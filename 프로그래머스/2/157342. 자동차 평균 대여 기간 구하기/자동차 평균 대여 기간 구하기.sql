-- 코드를 입력하세요
SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION>=7
ORDER BY AVERAGE_DURATION DESC,CAR_ID DESC


# SELECT A.CAR_ID AS CAR_ID,ROUND(AVG(A.DURATION),1) AS AVERAGE_DURATION
# FROM (SELECT CAR_ID,DATEDIFF(END_DATE,START_DATE) DURATION
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) AS A
# GROUP BY A.CAR_ID
# HAVING AVERAGE_DURATION>=7
# ORDER BY AVERAGE_DURATION DESC,CAR_ID DESC