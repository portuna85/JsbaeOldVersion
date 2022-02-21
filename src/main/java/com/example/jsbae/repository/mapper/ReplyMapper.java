package com.example.jsbae.repository.mapper;

import com.example.jsbae.domain.Reply;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyMapper implements RowMapper<Reply> {
    @Override
    public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reply reply = new Reply();
        reply.setIdx(rs.getLong("idx"));
        reply.setUserIdx(rs.getLong("userIdx"));
        reply.setPostIdx(rs.getLong("postIdx"));
        reply.setDescription(rs.getString("description"));
        reply.setUpdated(rs.getDate("updated"));
        reply.setCreated(rs.getDate("created"));
        return reply;
    }
}
