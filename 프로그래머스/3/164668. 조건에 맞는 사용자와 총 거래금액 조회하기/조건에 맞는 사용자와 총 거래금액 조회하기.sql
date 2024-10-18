-- 코드를 입력하세요
SELECT board.writer_id USER_ID,user.nickname as NICKNAME, sum(board.price) as TOTAL_SALES
from USED_GOODS_BOARD as board join USED_GOODS_USER as user 
    on board.writer_id=user.user_id
group by board.writer_id,board.status
having board.status='DONE' and total_sales>=700000
order by total_sales asc