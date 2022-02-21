package com.example.jsbae.repository;

import com.example.jsbae.domain.Board;

import java.util.List;

public interface BoardRepository {
    // 게시판 등록
    int createBoard(Board board);

    // 게시판 리스트
    List<Board> boardList();

    // 게시판 상세
    Board boardInfo(Long id);

    // 게시판 수정
    int boardUpdate(Board board);

    // 게시판 삭제
    int boardDelete(long id);
}
