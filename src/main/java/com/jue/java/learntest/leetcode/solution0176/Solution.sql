-- Write your MySQL query statement below

select max(salary) SecondHighestSalary from employee
where salary < (select max(salary) from employee)