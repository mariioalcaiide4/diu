package com.example.agenda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contacto {

    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer telefono;

}