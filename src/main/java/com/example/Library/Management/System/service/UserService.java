package com.example.Library.Management.System.service;
import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.model.entity.User;
import com.example.Library.Management.System.repository.UserRepository;
import com.example.Library.Management.System.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    public final UserRepository userRepository;

    public void addUser(UserDTO request) {
        userRepository.save(UserMapper.mapUserDtoToUser(request));
    }

    public List<UserDTO> viewAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(UserMapper.mapUserToUserDto(user));
        }
        return userDTOS;
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found"));
        return UserMapper.mapUserToUserDto(user);
    }
}
