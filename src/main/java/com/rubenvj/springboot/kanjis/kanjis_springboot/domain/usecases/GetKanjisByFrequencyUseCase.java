package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para obtener kanjis ordenados por frecuencia de uso
 */
@Service
public class GetKanjisByFrequencyUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetKanjisByFrequencyUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute() {
        return kanjiRepository.findAllByOrderByFrecuenciaUsoAsc();
    }
}
