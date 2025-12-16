package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
