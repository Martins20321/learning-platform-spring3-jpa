package com.estudosjavaspring.springcourse.config;

import com.estudosjavaspring.springcourse.entities.Course;
import com.estudosjavaspring.springcourse.entities.Enrollment;
import com.estudosjavaspring.springcourse.entities.User;
import com.estudosjavaspring.springcourse.entities.enums.CourseLevel;
import com.estudosjavaspring.springcourse.entities.enums.EnrollmentStatus;
import com.estudosjavaspring.springcourse.entities.enums.UserRole;
import com.estudosjavaspring.springcourse.repositories.CourseRepository;
import com.estudosjavaspring.springcourse.repositories.EnrollmentRepository;
import com.estudosjavaspring.springcourse.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "Pablo Marcelo", "pabloa@gmail.com", "6199843123", "1234", UserRole.ADMIN);
        User us2 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", UserRole.STUDENT);
        User us3 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", UserRole.INSTRUCTOR);

        Course c1 = new Course(null, "Desenvolvimento Web Full Stack", "Aprenda a criar aplicações web completas do front-end (React) ao back-end (Node.js e API REST).", 997.50, CourseLevel.BEGINNER, null);
        Course c2 = new Course(null, "Análise de Dados com Python e Pandas", "Domine as bibliotecas Python para manipulação, limpeza e visualização de grandes volumes de dados.", 450.00, CourseLevel.INTERMEDIATE, null);
        Course c3 = new Course(null, "Estratégias Avançadas de Marketing Digital", "Crie campanhas eficazes de SEO, tráfego pago (Google Ads) e otimização de funis de conversão.", 399.90, CourseLevel.ADVANCED, null);

        userRepository.saveAll(Arrays.asList(us1,us2,us3));
        courseRepository.saveAll(Arrays.asList(c1,c2,c3));

        Enrollment e1 = new Enrollment(c1, us2, Instant.now(), EnrollmentStatus.ACTIVE);
        Enrollment e2 = new Enrollment(c2, us1, Instant.now(), EnrollmentStatus.CANCELED);
        Enrollment e3 = new Enrollment(c3, us3, Instant.now(), EnrollmentStatus.COMPLETED);

        enrollmentRepository.saveAll(Arrays.asList(e1,e2,e3));

    }
}
