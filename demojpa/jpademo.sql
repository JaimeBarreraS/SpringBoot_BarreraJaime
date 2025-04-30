use jpademo;
select * from roles;
select * from personas;
select * from passport;
select * from project;

insert into roles (name) values
('Developer'),
('Designer'),
('Manager'),
('Engineer');

insert into personas (rol_id, full_name, last_name, programming_language) values
(1, 'Lucia', 'Gonzales', 'Python'),
(1, 'Jaime', 'Gonzales', 'HTML & CSS'),
(2, 'Jhonatan', 'Gonzales', 'Angular'),
(3, 'Freiler', 'Gonzales', 'Java'),
(4, 'Diego', 'Gonzales', 'SpringBoot');

insert into passport (expiration, number, person_id) values
('2027-12-31', 'A1234567', 1),
('2026-05-20', 'B7654321', 2),
('2028-03-15', 'C9988776', 3);

insert into project(name) values
('SpaceX'),
('PalmarisTech'),
('KarioMedia');

insert into personas_project(persona_id, project_id) values
(1,1),
(2,1),
(3,2),
(4,3),
(5,2);







