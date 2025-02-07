package com.example.agenda.controller.impl;

import com.example.agenda.controller.AgendaAPI;
import com.example.agenda.model.ContactoDto;
import com.example.agenda.repository.AgendaRepository;
import com.example.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AgendaController implements AgendaAPI {
    @Autowired
    private AgendaService agendaService;
    @Autowired
    private AgendaRepository agendaRepository;
    @Override
    @GetMapping("/agenda")
    public List<ContactoDto> getAllContacts(){return agendaService.getAllContacts();}

    @Override
    @GetMapping("/agenda/{dni}")
    public Optional<ContactoDto> getContactById(@PathVariable String dni) {
        return agendaService.getContactById(dni);
    }

    @Override
    @GetMapping("/agenda/nombre/{nombre}")
    public List<ContactoDto> findByNameContaining(@PathVariable String nombre) {
        return agendaService.findByNameContaining(nombre);
    }

    @Override
    @PostMapping("/agenda")
    public ContactoDto guardar(@RequestBody ContactoDto contactoDto) {
        return agendaService.guardar(contactoDto);
    }

    @Override
    @PutMapping("/agenda/{dni}")
    public ContactoDto actualizarContacto(@RequestBody ContactoDto contacto,@PathVariable String dni) {
        return agendaService.actualizarContacto(contacto);
    }

    @Override
    @DeleteMapping("/agenda/{dni}")
    public ResponseEntity borrarContacto(@PathVariable String dni) {
        return agendaService.borrarContacto(dni);
    }

    @Override
    @DeleteMapping("/tutorials")
    public ResponseEntity borrarAllContacts() {
        return agendaService.borrarAllContacts();
    }
}
