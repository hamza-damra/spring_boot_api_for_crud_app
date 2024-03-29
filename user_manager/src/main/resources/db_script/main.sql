create database user_manager;
       use user_manager;
           grant all privileges on user_manager.* to 'user_manager'@'localhost' identified by 'user_manager';

CREATE TABLE user (
                      user_id INT NOT NULL AUTO_INCREMENT,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP NULL,
                      PRIMARY KEY (user_id)
);

show tables ;



select * from user;

insert into user (first_name, last_name, email, password) values ('sanad', 'damra', 'sanad@mail.com', '123');

delete from user where user_id = 1;

describe user;

drop table user;