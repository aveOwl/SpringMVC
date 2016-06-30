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
   month_salary    REAL DEFAULT 0,
   CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);

INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email, month_salary)
values ('admin', 'admin', 'admin', 'admin', 'admin', 'admin@gmail.com', 50000);
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email, month_salary)
values ('Jake', 'Q', 'Clayton', 'tripLane991', 'tripLane991', 'jayQ@gmail.com', 2500);
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email, month_salary)
values ('Robin', 'J', 'BlueBerry', 'randyisoz19', 'randyisoz19', 'robinJ@gmail.com', 11000);
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email, month_salary)
values ('Wade', 'J', 'ThatGuy', '922isthisnight', '922isthisnight', 'wadeJ@gmail.com', 1800);
INSERT INTO iowniwant.user (first_name, last_name, nick_name, user_password, confirm_password, email, month_salary)
values ('Sarah', 'Q', 'GlanceBlade', 'black1white', 'black1white', 'sarahQ@gmail.com', 9000);