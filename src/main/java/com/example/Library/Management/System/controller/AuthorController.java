package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.AuthorDTO;
import com.example.Library.Management.System.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/author")
public class AuthorController {
    public final AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@Valid @RequestBody AuthorDTO request) {
        authorService.addAuthor(request);
        return ResponseEntity.ok().body("Author is added successfully");
    }
}