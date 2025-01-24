package com.example.tutorials.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder

public class TutorialDto {

    private String id;
    private String title;
    private String description;
    private Boolean published;


}
