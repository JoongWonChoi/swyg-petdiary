package com.swyg.petdiary.service.post;

import com.swyg.petdiary.domain.Post;

import java.util.List;

public interface PostService {

    Post findPost(Long id) throws Exception;
    Post viewPost(Long id)throws Exception;
    Post createPost();
    Post editPost();
    List viewAllPosts();

}
