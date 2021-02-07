# Write your MySQL query statement below

        select id,
        sum( case when month = 'Jan' then revenue else NULL end) Jan_Revenue,
        sum( case when month = 'Feb' then revenue else NULL end) Feb_Revenue,
        sum( case when month = 'Mar' then revenue else NULL end) Mar_Revenue,
        sum( case when month = 'Apr' then revenue else NULL end) Apr_Revenue,
        sum( case when month = 'May' then revenue else NULL end) May_Revenue,
        sum( case when month = 'Jun' then revenue else NULL end) Jun_Revenue,
        sum( case when month = 'Jul' then revenue else NULL end) Jul_Revenue,
        sum( case when month = 'Aug' then revenue else NULL end) Aug_Revenue,
        sum( case when month = 'Sep' then revenue else NULL end) Sep_Revenue,
        sum( case when month = 'Oct' then revenue else NULL end) Oct_Revenue,
        sum( case when month = 'Nov' then revenue else NULL end) Nov_Revenue,
        sum( case when month = 'Dec' then revenue else NULL end) Dec_Revenue
        from department
        group by id