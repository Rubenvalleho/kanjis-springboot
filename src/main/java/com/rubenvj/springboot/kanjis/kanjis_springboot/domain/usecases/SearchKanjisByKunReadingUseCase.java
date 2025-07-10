package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por lectura kun
 */
@Service
public class SearchKanjisByKunReadingUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByKunReadingUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String lecturaKun) {
        if (lecturaKun == null || lecturaKun.trim().isEmpty()) {
            return List.of();
        }
        return kanjiRepository.findByLecturaKunContainingIgnoreCase(lecturaKun.trim());
    }
}
