package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Caso de uso para obtener un kanji por su carácter
 */
@Service
public class GetKanjiByCharacterUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetKanjiByCharacterUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public Optional<Kanji> execute(String kanji) {
        if (kanji == null || kanji.trim().isEmpty()) {
            return Optional.empty();
        }
        return kanjiRepository.findByKanji(kanji.trim());
    }
}
