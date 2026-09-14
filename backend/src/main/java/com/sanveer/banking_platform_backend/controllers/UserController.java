package com.sanveer.banking_platform_backend.controllers;

import com.sanveer.banking_platform_backend.dtos.CreateUserRequest;
import com.sanveer.banking_platform_backend.dtos.CreateUserResponse;
import com.sanveer.banking_platform_backend.entities.User;
import com.sanveer.banking_platform_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }
}
