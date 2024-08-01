USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SET @input_category_id = 1;

SELECT @input_category_name := category_name
FROM categories
WHERE category_id = input_category_id;

SET @input_percent_increase = 1.20;

UPDATE products
SET unit_price = unit_price * input_percent_increase
WHERE category_id = input_category_id;