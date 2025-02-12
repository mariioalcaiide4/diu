package com.example.agenda.service.impl;

import com.example.agenda.model.Contacto;
import com.example.agenda.model.ContactoDto;
import com.example.agenda.repository.AgendaRepository;
import com.example.agenda.service.AgendaService;
import com.example.agenda.util.AgendaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public List<ContactoDto> getAllContacts(){
        List<Contacto> agendaList = agendaRepository.findAll();
        return agendaList.stream()
                .map(AgendaMapper::agendaMapperEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContactoDto> findByDni(String dni) {
        Optional<Contacto> tutorialOptional = agendaRepository.findById(dni);

        return tutorialOptional.map(AgendaMapper::agendaMapperEntityToDto);
    }

    @Override
    public List<ContactoDto> findByNombreContaining(String nombre) {
        List<Contacto> agendaOptional = agendaRepository.findByNombreContaining(nombre);

        return AgendaMapper.agendaListMapperEntityToDto(agendaOptional);
    }

    @Override
    public ContactoDto guardar(ContactoDto agendaDto) {
        Contacto agenda = AgendaMapper.agendaMapperDtoToEntity(agendaDto);
        Contacto savedAgendaEntity = agendaRepository.save(agenda);
        return AgendaMapper.agendaMapperEntityToDto(savedAgendaEntity);
    }

    @Override
    public ContactoDto actualizarContacto(ContactoDto contactoDto, String dni) {
        Optional<Contacto> existingAgendaOptional = agendaRepository.findById(dni);

        if (existingAgendaOptional.isPresent()) {
            Contacto existingAgenda = existingAgendaOptional.get();
            existingAgenda.setNombre(contactoDto.getNombre());
            existingAgenda.setDni(contactoDto.getDni());
            existingAgenda.setTelefono(contactoDto.getTelefono());
            existingAgenda.setApellido(contactoDto.getApellido());
            existingAgenda.setEdad(contactoDto.getEdad());
            existingAgenda.setEmail(contactoDto.getEmail());
            existingAgenda.setDireccion(contactoDto.getDireccion());

            Contacto updatedAgenda = agendaRepository.save(existingAgenda);
            return AgendaMapper.agendaMapperEntityToDto(updatedAgenda);
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity borrarContacto(String id) {
        try {
            Optional<Contacto> existingAgendaOptional = agendaRepository.findById(id);
            if (existingAgendaOptional.isPresent()) {
                agendaRepository.deleteById(id);
                return ResponseEntity.ok("Contacto eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contacto no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el contacto");
        }
    }

    @Override
    public ResponseEntity borrarAllContacts() {
        agendaRepository.deleteAll();
        return ResponseEntity.ok().body("Todos los contactos eliminados exitosamente");
    }


}

