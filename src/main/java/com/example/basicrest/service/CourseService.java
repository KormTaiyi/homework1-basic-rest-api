// CourseService.java
package com.example.basicrest.service;

import com.example.basicrest.dto.CourseResponseDto;
import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAllCourses(Boolean status);
    List<CourseResponseDto> getCourses(Boolean status, String title);
    CourseResponseDto getCourseById(String id);
    CourseResponseDto getCourseByCode(String code);
}