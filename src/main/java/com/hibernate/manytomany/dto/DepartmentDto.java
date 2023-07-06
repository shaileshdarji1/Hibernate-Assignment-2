package com.hibernate.manytomany.dto;

import com.hibernate.manytomany.annotation.ValidateDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @ValidateDepartment
    String name;
}
