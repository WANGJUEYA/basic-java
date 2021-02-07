-- Write your MySQL query statement below

-- select * from Employee a

-- where a.Salary >= (select * FROM (SELECT (case when Salary IS NULL then 0 else Salary end)
--  from (select distinct(b.Salary) Salary from Employee b  where a.DepartmentId = b.DepartmentId order by b.Salary desc limit 1 offset 2) T1) T2)


select c.name as department,a.name as Employee,a.Salary as Salary from Employee a
left join department c
on a.departmentid = c.id

where 3 > (
select count(distinct b.Salary)
from Employee b
where a.departmentid = b.departmentid and a.Salary < b.Salary)
and c.name is not null