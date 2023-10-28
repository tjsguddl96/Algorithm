-- 코드를 입력하세요
select i.rest_id,i.rest_name,i.food_type,i.favorites,i.address,r.score as score
from rest_info as i
    inner join (select rest_id,round(avg(review_score),2) as score
               from rest_review 
               group by rest_id) as r
    on i.rest_id=r.rest_id
where i.address like "서울%"
order by score desc,favorites desc

# select *
# from rest_info
# where address like '서울특별시%'



# select rest_id, round(avg(review_score),2)
# from rest_review
# group by rest_id
# having rest_id =00001 or rest_id=00005 or rest_id=00008