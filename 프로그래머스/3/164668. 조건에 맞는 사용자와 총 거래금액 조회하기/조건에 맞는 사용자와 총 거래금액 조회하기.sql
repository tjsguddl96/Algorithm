-- 코드를 입력하세요
select b.user_id,b.nickname,a.hap as TOTAL_SALES
from used_goods_user as b
    join 
        (SELECT writer_id,sum(price) as hap
        from used_goods_board
        group by status,writer_id
        having status='DONE' and hap>=700000) as a
    on b.user_id=a.writer_id
order by total_sales asc

# SELECT *
# from used_goods_board
# where writer_id='dhfkzmf09'

#tkfkdgo1 310000
#xlaortm1 done:10000,sale:0
#dhfkzmf09	860000 done