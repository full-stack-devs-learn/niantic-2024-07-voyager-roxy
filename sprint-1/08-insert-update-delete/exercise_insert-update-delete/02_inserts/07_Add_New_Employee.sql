USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default

INSERT INTO employees
(
	first_name
	, last_name
    , title
    , title_of_courtesy
    , birth_date
    , hire_date
    , address
    , notes
)
VALUES
(
	'Roxy'
    , 'Abedi'
    , 'Sales Associate'
    , 'Ms.'
    , '2000-01-29'
    , '2024-07-31'
    , '119 Northcreek Circle'
    , ' '
)