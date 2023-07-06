package com.hibernate.manytomany.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Entity
@Table(name = "STUDENT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id",referencedColumnName = "id")
    Department department;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_tbl",
            joinColumns = {
                    @JoinColumn(name = "s_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "c_id", referencedColumnName = "id")
            }
    )
    private List<Course> courses;
}
