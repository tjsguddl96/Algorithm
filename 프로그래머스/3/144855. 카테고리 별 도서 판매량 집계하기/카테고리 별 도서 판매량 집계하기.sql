-- 코드를 입력하세요
SELECT b.category as category, sum(s.sales) as total_sales
from book_sales as s inner join book as b
    on s.book_id=b.book_id
where date_format(s.sales_date,'%Y-%m')='2022-01'
group by b.category,date_format(s.sales_date,'%Y-%m')
order by b.category

