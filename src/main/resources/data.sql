DROP TABLE udemy.user;

CREATE TABLE udemy.user (
   id 		     BIGSERIAL NOT NULL,
   username 	 VARCHAR(60),
   password 	 VARCHAR(60),
   email	     VARCHAR(60),
CONSTRAINT id_pk PRIMARY KEY(id)
);

INSERT INTO udemy.user(username, password, email)
VALUES('user1', 'user1', 'user1@gmail.com');
INSERT INTO udemy.user(username, password, email)
VALUES('user2', 'user2', 'user2@red.com');
INSERT INTO udemy.user(username, password, email)
VALUES('user3', 'user3', 'user3@rot.com');
INSERT INTO udemy.user(username, password, email)
VALUES('user4', 'user4', 'user4@gmail.com');

SELECT udemy.user.id, udemy.user.username, udemy.user.password, udemy.user.email from udemy.user WHERE udemy.user.id=1;