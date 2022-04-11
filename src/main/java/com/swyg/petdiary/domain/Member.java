package com.swyg.petdiary.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member { //회원 객체 (회원 테이블 매핑)
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;

    /*회원 객체 생성 (회원가입)*/
    public void createMember(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = "ROLE_USER";
    }





}
