-- 코드를 입력하세요
select car_id,(
    case
        when car_id in(select car_id
                      from car_rental_company_rental_history
                      where date_format(start_date,'%Y-%m-%d')<='2022-10-16' and date_format(end_date,'%Y-%m-%d')>='2022-10-16') then '대여중'
        else '대여 가능'
    end
) as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc

# select car_id,start_date,end_date
# from car_rental_company_rental_history
# order by car_id

# select car_id,date_format(start_date,'%Y-%m-%d'),date_format(end_date,'%Y-%m-%d')
# from car_rental_company_rental_history
# where (car_id,end_date) in (select car_id,max(end_date)
#                 from car_rental_company_rental_history
#                 group by car_id)
# order by car_id desc



# select car_id,start_date,end_date
# from car_rental_company_rental_history
# where car_id=20
# order by end_date


# from -> where -> group by-> having -> select -> order by 