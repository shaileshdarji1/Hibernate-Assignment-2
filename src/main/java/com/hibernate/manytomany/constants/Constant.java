package com.hibernate.manytomany.constants;

public class Constant {

    public static final String STUDENTS = "/api/v1/students";
    public static final String STUDENT_ID = "id";
    public static final String PATH_STUDENT_ID = "/{" + STUDENT_ID + "}";
    public static final String UPDATE_STUDENT = "/update/{" + STUDENT_ID + "}";
    public static final String DELETE_STUDENT = "/delete/{" + STUDENT_ID + "}";
    public static final String SPRING = "spring";

    public static final String COURSES = "api/v1/courses";
    public static final String COURSE_ID = "id";
    public static final String PATH_COURSE_ID = "/{"+COURSE_ID+"}";
    public static final String UPDATE_COURSE = "/update/{" + COURSE_ID + "}";
    public static final String DELETE_COURSE = "/delete/{" + COURSE_ID + "}";

    public static final String DEPARTMENTS = "api/v1/departments";
    public static final String DEPARTMENT_ID = "id";
    public static final String PATH_DEPARTMENT_ID = "/{" + DEPARTMENT_ID + "}";
    public static final String UPDATE_DEPARTMENT = "/update/{" + DEPARTMENT_ID + "}";
    public static final String DELETE_DEPARTMENT = "/delete/{" + DEPARTMENT_ID + "}";

    private Constant() {

    }
}
