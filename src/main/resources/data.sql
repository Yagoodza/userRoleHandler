INSERT INTO role (name) VALUES ('admin'),
                               ('tester'),
                               ('developer'),
                               ('boss');

INSERT INTO user(login, name, password)
VALUES ('login 1', 'name 1', 'password 1'),
       ('login 2', 'name 2', 'password 2'),
       ('login 3', 'name 3', 'password 3');

INSERT INTO user_role(user_login, role_id)
VALUES ('login 1', 1),
       ('login 1', 3),
       ('login 3', 2);

