-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT g.genre_name
FROM movie m
JOIN movie_genre mg ON m.movie_id = mg.movie_id
JOIN genre g ON mg.genre_id = g.genre_id
WHERE m.title = 'The Wizard of Oz'
;

