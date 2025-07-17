package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<LibraryRequest> viewAllLibraries() {
        List<Library>  libraries = libraryRepository.findAll();
        List<LibraryRequest> libraryRequests = new ArrayList<>();

        for (Library library : libraries) {
            LibraryRequest libraryRequest = new LibraryRequest();
            libraryRequest.setName(library.getName());
            libraryRequest.setEstablishDate(library.getEstablishDate());
            libraryRequests.add(libraryRequest);
        }
        return libraryRequests;
    }

}
