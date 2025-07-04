package com.example.basicrest.controller;

import com.example.basicrest.dto.CourseResponseDto;
import com.example.basicrest.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getCourses(@RequestParam(required = false) Boolean status)
    {
        return courseService.getAllCourses(status);
    }
    @GetMapping("/{id}")
    public CourseResponseDto getById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/code")
    public CourseResponseDto getByCode(@RequestParam String code) {
        return courseService.getCourseByCode(code);
    }

    @GetMapping("/search")
    public List<CourseResponseDto> getByStatusAndTitle(@RequestParam Boolean status, @RequestParam String title) {
        return courseService.getCourses(status, title);
    }

}