package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por lectura on
 */
@Service
public class SearchKanjisByOnReadingUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByOnReadingUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String lecturaOn) {
        if (lecturaOn == null || lecturaOn.trim().isEmpty()) {
            return List.of();
        }
        return kanjiRepository.findByLecturaOnContainingIgnoreCase(lecturaOn.trim());
    }
}
