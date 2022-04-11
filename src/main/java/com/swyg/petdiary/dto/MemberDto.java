package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberDto {
    private String email;
    private String password;
    private String name;

}
