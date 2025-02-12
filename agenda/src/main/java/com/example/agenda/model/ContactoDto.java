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

    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer telefono;
    private String email;
    private String direccion;

}
