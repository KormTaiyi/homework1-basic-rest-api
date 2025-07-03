package com.example.basicrest.dto;

public record CourseResponse(
        String code,
        String title,
        Double price,
        Boolean status
) {
}
