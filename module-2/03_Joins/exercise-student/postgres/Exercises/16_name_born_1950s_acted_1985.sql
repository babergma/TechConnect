-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT p.person_name, p.birthday
FROM movie m
JOIN movie_actor ma ON ma.movie_id = m.movie_id
JOIN person p ON ma.actor_id = p.person_id
WHERE p.birthday >= '01-01-1950' AND p.birthday <= '12-31-1959' AND release_date >= '01-01-1985' AND release_date <= '12-31-1985';


