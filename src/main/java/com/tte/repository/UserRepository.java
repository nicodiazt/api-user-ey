package com.tte.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tte.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  
    boolean existsByEmail(String email);
}
