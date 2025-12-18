package com.estudosjavaspring.springcourse.services;

import com.estudosjavaspring.springcourse.entities.Course;
import com.estudosjavaspring.springcourse.repositories.CourseRepository;
import com.estudosjavaspring.springcourse.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Course insert(Course obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Course update(Long id, Course obj){
        try {
            Course entity = repository.getReferenceById(id);
            UpdateDate(entity, obj);
            return repository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void UpdateDate(Course entity, Course obj) {
        entity.setDescription(obj.getDescription());
        entity.setTitle(obj.getTitle());
        entity.setImgUrl(obj.getImgUrl());
    }
}
