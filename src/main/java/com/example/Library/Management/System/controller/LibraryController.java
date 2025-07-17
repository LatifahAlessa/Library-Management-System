package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.service.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/library")
public class LibraryController {
    private final LibraryService libraryService;

    //Get
    @GetMapping("/viewAllLibraries")
    public List<LibraryRequest> getMapping(){
        return libraryService.viewAllLibraries();
    }

    //Post
    @PostMapping ("/add")
    public ResponseEntity<?> addLibrary(@Valid @RequestBody LibraryRequest request) {
        libraryService.addLibrary (request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Library is added successfully");
    }

    //Put

    //Delete
}
