package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por grado escolar
 */
@Service
public class SearchKanjisByGradeUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByGradeUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(Integer grado) {
        if (grado == null || grado <= 0) {
            return List.of();
        }
        return kanjiRepository.findByGradoEscolar(grado);
    }
}
