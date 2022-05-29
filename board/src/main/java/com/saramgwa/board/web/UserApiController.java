package com.saramgwa.board.web;

import java.util.List;

import com.saramgwa.board.config.auth.LoginUser;
import com.saramgwa.board.config.auth.SessionUser;
import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.service.UserService;
import com.saramgwa.board.web.dto.User.UserCreateRequestDto;
import com.saramgwa.board.web.dto.User.UserResponseDto;
import com.saramgwa.board.web.dto.User.UserUpdateRequestDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserApiController {
    // private static final String API_VERSION_STRING = "/api/v1";
    private final UserService userService;

    @GetMapping("/users")
    public List<User> readAll() {
        return userService.readAll(); 
    }

    @GetMapping("/users/{id}")
    public UserResponseDto read(@PathVariable Long id) {
        return userService.read(id);
    }

    @GetMapping("/users/me")
    public UserResponseDto readMe(@LoginUser SessionUser sessionUser){
        return userService.read(sessionUser.getId());
    }

    @PostMapping("/users")
    public UserResponseDto create(@RequestBody UserCreateRequestDto requestDto){
        return userService.create(requestDto);
    }

    @PutMapping("/users/{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(id, requestDto);
    }

    @DeleteMapping("/users/{id}")
    public UserResponseDto delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
