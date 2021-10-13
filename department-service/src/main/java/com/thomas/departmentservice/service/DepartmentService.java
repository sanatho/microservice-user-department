package com.thomas.departmentservice.service;

import com.thomas.departmentservice.entity.Department;
import com.thomas.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Saving department ");
        return departmentRepository.save(department);
    }

    public Department findById(Long id){
        log.info("Finding department");
        return departmentRepository.findDepartmentById(id);
    }
}
