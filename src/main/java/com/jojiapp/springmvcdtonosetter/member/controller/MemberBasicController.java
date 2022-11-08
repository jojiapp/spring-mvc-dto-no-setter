package com.jojiapp.springmvcdtonosetter.member.controller;

import com.jojiapp.springmvcdtonosetter.member.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basic/members")
public class MemberBasicController {

    @PostMapping
    public MemberRequestBodyDTO post(@RequestBody MemberRequestBodyDTO dto) {

        return dto;
    }

    @GetMapping
    public MemberModelAttributeDTO get(MemberModelAttributeDTO dto) {

        return dto;
    }


    @GetMapping("/all-args-constructor")
    public MemberModelAttributeAllArgsConstructorDTO allArgsConstructor(MemberModelAttributeAllArgsConstructorDTO dto) {

        return dto;
    }

}
