create table student
(
    id_student      INT AUTO_INCREMENT,
    name_student    text NOT NULL,
    surname_student text NOT NULL,
    age             INT  NOT NULL,
    PRIMARY KEY (id_student)
);

INSERT INTO student
VALUES (1, 'Vladimir', 'Harelka', 30);
INSERT INTO student
VALUES (2, 'Nikolay', 'Miller', 28);
INSERT INTO student
VALUES (3, 'Alex', 'Karpov', 25);
INSERT INTO student
VALUES (4, 'Yura', 'Chernishev', 30);
INSERT INTO student
VALUES (5, 'Masha', 'Nikulina', 20);