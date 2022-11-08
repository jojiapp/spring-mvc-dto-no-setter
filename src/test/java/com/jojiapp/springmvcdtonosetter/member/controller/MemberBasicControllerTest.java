package com.jojiapp.springmvcdtonosetter.member.controller;

import com.fasterxml.jackson.databind.*;
import com.jojiapp.springmvcdtonosetter.member.dto.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MemberBasicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("@RequestBody의 경우 Setter가 없어도 값이 주입된다.")
    void test1() throws Exception {

        // Given
        final MemberRequestBodyDTO bodyDTO = new MemberRequestBodyDTO("이름", 26);

        // When & Then
        final String content = objectMapper.writeValueAsString(bodyDTO);
        mockMvc.perform(post("/api/basic/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(content().json(content));
    }

    @Test
    @DisplayName("@ModelAttribute 경우 Setter가 없으면 값이 주입안된다")
    void test2() throws Exception {

        // When & Then
        mockMvc.perform(get("/api/basic/members")
                        .param("name", "이름")
                        .param("age", "26"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").doesNotExist())
                .andExpect(jsonPath("$.age").doesNotExist());
    }

    @Test
    @DisplayName("@ModelAttribute 경우 모든 필드를 포함하는 생성자가 있으면 값이 주입된다.")
    void test3() throws Exception {

        // When & Then
        mockMvc.perform(get("/api/basic/members/all-args-constructor")
                        .param("name", "이름")
                        .param("age", "26"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("이름"))
                .andExpect(jsonPath("$.age").value(26));
    }
}
