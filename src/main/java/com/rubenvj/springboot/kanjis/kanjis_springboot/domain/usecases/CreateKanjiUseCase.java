package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para crear un nuevo kanji
 */
@Service
public class CreateKanjiUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public CreateKanjiUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public Kanji execute(Kanji kanji) {
        validateKanji(kanji);
        
        // Verificar si ya existe un kanji con ese carácter
        if (kanjiRepository.existsByKanji(kanji.getKanji())) {
            throw new IllegalArgumentException("Ya existe un kanji con ese carácter");
        }
        
        return kanjiRepository.save(kanji);
    }
    
    private void validateKanji(Kanji kanji) {
        if (kanji == null) {
            throw new IllegalArgumentException("El kanji no puede ser nulo");
        }
        
        if (kanji.getKanji() == null || kanji.getKanji().trim().isEmpty()) {
            throw new IllegalArgumentException("El kanji es obligatorio");
        }
        
        if (kanji.getKanji().length() != 1) {
            throw new IllegalArgumentException("El kanji debe ser un solo carácter");
        }
        
        if (kanji.getSignificadoEspanol() == null || kanji.getSignificadoEspanol().trim().isEmpty()) {
            throw new IllegalArgumentException("El significado en español es obligatorio");
        }
    }
}
