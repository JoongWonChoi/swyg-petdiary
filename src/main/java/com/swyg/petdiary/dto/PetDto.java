package com.swyg.petdiary.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PetDto {
    private Long id;
    private String petName; //펫 이름
    private String type; //펫 종류
    private String typeDetail; //펫 품종
    private String birthDay; //펫 생일
    private String sex; //펫 성별

    public void setRegisterPetAPI(String petName) {
        this.petName = petName;
    }
    public Map getRegisterPetAPI() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("registerSuccess", true);
        map.put("petName", petName);
        return map;


    }
}
