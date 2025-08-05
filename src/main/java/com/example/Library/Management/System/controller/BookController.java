package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.BookSimpleDTO;
import com.example.Library.Management.System.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/book")
public class BookController {
    public final BookService bookService;

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok().body(bookService.viewAllBooks());
    }

    @GetMapping("/view-by-id/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.viewBookById(id));
    }

    @PostMapping ("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookSimpleDTO request) {
        bookService.addBook(request);
        return ResponseEntity.ok().body("Book is added successfully");
    }

    @PatchMapping("/add-to-library")
    public ResponseEntity<?> addToLibrary(@RequestParam Long libraryId, @RequestParam Long bookId) {
        bookService.addToLibrary(libraryId,bookId);
        return ResponseEntity.ok().body("Book is added to the library successfully");
    }

    @PatchMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestParam Long bookId, @RequestParam Long borrowerId) {
        bookService.borrowBook(bookId,borrowerId);
        return ResponseEntity.ok("Book is borrowed successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam Long id, @RequestParam Long userId) {
        bookService.deleteBookById(id,userId);
        return ResponseEntity.ok("Book Deleted Successfully");
    }
}

