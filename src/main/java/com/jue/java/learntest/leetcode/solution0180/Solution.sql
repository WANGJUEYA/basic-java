-- Write your MySQL query statement below

select distinct a.num as ConsecutiveNums
from Logs a
left join Logs b
on a.id + 1 = b.id
left join Logs c
on a.id + 2 = c.id
where a.num = b.num and b.num = c.num