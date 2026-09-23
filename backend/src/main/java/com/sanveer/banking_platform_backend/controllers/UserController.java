package com.sanveer.banking_platform_backend.controllers;

import com.sanveer.banking_platform_backend.dtos.user.CreateUserRequest;
import com.sanveer.banking_platform_backend.dtos.user.UserResponse;
import com.sanveer.banking_platform_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }
}
