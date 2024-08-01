USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SET @category_name = 'Beverages'
	, @percent_increase = 1.44;

SELECT @category_id := category_id
FROM categories
WHERE category_name = @category_name;

UPDATE products
SET unit_price = unit_price * @percent_increase
WHERE category_id = @category_id;