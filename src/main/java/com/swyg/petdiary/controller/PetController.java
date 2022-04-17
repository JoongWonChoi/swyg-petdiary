package com.swyg.petdiary.controller;

import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Pet;
import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PetController {

    @Autowired private PetService petService;

    /*펫 생성*/
    @PostMapping("/pet/new")
    public Map joinPet(@RequestBody PetDto petDto, @AuthenticationPrincipal MemberAdapter memberAdapter) throws Exception{
        PetDto petAPI = new PetDto();
        Pet pet;
        try{
            pet = petService.register(petDto, memberAdapter.getMember().getId());
        }
        catch (Exception e){
            HashMap<String, Boolean> map = new HashMap();
            map.put("registerSuccess", false);
            return map;
        }
        petAPI.setRegisterPetAPI(pet.getPetName());
        return petAPI.getRegisterPetAPI();
    }

    /*펫 조회*/
    @GetMapping("/pet/{id}")
    public Map viewPet(@PathVariable("id")Long id) throws Exception{
        Pet pet;
        try{pet = petService.findById(id);}
        catch (Exception e){
            HashMap<String, Boolean> map = new HashMap();
            map.put("findSuccess", false);
            return map;
        }
        PetDto petApi = new PetDto();
        petApi.setViewPetAPI(pet.getId(), pet.getPetName(), pet.getType(), pet.getTypeDetail(), pet.getBirthDay(), pet.getSex());
        return petApi.getViewPetAPI();
    }

    /*펫 수정*/
    @PostMapping("/pet/edit")
    public Map editPet(@RequestBody PetDto petDto) throws  Exception{
        Pet pet;
        try{
            pet = petService.update(petDto);
        }
        catch(Exception e){
            HashMap<String, Boolean> map = new HashMap();
            map.put("editSuccess", false);
            return map;
        }
        PetDto petAPI = new PetDto();
        petAPI.setEditPetAPI(pet.getPetName(), pet.getType(), pet.getTypeDetail(), pet.getBirthDay(), pet.getSex());
        return petAPI.getEditPetAPI();
    }

    /*펫 삭제*/
}
