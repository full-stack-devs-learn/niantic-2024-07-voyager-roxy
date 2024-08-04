-- use after running script to create database and script to populate tables with starting data
-- script for variable input

USE budget;

SET @person_first_name = 'Scott';
SET @category_name = 'Housing';
SET @subcategory_name = 'Rent';
SET @vendor = 'Landlord';
SET @transaction_date = '2024-05-01';
SET @transaction_amount = '1200';
SET @transaction_note = 'Monthly rent';
    
INSERT IGNORE INTO people (first_name)
VALUES (@person_first_name)
ON DUPLICATE KEY UPDATE person_id = LAST_INSERT_ID(person_id);

SELECT @person_id := person_id
FROM people
WHERE first_name = @person_first_name;

INSERT INTO categories
(
	category_name
)
VALUES
	(@category_name)
ON DUPLICATE KEY UPDATE category_id = LAST_INSERT_ID(category_id);
;

SELECT @category_id := category_id
FROM categories
WHERE category_name = @category_name;

INSERT INTO subcategories
(
	subcategory_name
    , category_id
)
VALUES
	(@subcategory_name, @category_id)
ON DUPLICATE KEY UPDATE category_id = LAST_INSERT_ID(category_id);

SELECT @subcategory_id := subcategory_id
FROM subcategories
WHERE subcategory_name = @subcategory_name;

INSERT INTO vendors
(
	vendor_name
)
VALUES
	(@vendor)
ON DUPLICATE KEY UPDATE vendor_id = LAST_INSERT_ID(vendor_id);
    
SELECT @vendor_id := vendor_id
FROM vendors
WHERE vendor_name = @vendor;
    
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
	(@transaction_date, @transaction_amount, @transaction_note, @person_id, @subcategory_id, @vendor_id);
        
SELECT 
	date as Date
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

SET @month_and_year = '2024-05%';

SELECT 
	DATE_FORMAT(date, '%Y-%M') AS Month
    , category_name AS Category
    , SUM(amount) AS Amount
FROM transaction_details
INNER JOIN subcategories ON transaction_details.subcategory_id = subcategories.subcategory_id
INNER JOIN categories ON subcategories.category_id = categories.category_id
WHERE date LIKE @month_and_year
GROUP BY category_name
	, Month;

SELECT 
	DATE_FORMAT(date, '%Y-%M') AS Month
    , subcategory_name AS Subcategory
    , SUM(amount) AS Amount
FROM transaction_details
INNER JOIN subcategories ON transaction_details.subcategory_id = subcategories.subcategory_id
WHERE date LIKE @month_and_year
GROUP BY subcategory_name
	, Month;
