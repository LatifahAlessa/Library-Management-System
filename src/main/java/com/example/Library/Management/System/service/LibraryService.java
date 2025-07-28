package com.example.Library.Management.System.service;

import com.example.Library.Management.System.mapper.LibraryMapper;
import com.example.Library.Management.System.mapper.UserMapper;
import com.example.Library.Management.System.dto.LibraryDTO;
import com.example.Library.Management.System.dto.LibrarySimpleDTO;
import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.enums.RoleEnum;
import com.example.Library.Management.System.model.entity.Library;
import com.example.Library.Management.System.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final UserService userService;

    public void addLibrary(LibraryDTO request) {
        libraryRepository.save(LibraryMapper.mapLibraryDtoToLibrary(request));
    }

    public List<LibrarySimpleDTO> viewAllLibraries() {
        List<Library>  libraries = libraryRepository.findAll();
        List<LibrarySimpleDTO> librarySimpleDTOS = new ArrayList<>();

        for (Library library : libraries) {
            librarySimpleDTOS.add(LibraryMapper.mapLibraryToLibrarySimpleDto(library));
        }
        return librarySimpleDTOS;
    }

    public void deleteLibraryById(Long id) {
        libraryRepository.deleteById(id);
    }

    public LibraryDTO viewLibraryById(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Library with ID " + id + " is not found"));
        LibraryDTO libraryDTO = LibraryMapper.mapLibraryToLibraryDto(library);
        return libraryDTO;
    }

    public void assignManagerToLibrary (Long libraryId, Long managerId) {//check if manager first
        Library library = libraryRepository.findById(libraryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Library Not Found"));
        if (library.getUser() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Library Manager is Already Assigned");
        UserDTO userDTO = userService.getById(managerId);
        if (userDTO.getRole() != RoleEnum.MANAGER)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User is not Manager");

        library.setUser(UserMapper.mapUserDtoToUser(userDTO));
        libraryRepository.save(library);
    }
}
