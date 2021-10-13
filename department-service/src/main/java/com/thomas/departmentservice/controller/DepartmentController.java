package com.thomas.departmentservice.controller;

import com.thomas.departmentservice.entity.Department;
import com.thomas.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Saving department {}", department.toString());
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id){
        log.info("Searching for department {}", id);
        return departmentService.findById(id);
    }
}
