-- Write your MySQL query statement below

select a.id from weather a
left join weather b -- 假定之于昨天
on date_sub(a.recordDate,interval 1 day) = b.recordDate
where a.temperature > b.temperature