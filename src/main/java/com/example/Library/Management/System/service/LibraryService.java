package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class LibraryService {
    private final LibraryRepository libraryRepository;

    public void addLibrary(LibraryRequest request) {
        Library library = new Library();
        library.setName(request.getName());
        library.setEstablishDate(request.getEstablishDate());
        libraryRepository.save(library);
    }
}
