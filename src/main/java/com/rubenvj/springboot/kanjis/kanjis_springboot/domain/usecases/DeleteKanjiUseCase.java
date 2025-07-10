package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para eliminar un kanji
 */
@Service
public class DeleteKanjiUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public DeleteKanjiUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public void execute(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        if (!kanjiRepository.existsById(id)) {
            throw new IllegalArgumentException("Kanji no encontrado con ID: " + id);
        }
        
        kanjiRepository.deleteById(id);
    }
}
