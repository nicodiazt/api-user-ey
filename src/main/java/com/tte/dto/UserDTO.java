package com.tte.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private boolean isActive;
    private List<PhoneDTO> phones;


    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id  + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + email + '\'' +
                ", contraseña='" + password + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", telefonos='" + phones.toString() + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public void setIsActive(boolean active) {
    }
}
