package com.estudosjavaspring.springcourse.resources;

import com.estudosjavaspring.springcourse.entities.Course;
import com.estudosjavaspring.springcourse.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseResource {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        List<Course> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable long id){
        Course obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
