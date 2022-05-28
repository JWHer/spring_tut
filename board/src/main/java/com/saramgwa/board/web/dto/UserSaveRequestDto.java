package com.saramgwa.board.web.dto;

import com.saramgwa.board.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String username;
    private String password;

    @Builder
    public UserSaveRequestDto(String username, String password){
        this.username=username;
        this.password=password;
    }

    public User toEntity(){
        return User.builder().username(username).password(password).build();
    }
}
