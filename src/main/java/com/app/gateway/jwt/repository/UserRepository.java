package com.app.gateway.jwt.repository;

import com.app.gateway.jwt.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUsername(String Username);
}
