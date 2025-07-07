package com.pard.server.discoPangPang_BE.user.service;


import com.pard.server.discoPangPang_BE.user.dto.UserRequest;
import com.pard.server.discoPangPang_BE.user.dto.UserResponse;
import com.pard.server.discoPangPang_BE.user.entity.User;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;


    @Transactional

    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createUser(UserRequest.UserCreateRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
//                .project(new ArrayList<>())
//                .role(Role.USER)
                .build();


        userRepo.save(user);
    }

    public UserResponse.ReadUser readUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        return UserResponse.ReadUser.builder()
                .name(user.getName())
                .build();
    }

    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));
        userRepo.delete(user); // cascade 설정에 따라 블로그도 같이 삭제됨
    }




    public void updateUser(Long userId, UserRequest.UserUpdateRequest req) {
    }
}
