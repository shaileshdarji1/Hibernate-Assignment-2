package com.hibernate.manytomany.controller;

import com.hibernate.manytomany.constants.Constant;
import com.hibernate.manytomany.dto.DepartmentDto;
import com.hibernate.manytomany.service.DepartmentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hibernate.manytomany.constants.Constant.*;

@RestController
@RequestMapping(DEPARTMENTS)
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping(PATH_DEPARTMENT_ID)
    public DepartmentDto getDepartment(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    @PostMapping
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }

    @PutMapping(UPDATE_DEPARTMENT)
    public DepartmentDto updateDepartment(@PathVariable Integer id,@RequestBody DepartmentDto departmentDto){
        return departmentService.updateDepartment(departmentDto,id);
    }

    @DeleteMapping(DELETE_DEPARTMENT)
    public String deleteDepartment(@PathVariable Integer id){
        try {
            departmentService.deleteDepartment(id);
            return "Department Delete Successfully";
        }
        catch (Exception e){
            return "Something went wrong";
        }
    }

}
