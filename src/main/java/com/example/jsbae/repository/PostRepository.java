package com.example.jsbae.repository;

import com.example.jsbae.domain.Post;

import java.util.List;

public interface PostRepository {
    // 게시글 작성
    int createPost(Post post);

    // 게시글 리스트
    List<Post> postList();

    // 게시글 상세 (댓글 포함)
    Post postInfo(Long id);

    // 게시글 수정
    int postUpdate(Post post);

    // 게시글 삭제
    int postDelete(Long idx);
}
