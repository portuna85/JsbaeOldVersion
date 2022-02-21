package com.example.jsbae.repository;

import com.example.jsbae.domain.User;

public interface UserRepository {
    // 회원 등록
    int createUser(User user);

    // 회원 조회
    User findDetail(Long id);

    // 회원 수정
    int userUpdate(User user);

    // 회원 삭제
    int userDelete(Long id);
}
