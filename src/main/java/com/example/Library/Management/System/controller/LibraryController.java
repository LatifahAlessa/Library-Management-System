package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.service.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/library")

public class LibraryController {
    private final LibraryService libraryService;

    //Get

    //Post
    @PostMapping ("/add")
    public String postMapping(@Valid @RequestBody LibraryRequest request) {
        libraryService.addLibrary (request);
        return "Library is added successfully";
    }

    //Put

    //Delete
}
