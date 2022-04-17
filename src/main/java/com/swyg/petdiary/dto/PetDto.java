package com.swyg.petdiary.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
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


    /*펫 등록API*/
    public void setRegisterPetAPI(String petName) {
        this.petName = petName;
    }
    public Map getRegisterPetAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("registerSuccess", true);
        map.put("petName", petName);
        return map;
    }

    /*펫 조회API*/
    public void setViewPetAPI(Long id, String petName, String type, String typeDetail, String birthDay, String sex) {
        this.id = id;
        this.petName = petName;
        this.type = type;
        this.typeDetail = typeDetail;
        this.birthDay = birthDay;
        this.sex = sex;
    }
    public Map getViewPetAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("findSuccess", true);
        map.put("petName", petName);
        map.put("type", type);
        map.put("typeDetail", typeDetail);
        map.put("birthDay", birthDay);
        map.put("sex", sex);
        return map;
    }
    /*펫 수정API*/
    public void setEditPetAPI(String petName, String type, String typeDetail, String birthDay, String sex) {
        this.petName = petName;
        this.type = type;
        this.typeDetail = typeDetail;
        this.birthDay = birthDay;
        this.sex = sex;
    }
    public Map getEditPetAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("editSuccess", true);
        map.put("petName", petName);
        map.put("type", type);
        map.put("typeDetail", typeDetail);
        map.put("birthDay", birthDay);
        map.put("sex", sex);
        return map;
    }
    /*펫 삭제 API*/
}
