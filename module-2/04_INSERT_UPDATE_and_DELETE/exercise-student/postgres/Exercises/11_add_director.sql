-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. 
--Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

--add myself to person table
INSERT INTO person (person_name)
VALUES ('Bridgette Bergman');

--update movie the blob to have a director id of my id that is in the person table 
UPDATE movie
SET director_id = 
(SELECT person_id FROM person WHERE person_name = 'Bridgette Bergman');
WHERE title = 'The Blob';

--SELECT * FROM movie WHERE title = 'The Blob';