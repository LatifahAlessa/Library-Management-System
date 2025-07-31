package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.LibraryDTO;
import com.example.Library.Management.System.dto.LibrarySimpleDTO;
import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.model.entity.Library;

public class LibraryMapper {

    public static Library mapLibraryDtoToLibrary(LibraryDTO request) {
        Library library = new Library();
        library.setName(request.getName());
        library.setEstablishDate(request.getEstablishDate());
        library.setNumberOfAvailableBooks(request.getNumberOfAvailableBooks());
        return library;
    }

    public static LibraryDTO mapLibraryToLibraryDto (Library library) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setId(library.getId());
        libraryDTO.setName(library.getName());
        libraryDTO.setEstablishDate(library.getEstablishDate());
        libraryDTO.setNumberOfAvailableBooks(library.getNumberOfAvailableBooks());
        if (library.getUser() != null) {
            UserDTO userDTO = UserMapper.mapUserToUserDto(library.getUser());
            libraryDTO.setManager(userDTO);
        }
        return libraryDTO;
    }

    public static LibrarySimpleDTO mapLibraryToLibrarySimpleDto (Library library) {
        LibrarySimpleDTO librarySimpleDTO = new LibrarySimpleDTO();
        librarySimpleDTO.setId(library.getId());
        librarySimpleDTO.setName(library.getName());
        librarySimpleDTO.setEstablishDate(library.getEstablishDate());
        librarySimpleDTO.setNumberOfAvailableBooks(library.getNumberOfAvailableBooks());
        if (library.getUser() != null) {
            UserDTO userDTO = UserMapper.mapUserToUserDto(library.getUser());
            librarySimpleDTO.setManagerName(userDTO.getFirstName() + " " + userDTO.getLastName());
        }
        return librarySimpleDTO;
    }
}
