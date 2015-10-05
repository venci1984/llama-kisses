DROP TABLE offers IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE subscriptions IF EXISTS;

CREATE TABLE offers (
  id  				INTEGER IDENTITY PRIMARY KEY,
  name 		 		VARCHAR(255) DEFAULT '' NOT NULL ,
  amount  	 		INTEGER DEFAULT -1 NOT NULL ,
  paymill_id 		VARCHAR(255) DEFAULT '' NOT NULL
);

CREATE TABLE users (
  id   				INTEGER IDENTITY PRIMARY KEY,
  email 			VARCHAR(255) DEFAULT '' NOT NULL,
  password			VARCHAR(255) DEFAULT '' NOT NULL,
  name				VARCHAR(255) DEFAULT '' NOT NULL,
  paymill_id		VARCHAR(255) DEFAULT '' NOT NULL,
  offer_id			INTEGER NOT NULL  
);
ALTER TABLE users ADD CONSTRAINT fk_users_offers FOREIGN KEY (offer_id) REFERENCES offers (id);
ALTER TABLE users ADD CONSTRAINT un_email UNIQUE (email);

CREATE TABLE subscriptions (
  id       			INTEGER IDENTITY PRIMARY KEY,
  active 			BOOLEAN,
  next_capture_at	INTEGER DEFAULT -1 NOT NULL ,
  canceled_at		INTEGER DEFAULT NULL,
  paymill_id		VARCHAR(255) DEFAULT '' NOT NULL ,
  payment_id		VARCHAR(255) DEFAULT '' NOT NULL ,
  user_id			INTEGER NOT NULL 
);
ALTER TABLE subscriptions ADD CONSTRAINT fk_subscriptions_users FOREIGN KEY (user_id) REFERENCES users (id);
