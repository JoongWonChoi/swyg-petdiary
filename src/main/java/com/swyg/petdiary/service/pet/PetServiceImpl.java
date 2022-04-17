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
    @Autowired private MemberService memberService;

    /*펫 조회*/
    //객체 존재 시 -> 객체 반환
    //객체 존재 x -> 에러 반환 (Optional 문법 :: orElseThrow()
    @Override
    public Pet findById(Long id) throws Exception{
        return petRepository.findById(id).orElseThrow(()->new Exception("not exists Pet"));
    }

    /*펫 등록*/
    @Transactional
    @Override
    public Pet register(PetDto petDto, Long memberId) throws Exception{ //펫 등록은 딱히 거부되는 에러가 없음
        Pet pet = new Pet();
        Member member =  memberService.findById(memberId);
        pet.registerPet(petDto.getPetName(), petDto.getType(), petDto.getTypeDetail(), petDto.getBirthDay(), petDto.getSex(), member);
        return petRepository.save(pet);
    }
    /*펫 수정*/
    @Override
    @Transactional
    public Pet update(PetDto petDto) throws Exception {
        Pet pet = findById(petDto.getId());
        pet.updatePet(petDto.getPetName(), petDto.getType(), petDto.getTypeDetail(), petDto.getBirthDay(), petDto.getSex());
        return pet;
    }

    /*펫 삭제*/
    @Override
    public boolean remove(Long petId) throws Exception {
        return false;
    }
}
