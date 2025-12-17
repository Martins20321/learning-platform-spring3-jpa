package com.estudosjavaspring.springcourse.repositories;

import com.estudosjavaspring.springcourse.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
