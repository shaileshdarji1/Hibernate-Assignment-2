package com.hibernate.manytomany.service;

import com.hibernate.manytomany.dto.StudentDto;
import com.hibernate.manytomany.entity.Student;

import java.util.List;

public interface StudentService {

    public StudentDto addStudent(StudentDto studentDto);

    public List<StudentDto> getStudents();

    public StudentDto updateStudent(StudentDto studentDto,Integer id);

    public void deleteStudent(Integer id);

    public StudentDto findStudentById(Integer id);
}
