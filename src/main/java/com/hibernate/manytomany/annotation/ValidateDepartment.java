package com.hibernate.manytomany.annotation;

import com.hibernate.manytomany.exception.DepartmentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartmentValidator.class)
public @interface ValidateDepartment {

    public String message() default "Invalid Department";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
