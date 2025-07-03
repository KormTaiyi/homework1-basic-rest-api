package com.example.basicrest.dto;

import lombok.Builder;

@Builder
public record CourseResponseDto(
        String code,
        String title,
        Double price,
        Boolean status
) {
}
