package com.swyg.petdiary.service.pet;

import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;

public interface PetService {
    Pet findById(Long id) throws Exception; //조회
    Pet register(PetDto petDto, Long memberId) throws Exception; //생성
    Pet update(PetDto petDto) throws Exception; //수정
    boolean remove(Long petId) throws Exception; //삭제
}
