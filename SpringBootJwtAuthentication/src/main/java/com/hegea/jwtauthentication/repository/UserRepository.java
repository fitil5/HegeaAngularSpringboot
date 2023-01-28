package com.hegea.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hegea.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean deleteByUsername(String username);
    @Query("SELECT u.enabled FROM User u WHERE u.username = ?1")
    boolean getEnabledByUsername(String username);
    @Query("SELECT u.name FROM User u WHERE u.username = ?1")
    String getNAmeByUsername(String username);
   
    
}