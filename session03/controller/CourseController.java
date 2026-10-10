package com.example.session03.controller;

import com.example.session03.model.Course;
import com.example.session03.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id) {
        Course x = service.getCourseById(id);
        return x != null ? ResponseEntity.ok(x) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course x) {
        return ResponseEntity.status(201).body(service.createCourse(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable int id, @RequestBody Course x) {
        Course updated = service.updateCourse(id, x);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteCourseById(id) != null
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}