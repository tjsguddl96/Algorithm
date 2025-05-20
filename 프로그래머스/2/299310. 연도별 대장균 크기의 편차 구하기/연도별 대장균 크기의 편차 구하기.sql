-- 코드를 작성해주세요
select YEAR(a.differentiation_date) as YEAR,(tmp.MAXX-a.size_of_colony) as YEAR_DEV,a.id as ID
from ecoli_data as a left join (
    select max(size_of_colony) as MAXX,YEAR(differentiation_date) as dateF
    from ecoli_data
    group by YEAR(differentiation_date)) as tmp
    on YEAR(a.differentiation_date)=tmp.dateF
order by 1,2

# select *
# from ecoli_data


# (select max(size_of_colony),date_format(differentiation_date,'%Y')
# from ecoli_data
# group by date_format(differentiation_date,'%Y') as tmp