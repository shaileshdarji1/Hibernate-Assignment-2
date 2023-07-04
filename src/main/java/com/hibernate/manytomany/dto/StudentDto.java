package com.hibernate.manytomany.dto;

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

    @NotNull
    String department;

    @NotNull
    @Size(min = 1)
    List<CourseDto> courseDtos;
}
