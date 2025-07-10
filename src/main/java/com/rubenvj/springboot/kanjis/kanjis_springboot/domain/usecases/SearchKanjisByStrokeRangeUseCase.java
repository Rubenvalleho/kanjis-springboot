package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por rango de trazos
 */
@Service
public class SearchKanjisByStrokeRangeUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByStrokeRangeUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(Integer min, Integer max) {
        if (min == null || max == null || min <= 0 || max <= 0 || min > max) {
            return List.of();
        }
        return kanjiRepository.findByNumeroTrazosBetween(min, max);
    }
}
