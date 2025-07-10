package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para buscar kanjis por radical
 */
@Service
public class SearchKanjisByRadicalUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public SearchKanjisByRadicalUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(String radical) {
        if (radical == null || radical.trim().isEmpty()) {
            return List.of();
        }
        return kanjiRepository.findByRadicalPrincipal(radical.trim());
    }
}
