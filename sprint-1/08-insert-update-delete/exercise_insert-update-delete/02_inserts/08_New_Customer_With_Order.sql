-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/

SET @product1_id = 2;
SET @product2_id = 6;
SET @product3_id = 67;
SET @product4__id = 80;
SET @product5_id = 7;

SET @input_customer_id = 'APTEC';
SET @input_company_name = 'Apex Technologies';
SET @input_contact_name = 'Jordan Lee';
SET @input_address = '123 Innovation Drive';
SET @input_city = 'Tech City';
SET @input_region = 'TX';
SET @input_postal_code = 75001;
SET @input_country = 'USA';

SELECT @price1 := unit_price
FROM products
WHERE product_id = @product_id1;

SELECT @price2 := unit_price
FROM products
WHERE product_id = @product_id2;

SELECT @price3 := unit_price
FROM products
WHERE product_id = @product_id3;

SELECT @price4 := unit_price
FROM products
WHERE product_id = @product_id;

SELECT @price5 := unit_price
FROM products
WHERE product_id = @product_id5;


INSERT INTO customers
(
	customer_id
    , company_name
    , contact_name
    , address
    , city
    , region
    , postal_code
    , country
)
VALUES
(
	input_customer_id
    , input_company_name
    , input_contact_name
    , input_address
    , input_city
    , input_region
    , input_postal_code
    , input_country
);

INSERT INTO orders
(
	customer_id
    , order_date
    , ship_name
    , ship_address
)
VALUES
(
	input_customer_id
    , '2024-07-31'
    , input_company_name
    , input_address
);

INSERT INTO order_details
(
	order_id
    , product_id
    , unit_price
    , quantity
    , discount
)
VALUES
(
	(last_insert_id(), product1_id, price1, 5, 0)
    , (last_insert_id(), product2_id, price2, 5, 0)
    , (last_insert_id(), product3_id, price3, 1, 0)
    , (last_insert_id(), product4_id, price4, 1, 0)
    , (last_insert_id(), product5_id, price5, 1, 0)
)




