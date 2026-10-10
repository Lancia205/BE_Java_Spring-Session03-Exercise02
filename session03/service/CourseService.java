package com.example.session03.service;

import com.example.session03.model.Course;
import com.example.session03.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(int id) {
        return repo.findById(id);
    }

    public Course createCourse(Course x) {
        return repo.create(x);
    }

    public Course updateCourse(int id, Course x) {
        return repo.update(id, x);
    }

    public Course deleteCourseById(int id) {
        return repo.deleteById(id);
    }
}