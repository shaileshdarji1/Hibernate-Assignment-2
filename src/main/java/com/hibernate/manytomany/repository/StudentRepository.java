package com.hibernate.manytomany.repository;

import com.hibernate.manytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("SELECT s FROM Student s LEFT JOIN s.department d WHERE d.name=?1")
    public List<Student> findStudentByDepartment(String name);

    @Query("SELECT s FROM Student s LEFT JOIN s.courses c WHERE c.title=?1")
    public List<Student> findStudentByCourseName(String courseName);

    @Query("SELECT s FROM Student s WHERE s.name LIKE '?1%'")
    public List<Student> findStudentByCharacter(String character);
}
