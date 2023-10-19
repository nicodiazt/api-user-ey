package com.tte.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tte.dto.UserDTO;
import com.tte.dto.UserResponseRegisterDTO;
import com.tte.exception.CustomException;
 
import com.tte.mapper.UserMapper;
import com.tte.model.User;
import com.tte.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

  @Transactional
  public UserResponseRegisterDTO crearUser(UserDTO userDTO) {
    try {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        Date fechaActual = new Date();
        user.setCreated(fechaActual);
        user.setModified(fechaActual);
        user.setLastLogin(fechaActual);

        // Validación del formato del correo
        if (!validateFormatMail(user.getEmail())) {
            throw new CustomException("El formato del correo es inválido");
        }

        if (mailRegister(userDTO.getEmail())) {
            throw new CustomException("El correo ya se encuentra registrado");
        }

        if (!validateFormatPassword(user.getPassword())) {
            throw new CustomException("La contraseña no cumple con los requisitos");
        }

        User userGuardado = userRepository.save(user);
        return UserMapper.toRegisterResponse(userGuardado);
    } catch (CustomException e) {
 
     
        throw e; 
    } catch (Exception e) {
 
        System.out.println(e.toString());
        throw new CustomException("Ocurrió un error no controlado");
    }
}

public boolean validateFormatMail(String mail) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(mail);
    return matcher.matches();
}


 public boolean mailRegister(String mail) {

    return userRepository.existsByEmail(mail);
}
 
 public boolean validateFormatPassword(String contraseña) {
    // Requisitos: una mayúscula, letras minúsculas y al menos dos números
    String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d).*$";
    Pattern pattern = Pattern.compile(regexPassword);
    Matcher matcher = pattern.matcher(contraseña);
    return matcher.matches();
}

@Autowired
public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
}
}
