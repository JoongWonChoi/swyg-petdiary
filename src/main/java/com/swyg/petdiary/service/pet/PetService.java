package com.swyg.petdiary.service.pet;

import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;

public interface PetService {
    Long register(PetDto petDto);
    Pet findById(Long id);
}
