package com.hibernate.manytomany.repository;

import com.hibernate.manytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    //Find Course Purchase By One Student

}
