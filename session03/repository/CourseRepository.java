package com.example.session03.repository;

import com.example.session03.model.Course;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CourseRepository {
    private final List<Course> list = new ArrayList<>(List.of(
            new Course(1, "Java", "Active", 1),
            new Course(2, "Spring Boot", "Active", 2)
    ));

    public List<Course> findAll() {
        return list;
    }

    public Course findById(int id) {
        return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public Course create(Course x) {
        list.add(x);
        return x;
    }

    public Course update(int id, Course x) {
        Course old = findById(id);
        if (old == null) return null;
        old.setTitle(x.getTitle());
        old.setStatus(x.getStatus());
        old.setInstructorId(x.getInstructorId());
        return old;
    }

    public Course deleteById(int id) {
        Course x = findById(id);
        list.remove(x);
        return x;
    }
}