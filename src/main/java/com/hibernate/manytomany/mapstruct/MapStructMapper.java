package com.hibernate.manytomany.mapstruct;

import com.hibernate.manytomany.constants.Constant;
import com.hibernate.manytomany.dto.CourseDto;
import com.hibernate.manytomany.dto.StudentDto;
import com.hibernate.manytomany.entity.Course;
import com.hibernate.manytomany.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constant.SPRING)
public interface MapStructMapper {


    public Course dtoToCourse(CourseDto courseDto);
    public CourseDto courseToDto(Course course);

    public Student dtoToStudent(StudentDto studentDto);
    public StudentDto studentToDto(Student student);
}
