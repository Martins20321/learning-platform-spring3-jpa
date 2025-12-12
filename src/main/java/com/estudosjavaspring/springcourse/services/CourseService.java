package com.estudosjavaspring.springcourse.services;

import com.estudosjavaspring.springcourse.entities.Course;
import com.estudosjavaspring.springcourse.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> findAll(){
        return repository.findAll();
    }

    public Course findById(Long id){
        Optional<Course> obj = repository.findById(id);
        return obj.get();
    }
}
