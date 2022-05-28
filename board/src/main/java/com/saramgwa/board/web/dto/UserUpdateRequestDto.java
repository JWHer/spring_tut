package com.saramgwa.board.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String password;
    private String role;
    @Builder
    public UserUpdateRequestDto(String password, String role){
        this.password = password;
        this.role = role;
    }
}
