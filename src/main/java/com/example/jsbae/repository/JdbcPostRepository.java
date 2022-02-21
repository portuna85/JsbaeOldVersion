package com.example.jsbae.repository;

import com.example.jsbae.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPostRepository implements PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int createPost(Post post) {
        return jdbcTemplate.update("INSERT INTO tbl_post(idx, userIdx, boardIdx, title, description, updated, created) VALUES (NULL, ?, ?, ?, ?, now(), now())",
                new Object[]{post.getUserIdx(), post.getBoardIdx(), post.getTitle(), post.getDescription()});
    }

    @Override
    public List<Post> postList() {
        return jdbcTemplate.query("SELECT idx, title, created FROM tbl_post", BeanPropertyRowMapper.newInstance(Post.class));
    }

    @Override
    public Post postInfo(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_post WHERE idx = ?",
                BeanPropertyRowMapper.newInstance(Post.class), id);
    }

    @Override
    public int postUpdate(Post post) {
        return jdbcTemplate.update("UPDATE tbl_post SET title = ?, description = ?, updated = now() WHERE idx = ?",
                new Object[]{post.getTitle(), post.getDescription(), post.getIdx()});
    }

    @Override
    public int postDelete(Long idx) {
        return jdbcTemplate.update("DELETE FROM tbl_post WHERE idx = ?", idx);
    }
}