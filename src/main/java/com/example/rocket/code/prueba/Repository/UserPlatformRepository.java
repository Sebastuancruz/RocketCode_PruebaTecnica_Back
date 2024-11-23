package com.example.rocket.code.prueba.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rocket.code.prueba.Entity.UserPlatform;

public interface UserPlatformRepository extends JpaRepository<UserPlatform, Long> {
            Optional<UserPlatform> findByEmail(String email);
            List<UserPlatform> findByRole(String role);
}
