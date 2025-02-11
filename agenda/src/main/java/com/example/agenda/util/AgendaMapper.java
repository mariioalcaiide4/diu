package com.example.agenda.util;

import com.example.agenda.model.Contacto;
import com.example.agenda.model.ContactoDto;

import java.util.List;
import java.util.stream.Collectors;

public class AgendaMapper {

    // Convierte un DTO a una entidad
    public static Contacto agendaMapperDtoToEntity(ContactoDto contactoDto) {
        return Contacto.builder()
                .dni(contactoDto.getDni())
                .nombre(contactoDto.getNombre())
                .apellido(contactoDto.getApellido())
                .edad(contactoDto.getEdad())
                .telefono(contactoDto.getTelefono())
                .build();
    }

    // Convierte una entidad a un DTO
    public static ContactoDto agendaMapperEntityToDto(Contacto contacto) {
        return ContactoDto.builder()
                .dni(contacto.getDni())
                .nombre(contacto.getNombre())
                .apellido(contacto.getApellido())
                .edad(contacto.getEdad())
                .telefono(contacto.getTelefono())
                .build();
    }

    // Convierte una lista de DTOs a una lista de entidades
    public static List<Contacto> agendaListMapperDtoToEntity(List<ContactoDto> contactoDtoList) {
        return contactoDtoList.stream()
                .map(AgendaMapper::agendaMapperDtoToEntity)
                .collect(Collectors.toList());
    }

    // Convierte una lista de entidades a una lista de DTOs
    public static List<ContactoDto> agendaListMapperEntityToDto(List<Contacto> agendaList) {
        return agendaList.stream()
                .map(AgendaMapper::agendaMapperEntityToDto)
                .collect(Collectors.toList());
    }
}
