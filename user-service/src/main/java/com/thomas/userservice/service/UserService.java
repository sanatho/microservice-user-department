package com.thomas.userservice.service;

import com.thomas.userservice.VO.Department;
import com.thomas.userservice.VO.RespondeTemplateVo;
import com.thomas.userservice.entity.User;
import com.thomas.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside service saving user {}", user.toString());
        return userRepository.save(user);
    }

    public RespondeTemplateVo getUserWithDepartment(Long id) {
        log.info("Inside service for searching department");
        RespondeTemplateVo respondeTemplate = new RespondeTemplateVo();
        User user = userRepository.findById(id).get();

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getId(), Department.class);

        respondeTemplate.setUser(user);
        respondeTemplate.setDepartment(department);

        return respondeTemplate;
    }
}
