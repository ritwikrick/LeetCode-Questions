-- # Write your MySQL query statement below
-- select num
-- from MyNUmbers
-- group by num
-- having count(num)=1
-- order by num desc
-- limit 1

SELECT (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    ORDER BY num DESC
    LIMIT 1
) AS num;
