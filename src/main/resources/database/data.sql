DROP TABLE iowniwant.user;

-- User Data Table
CREATE TABLE iowniwant.user (
   user_id         BIGSERIAL NOT NULL,
   first_name      VARCHAR(60) NOT NULL,
   last_name       VARCHAR(60) NOT NULL,
   nick_name       VARCHAR(60) NOT NULL UNIQUE,
   user_password   VARCHAR(60) NOT NULL,
   confirm_password VARCHAR(60) NOT NULL,
   email           VARCHAR(60),
   CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);

INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email)
values ('Jake', 'Q', 'Clayton', 'tripLane991', 'tripLane991', 'jayQ@gmail.com');
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email)
values ('Robin', 'J', 'BlueBerry', 'randyisoz19', 'randyisoz19', 'robinJ@gmail.com');
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email)
values ('Wade', 'J', 'ThatGuy', '922isthisnight', '922isthisnight', 'wadeJ@gmail.com');
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email)
values ('Sarah', 'Q', 'GlanceBlade', 'black1white', 'black1white', 'sarahQ@gmail.com');