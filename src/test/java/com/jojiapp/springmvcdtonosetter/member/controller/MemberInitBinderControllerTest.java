package com.jojiapp.springmvcdtonosetter.member.controller;

import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.web.servlet.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MemberInitBinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("@ModelAttribute 경우 Setter가 없으면 값이 주입안된다")
    void test2() throws Exception {

        // When & Then
        mockMvc.perform(get("/api/member/init-binder")
                        .param("name", "이름")
                        .param("age", "26"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("이름"))
                .andExpect(jsonPath("$.age").value(26));
    }

}
