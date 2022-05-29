package com.saramgwa.board.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER", "plain user"),
    ADMIN("ROLE_ADMIN", "administrator");

    private final String key;
    private final String desc;
}
