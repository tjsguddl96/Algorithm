-- 코드를 입력하세요
# SELECT year(o.sales_date)as year,month(o.sales_date) as month,u.gender,count(*) as users
# from user_info as u
#     inner join online_sale as o
#     on u.user_id=o.user_id
# where gender is not null
# group by u.gender,u.user_id,year,month

select year(o.sales_date) as year,month(o.sales_date)as month,gender,count(distinct (u.user_id)) as users
from user_info as u
    inner join online_sale o
    on u.user_id=o.user_id
where gender is not null
group by gender,year(o.sales_date),month(o.sales_date)
order by year,month,gender
