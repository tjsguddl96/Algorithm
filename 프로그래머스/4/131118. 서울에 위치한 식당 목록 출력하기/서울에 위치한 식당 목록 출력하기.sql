# # -- 코드를 입력하세요
SELECT r.rest_id as REST_ID,i.rest_name as REST_NAME, i.food_type as FOOD_TYPE,i.FAVORITES as FAVORITES,i.address as ADDRESS,round(avg(r.review_score),2) as SCORE
from rest_review r inner join rest_info as i on r.rest_id=i.rest_id
group by r.rest_id
having i.address like '서울%'
order by SCORE desc,FAVORITES desc;


# SELECT A.REST_ID, B.REST_NAME, B.FOOD_TYPE, B.FAVORITES, B.ADDRESS, ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE
# FROM REST_REVIEW A
# JOIN REST_INFO B ON A.REST_ID = B.REST_ID
# GROUP BY A.REST_ID
# HAVING B.ADDRESS LIKE '서울%'
# ORDER BY SCORE DESC, B.FAVORITES DESC
