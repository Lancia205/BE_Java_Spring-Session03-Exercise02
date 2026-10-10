package com.example.session03.controller;

import com.example.session03.model.Enrollment;
import com.example.session03.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> findAll() {
        return ResponseEntity.ok(service.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> findById(@PathVariable int id) {
        Enrollment x = service.getEnrollmentById(id);
        return x != null ? ResponseEntity.ok(x) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment x) {
        return ResponseEntity.status(201).body(service.createEnrollment(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable int id, @RequestBody Enrollment x) {
        Enrollment updated = service.updateEnrollment(id, x);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteEnrollmentById(id) != null
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}