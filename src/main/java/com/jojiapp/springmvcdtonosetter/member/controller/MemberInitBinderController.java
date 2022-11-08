package com.jojiapp.springmvcdtonosetter.member.controller;

import com.jojiapp.springmvcdtonosetter.member.dto.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member/init-binder")
public class MemberInitBinderController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.initDirectFieldAccess();
    }

    @GetMapping
    public MemberModelAttributeDTO get(MemberModelAttributeDTO dto) {

        return dto;
    }
}
