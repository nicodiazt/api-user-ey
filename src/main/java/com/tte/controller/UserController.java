package com.tte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tte.dto.UserDTO;
import com.tte.dto.UserResponseRegisterDTO;
import com.tte.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseRegisterDTO> crearUser(@RequestBody UserDTO userDTO) {
 
        UserResponseRegisterDTO newUser = userService.crearUser(userDTO);
        return ResponseEntity.ok(newUser);
    }
}
