package com.epam.demojenkinsspringboot.repository;

import com.epam.demojenkinsspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
