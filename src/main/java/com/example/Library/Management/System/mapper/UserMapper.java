package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.UserDTO;
import com.example.Library.Management.System.model.entity.User;

public class UserMapper {
    public static User mapUserDtoToUser(UserDTO request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmploymentDate(request.getEmploymentDate());
        user.setRole(request.getRole());
        return user;
    }

    public static UserDTO mapUserToUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmploymentDate(user.getEmploymentDate());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
