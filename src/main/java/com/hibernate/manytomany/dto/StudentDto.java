package com.hibernate.manytomany.dto;

import com.hibernate.manytomany.annotation.ValidateDepartment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotNull(message = "student name should't be null")
    private String studentName;

    @Min(5)
    @Max(100)
    private Integer age;

    List<CourseDto> courses;

    @NotNull
    @Valid
    DepartmentDto department;
}
