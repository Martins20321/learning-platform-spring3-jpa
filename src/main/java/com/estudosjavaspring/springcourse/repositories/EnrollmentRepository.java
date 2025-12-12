package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.Enrollment;
import com.estudosjavaspring.springcourse.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
