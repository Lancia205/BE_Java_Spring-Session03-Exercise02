package com.example.session03.service;

import com.example.session03.model.Enrollment;
import com.example.session03.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) {
        this.repo = repo;
    }

    public List<Enrollment> getAllEnrollments() {
        return repo.findAll();
    }

    public Enrollment getEnrollmentById(int id) {
        return repo.findById(id);
    }

    public Enrollment createEnrollment(Enrollment x) {
        return repo.create(x);
    }

    public Enrollment updateEnrollment(int id, Enrollment x) {
        return repo.update(id, x);
    }

    public Enrollment deleteEnrollmentById(int id) {
        return repo.deleteById(id);
    }
}