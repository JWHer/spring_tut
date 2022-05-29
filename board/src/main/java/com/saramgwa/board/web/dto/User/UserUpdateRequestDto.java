package com.saramgwa.board.web.dto.User;

import com.saramgwa.board.domain.user.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String password;
    private Role role;
    
    @Builder
    public UserUpdateRequestDto(String password, Role role){
        this.password = password;
        this.role = role;
    }
}
