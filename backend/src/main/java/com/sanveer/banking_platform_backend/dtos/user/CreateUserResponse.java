package com.sanveer.banking_platform_backend.dtos.user;

import java.time.Instant;

public class CreateUserResponse {

    private final Long id;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Instant createdTimestamp;

    public CreateUserResponse(Long id, String firstName, String lastName, String email, String phoneNumber, Instant createdTimestamp) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdTimestamp = createdTimestamp;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }
}
