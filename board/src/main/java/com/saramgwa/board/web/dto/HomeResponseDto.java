package com.saramgwa.board.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HomeResponseDto {
    private final String name;
    private final int amount;
}
