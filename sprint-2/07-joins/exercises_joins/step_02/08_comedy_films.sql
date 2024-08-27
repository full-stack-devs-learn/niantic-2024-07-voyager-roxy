-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT c.name AS category
	, f.title
FROM category AS c
INNER JOIN film_category AS fa ON c.category_id = fa.category_id
INNER JOIN film as f ON fa.film_id = f.film_id
WHERE c.name = 'Comedy';
