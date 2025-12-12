package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
