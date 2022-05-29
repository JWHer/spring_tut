package com.saramgwa.board.web.dto.User;

import com.saramgwa.board.domain.user.Role;
import com.saramgwa.board.domain.user.User;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private Role role;

    public UserResponseDto(User entity){
        this.id=entity.getId();
        this.username=entity.getUsername();
        this.password=entity.getPassword();
        this.role=entity.getRole();
    }
}
