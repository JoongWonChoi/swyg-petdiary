package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String name;

    /*로그인 API*/
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

    /*회원 가입 API*/
    /*회원 조회 API*/
    /*public void setViewMemberAPI(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Map getViewMemberAPI() {
        Map<String,Object> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("login_success", true);
        return map;
    }*/

    /*회원 수정 API*/
    public void setEditMemberAPI(String name) {
        this.name = name;
    }
    public Map getEditMemberAPI() {
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("editSuccess", true);
        map.put("name", name);
        return map;
    }
}
