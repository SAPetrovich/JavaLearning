DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Customer2;

CREATE TABLE Customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  FirstName varchar,
  LastName varchar
);

INSERT INTO Customer (FirstName, LastName) VALUES
  ('Jack', 'Bauer'),
  ('Chloe', 'O''Brian'),
  ('Kim', 'Bauer'),
  ('David', 'Palmer'),
  ('Michelle', 'Dessler');
