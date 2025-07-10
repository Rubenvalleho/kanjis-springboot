package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para obtener kanjis aleatorios
 */
@Service
public class GetRandomKanjisUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetRandomKanjisUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute(Integer limite) {
        if (limite == null || limite <= 0) {
            limite = 10;
        }
        if (limite > 50) {
            limite = 50; // Límite máximo para evitar sobrecarga
        }
        return kanjiRepository.findRandomKanjis(limite);
    }
}
