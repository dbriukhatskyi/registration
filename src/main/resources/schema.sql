CREATE TABLE users (
  email VARCHAR(40) UNIQUE,
  password VARCHAR(40),
  is_confirmed BOOLEAN
);