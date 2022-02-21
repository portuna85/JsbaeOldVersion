package com.example.jsbae.repository;

import com.example.jsbae.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update("INSERT INTO tbl_user(idx, email, name, updated, created) VALUES (null, ?, ?, now(), now())",
                new Object[]{user.getEmail(), user.getName()});
    }

    @Override
    public User findDetail(Long id) {
        return jdbcTemplate.queryForObject("SELECT idx, email, name, updated, created FROM tbl_user u WHERE idx = ?",
                BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public int userUpdate(User user) {
        return jdbcTemplate.update("UPDATE tbl_user SET email = ?, updated = now() WHERE idx = ?",
                new Object[]{user.getEmail(), user.getIdx()});
    }

    @Override
    public int userDelete(Long id) {
        return jdbcTemplate.update("DELETE FROM tbl_user WHERE idx = ?", id);
    }
}