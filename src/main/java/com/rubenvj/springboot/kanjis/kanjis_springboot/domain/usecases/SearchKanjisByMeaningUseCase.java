package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por significado
 */
@Service
public class SearchKanjisByMeaningUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByMeaningUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String significado) {
        if (significado == null || significado.trim().isEmpty()) {
            return List.of();
        }
        return kanjiRepository.findBySignificadoEspanolContainingIgnoreCase(significado.trim());
    }
}
