package com.pard.server.discoPangPang_BE.user.controller;


import com.pard.server.discoPangPang_BE.user.dto.UserRequest;
import com.pard.server.discoPangPang_BE.user.dto.UserResponse;
import com.pard.server.discoPangPang_BE.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 조회", description = "사용자의 정보를 불러옵니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse.ReadUser> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.readUser(userId));
    }

    @Operation(summary = "회원 가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping("")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest.UserCreateRequest req) {
        userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PatchMapping("/{userId}")
//    public ResponseEntity<Void> patchUser(@PathVariable Long userId ,
//                                          @RequestBody UserRequest.UserUpdateRequest req) {
//        userService.updateUser(userId, req);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @Operation(summary = "회원 탈퇴", description = "기존의 사용자를 삭제합니다.")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
