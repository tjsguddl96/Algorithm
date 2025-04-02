-- 코드를 작성해주세요

select id
from ecoli_data as c
where c.parent_id in (select id
                        from ecoli_data as b
                        where b.parent_id in    (
                                                select id
                                                from ecoli_data as a
                                                where a.parent_id is null)
                     )
order by id asc

# select *
# from ecoli_data as b
# where b.parent_id in(
# select id
# from ecoli_data as a
# where a.parent_id is null)

# select *
# from ecoli_data