package com.swyg.petdiary.service.member;

import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.MemberDto;

public interface MemberService {
    Member findById(Long id) throws Exception;
    Long join(MemberDto memberDto) throws Exception;
    Member update(MemberDto memberDto)throws Exception;
    boolean delete(Long memberId) throws Exception;
}
