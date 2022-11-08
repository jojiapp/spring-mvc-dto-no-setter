package com.jojiapp.springmvcdtonosetter.member.dto;

import lombok.*;


@AllArgsConstructor
@Getter
public class MemberRequestBodyDTO {

    private String name;
    private Integer age;
}
