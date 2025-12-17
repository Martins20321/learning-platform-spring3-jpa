package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
