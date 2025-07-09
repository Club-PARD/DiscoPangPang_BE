package com.pard.server.discoPangPang_BE.user.controller;


import com.pard.server.discoPangPang_BE.user.dto.UserRequest;
import com.pard.server.discoPangPang_BE.user.dto.UserResponse;
import com.pard.server.discoPangPang_BE.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse.ReadUser> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.readUser(userId));
    }

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


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
