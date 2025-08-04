package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.BookDTO;
import com.example.Library.Management.System.dto.BookSimpleDTO;
import com.example.Library.Management.System.model.entity.Book;

public class BookMapper {

    public static Book mapBookSimpleDtoToBook(BookSimpleDTO request){
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setCopies(request.getCopies());
        book.setRentedCopies(request.getRentedCopies());
        book.setPublishedDate(request.getPublishedDate());
        book.setBorrowed(request.isBorrowed());
        return book;
    }

    public static BookDTO mapBookToBookDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCopies(book.getCopies());
        bookDTO.setRentedCopies(book.getRentedCopies());
        bookDTO.setPublishedDate(book.getPublishedDate());
        bookDTO.setBorrowed(book.isBorrowed());
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setBorrowers(book.getBorrowers());
        return bookDTO;
    }
}