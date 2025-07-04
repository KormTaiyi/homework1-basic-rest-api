package com.example.basicrest.service;

import com.example.basicrest.doman.Courses;
import com.example.basicrest.dto.CourseResponseDto;
import com.example.basicrest.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    public List<CourseResponseDto> getAllCourses() {
        return mapToDtoList(courseRepository.getCourses());
    }

    @Override
    public List<CourseResponseDto> getAllCourses(Boolean status) {
        List<Courses> courseList = courseRepository.getCourses();
        if (status != null) {
            courseList = courseList.stream()
                    .filter(course -> course.getStatus().equals(status))
                    .toList();
        }
        return mapToDtoList(courseList);
    }

    @Override
    public List<CourseResponseDto> getCourses(Boolean status, String title) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(status) &&
                        course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public CourseResponseDto getCourseById(String id) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .map(this::mapToDto)
                .orElse(null);
    }

    @Override
    public CourseResponseDto getCourseByCode(String code) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .map(this::mapToDto)
                .orElse(null);
    }

    // === Helper methods ===
    private CourseResponseDto mapToDto(Courses course) {
        return CourseResponseDto.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .price(course.getPrice())
                .status(course.getStatus())
                .build();
    }

    private List<CourseResponseDto> mapToDtoList(List<Courses> courseList) {
        return courseList.stream()
                .map(this::mapToDto)
                .toList();
    }
}
