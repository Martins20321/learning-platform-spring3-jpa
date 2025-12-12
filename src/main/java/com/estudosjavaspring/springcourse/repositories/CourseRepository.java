package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
