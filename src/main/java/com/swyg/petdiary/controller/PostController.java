package com.swyg.petdiary.controller;


import com.swyg.petdiary.config.auth.MemberAdapter;
import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.domain.Reply;
import com.swyg.petdiary.dto.PostDto;
import com.swyg.petdiary.dto.ReplyDto;
import com.swyg.petdiary.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
        postDto.setViewPostAPI(post.getId(), post.getTitle(), post.getBody(), post.getUploadTime(), post.getMember().getName(), post.getBoard().getBoardName());
        return postDto.getViewPostAPI();
    }

    /* 게시물 작성 */
    @PostMapping("/post/new")
    public Map creatBoard(@RequestBody PostDto postDto, @AuthenticationPrincipal MemberAdapter memberAdapter) {
        Post post;
        try{
            post = postService.createPost(postDto, memberAdapter.getMember().getId());
        }
        catch(Exception e){
            Map map = new HashMap();
            map.put("createSuccess", false);
            return map;
        }
        PostDto postDtoAPI = new PostDto();
        postDtoAPI.setCreatePostAPI(post.getId(), post.getTitle(), post.getMember().getName());
        return postDtoAPI.getCreatePostAPI();

    }

    /*게시물 수정*/
    @PostMapping("/post/edit")
    public Map updatePost(@RequestBody PostDto postDto) {
        Post post;
        Map<String, Object> map = new HashMap<>();
        try {
            post = postService.editPost(postDto);
        } catch (Exception e) {
            map.put("updateSuccess", false);
            return map;
        }
        map.put("updateSuccess", true);
        return map;
    }

    /*게시물 삭제*/
    @PostMapping("/post/delete")
    public Map deletePost(@RequestBody PostDto postDto) {
        boolean b;
        Map<String, Object> map = new HashMap<>();
        try {
            b = postService.deletePost(postDto);
        } catch (Exception e) {
            map.put("deleteSuccess", false);
            return map;
        }
        map.put("deleteSuccess", true);
        return map;
    }


}
