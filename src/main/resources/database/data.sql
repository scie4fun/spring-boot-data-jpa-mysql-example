INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL)
  SELECT *
  FROM (SELECT 'Petro', 'Zaharulko', 'petroUA.1985@gmail.com') AS target
  WHERE NOT EXISTS(
      SELECT email
      FROM USERS
      WHERE email = 'petroUA.1985@gmail.com'
  )
  LIMIT 1;

INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL)
  SELECT *
  FROM (SELECT 'Orest', 'Zvytyazny', 'zvytyaha.orest.95@gmail.com') AS target
  WHERE NOT EXISTS(
      SELECT email
      FROM USERS
      WHERE email = 'zvytyaha.orest.95@gmail.com'
  )
  LIMIT 1;

INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL)
  SELECT *
  FROM (SELECT 'Kyrylo', 'Kozhumjyaka', 'k.kozhumjyaka.87@gmail.com') AS target
  WHERE NOT EXISTS(
      SELECT email
      FROM USERS
      WHERE email = 'k.kozhumjyaka.87@gmail.com'
  )
  LIMIT 1;
