-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
SELECT title, tagline
FROM movie m
JOIN movie_actor ma ON ma.movie_id = m.movie_id
JOIN person p ON ma.actor_id = p.person_id
WHERE p.birthday >= '01-01-1950' AND p.birthday <= '12-31-1959' AND release_date >= '01-01-1985' AND release_date <= '12-31-1985';


