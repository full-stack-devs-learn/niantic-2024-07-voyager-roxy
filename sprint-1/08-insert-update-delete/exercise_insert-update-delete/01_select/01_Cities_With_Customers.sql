USE northwind;

-- Return all countries and cities where we 
-- have customers

-- Expected: 69 Rows

SELECT country
	, city
FROM customers
GROUP BY country,
	city;