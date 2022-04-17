package com.swyg.petdiary.service.member;

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
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*회원 Id값으로 찾기*/
    @Override
    public Member findById(Long id) throws Exception {
        return memberRepository.findById(id).orElseThrow(() -> new Exception("not exist member"));
    }
    /*회원가입*/
    @Override
    @Transactional
    public Long join(MemberDto memberDto) throws Exception{
        Member member = new Member();
        validateDuplicateEmail(memberDto.getEmail());
        member.createMember(memberDto.getEmail(), bCryptPasswordEncoder.encode(memberDto.getPassword()), memberDto.getName());
        Member joinedMember = memberRepository.save(member);
        return joinedMember.getId();
    }
    /*회원 수정*/
    @Override
    @Transactional
    public Member update(MemberDto memberDto) throws Exception {
        Member member = memberRepository.findById(memberDto.getId()).orElseThrow(() -> new Exception("not exist member"));
        member.updateMember(bCryptPasswordEncoder.encode(memberDto.getPassword()), memberDto.getName());
        return member;
    }
    /*회원 삭제(탈퇴)*/
    @Override
    public boolean delete(Long memberId) throws Exception {
        return false;
    }

    private void validateDuplicateEmail(String email) throws Exception{ //이메일 중복확인
        Optional<Member> member = memberRepository.findByEmail(email);
        if (!member.isEmpty()) {
            throw new Exception("already exists member");
        }
    }
}
