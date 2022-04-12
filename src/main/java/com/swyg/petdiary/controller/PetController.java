package com.swyg.petdiary.controller;


import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/pet/new")
    public Object joinPet(@RequestBody PetDto petDto) {
        Map<String, Object> map = new HashMap<>();
        Long registerId = petService.register(petDto);
        map.put("register_success",true);
        map.put("petName", petService.findById(registerId).getName());
        return map;
    }
    /*@PostMapping("/pet/edit")*/
}
