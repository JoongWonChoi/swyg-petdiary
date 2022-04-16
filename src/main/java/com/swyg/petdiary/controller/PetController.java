package com.swyg.petdiary.controller;


import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PetController {

    @Autowired private PetService petService;

    @PostMapping("/pet/new")
    public Map joinPet(@RequestBody PetDto petDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        PetDto registerPet = new PetDto();
        registerPet.setRegisterPetAPI(petService.register(petDto, memberAdapter.getMember().getId()).getPetName());
        return registerPet.getRegisterPetAPI();
    }
    /*@PostMapping("/pet/edit")*/
}
