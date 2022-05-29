package com.saramgwa.board.web.dto.User;

import com.saramgwa.board.domain.user.Role;
import com.saramgwa.board.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    private String username;
    private String password;
    // private Role role=Role.USER;

    @Builder
    public UserCreateRequestDto(String username, String password){
        this.username=username;
        this.password=password;
    }

    public User toEntity(){
        return User.builder().username(username).password(password).role(Role.USER).build();
    }
}
