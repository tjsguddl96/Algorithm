-- 코드를 작성해주세요
select id as ID,email as EMAIL,first_name as FIRST_NAME,last_name as LAST_NAME
from  developers
where skill_code & (select code from skillcodes where name="Python") or
skill_code & (select code from skillcodes where name="C#")
order by id asc