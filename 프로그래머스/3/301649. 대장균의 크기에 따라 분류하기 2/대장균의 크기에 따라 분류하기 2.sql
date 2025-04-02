-- 코드를 작성해주세요
select a.id as ID, case 
                        when a.per<=0.25 then 'CRITICAL'
                        when a.per<=0.50 then 'HIGH'
                        when a.per<=0.75 then 'MEDIUM'
                        else 'LOW'
                    end as COLONY_NAME
from (select id, percent_rank() over (order by size_of_colony desc) as per
        from ecoli_data) as a
order by ID
