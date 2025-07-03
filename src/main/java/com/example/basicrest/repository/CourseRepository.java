package com.example.basicrest.repository;

import com.example.basicrest.doman.Courses;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class CourseRepository {
    private List<Courses> courses;
    public CourseRepository() {
        courses = new ArrayList<>();
        courses.add(Courses.builder()
                .id("1")
                .code("C001")
                .title("Java Programming")
                .price(100.0)
                .status(true)
                .build());
        courses.add(Courses.builder()
                .id("2")
                .code("C002")
                .title("Python Programming")
                .price(120.0)
                .status(false)
                .build());
    }
}
