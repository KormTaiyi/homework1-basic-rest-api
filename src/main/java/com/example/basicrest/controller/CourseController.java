package com.example.basicrest.controller;

import com.example.basicrest.dto.CourseResponseDto;
import com.example.basicrest.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getCourses(@RequestParam(required = false) Boolean status) {
        return courseService.getAllCourses(status);
    }
}
