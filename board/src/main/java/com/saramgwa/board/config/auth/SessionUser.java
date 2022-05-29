package com.saramgwa.board.config.auth;

import java.io.Serializable;

import com.saramgwa.board.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{
    private Long id;
    private String name;
    
    public SessionUser(User user){
        this.id = user.getId();
        this.name = user.getUsername();
    }
}
