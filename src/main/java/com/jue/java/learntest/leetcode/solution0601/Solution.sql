-- Write your MySQL query statement below

Select distinct * from stadium 
where people >= 100
and (
    ((id + 1) in (Select id from stadium where people >= 100) and (id + 2) in (Select id from stadium where people >= 100))
    or ((id - 1) in (Select id from stadium where people >= 100) and (id + 1) in (Select id from stadium where people >= 100))
    or ((id - 1) in (Select id from stadium where people >= 100) and (id - 2) in (Select id from stadium where people >= 100)))