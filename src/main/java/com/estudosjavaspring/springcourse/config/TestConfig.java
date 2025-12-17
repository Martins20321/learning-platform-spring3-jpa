package com.estudosjavaspring.springcourse.config;

import com.estudosjavaspring.springcourse.entities.*;
import com.estudosjavaspring.springcourse.entities.enums.CourseLevel;
import com.estudosjavaspring.springcourse.entities.enums.EnrollmentStatus;
import com.estudosjavaspring.springcourse.entities.enums.UserRole;
import com.estudosjavaspring.springcourse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "Pablo Marcelo", "pabloa@gmail.com", "6199843123", "1234", UserRole.ADMIN);
        User us2 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", UserRole.STUDENT);
        User us3 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", UserRole.INSTRUCTOR);

        Category cat1 = new Category(null, "Full Stack");
        Category cat2 = new Category(null, "Carreira Python");
        Category cat3 = new Category(null, "Marketing Digital");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        Course c1 = new Course(null, "Desenvolvimento Web Full Stack", "Aprenda a criar aplicações web completas do front-end (React) ao back-end (Node.js e API REST).", 997.50, CourseLevel.BEGINNER, null, cat1);
        Course c2 = new Course(null, "Análise de Dados com Python e Pandas", "Domine as bibliotecas Python para manipulação, limpeza e visualização de grandes volumes de dados.", 450.00, CourseLevel.INTERMEDIATE, null, cat2);
        Course c3 = new Course(null, "Estratégias Avançadas de Marketing Digital", "Crie campanhas eficazes de SEO, tráfego pago (Google Ads) e otimização de funis de conversão.", 399.90, CourseLevel.ADVANCED, null , cat3);

        userRepository.saveAll(Arrays.asList(us1,us2,us3));
        courseRepository.saveAll(Arrays.asList(c1,c2,c3));

        Enrollment e1 = new Enrollment(c1, us2, Instant.now(), EnrollmentStatus.ACTIVE);
        Enrollment e2 = new Enrollment(c2, us1, Instant.now(), EnrollmentStatus.CANCELED);
        Enrollment e3 = new Enrollment(c3, us3, Instant.now(), EnrollmentStatus.COMPLETED);

        Payment p1 = new Payment(null, Instant.now(), c1.getPrice(),e1);
        Payment p2 = new Payment(null, Instant.now(), 0.00 ,e2);
        Payment p3 = new Payment(null, Instant.now(), c3.getPrice(),e3);

        enrollmentRepository.saveAll(Arrays.asList(e1,e2,e3));
        paymentRepository.saveAll(Arrays.asList(p1,p2,p3));

        Lesson l1 = new Lesson(null, "Criação de API", 2.00, "teste");
        Lesson l2 = new Lesson(null, "Aprendendo Spring Boot", 3.00, "teste");
        Lesson l3 = new Lesson(null, "Certificação AWS", 3.30, "teste");

        lessonRepository.saveAll(Arrays.asList(l1,l2,l3));
    }
}
