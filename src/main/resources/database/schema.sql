CREATE TABLE IF NOT EXISTS people.users (
  id         INT         NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  last_name  VARCHAR(30) NOT NULL,
  email      VARCHAR(60) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);