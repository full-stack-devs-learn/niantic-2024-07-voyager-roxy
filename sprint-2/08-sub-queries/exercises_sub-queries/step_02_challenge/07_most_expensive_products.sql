-- 7. expensive products report

-- Display the most expensive product in each category

-- Columns to include:
-- Category Name
-- Product Name
-- Unit price

-- NOTE: you can combine INNER JOIN and sub queries in the
-- query if you would like

-- (8 rows - one per category)
-- Beverages        Cte de Blaye            263.5000
-- Condiments       Vegie-spread            43.9000
-- Confections      Sir Rodney's Marmalade  81.0000
-- Dairy Products   Raclette Courdavault    55.0000
-- Grains/Cereals   Gnocchi di nonna Alice  38.0000
-- Meat/Poultry     Thringer Rostbratwurst  123.7900
-- Produce          Manjimup Dried Apples   53.0000
-- Seafood          Carnarvon Tigers        62.5000


USE northwind;

SELECT (SELECT category_name
    FROM categories AS c
    WHERE p2.category_id = c.category_id) category_name
	, p2.product_name
	, p2.unit_price    
FROM products AS p2
WHERE p2.unit_price = (SELECT MAX(p1.unit_price)
    FROM products AS p1
    WHERE p1.category_id = p2.category_id)
ORDER BY category_name
;
