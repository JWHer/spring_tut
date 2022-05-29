package com.saramgwa.board.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHealth() throws Exception {
        String health = "ok";
        mvc.perform(get("/api/v1/health"))
            .andExpect(status().isOk())
            .andExpect(content().string(health));
    }
}
