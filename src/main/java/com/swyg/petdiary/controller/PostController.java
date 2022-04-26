package com.swyg.petdiary.controller;


import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.dto.PostDto;
import com.swyg.petdiary.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

    @Autowired private final PostService postService;

    /* 서비스 내의 모든 게시물 보기 */
    @GetMapping("/posts")
    public Map viewAllPosts(){
        return null;
    }

    /* 게시물 상세보기 */
    @GetMapping("/post/{id}")
    public Map viewPost(@PathVariable("id")Long id){
        Post post;
        try{
            post = postService.viewPost(id);
        }
        catch(Exception e){
            Map map = new HashMap();
            map.put("findSuccess", false);
            return map;
        }
        PostDto postDto = new PostDto();
        postDto.setViewPostAPI(post.getId(), post.getTitle(), post.getBody(), post.getUploadTime(), post.getMember(), post.getBoard());
        return postDto.getViewPostAPI();


    }

    /* 게시물 작성 */
    @PostMapping("/post/new")

    /* 게시물 수정 */
    @PostMapping("/post/edit")


}
