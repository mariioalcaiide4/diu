package com.example.agenda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.swing.plaf.synth.SynthIcon;

@Getter
@Setter
@Builder
public class Contacto {

    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer telefono;
    private String email;
    private String direccion;

}