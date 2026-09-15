package com.sanveer.banking_platform_backend.services;

import com.sanveer.banking_platform_backend.dtos.user.CreateUserRequest;
import com.sanveer.banking_platform_backend.dtos.user.CreateUserResponse;
import com.sanveer.banking_platform_backend.entities.User;
import com.sanveer.banking_platform_backend.exceptions.UserNotFoundException;
import com.sanveer.banking_platform_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sanveer.banking_platform_backend.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public CreateUserResponse createUser(CreateUserRequest requestDTO)
    {
        User user = userMapper.toEntity(requestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public User getUser(Long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
