package com.swyg.petdiary.controller;


import com.swyg.petdiary.dto.PetDto;
import com.swyg.petdiary.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/pet/new")
    public Object joinPet(@RequestBody PetDto petDto) {
        return null;
    }
    /*@PostMapping("/pet/edit")*/
}
