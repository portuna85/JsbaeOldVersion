package com.example.jsbae.repository;

import com.example.jsbae.domain.Reply;
import com.example.jsbae.repository.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReplyRepository implements ReplyRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Reply replySearch(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_reply WHERE idx = ?", BeanPropertyRowMapper.newInstance(Reply.class), id);
    }

    @Override
    public List<Reply> replyListByPostId(Long postIdx) {
        return jdbcTemplate.query("SELECT * FROM tbl_reply where postIdx = ?", new ReplyMapper(), postIdx);
    }

    @Override
    public List<Reply> replyList(Long id) {
        return jdbcTemplate.query("SELECT * FROM tbl_reply", BeanPropertyRowMapper.newInstance(Reply.class));
    }

    @Override
    public int createReply(Reply reply) {
        return jdbcTemplate.update("INSERT INTO tbl_reply(userIdx, postIdx, description, updated, created) VALUES (?, ?, ?, now(), now())",
                new Object[]{reply.getUserIdx(), reply.getPostIdx(), reply.getDescription()});
    }

    @Override
    public int updateReply(Reply reply) {
        return jdbcTemplate.update("UPDATE tbl_reply SET description = ?, updated = now() WHERE idx = ?", new Object[]{reply.getDescription(), reply.getIdx()});
    }

    @Override
    public int deleteReply(Long id) {
        return jdbcTemplate.update("DELETE FROM tbl_reply WHERE idx = ?", id);
    }
}
