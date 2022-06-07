package com.swyg.petdiary.dto.postComments;

import lombok.Setter;

public interface PostComments {
    Long getCommentId();
    String getName();
    String getContent();
    String getCreateTime();
}
