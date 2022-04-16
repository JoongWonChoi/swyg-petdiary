package com.swyg.petdiary.controller;


import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired private final MemberService memberService;

    /*==회원 상세보기(마이페이지)==*/
    @GetMapping("/mypage")
    public Object member(@AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception{
        String byId = memberService.findById(memberAdapter.getMember().getId());
        return byId;

    }
}
