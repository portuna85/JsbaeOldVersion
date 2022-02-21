package com.example.jsbae.repository;

import com.example.jsbae.domain.Post;
import com.example.jsbae.domain.Reply;

import java.util.List;

public interface ReplyRepository {
    // 댓글 작성
    int createReply(Reply reply);

    // 댓글 찻기
    Reply replySearch(Long id);


    List<Reply> replyListByPostId(Long postIdx);

    // 댓글 리스트
    List<Reply> replyList(Long id);

    // 댓글 수정
    int updateReply(Reply reply);

    // 댓글 삭제
    int deleteReply(Long id);
}
