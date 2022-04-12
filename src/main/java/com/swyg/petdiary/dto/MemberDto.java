package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class MemberDto {
    private String email;
    private String password;
    private String name;

    public void setLoginInfo(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Map getLoginInfo() {
        Map<String,Object> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("login_success", true);
        return map;
    }

}
