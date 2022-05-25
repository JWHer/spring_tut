package com.saramgwa.board.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeResponseDtoTest {
    @Test
    public void homeResponseTest() {
        String name = "Test";
        int amount = 1000;

        HomeResponseDto dto = new HomeResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
