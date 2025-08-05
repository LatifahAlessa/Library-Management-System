package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.AuthorDTO;
import com.example.Library.Management.System.model.entity.Author;

public class AuthorMapper {

    public static Author mapAuthorDtoToAuthor(AuthorDTO request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setNumberOfBooks(0);
        return author;
    }
}
