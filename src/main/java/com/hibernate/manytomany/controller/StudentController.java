package com.hibernate.manytomany.controller;

import com.hibernate.manytomany.dto.StudentDto;
import com.hibernate.manytomany.entity.Student;
import com.hibernate.manytomany.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid StudentDto studentDto){
        return new ResponseEntity<>(studentService.addStudent(studentDto),HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") Integer id){
        return new ResponseEntity<>(studentService.findStudentById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> update(@RequestBody @Valid StudentDto studentDto,@PathVariable Integer id){
        return new ResponseEntity<>(studentService.updateStudent(studentDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id){
        try {
          studentService.deleteStudent(id);
          return new ResponseEntity<>("Student Delete Successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
        }

    }

}
