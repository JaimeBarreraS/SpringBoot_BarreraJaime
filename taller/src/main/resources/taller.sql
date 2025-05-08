insert into role (name) values
('Developer'),
('Designer'),
('Manager'),
('Engineer');

insert into user (role_id, name, password, username) 
VALUES 
(1, 'Lucia', 'password123', 'PythonDev'),
(1, 'Jaime', 'password456', 'WebMaster'),
(2, 'Jhonatan', 'password789', 'FullStack'),
(3, 'Freiler', 'password321', 'JavaExpert'),
(4, 'Diego', 'password654', 'SpringGuru');
