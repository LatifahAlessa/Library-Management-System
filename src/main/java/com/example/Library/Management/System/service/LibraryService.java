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

    public String deleteLibraryById(Integer id) {
        if (libraryRepository.existsById(Long.valueOf(id))) {
            libraryRepository.deleteById(Long.valueOf(id));
            return "Library Deleted Successfully";
        }
        else
            return "Library Not Found";
    }

}
