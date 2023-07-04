package com.hibernate.manytomany.service.impl;

import com.hibernate.manytomany.dto.CourseDto;
import com.hibernate.manytomany.entity.Course;
import com.hibernate.manytomany.exception.CourseNotFoundException;
import com.hibernate.manytomany.mapstruct.MapStructMapper;
import com.hibernate.manytomany.repository.CourseRepository;
import com.hibernate.manytomany.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course course = mapStructMapper.dtoToCourse(courseDto);
        Course save = courseRepository.save(course);
        log.info("Course Added Successfully");
        return mapStructMapper.courseToDto(save);
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> all = courseRepository.findAll();
        List<CourseDto> collect = all.stream().map(c -> mapStructMapper.courseToDto(c)).collect(Collectors.toList());
        log.info("Fetch all courses");
        return collect;
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto,Integer id) {
        Course course = courseRepository.findById(id).orElse(null);
        if(course!=null) {
            course = mapStructMapper.dtoToCourse(courseDto);
            course.setId(id);
            log.info(courseDto.toString());
            return mapStructMapper.courseToDto(courseRepository.save(course));
        }
        else{
            log.error("Course Not Found");
            throw new CourseNotFoundException("Course Not Found");
        }

    }

    @Override
    public void deleteCourse(Integer id) {
        log.info("Course successfully deleted");
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDto findCourseById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()){
            log.info(course.toString());
        return mapStructMapper.courseToDto(course.get());
        }
        else{
            throw new CourseNotFoundException("Course not found exception");
        }
    }
}
