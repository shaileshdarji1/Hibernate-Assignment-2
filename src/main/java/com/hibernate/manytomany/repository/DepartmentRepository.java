package com.hibernate.manytomany.repository;

import com.hibernate.manytomany.entity.Department;
import com.hibernate.manytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("SELECT d FROM Department d LEFT JOIN d.studentList s WHERE s.studentName=?1")
    public Department findDepartmentByStudentName(String name);
}
