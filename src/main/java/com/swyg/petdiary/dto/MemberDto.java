package com.swyg.petdiary.dto;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String name;

    private List<LinkedHashMap<String, Object>> pets;
    private List<LinkedHashMap<String, Object>> posts;
    //private List<LinkedHashMap<String, Object>> comments;


    /*로그인 API*/
    public void setLoginInfo(String email, String name) {
        this.email = email;
        this.name = name;
    }
    public Map getLoginInfo() {
        Map<String,Object> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        return map;
    }

    /*회원 가입 API*/
    /*회원 조회 API ( my page )*/
    public void setViewMemberAPI(String email, String name, List<LinkedHashMap<String, Object>> pets, List<LinkedHashMap<String, Object>> posts) {
        this.email = email;
        this.name = name;
        this.pets = pets;
        this.posts = posts;
    }

    public Map getViewMemberAPI() {
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("pets", pets);
        map.put("posts", posts);
        return map;
    }

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
