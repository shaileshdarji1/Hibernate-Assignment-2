package com.hibernate.manytomany.repository;

import com.hibernate.manytomany.entity.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@TestPropertySource("classpath:application-test.properties")
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    List<Student> studentList;

    @BeforeEach
    void setUp() {
        studentList = studentRepository.findAll();
    }

    @AfterEach
    void tearDown() {
        studentList = null;
    }

    @Test
    void testFindStudentByDepartment_Found() {
        List<Student> studentByDepartment = studentRepository.findStudentByDepartment("Computer Science");
        List<Student> studentByDepartment1 = studentList.stream().filter(student -> student.getDepartment().getName().equals("Computer Science")).collect(Collectors.toList());
        assertTrue(studentByDepartment.size() == studentByDepartment1.size()
                && studentByDepartment.containsAll(studentByDepartment1)
                && studentByDepartment1.containsAll(studentByDepartment));
    }

    @Test
    void testFindStudentByDepartment_NotFound(){
        List<Student> studentByDepartment = studentRepository.findStudentByDepartment("Shailesh");
        assertThat(studentByDepartment.isEmpty()).isTrue();
    }

    @Test
    void testFindStudentByCourseName_Found(){
        List<Student> studentByCourseNameDB = studentRepository.findStudentByCourseName("Introduction to Programming");
        List<Student> studentByCourseNameStream = studentList.stream()
                .filter(student -> student.getCourses()
                        .stream()
                        .anyMatch(course -> course.getTitle().equals("Introduction to Programming")))
                .collect(Collectors.toList());

        assertTrue(studentByCourseNameDB.size()==studentByCourseNameStream.size()
                && studentByCourseNameDB.containsAll(studentByCourseNameStream)
                && studentByCourseNameStream.containsAll(studentByCourseNameDB));
    }

    @Test
    void testFindStudentByCourseName_NotFound(){
        List<Student> students = studentRepository.findStudentByCourseName("Java");
        assertThat(students.isEmpty()).isTrue();
    }

}