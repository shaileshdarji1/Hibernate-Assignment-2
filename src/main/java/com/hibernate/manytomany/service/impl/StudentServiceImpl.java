package com.hibernate.manytomany.service.impl;

import com.hibernate.manytomany.dto.StudentDto;
import com.hibernate.manytomany.entity.Student;
import com.hibernate.manytomany.exception.StudentNotFoundException;
import com.hibernate.manytomany.mapstruct.MapStructMapper;
import com.hibernate.manytomany.repository.StudentRepository;
import com.hibernate.manytomany.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MapStructMapper mapStructMapper;
    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = mapStructMapper.dtoToStudent(studentDto);
        Student save = studentRepository.save(student);
        log.info("Student saved successfully");
        return mapStructMapper.studentToDto(save);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> all = studentRepository.findAll();
        List<StudentDto> collect = all.stream().map(s -> mapStructMapper.studentToDto(s)).collect(Collectors.toList());
        log.info("Student record fetch successfully");
        return collect;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto,Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student!=null){
        student = mapStructMapper.dtoToStudent(studentDto);
        student.setId(id);
        log.info(studentDto.toString());
        return mapStructMapper.studentToDto(studentRepository.save(student));
        }
        else{
            log.error("Student not found!");
            throw new StudentNotFoundException("Student not found!");
        }
    }

    @Override
    public void deleteStudent(Integer id) {
           log.info("student delete successfully");
           studentRepository.deleteById(id);
    }

    @Override
    public StudentDto findStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            log.info(student.toString());
            return mapStructMapper.studentToDto(student.get());
        }
        else {
            log.error("Student Not Found");
            throw new StudentNotFoundException("Student Not Found");
        }
    }
}
