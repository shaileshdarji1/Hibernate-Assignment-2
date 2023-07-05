package com.hibernate.manytomany.service;

import com.hibernate.manytomany.dto.DepartmentDto;
import com.hibernate.manytomany.entity.Department;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartment(Integer id);

    public List<DepartmentDto> getDepartments();


}
