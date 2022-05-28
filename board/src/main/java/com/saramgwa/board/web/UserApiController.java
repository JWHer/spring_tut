package com.saramgwa.board.web;

import java.util.List;

import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.service.user.UserService;
import com.saramgwa.board.web.dto.UserResponseDto;
import com.saramgwa.board.web.dto.UserSaveRequestDto;
import com.saramgwa.board.web.dto.UserUpdateRequestDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private static final String API_VERSION_STRING = "/api/v1";
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public List<User> userList() {
        return userService.getAll(); 
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto user(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("/api/v1/user")
    public UserResponseDto save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PutMapping(API_VERSION_STRING+"/user/{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(id, requestDto);
    }

    @DeleteMapping(API_VERSION_STRING+"/user/{id}")
    public UserResponseDto delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
