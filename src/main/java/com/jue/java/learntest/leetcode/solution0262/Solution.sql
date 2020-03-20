-- Write your MySQL query statement below
SELECT day, round(sum(cancel) /sum(total),2) as 'Cancellation Rate' from
(SELECT request_at as day, sum(case Status when 'completed' then 0 else 1 end) cancel, sum(1) total 
from (SELECT a.* 
from trips a

left join users b on a.client_id = b.users_id
left join users c on a.driver_id = c.users_id

where b.banned = 'No' and c.banned = 'No') t
group by request_at, Status)t
where day in ('2013-10-01','2013-10-02','2013-10-03')
group by day