package com.estudosjavaspring.springcourse.entities;

import com.estudosjavaspring.springcourse.entities.enums.CourseLevel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imgUrl;

    private Integer level;

    @OneToMany(mappedBy = "course")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.course")
    private Set<Enrollment> enrollments = new HashSet<>(); //Não havendo repetição

    public Course(){

    }

    public Course(Long id, String title, String description, Double price, CourseLevel level, String imgUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        setLevel(level);
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CourseLevel getLevel() {
        return CourseLevel.valueOf(level);
    }

    public void setLevel(CourseLevel level) {
        if(level != null) {
            this.level = level.getCode();
        }
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Enrollment> getEnrollments(){
        return enrollments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
