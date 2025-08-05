package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.BookDTO;
import com.example.Library.Management.System.dto.BookSimpleDTO;
import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.enums.RoleEnum;
import com.example.Library.Management.System.mapper.BookMapper;
import com.example.Library.Management.System.model.entity.Author;
import com.example.Library.Management.System.model.entity.Book;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.model.entity.User;
import com.example.Library.Management.System.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final LibraryService libraryService;
    private final UserService userService;

    public void addBook(BookSimpleDTO request){
        UserDTO userDto = userService.getById(request.getRequesterId());
        if (userDto.getRole().equals(RoleEnum.ADMIN)||userDto.getRole().equals(RoleEnum.MANAGER)){
            Book book = BookMapper.mapBookSimpleDtoToBook(request);
            List<Author> authors = authorService.getAuthorsByIds(request.getAuthors());
            authors.forEach(author -> {
                author.setNumberOfBooks(author.getNumberOfBooks() + 1);
                author.getBooks().add(book);
            });
            book.setAuthors(authors);
            bookRepository.save(book);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    public List<BookDTO> viewAllBooks (){
        List<Book>  books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : books) {
            bookDTOS.add(BookMapper.mapBookToBookDto(book));
        }
        return bookDTOS;
    }

    public void deleteBookById(Long id,Long userId) {
        UserDTO userDTO = userService.getById(userId);
        Book book = bookRepository.findById(id.intValue()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found"));
        if (userDTO.getRole() == RoleEnum.ADMIN) {
            if (book.isBorrowed()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Book is borrowed");
            }
            List<Author> authors = book.getAuthors();
            authors.forEach(author -> {
                author.setNumberOfBooks(author.getNumberOfBooks() - 1);
            });
            bookRepository.delete(book);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only Admin can delete a book");
        }
    }

    public void addToLibrary(Long libraryId, Long bookId) {
        Book book = bookRepository.findById(bookId.intValue()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book Not Found"));
        Library library = libraryService.getById(libraryId);
        if(!book.getLibraries().contains(library)){
            book.getLibraries().add(library);
            library.getBooks().add(book);
            bookRepository.save(book);
        }
    }

    public BookDTO viewBookById(Long id) {
        Book book = bookRepository.findById(id.intValue()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Library with ID " + id + " is not found"));
        BookDTO bookDTO = BookMapper.mapBookToBookDto(book);
        return bookDTO;
    }

    public void borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId.intValue()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The book with Id " + bookId + " is not found"));
        if (book.isBorrowed()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The book is already borrowed");
        }
        else {
            User user = userService.getUserById(userId);
            book.setRentedCopies(book.getRentedCopies() + 1);
            book.getBorrowers().add(user);
            if(book.getCopies()== book.getRentedCopies()) {
                book.setBorrowed(true);
            }
            bookRepository.save(book);
        }
    }
}

