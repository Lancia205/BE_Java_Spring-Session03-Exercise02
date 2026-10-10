package com.example.session03.repository;

import com.example.session03.model.Instructor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InstructorRepository {
    private final List<Instructor> list = new ArrayList<>(List.of(
            new Instructor(1, "Nguyen Van A", "a@gmail.com"),
            new Instructor(2, "Tran Van B", "b@gmail.com")
    ));

    public List<Instructor> findAll() {
        return list;
    }

    public Instructor findById(int id) {
        return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public Instructor create(Instructor x) {
        list.add(x);
        return x;
    }

    public Instructor update(int id, Instructor x) {
        Instructor old = findById(id);
        if (old == null) return null;
        old.setName(x.getName());
        old.setEmail(x.getEmail());
        return old;
    }

    public Instructor deleteById(int id) {
        Instructor x = findById(id);
        list.remove(x);
        return x;
    }
}