package com.swyg.petdiary.controller;


import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.MemberDto;
import com.swyg.petdiary.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired private final MemberService memberService;

    /*==회원 상세보기(마이페이지)==*/
    @GetMapping("/mypage")
    public Object member(@AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception{
        Member member = memberService.findById(memberAdapter.getMember().getId());
        return member;
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
