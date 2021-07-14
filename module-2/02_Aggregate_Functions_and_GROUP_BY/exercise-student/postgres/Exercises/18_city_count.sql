-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory
-- (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)
SELECT state_abbreviation, COUNT(city_id) AS num_cities
FROM city
WHERE state_abbreviation != 'DC'
Group BY state_abbreviation;
