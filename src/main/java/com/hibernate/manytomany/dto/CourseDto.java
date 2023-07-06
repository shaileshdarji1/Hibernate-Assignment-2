package com.hibernate.manytomany.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    @NotNull(message = "title must be not null")
    private String title;
    @NotNull(message = "abbreviation must be not null" )
    private String abbreviation;
    @NotBlank(message = "modules not blank")
    private int modules;
    @NotBlank(message = "fee not blank")
    private double fee;
}
