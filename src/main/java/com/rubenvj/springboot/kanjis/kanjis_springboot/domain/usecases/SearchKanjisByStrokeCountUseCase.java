package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por número de trazos
 */
@Service
public class SearchKanjisByStrokeCountUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByStrokeCountUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(Integer numeroTrazos) {
        if (numeroTrazos == null || numeroTrazos <= 0) {
            return List.of();
        }
        return kanjiRepository.findByNumeroTrazos(numeroTrazos);
    }
}
