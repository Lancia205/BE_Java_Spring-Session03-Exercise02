package com.example.session03.service;

import com.example.session03.model.Instructor;
import com.example.session03.repository.InstructorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repo;

    public InstructorService(InstructorRepository repo) {
        this.repo = repo;
    }

    public List<Instructor> getAllInstructors() {
        return repo.findAll();
    }

    public Instructor getInstructorById(int id) {
        return repo.findById(id);
    }

    public Instructor createInstructor(Instructor x) {
        return repo.create(x);
    }

    public Instructor updateInstructor(int id, Instructor x) {
        return repo.update(id, x);
    }

    public Instructor deleteInstructorById(int id) {
        return repo.deleteById(id);
    }
}