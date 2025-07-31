package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/user")
public class UserController {
    public final UserService userService;

    @GetMapping ("/view-all")
    public ResponseEntity<?>  viewAllUsers() {
        return ResponseEntity.ok(userService.viewAllUsers());
    }

    @PostMapping ("/add")
    public ResponseEntity<?> addUser (@Valid @RequestBody UserDTO request) {
        userService.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User is added successfully");
    }
}
