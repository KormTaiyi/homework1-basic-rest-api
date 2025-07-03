package com.example.basicrest.doman;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courses {
    private String id;
    private String code;
    private String title;
    private Double price;
    private Boolean status;
}
