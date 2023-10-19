package com.tte.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tte.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Puedes agregar métodos de consulta personalizados si los necesitas.
    boolean existsByEmail(String email);
}
