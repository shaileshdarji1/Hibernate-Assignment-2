package com.hibernate.manytomany.service.impl;

import com.hibernate.manytomany.dto.DepartmentDto;
import com.hibernate.manytomany.entity.Department;
import com.hibernate.manytomany.mapstruct.MapStructMapper;
import com.hibernate.manytomany.repository.DepartmentRepository;
import com.hibernate.manytomany.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapStructMapper.dtoToDepartment(departmentDto);
        return mapStructMapper.departmentToDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto getDepartment(Integer id) {
        return mapStructMapper.departmentToDto(departmentRepository.findById(id).get());
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> collect = departments.stream().map(d -> mapStructMapper.departmentToDto(d)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Integer id) {
        Department department = mapStructMapper.dtoToDepartment(departmentDto);
        department.setId(id);
        return mapStructMapper.departmentToDto(departmentRepository.save(department));
    }
}
