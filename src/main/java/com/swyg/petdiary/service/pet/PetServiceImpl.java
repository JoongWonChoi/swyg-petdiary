package com.swyg.petdiary.service.pet;

import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.repository.MemberRepository;
import com.swyg.petdiary.repository.PetRepository;
import com.swyg.petdiary.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetServiceImpl implements PetService{

    @Autowired private PetRepository petRepository;
    @Autowired private MemberRepository memberRepository;

    /*펫 등록*/
    @Transactional
    @Override
    public Pet register(PetDto petDto, Long memberId) { //펫 등록은 딱히 거부되는 에러가 없음
        Pet pet = new Pet();
        Optional<Member> member = memberRepository.findById(memberId);
        pet.registerPet(petDto.getPetName(), petDto.getType(), petDto.getTypeDetail(), petDto.getBirthDay(), petDto.getSex(), member.get());
        return petRepository.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }
}
