-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
-- names and birthday: TABLE = person
-- The Fifth Element: TABLE = movie
SELECT p.person_name, p.birthday 
FROM movie m
JOIN movie_actor a ON m.movie_id = a.movie_id
JOIN person p ON a.actor_id = p.person_id
WHERE m.title = 'The Fifth Element';

