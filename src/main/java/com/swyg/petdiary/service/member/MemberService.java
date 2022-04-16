package com.swyg.petdiary.service.member;

import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.MemberDto;

public interface MemberService {
    Long join(MemberDto memberDto) throws Exception;
    Member findById(Long id) throws Exception;
}
