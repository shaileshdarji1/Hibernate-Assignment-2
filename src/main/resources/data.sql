-- Inserting records into department table
INSERT INTO department (name) VALUES ('Computer Science');
INSERT INTO department (name) VALUES ('Electrical Engineering');
INSERT INTO department (name) VALUES ('Mechanical Engineering');

-- Inserting records into course_tbl table
INSERT INTO course_tbl (title, abbreviation, modules, fee) VALUES ('Introduction to Programming', 'CS101', 4, 1200.00);
INSERT INTO course_tbl (title, abbreviation, modules, fee) VALUES ('Database Management Systems', 'CS201', 5, 1500.00);
INSERT INTO course_tbl (title, abbreviation, modules, fee) VALUES ('Software Engineering', 'CS301', 4, 1300.00);
INSERT INTO course_tbl (title, abbreviation, modules, fee) VALUES ('Network Security', 'CS401', 5, 1600.00);

-- Inserting records into student_tbl table
INSERT INTO student_tbl (student_name, age, dept_id) VALUES ('John Smith', 20, 1);
INSERT INTO student_tbl (student_name, age, dept_id) VALUES ('Emma Johnson', 22, 2);
INSERT INTO student_tbl (student_name, age, dept_id) VALUES ('Michael Brown', 21, 1);
INSERT INTO student_tbl (student_name, age, dept_id) VALUES ('Sophia Davis', 19, 3);

-- Inserting records into student_course_tbl table
INSERT INTO student_course_tbl (s_id, c_id) VALUES (1, 1);
INSERT INTO student_course_tbl (s_id, c_id) VALUES (1, 2);
INSERT INTO student_course_tbl (s_id, c_id) VALUES (2, 2);
INSERT INTO student_course_tbl (s_id, c_id) VALUES (3, 1);
INSERT INTO student_course_tbl (s_id, c_id) VALUES (3, 3);
