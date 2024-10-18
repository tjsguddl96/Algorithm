-- 코드를 입력하세요
SELECT concat('/home/grep/src/',file.board_id,'/',file.file_id,file.file_name,file.file_ext) as FILE_PATH
FROM USED_GOODS_FILE AS FILE join USED_GOODS_BOARD AS BOARD
    on file.board_id=board.board_id
WHERE FILE.BOARD_ID = (SELECT BOARD_ID
                      FROM USED_GOODS_BOARD AS BOARD
                       ORDER BY VIEWS desc
                       LIMIT 1
                      )
order by file.file_id desc