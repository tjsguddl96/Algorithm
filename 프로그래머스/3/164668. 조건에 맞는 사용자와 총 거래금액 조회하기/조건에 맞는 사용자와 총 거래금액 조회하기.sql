select u.user_id as user_id,u.nickname as nickname,sum(b.price) as total_sales
from used_goods_board as b inner join used_goods_user as u
    on b.writer_id=u.user_id
group by b.writer_id,b.status
having b.status='DONE' and sum(b.price)>=700000
order by total_sales


# select writer_id,price,status
# from used_goods_board
# order by writer_id

# select writer_id,sum(price),status
# from used_goods_board
# group by writer_id,status
# order by writer_id
