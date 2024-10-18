SELECT info.id as ID,ninfo.fish_name as FISH_NAME, LENGTH
FROM FISH_INFO as info join fish_name_info as ninfo on info.FISH_TYPE=ninfo.FISH_TYPE
WHERE (info.FISH_TYPE, LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    GROUP BY FISH_TYPE
) 
