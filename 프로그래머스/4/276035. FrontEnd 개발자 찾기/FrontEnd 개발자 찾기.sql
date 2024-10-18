-- 코드를 작성해주세요 CONV(데이터,원래진법,바꿀진법)

select distinct(d.id) as ID,d.email as EMAIL,d.first_name AS FIRST_NAME,D.LAST_NAME AS LAST_NAME
from developers as d join skillcodes as c
            on d.skill_code=d.skill_code|c.code
where c.category='Front End'
ORDER BY ID ASC;



# SELECT NAME,CATEGORY,CODE
# FROM  SKILLCODES
# WHERE CATEGORY='Front End';
