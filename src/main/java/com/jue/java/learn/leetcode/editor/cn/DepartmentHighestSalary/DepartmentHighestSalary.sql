-- Write your MySQL query statement below
        select c.name as department,b.name as employee,a.max as salary

        from (select departmentid id,max(salary) max
        from employee
        group by departmentid)a

        left join employee b
        on a.id = b.departmentid and a.max = b.salary

        left join department c
        on a.id = c.id

        where c.name is not null and b.name is not null and a.max is not null