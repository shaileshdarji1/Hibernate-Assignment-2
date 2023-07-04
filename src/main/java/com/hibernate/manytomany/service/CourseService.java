package com.hibernate.manytomany.service;

import com.hibernate.manytomany.dto.CourseDto;
import com.hibernate.manytomany.entity.Course;

import java.util.List;

public interface CourseService {

    public CourseDto addCourse(CourseDto courseDto);

    public List<CourseDto> getCourses();

    public CourseDto updateCourse(CourseDto courseDto,Integer id);

    public void deleteCourse(Integer id);

    public CourseDto findCourseById(Integer id);
}
