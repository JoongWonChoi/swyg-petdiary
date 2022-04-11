package com.swyg.petdiary.service;

import java.util.*;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.dto.MemberDto;
import com.swyg.petdiary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{
    @Autowired private MemberRepository memberRepository;
    //@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*회원 Id값으로 찾기*/
    @Override
    public String findById(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()) {
            throw new Exception("not exists Member");
        }
        else{
            return member.get().getEmail();
        }
    }

    /*회원가입*/
    @Override
    public Long join(MemberDto memberDto) throws Exception{
        Member member = new Member();
        validateDuplicateEmail(memberDto.getEmail());
        member.createMember(memberDto.getEmail(), memberDto.getPassword(), memberDto.getName());
        Member joinedMember = memberRepository.save(member);
        return joinedMember.getId();
    }
    private void validateDuplicateEmail(String email) throws Exception{ //이메일 중복확인
        Optional<Member> member = memberRepository.findByEmail(email);
        if (!member.isEmpty()) {
            throw new Exception("already exists member");
        }
    }
}
