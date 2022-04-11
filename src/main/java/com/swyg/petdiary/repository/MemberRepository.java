package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Member;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);


}
