create table courses
(
    id_cours   INT AUTO_INCREMENT,
    name_cours text NOT NULL,
    PRIMARY KEY (id_cours)
);

INSERT INTO courses
VALUES (1, 'JAVA');
INSERT INTO courses
VALUES (2, 'PYTHON');
INSERT INTO courses
VALUES (3, 'C++');

create table student_level
(
    id_level   INT AUTO_INCREMENT,
    name_level text NOT NULL,
    PRIMARY KEY (id_level)
);

INSERT INTO student_level
VALUES (1, 'JUNIOR');
INSERT INTO student_level
VALUES (2, 'MIDDLE');
INSERT INTO student_level
VALUES (3, 'SENIOR');

create table student
(
    id_student      INT AUTO_INCREMENT,
    name_student    text NOT NULL,
    surname_student text NOT NULL,
    age             INT  NOT NULL,
    id_cours        INT  NOT NULL,
    id_level        INT  NOT NULL,
    PRIMARY KEY (id_student),
    FOREIGN KEY (id_cours) REFERENCES courses (id_cours),
    FOREIGN KEY (id_level) REFERENCES student_level (id_level)
);

INSERT INTO student
VALUES (1, 'Vladimir', 'Harelka', 30, 1, 1);
INSERT INTO student
VALUES (2, 'Nikolay', 'Miller', 28, 2, 1);
INSERT INTO student
VALUES (3, 'Alex', 'Karpov', 25, 3, 2);
INSERT INTO student
VALUES (4, 'Yura', 'Chernishev', 30, 1, 2);
INSERT INTO student
VALUES (5, 'Masha', 'Nikulina', 20, 2, 3);