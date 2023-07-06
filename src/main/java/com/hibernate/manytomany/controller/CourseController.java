package com.hibernate.manytomany.controller;

import com.hibernate.manytomany.constants.Constant;
import com.hibernate.manytomany.dto.CourseDto;
import com.hibernate.manytomany.entity.Course;
import com.hibernate.manytomany.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.hibernate.manytomany.constants.Constant.*;
import java.util.List;

@RestController
@RequestMapping(COURSES)
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

    @GetMapping(PATH_COURSE_ID)
    public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") Integer courseId){
        return new ResponseEntity<>(courseService.findCourseById(courseId),HttpStatus.OK);
    }

    @PutMapping(UPDATE_COURSE)
    public ResponseEntity<CourseDto> updateCourse(@RequestBody @Valid CourseDto courseDto,@PathVariable Integer id){
        return new ResponseEntity<>(courseService.updateCourse(courseDto,id),HttpStatus.OK) ;
    }

    @DeleteMapping(DELETE_COURSE)
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id){
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>("Course Delete successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Course not found",HttpStatus.NOT_FOUND);
        }
    }
}
