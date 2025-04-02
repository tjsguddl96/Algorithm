# 종류가 세단, SUV
# 대여 가능 기간 : 2022년 11월 1일 ~2022년 11월 30일 -> history에서 해당 기간 동안 빌린게 아니여야함
# 대여 금액 : 30일 간의 대여 금액이 50만 이상 200만 미만 -> 30일 할인율 적용
# 자동차 Id, 종류, 대여 금액 (fee) 
# 대여 금액 (내림차순), 종류 (오름차순), id(내림차순)


SELECT C.CAR_ID as CAR_ID, -- 자동차 ID
       C.CAR_TYPE as CAR_TYPE, -- 자동차 종류
       -- 대여료 x 30일 x 내야할 비율 = 요금
       -- (100 - 할인률)/100 = 내야할 비율
       ROUND(C.DAILY_FEE*30*(100-P.DISCOUNT_RATE)/100) AS FEE -- 지불 비용
    FROM CAR_RENTAL_COMPANY_CAR C
            -- C가 각각 연결될 수 있기 때문에 C를 기준으로 나머지 두 테이블을 연결한다.
            JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID -- CAR_ID기준으로
            JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE -- CAR_TYPE기준으로
            
    -- 대여 가능한 2022-11-01 ~ 2022-12-01에 대여가 가능한 자동차를 목록을 가져와야하므로 
    -- NOT IN을 써서 해당 기간에 렌탈 기록이 없는 CAR_ID를 가져와야 한다
    WHERE C.CAR_ID NOT IN ( 
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'
        
) AND P.DURATION_TYPE like '30%' -- 그리고 대여 기간이 30일 이상인 것을 검색해야하므로
GROUP BY C.CAR_ID -- 자동차 ID 기준으로 그룹화하여
HAVING C.CAR_TYPE IN ('세단', 'SUV') -- 자동차 종류가 세단과 SUV인 것만
    AND (FEE >= 500000 AND FEE < 2000000) -- 30일간의 대여 금액이 50만원 200만원 미만인 자동차 
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC

# select distinct(tmp.id) as CAR_ID,tmp.type as CAR_TYPE,tmp.fee as FEE
# from (select car.car_id as id,car.car_type as type,ceiling(30*car.daily_fee*(100-plan.discount_rate)*0.01) as fee
# from car_rental_company_car as car left join car_rental_company_discount_plan as plan on car.car_type = plan.car_type
# where plan.duration_type='30일 이상' and car.car_type in ('SUV','세단')) as tmp left join CAR_RENTAL_COMPANY_RENTAL_HISTORY as history on tmp.id=history.car_id
# where tmp.fee>=500000 and tmp.fee<2000000 and (history.start_date>'2022-11-30' or history.end_date<'2022-11-01')
# order by FEE desc, CAR_TYPE,CAR_ID desc



# select *
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# union


# select history.car_id as CAR_ID,tmp.car_type as CAR_TYPE, tmp.fee as FEE
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY as history union 
# (select car.car_id as id,car.car_type as type,ceiling(30*car.daily_fee*plan.discount_rate*0.01) as fee
# from car_rental_company_car as car left join car_rental_company_discount_plan as plan on car.car_type = plan.car_type
# where plan.duration_type='30일 이상' and car.car_type in ('SUV','세단')) as tmp


# select car_id,date_format(start_date,"%Y-%m-%d")
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY as history
# where history.start_date>'2022-11-30' or history.end_date<'2022-11-01'


