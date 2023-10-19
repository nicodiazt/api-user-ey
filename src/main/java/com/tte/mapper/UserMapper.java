package com.tte.mapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tte.dto.UserDTO;
import com.tte.dto.UserResponseRegisterDTO;
import com.tte.model.User;

@Component
public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreated(user.getCreated());
        userDTO.setModified(user.getModified());
        userDTO.setLastLogin(user.getLastLogin());
        userDTO.setIsActive(user.isActive());
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreated(userDTO.getCreated());
        user.setModified(userDTO.getModified());
        user.setLastLogin(userDTO.getLastLogin());
        user.setActive(userDTO.isActive());
        return user;
    }

    public static UserResponseRegisterDTO toRegisterResponse(User user) {
    UserResponseRegisterDTO userDTO = new UserResponseRegisterDTO();
    userDTO.setId(user.getId());
    userDTO.setName(user.getName());
    userDTO.setEmail(user.getEmail());
    userDTO.setPassword(user.getPassword());
    userDTO.setCreated(user.getCreated());
    userDTO.setModified(user.getModified());
    userDTO.setLastLogin(user.getLastLogin());
    userDTO.setToken(user.getId());
    userDTO.setIsActive(user.isActive());
 
    return userDTO;
}
}
