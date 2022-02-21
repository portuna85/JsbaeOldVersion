package com.example.jsbae.repository;

import com.example.jsbae.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcBoardRepository implements BoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int createBoard(Board board) {
        return jdbcTemplate.update("INSERT INTO tbl_board(idx, title, type, updated, created) VALUES (null, ?, ?, now(), now())",
                new Object[]{board.getTitle(), board.getType()});
    }

    @Override
    public List<Board> boardList() {
        return jdbcTemplate.query("SELECT idx, title, type, updated, created FROM tbl_board tb", BeanPropertyRowMapper.newInstance(Board.class));
    }

    @Override
    public Board boardInfo(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_board WHERE idx = ?", BeanPropertyRowMapper.newInstance(Board.class), id);
    }

    @Override
    public int boardUpdate(Board board) {
        return jdbcTemplate.update("UPDATE tbl_board SET title = ?, type = ?, updated = now() WHERE idx = ?",
                new Object[]{board.getTitle(), board.getType(), board.getIdx()});
    }

    @Override
    public int boardDelete(long id) {
        return jdbcTemplate.update("DELETE FROM tbl_board WHERE idx = ?", id);
    }
}
