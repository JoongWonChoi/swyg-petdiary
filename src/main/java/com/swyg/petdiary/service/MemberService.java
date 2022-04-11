package com.swyg.petdiary.service;

import com.swyg.petdiary.dto.MemberDto;

public interface MemberService {
    Long join(MemberDto memberDto) throws Exception;
    String findById(Long id) throws Exception;
}
