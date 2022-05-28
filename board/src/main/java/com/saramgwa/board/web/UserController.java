package com.saramgwa.board.web;

import java.util.List;

import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.domain.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll(); 
    }

    // @RequestMapping("/user")
    // public User user(Long id) {
    //     return userRepository.findOne(id);
    // }
}
