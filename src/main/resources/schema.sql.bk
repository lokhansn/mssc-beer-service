-- H2 Database specific table had to add it otherwise getting error as beer table not found while
-- executing insert statements

CREATE TABLE beer
(
    id VARCHAR(255) primary key,
    beer_name VARCHAR(255),
    beer_style VARCHAR(255),
    created_date DATE,
    last_modified_date DATE ,
    min_on_hand integer,
    price numeric(19,2),
    quantity_to_brew integer,
    upc VARCHAR(255) NOT NULL UNIQUE,
    version bigint
);