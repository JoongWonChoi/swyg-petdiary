package com.swyg.petdiary.service.pet;

import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;

public interface PetService {
    Pet register(PetDto petDtom, Long memberId);
    Pet findById(Long id);
}
