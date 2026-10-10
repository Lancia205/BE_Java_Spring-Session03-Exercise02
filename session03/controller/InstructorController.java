package com.example.session03.controller;

import com.example.session03.model.Instructor;
import com.example.session03.service.InstructorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        return ResponseEntity.ok(service.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id) {
        Instructor x = service.getInstructorById(id);
        return x != null ? ResponseEntity.ok(x) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor x) {
        return ResponseEntity.status(201).body(service.createInstructor(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable int id, @RequestBody Instructor x) {
        Instructor updated = service.updateInstructor(id, x);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteInstructorById(id) != null
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}