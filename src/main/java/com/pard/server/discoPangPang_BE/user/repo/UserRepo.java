package com.pard.server.discoPangPang_BE.user.repo;


import com.pard.server.discoPangPang_BE.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
