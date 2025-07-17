package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public void addLibrary(LibraryRequest request) {
        libraryRepository.save(this.map(request));
    }

    public List<LibraryRequest> viewAllLibraries() {
        List<Library>  libraries = libraryRepository.findAll();
        List<LibraryRequest> libraryRequests = new ArrayList<>();

        for (Library library : libraries) {
            libraryRequests.add(this.mapRequest(library));
        }
        return libraryRequests;
    }

    public Library map(LibraryRequest request) {
        Library library = new Library();
        library.setName(request.getName());
        library.setEstablishDate(request.getEstablishDate());
        return library;
    }

    public LibraryRequest mapRequest (Library library) {
        LibraryRequest libraryRequest = new LibraryRequest();
        libraryRequest.setName(library.getName());
        libraryRequest.setEstablishDate(library.getEstablishDate());
        return libraryRequest;
    }

}
