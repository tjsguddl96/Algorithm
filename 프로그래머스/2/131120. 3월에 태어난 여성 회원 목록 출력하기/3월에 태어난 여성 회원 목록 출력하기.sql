-- 코드를 입력하세요
SELECT member_id,member_name,gender,date_format(date_of_birth,'%Y-%m-%d') as date_of_birth
from member_profile
where gender='W' and tlno is not null and date_format(date_of_birth,'%m')=3
order by member_id asc;
# select date_format(date_of_birth,'%Y-%m-%d')
# from member_profile
