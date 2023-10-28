select month(c.start_date) as m,c.car_id,count(c.car_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as c
where c.start_date between '2022-08-01' and '2022-10-31' and c.car_id in
                                                                (select a.car_id
                                                                from (SELECT *
                                                                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                                    where start_date between '2022-08-01' and '2022-10-31') as a
                                                                group by a.car_id
                                                                having count(*)>=5)
group by m,car_id
order by m,car_id desc
# select date_format(h.start_date,'%m'),h.car_id,count(h.car_id)
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
# group by h.start_date,h.car_id
# order by car_id

# select *,count(*) as cnt
# from (SELECT *
#     from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     where start_date between '2022-08-01' and '2022-10-31') as a
# group by a.car_id
# having count(*)>=5
# order by car_id

# SELECT *
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where car_id=2


# car_id가 2인 애는 7번