package com.example.tutorials.repository;

import com.example.tutorials.model.TutorialsVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutorialsRepository extends MongoRepository {

    List<TutorialsVO> findByPublishedTrue();
    List<TutorialsVO> findAll();
    Optional<TutorialsVO> getTutorialById();
    List<TutorialsVO> findByTitleContaining(String title);
    List<TutorialsVO> findByPublished(boolean published);

}
