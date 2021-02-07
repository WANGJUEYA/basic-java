-- Write your MySQL query statement below

select class
from (select distinct student,class from courses) t
group by class
having count(1) >= 5