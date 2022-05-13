package com.swyg.petdiary.controller;

import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RestController
public class LoginController {

    @GetMapping("/loginSuccess")
    public Map loginSuccess(@AuthenticationPrincipal MemberAdapter memberAdapter) {
        MemberDto memberDto = new MemberDto();
        memberDto.setLoginInfo(memberAdapter.getMember().getEmail(), memberAdapter.getMember().getName());
        return memberDto.getLoginInfo();
    }
}
