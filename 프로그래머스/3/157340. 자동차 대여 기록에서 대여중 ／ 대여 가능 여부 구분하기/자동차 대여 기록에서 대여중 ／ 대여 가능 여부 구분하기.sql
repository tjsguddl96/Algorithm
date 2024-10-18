-- 코드를 입력하세요
select history.car_id CAR_ID,
case 
    when CAR_ID NOT IN (SELECT car_id
                        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        where start_date<='2022-10-16' and end_date>='2022-10-16') THEN '대여 가능'
else '대여중'
end AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY history
group by CAR_ID
order by CAR_ID desc