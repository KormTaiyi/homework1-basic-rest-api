package com.example.basicrest.service;

import com.example.basicrest.doman.Courses;
import com.example.basicrest.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    List<Courses> courses= new ArrayList<>();
    @Override
    public List<CourseResponseDto> getAllCourses() {
        return List.of();
    }

    @Override
    public List<CourseResponseDto> getCourses(Boolean status, String title) {

        List <Courses> filterCourses = courses.stream().filter(course->course.getStatus().equals(status) && course.getTitle().contains(title))
                .map(course -> CourseResponseDto.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();
        List<CourseResponseDto> courseResponseList = filterCourses.stream().map(course -> CourseResponseDto.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .price(course.getPrice())
                .status(course.getStatus())
                .build()).toList();

        return courseResponseList;
    }

    @Override
    public CourseResponseDto getCourseById(String id) {
        return null;
    }

    @Override
    public CourseResponseDto getCourseByCode(String code) {
        return null;
    }
}
