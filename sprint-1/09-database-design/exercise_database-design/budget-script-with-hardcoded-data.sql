-- use after running script to create database
-- script to populate hardcoded data
-- ideally run before script with variable input so table is first populated with some data

INSERT INTO people
(
	first_name
)
VALUES
(
	'Roxy'
);

INSERT INTO categories
(
	category_name
)
VALUES
	('Entertainment')
    , ('Food')
    , ('Healthcare')
    , ('Housing')
    , ('Transportation')
    , ('Vacation')
;

INSERT INTO subcategories
(
	subcategory_name
    , category_id
)
VALUES
('NBA League Pass', 1)
, ('Spotify', 1)
, ('Movies', 1)
, ('Sports', 1)
, ('Groceries', 2)
, ('Restaurant', 2)
, ('Snacks', 2)
, ('Rx', 3)
, ('OTC Medicine', 3)
, ('Rent', 4)
, ('Internet', 4)
, ('Utilities', 4)
, ('Gas', 5)
, ('BART', 5)
, ('Flight', 6)
, ('Hotel', 6)
, ('Car Rental', 6);

INSERT INTO vendors
(
	vendor_name
)
VALUES
	('NBA')
	, ('Spotify')
    , ('Cinemark')
    , ('Oracle Park')
    , ('Safeway')
    , ('In N Out')
    , ('Target')
    , ('Trader Joes')
    , ('CVS Pharmacy')
    , ('Walgreens')
    , ('Landlord')
    , ('Verizon')
    , ('PG&E')
    , ('Chevron')
    , ('BART')
    , ('Southwest')
    , ('Marriott')
    , ('Hertz');
    
INSERT INTO transaction_details
(
	date
	, amount
	, notes
	, person_id
	, subcategory_id
	, vendor_id
)
VALUES
	('2024-05-01', 12.99, 'Monthly subscription fee', 1, 1, 1)
	, ('2024-05-01', 10.99, 'Monthly subscription fee', 1, 2, 2)
	, ('2024-05-03', 8.99, 'Movie night', 1, 3, 3)
	, ('2024-05-15', 21.00, 'Tickets to a baseball game', 1, 4, 4)
	, ('2024-05-04', 70.00, 'Weekly groceries', 1, 5, 5)
	, ('2024-05-20', 8.99, 'Dinner with friends', 1, 6, 6)
	, ('2024-05-03', 11.99, 'Snacks for movie night', 1, 7, 7)
	, ('2024-05-06', 10.99, 'Prescription refill', 1, 8, 9)
	, ('2024-05-25', 50.00, 'Weekly groceries', 1, 5, 8)
	, ('2024-05-19', 15.99, 'Allergy medicine', 1, 9, 10)
	, ('2024-05-01', 1350.00, 'Monthly rent', 1, 10, 11)
	, ('2024-05-30', 50.00, 'Internet bill', 1, 11, 12)
	, ('2024-05-17', 45.00, 'Electric bill', 1, 12, 13)
	, ('2024-05-10', 90.00, 'Fill up car', 1, 13, 14)
	, ('2024-05-14', 25.60, 'Fare costs', 1, 14, 15)
	, ('2024-05-20', 80.00, 'Plane tickets', 1, 15, 16)
	, ('2024-05-20', 200.00, 'Hotel booking', 1, 16, 17)
	, ('2024-05-20', 150.00, 'Rental car for trip', 1, 17, 18);
        
SELECT 
	date AS Date
    , first_name AS Person
    , category_name AS Category
    , subcategory_name AS Subcategory
    , vendor_name AS Vendor
    , amount AS Amount
    , notes AS Notes
FROM transaction_details
INNER JOIN subcategories ON transaction_details.subcategory_id = subcategories.subcategory_id
INNER JOIN categories ON subcategories.category_id = categories.category_id
INNER JOIN people ON transaction_details.person_id = people.person_id
INNER JOIN vendors ON transaction_details.vendor_id = vendors.vendor_id;

SELECT 
	DATE_FORMAT(date, '%Y-%M') AS Month
    , category_name AS Category
    , SUM(amount) AS Amount
FROM transaction_details
INNER JOIN subcategories ON transaction_details.subcategory_id = subcategories.subcategory_id
INNER JOIN categories ON subcategories.category_id = categories.category_id
WHERE date LIKE '2024-05%'
GROUP BY category_name
	, Month;

SELECT 
	DATE_FORMAT(date, '%Y-%M') AS Month
    , subcategory_name AS Subcategory
    , SUM(amount) AS Amount
FROM transaction_details
INNER JOIN subcategories ON transaction_details.subcategory_id = subcategories.subcategory_id
WHERE date LIKE '2024-05%'
GROUP BY subcategory_name
	, Month;


