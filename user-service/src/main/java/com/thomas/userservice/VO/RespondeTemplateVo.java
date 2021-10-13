package com.thomas.userservice.VO;

import com.thomas.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RespondeTemplateVo {
    private User user;
    private Department department;
}
