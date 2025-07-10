package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por nivel JLPT
 */
@Service
public class SearchKanjisByJlptLevelUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByJlptLevelUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String nivelJlpt) {
        if (nivelJlpt == null || nivelJlpt.trim().isEmpty()) {
            return List.of();
        }
        return kanjiRepository.findByNivelJlpt(nivelJlpt.trim());
    }
}
