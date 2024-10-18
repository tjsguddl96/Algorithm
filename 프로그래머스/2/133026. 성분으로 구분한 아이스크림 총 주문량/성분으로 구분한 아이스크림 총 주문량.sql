-- 코드를 입력하세요
SELECT b.INGREDIENT_TYPE as INGREDIENT_TYPE,sum(total_order) as TOTAL_ORDER
from first_half as a join icecream_info as b
    on a.flavor=b.flavor
group by b.ingredient_type
order by total_order asc