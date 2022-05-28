package com.saramgwa.board.web.dto;

import com.saramgwa.board.domain.user.User;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;

    public UserResponseDto(User entity){
        this.id=entity.getId();
        this.username=entity.getUsername();
        this.password=entity.getPassword();
    }
}
