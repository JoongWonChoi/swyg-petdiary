package com.swyg.petdiary.service.post;

import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.dto.PostDto;

import java.util.List;

public interface PostService {

    Post findPost(Long id) throws Exception;
    Post viewPost(Long id) throws Exception;
    Post createPost(PostDto postDto, Long memberId) throws Exception;
    Post editPost();
    List viewAllPosts();

}
