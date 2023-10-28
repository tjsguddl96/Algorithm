-- 코드를 입력하세요
# select category,price as max_price, product_name
# from food_product
# where (category,price) in (SELECT max(price),category
#                             from food_product
#                             group by category)
select category,price as max_price,product_name
from food_product
where (price,category) in (SELECT max(price),category
                            from food_product
                            group by category)
    and category in ('과자','국','김치','식용유')
order by price desc


# select * 
# from food_product
# order by price desc