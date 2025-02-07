package com.example.agenda.repository;

import com.example.agenda.model.AgendaDto;
import com.example.agenda.model.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AgendaRepository extends MongoRepository<Contacto,String> {
    List<Contacto> findAll();
    Optional<Contacto> getContactById();
    List<Contacto> findByNameContaining(String nombre);
}
