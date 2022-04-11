package com.swyg.petdiary.controller;


import com.swyg.petdiary.dto.MemberDto;
import com.swyg.petdiary.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class JoinController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/join")
    public Map join(@RequestBody MemberDto memberDto) throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        Long join = memberService.join(memberDto);
        try {
            memberService.findById(join);
        } catch (Exception e) {
            map.put("join_Success", false);
        }
        map.put("join_Success", true);
        return map;
    }
}