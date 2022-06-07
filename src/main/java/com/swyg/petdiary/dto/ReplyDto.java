package com.swyg.petdiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {

    private Long id;
    private Long replyId;
    private Long commentId;
    private String content;
    private String createDate;
}
