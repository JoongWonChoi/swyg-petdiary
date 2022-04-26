package com.swyg.petdiary.service.post;

import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService{

    @Autowired private final PostRepository postRepository;

    @Override
    public Post findPost(Long id) throws Exception {
        return postRepository.findById(id).orElseThrow(()->new Exception("not exist post"));
    }
    /*게시물 조회 로직*/
    @Override
    public Post viewPost(Long id) throws Exception{
        return findPost(id);
    }

    @Override
    public Post createPost() {
        return null;
    }

    @Override
    public Post editPost() {
        return null;
    }

    @Override
    public List viewAllPosts() {
        return null;
    }
}
