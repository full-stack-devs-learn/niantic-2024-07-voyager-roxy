USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

INSERT INTO products
(
	product_name
    , category_id
    , unit_price
    , units_in_stock
    , units_on_order
    , reorder_level
)
VALUES ('Soccer Ball', 9, 25.99, 20, 0, 10)
	, ('Tennis Racket', 9, 49.99, 20, 0, 10)
    , ('Yoga Mat', 9, 19.99, 20, 0, 10)
    , ('Mountain Bike', 9, 399.99, 20, 0, 10)
    , ('Hiking Backpack', 9, 79.99, 20, 0, 10)
    , ('Baseball Glove', 9, 45.00, 20, 0, 10)
    , ('Running Shoes', 9, 89.99, 20, 0, 10)
    , ('Fishing Rod', 9, 59.99, 20, 0, 10)
    , ('Kayak', 9, 299.99, 20, 0, 10)
    , ('Badminton Set', 9, 34.99, 20, 0, 10)
;