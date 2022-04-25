package com.swyg.petdiary.controller;


import com.swyg.petdiary.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    /* 서비스 내의 모든 게시물 보기 */
    @GetMapping("/posts")
    public Map viewAllPosts() {


    }
    /* 게시물 상세조회 */
    @GetMapping("/post/{id}")

    /* 게시물 작성 */
    @PostMapping("/post/new")

    /* 게시물 수정 */
    @PostMapping("/post/edit")


}
