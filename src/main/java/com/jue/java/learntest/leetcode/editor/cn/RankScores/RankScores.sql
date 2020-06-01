-- Write your MySQL query statement below
select scores.score,map.rank from scores
left join
(select score, @rank := @rank + 1 as rank from (select distinct score from scores
order by score desc) a,(select @rank := 0) b) map
on scores.score = map.score
order by map.rank asc