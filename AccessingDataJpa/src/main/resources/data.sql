DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name varchar,
  last_name varchar
);

INSERT INTO Customer (first_name, last_name) VALUES
  ('Jack', 'Bauer'),
  ('Chloe', 'O''Brian'),
  ('Kim', 'Bauer'),
  ('David', 'Palmer'),
  ('Michelle', 'Dessler');
