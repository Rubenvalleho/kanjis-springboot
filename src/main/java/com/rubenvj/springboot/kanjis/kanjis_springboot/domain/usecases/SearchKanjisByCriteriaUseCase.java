package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para búsqueda avanzada de kanjis por múltiples criterios
 */
@Service
public class SearchKanjisByCriteriaUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByCriteriaUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String significado, String jlpt, Integer grado) {
        return kanjiRepository.buscarPorCriterios(significado, jlpt, grado);
    }
}
