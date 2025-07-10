package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Caso de uso para obtener un kanji por ID
 */
@Service
public class GetKanjiByIdUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetKanjiByIdUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public Optional<Kanji> execute(Long id) {
        if (id == null || id <= 0) {
            return Optional.empty();
        }
        return kanjiRepository.findById(id);
    }
}
