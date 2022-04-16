package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Long id;
    private String content; // 댓글 내용
    private String createTime; // 댓글 작성 일자 및 시간
}
