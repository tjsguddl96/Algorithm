select i.rest_id as REST_ID	,i.rest_name as REST_NAME,i.food_type as FOOD_TYPE,i.favorites as FAVORITES	,i.address as ADDRESS,v.review_score as SCORE
from rest_info as i inner join (select rest_id,round(avg(review_score),2) as review_score
                                from rest_review
                                group by rest_id) as v
                    on i.rest_id=v.rest_id
where i.address like '서울%'
order by SCORE desc,FAVORITES desc

# select * 
# from rest_info
# where address like '서울%'

# select v.rest_id as rest_id,round(avg(v.review_score),3) as review_score
# from rest_review as v
# group by v.rest_id