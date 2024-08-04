-- script for creating the database

DROP DATABASE IF EXISTS budget;

CREATE DATABASE budget;

USE budget;

CREATE TABLE people
(
   person_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(40) NOT NULL UNIQUE,
   PRIMARY KEY (person_id)
);

CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(20) UNIQUE,
    PRIMARY KEY (category_id)
);

CREATE TABLE vendors
(
	vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(40) UNIQUE,
    PRIMARY KEY (vendor_id)
);

CREATE TABLE subcategories
(
	subcategory_id INT NOT NULL AUTO_INCREMENT,
    subcategory_name VARCHAR(20) UNIQUE,
    category_id INT NOT NULL,
    PRIMARY KEY (subcategory_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE TABLE transaction_details
(
	transaction_id INT NOT NULL AUTO_INCREMENT,
    date DATE,
    amount DECIMAL(10,2),
    notes TEXT,
    person_id INT NOT NULL,
    subcategory_id INT NOT NULL,
    vendor_id INT NOT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (person_id) REFERENCES people (person_id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategories (subcategory_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id)
);