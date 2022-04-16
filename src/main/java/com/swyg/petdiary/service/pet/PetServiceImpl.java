package com.swyg.petdiary.service.pet;

import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetServiceImpl implements PetService{

    @Autowired private PetRepository petRepository;

    /*펫 등록*/
    @Override
    public Long register(PetDto petDto) { //펫 등록은 딱히 거부되는 에러가 없음  
        Pet pet = new Pet();
        pet.registerPet(petDto.getName(), petDto.getType(), petDto.getBirthDay(), petDto.getSex());
        petRepository.save(pet);
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }
}
