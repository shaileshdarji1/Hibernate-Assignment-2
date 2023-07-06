package com.hibernate.manytomany.exception;

import com.hibernate.manytomany.annotation.ValidateDepartment;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class DepartmentValidator implements ConstraintValidator<ValidateDepartment,String> {
    @Override
    public boolean isValid(String departmentName, ConstraintValidatorContext constraintValidatorContext) {
        List<String> departmentNames = Arrays.asList("Java","Python",".Net","React","ROR");

        return departmentNames.contains(departmentName);
    }
}
