-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)
SELECT title, release_date 
FROM movie m
JOIN movie_actor a ON m.movie_id = a.movie_id
JOIN person p ON a.actor_id = p.person_id
WHERE p.person_name = 'Tom Hanks';


