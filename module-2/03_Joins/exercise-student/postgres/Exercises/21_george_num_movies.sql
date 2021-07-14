-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, 
--even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'

SELECT p.person_name, COUNT(m.movie_id) AS num_of_movies
FROM person p
LEFT JOIN movie_actor mg ON  p.person_id = mg.actor_id
LEFT JOIN movie m ON m.movie_id = mg.movie_id
WHERE person_name LIKE 'George %'
GROUP BY person_id
ORDER BY person_name;
