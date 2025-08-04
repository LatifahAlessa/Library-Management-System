package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.LibraryDTO;
import com.example.Library.Management.System.service.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping ("/library")
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllLibraries() {
        return ResponseEntity.ok().body(libraryService.viewAllLibraries());
    }

    @GetMapping("/view-by-id/{id}")
    public ResponseEntity<?> getLibraryById(@PathVariable Long id){
        return ResponseEntity.ok().body(libraryService.viewLibraryById(id));
    }

    @PostMapping ("/add")
    public ResponseEntity<?> addLibrary(@Valid @RequestBody LibraryDTO request) {
        libraryService.addLibrary (request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Library is added successfully");
    }

    @PatchMapping("/assign-manager-to-library/")
    public ResponseEntity<?> assignManager(@RequestParam Long libraryId, @RequestParam Long managerId) {
        libraryService.assignManagerToLibrary(libraryId,managerId);
        return ResponseEntity.ok("Manager Assigned Successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibraryById(id);
        return ResponseEntity.ok("Library Deleted Successfully");
    }
}