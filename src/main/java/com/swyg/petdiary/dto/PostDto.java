package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title; //제목
    private String body; //내용
    private String uploadTime; //작성일자 및 시간
}
