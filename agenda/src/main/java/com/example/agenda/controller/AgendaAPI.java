package com.example.agenda.controller;

import com.example.agenda.model.ContactoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AgendaAPI {

    List<ContactoDto> getAllContacts(); //funciona
    Optional<ContactoDto> getContactById(String dni); //funciona
    List<ContactoDto> findByNameContaining(String nombre);
    ContactoDto guardar(ContactoDto contacto); //funciona
    ContactoDto actualizarContacto(ContactoDto contacto); //funciona
    ResponseEntity borrarContacto(String dni); //funciona
    ResponseEntity borrarAllContacts(); //funciona

}
