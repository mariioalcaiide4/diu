package com.example.agenda.controller;

import com.example.agenda.model.ContactoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AgendaAPI {

    List<ContactoDto> getAllContacts(); //funciona
    Optional<ContactoDto> findByDni(String dni); //funciona
    List<ContactoDto> findByNombreContaining(String nombre);
    ContactoDto guardar(ContactoDto contactoDto); //funciona
    ContactoDto actualizarContacto(ContactoDto contactoDto, String dni); //funciona
    ResponseEntity borrarContacto(String dni); //funciona
    ResponseEntity borrarAllContacts(); //funciona

}
