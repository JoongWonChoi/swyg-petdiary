package com.swyg.petdiary.service.post;

import com.swyg.petdiary.domain.Board;
import com.swyg.petdiary.domain.Member;
import com.swyg.petdiary.domain.Post;
import com.swyg.petdiary.dto.PostDto;
import com.swyg.petdiary.dto.viewAllPosts.ViewAllPostInterface;
import com.swyg.petdiary.repository.PostRepository;
import com.swyg.petdiary.service.board.BoardService;
import com.swyg.petdiary.service.member.MemberService;
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
    @Autowired private final MemberService memberService;
    @Autowired private final BoardService boardService;

    @Override
    public Post findPost(Long id) throws Exception {
        return postRepository.findById(id).orElseThrow(()->new Exception("not exist post"));
    }
    /*게시물 조회 로직*/
    @Override
    public Post viewPost(Long id) throws Exception{
        return findPost(id);
    }
    /*게시물 작성 로직*/
    @Transactional
    @Override
    public Post createPost(PostDto postDto, Long memberId) throws Exception {
        Member member = memberService.findById(memberId);
        Board board = boardService.findById(postDto.getBoardId());
        Post post = new Post();
        post.createPost(postDto.getTitle(), postDto.getBody(), board, member);
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post editPost(PostDto postDto) throws Exception {
        Post post = findPost(postDto.getPostId());
        post.updatePost(postDto.getTitle(), postDto.getBody());
        return post;
    }

    @Override
    @Transactional
    public boolean deletePost(PostDto postDto) throws Exception {
        Post post = findPost(postDto.getPostId());
        postRepository.delete(post);
        return true;
    }

    @Override
    public List viewAllPosts() { //제목, 내용, 작성일자, 댓글 수
        List<ViewAllPostInterface> posts = postRepository.findAllPosts();
        return posts;
    }

    @Override
    public List viewBoardPosts(Long boardId) throws Exception{
        Board board = boardService.findById(boardId);
        List<ViewAllPostInterface> boardPosts = postRepository.findByBoard(boardId);
        System.out.println(boardPosts.size());
        return boardPosts;
    }
}
