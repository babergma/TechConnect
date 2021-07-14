-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT title, person_name
FROM movie m
JOIN movie_actor ma ON ma.movie_id = m.movie_id
JOIN person p ON ma.actor_id = p.person_id
WHERE ma.actor_id = p.person_id AND m.director_id = p.person_id;

