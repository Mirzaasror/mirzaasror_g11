package com.example.studen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {
    private int id;
    private String full_name;
    private String course_name;
    private String mentor_name;
    private int course;

}
