package com.codeswing.user.service;

import com.codeswing.user.VO.Department;
import com.codeswing.user.VO.ResponseTemplet;
import com.codeswing.user.entity.User;
import com.codeswing.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside userservice the usercontroller method" + user);
        return userRepository.save(user);

    }

    public ResponseTemplet getById(Long userId) {
       ResponseTemplet responseTemplet = new ResponseTemplet();
        User user = userRepository.findById(userId).get();

        Department department =
                restTemplate.getForObject(
                        "http://DEPARTMENT-SERVICE/v1/department/getbyid/" + user.getDepartmentId(),
                        Department.class);
        responseTemplet.setUser(user);
        responseTemplet.setDepartment(department);
        log.info("Inside the userservice of usercontrolller" + userId);
        return responseTemplet;
    }
}
