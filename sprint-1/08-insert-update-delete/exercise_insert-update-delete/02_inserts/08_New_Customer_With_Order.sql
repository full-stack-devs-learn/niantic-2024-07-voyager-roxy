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

SET @product1_name = 'Chai'
	, @product2_name = 'Tofu'
    , @product3_name = 'Ikura'
    , @product4_name = 'Chang'
    , @product5_name = 'Boston Crab Meat';

SET @customer_id = 'APTEC'
	, @company_name = 'Apex Technologies'
    , @contact_name = 'Jordan Lee'
    , @address = '123 Innovation Drive'
    , @city = 'Tech City'
    , @region = 'TX'
    , @postal_code = 75001
    , @country = 'USA';

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
	@customer_id
    , @company_name
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);

INSERT INTO orders
(
	customer_id
    , order_date
    , ship_name
    , ship_address
    , ship_city
    , ship_region
    , ship_postal_code
    , ship_country
)
VALUES
(
	@customer_id
    , CURRENT_DATE
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);

SET @order_id = LAST_INSERT_ID();

SELECT @product1_id := product_id
	, @product_price_1 := unit_price
FROM products
WHERE product_name = @product1_name;

SELECT @product2_id := product_id
	, @product_price_2 := unit_price
FROM products
WHERE product_name = @product2_name;

SELECT @product3_id := product_id
	, @product_price_3 := unit_price
FROM products
WHERE product_name = @product3_name;

SELECT @product4_id := product_id
	, @product_price_4 := unit_price
FROM products
WHERE product_name = @product4_name;

SELECT @product5_id := product_id
	, @product_price_5 := unit_price
FROM products
WHERE product_name = @product5_name;

INSERT INTO order_details
(
	order_id
    , product_id
    , unit_price
)
VALUES
	(@order_id, @product1_id, @product_price_1)
	, (@order_id, @product2_id, @product_price_2)
	, (@order_id, @product3_id, @product_price_3)
	, (@order_id, @product4_id, @product_price_4)
	, (@order_id, @product5_id, @product_price_5)
;

SELECT *
FROM order_details
WHERE order_id = @order_id;