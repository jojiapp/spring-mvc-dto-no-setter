package com.jojiapp.springmvcdtonosetter.member.controller;

import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

//@ControllerAdvice
public class WebBinderControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.initDirectFieldAccess();
    }
}
