package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Caso de uso para obtener estadísticas de kanjis
 */
@Service
public class GetKanjiStatisticsUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public GetKanjiStatisticsUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public Map<String, Object> execute() {
        Map<String, Object> estadisticas = new HashMap<>();
        
        estadisticas.put("totalKanjis", kanjiRepository.count());
        estadisticas.put("kanjisPorNivel", Map.of(
            "N5", kanjiRepository.countByNivelJlpt("N5"),
            "N4", kanjiRepository.countByNivelJlpt("N4"),
            "N3", kanjiRepository.countByNivelJlpt("N3"),
            "N2", kanjiRepository.countByNivelJlpt("N2"),
            "N1", kanjiRepository.countByNivelJlpt("N1")
        ));
        
        return estadisticas;
    }
}
