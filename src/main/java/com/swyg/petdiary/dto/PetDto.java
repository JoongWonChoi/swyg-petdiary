package com.swyg.petdiary.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDto {
    private String name; //펫 이름
    private String type; //펫 종류
    private String birthDay; //펫 생일
    private String sex; //펫 성별
}
