package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.AuthorDTO;
import com.example.Library.Management.System.mapper.AuthorMapper;
import com.example.Library.Management.System.model.entity.Author;
import com.example.Library.Management.System.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public void addAuthor(AuthorDTO request) {
        authorRepository.save(AuthorMapper.mapAuthorDtoToAuthor(request));
    }

    public List<Author> getAuthorsByIds(Set<Long> ids) {
        List<Author> authors = new ArrayList<>();
        for (Long id : ids) {
            Author author = authorRepository.findById(id.intValue()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author Not Found"));
            authors.add(author);
        }
        return authors;
    }

}
