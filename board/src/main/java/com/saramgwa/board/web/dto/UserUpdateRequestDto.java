package com.saramgwa.board.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String password;
    @Builder
    public UserUpdateRequestDto(String password){
        this.password = password;
    }
}
