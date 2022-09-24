package com.example.studen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    private int id;
    private String full_name;
    private String course_name;
    private int couse;
    private int mentor_id;


}
