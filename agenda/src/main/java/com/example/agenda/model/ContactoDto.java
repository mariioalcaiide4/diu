package com.example.agenda.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder

public class ContactoDto {

    private String id;
    private String nombre;
    private String description;
    private Boolean published;


}
