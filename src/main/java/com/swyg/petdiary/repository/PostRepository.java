package com.swyg.petdiary.repository;

import com.swyg.petdiary.domain.Comment;
import com.swyg.petdiary.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
