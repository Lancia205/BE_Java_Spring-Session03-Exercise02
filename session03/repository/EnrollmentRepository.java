package com.example.session03.repository;

import com.example.session03.model.Enrollment;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> list = new ArrayList<>(List.of(
            new Enrollment(1, "Nguyen Van C", 1),
            new Enrollment(2, "Tran Thi D", 2)
    ));

    public List<Enrollment> findAll() {
        return list;
    }

    public Enrollment findById(int id) {
        return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public Enrollment create(Enrollment x) {
        list.add(x);
        return x;
    }

    public Enrollment update(int id, Enrollment x) {
        Enrollment old = findById(id);
        if (old == null) return null;
        old.setStudentName(x.getStudentName());
        old.setCourseId(x.getCourseId());
        return old;
    }

    public Enrollment deleteById(int id) {
        Enrollment x = findById(id);
        list.remove(x);
        return x;
    }
}