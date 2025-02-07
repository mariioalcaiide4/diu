package com.example.agenda.service.impl;

import com.example.agenda.model.Agenda;
import com.example.agenda.model.AgendaDto;
import com.example.agenda.repository.AgendaRepository;
import com.example.agenda.service.AgendaService;
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
    public List<AgendaDto> getAllTutorials(){
        List<Agenda> agendaList = agendaRepository.findAll();
        return agendaList.stream()
                .map(AgendaMapper::agendaMapperEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AgendaDto> getTutorialById(String id) {
        Optional<Tutorials> tutorialOptional = agendaRepository.findById(id);

        return tutorialOptional.map(TutorialsMapper::tutorialsMapperEntityToDto);
    }

    @Override
    public List<TutorialsDto> findByTitleContaining(String title) {
        List<Tutorials> tutorialOptional = agendaRepository.findByTitleContaining(title);

        return TutorialsMapper.tutorialsListMapperEntityToDto(tutorialOptional);
    }

    @Override
    public List<TutorialsDto> findByPublished() {
        List<Tutorials> publishedTutorials = agendaRepository.findByPublished(true);

        return TutorialsMapper.tutorialsListMapperEntityToDto(publishedTutorials);
    }

    @Override
    public TutorialsDto save(TutorialsDto tutorialDto) {
        Tutorials tutorials = TutorialsMapper.tutorialsMapperDtoToEntity(tutorialDto);
        Tutorials savedTutorialEntity = agendaRepository.save(tutorials);
        return TutorialsMapper.tutorialsMapperEntityToDto(savedTutorialEntity);
    }

    @Override
    public TutorialsDto updateTutorial(TutorialsDto tutorial) {
        Optional<Tutorials> existingTutorialOptional = agendaRepository.findById(tutorial.getId());

        if (existingTutorialOptional.isPresent()) {
            Tutorials existingTutorial = existingTutorialOptional.get();
            existingTutorial.setTitle(tutorial.getTitle());
            existingTutorial.setDescription(tutorial.getDescription());
            existingTutorial.setPublished(tutorial.getPublished());

            Tutorials updatedTutorial = agendaRepository.save(existingTutorial);

            return TutorialsMapper.tutorialsMapperEntityToDto(updatedTutorial);
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity deleteTutorial(String id) {
        try {
            Optional<Tutorials> existingTutorialOptional = agendaRepository.findById(id);
            if (existingTutorialOptional.isPresent()) {
                agendaRepository.deleteById(id);
                return ResponseEntity.ok("Tutorial eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutorial no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el tutorial");
        }
    }

    @Override
    public ResponseEntity deleteAllTutorials() {
        agendaRepository.deleteAll();
        ResponseEntity.ok("Tutorial eliminado exitosamente");
        return ResponseEntity.ok().build();
    }



}

