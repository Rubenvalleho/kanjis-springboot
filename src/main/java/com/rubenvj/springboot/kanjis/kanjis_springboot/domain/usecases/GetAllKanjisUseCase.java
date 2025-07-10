package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso para obtener todos los kanjis
 */
@Service
public class GetAllKanjisUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetAllKanjisUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public List<Kanji> execute() {
        return kanjiRepository.findAll();
    }
}
