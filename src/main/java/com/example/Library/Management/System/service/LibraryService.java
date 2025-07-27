package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.LibraryRequest;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<?> deleteLibraryById(Long id) {
        if (libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            return ResponseEntity.ok("Library Deleted Successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Library Not Found");
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

    public LibraryRequest viewLibraryById(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Library with ID " + id + " is not found"));
        LibraryRequest libraryRequest = new LibraryRequest();
        libraryRequest.setName(library.getName());
        libraryRequest.setEstablishDate(library.getEstablishDate());
        return libraryRequest;
    }

}
