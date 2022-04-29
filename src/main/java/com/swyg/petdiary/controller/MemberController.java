package com.swyg.petdiary.controller;

import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.MemberDto;
import com.swyg.petdiary.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired private final MemberService memberService;

    /*==회원 상세보기(마이페이지)==*/
    @GetMapping("/mypage")
    public Map member(@AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception{
        Member member;
        try{
            member = memberService.findById(memberAdapter.getMember().getId());
        }
        catch(Exception e){
            HashMap<String, Boolean> map = new HashMap();
            map.put("existsMember", false);
            return map;
        }
        /*pet info*/
        ArrayList<LinkedHashMap<String, Object>> pets = new ArrayList<>();
        for(int i=0; i<member.getPets().size();i++){
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("id",member.getPets().get(i).getId());
            map.put("petName",member.getPets().get(i).getPetName());
            map.put("typeDetail",member.getPets().get(i).getTypeDetail());
            pets.add(map);
        }
        /*post info*/
        ArrayList<LinkedHashMap<String, Object>> posts = new ArrayList<>();
        for(int i=0; i<member.getPosts().size();i++){
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("id",member.getPosts().get(i).getId());
            map.put("title",member.getPosts().get(i).getTitle());
            map.put("uploadTime", member.getPosts().get(i).getUploadTime());
            posts.add(map);
        }

        MemberDto memberDto = new MemberDto();
        memberDto.setViewMemberAPI(member.getEmail(), member.getName(), pets, posts);
        return memberDto.getViewMemberAPI();
    }
    /*회원 수정*/
    @PostMapping("/member/edit")
    public Map editMember(@RequestBody MemberDto memberDto) throws Exception{
        Member member;
        try{
            member = memberService.update(memberDto);
        }
        catch(Exception e){
            HashMap<String, Boolean> map = new HashMap();
            map.put("editSuccess", false);
            return map;
        }
        MemberDto memberAPI = new MemberDto();
        memberAPI.setEditMemberAPI(member.getName());
        return memberAPI.getEditMemberAPI();
    }
}
