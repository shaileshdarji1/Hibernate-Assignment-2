package com.hibernate.manytomany.controller;

import com.hibernate.manytomany.dto.CourseDto;
import com.hibernate.manytomany.entity.Course;
import com.hibernate.manytomany.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> addCourse(@RequestBody @Valid CourseDto courseDto){
        return new ResponseEntity<>(courseService.addCourse(courseDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses(){

        return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") Integer courseId){
        return new ResponseEntity<>(courseService.findCourseById(courseId),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody @Valid CourseDto courseDto,@PathVariable Integer id){
        return new ResponseEntity<>(courseService.updateCourse(courseDto,id),HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Integer courseId){
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>("Course Delete successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Course not found",HttpStatus.NOT_FOUND);
        }
    }
}
