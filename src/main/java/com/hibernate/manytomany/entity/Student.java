package com.hibernate.manytomany.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "STUDENT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private Integer age;
    String department;


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
