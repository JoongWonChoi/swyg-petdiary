package com.swyg.petdiary.service.reply;

import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.domain.Reply;
import com.swyg.petdiary.dto.CommentDto;
import com.swyg.petdiary.dto.ReplyDto;

public interface ReplyService {
    Reply findReply(Long replyId) throws Exception;
    Reply createReply(ReplyDto replyDto, Member member) throws Exception;
    Reply updateReply(ReplyDto replyDto) throws Exception;
    Boolean deleteReply(ReplyDto replyDto) throws Exception;
}
