package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Caso de uso para actualizar un kanji existente
 */
@Service
public class UpdateKanjiUseCase {
    
    private final KanjiRepositoryInterface kanjiRepository;
    
    public UpdateKanjiUseCase(KanjiRepositoryInterface kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }
    
    public Kanji execute(Long id, Kanji kanjiActualizado) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        Optional<Kanji> kanjiExistente = kanjiRepository.findById(id);
        if (kanjiExistente.isEmpty()) {
            throw new IllegalArgumentException("Kanji no encontrado con ID: " + id);
        }
        
        Kanji kanji = kanjiExistente.get();
        updateKanjiFields(kanji, kanjiActualizado, id);
        
        return kanjiRepository.save(kanji);
    }
    
    private void updateKanjiFields(Kanji kanji, Kanji kanjiActualizado, Long id) {
        if (kanjiActualizado.getKanji() != null) {
            validateKanjiCharacter(kanjiActualizado.getKanji(), id);
            kanji.setKanji(kanjiActualizado.getKanji());
        }
        
        if (kanjiActualizado.getLecturaKun() != null) {
            kanji.setLecturaKun(kanjiActualizado.getLecturaKun());
        }
        
        if (kanjiActualizado.getLecturaOn() != null) {
            kanji.setLecturaOn(kanjiActualizado.getLecturaOn());
        }
        
        if (kanjiActualizado.getSignificadoEspanol() != null) {
            kanji.setSignificadoEspanol(kanjiActualizado.getSignificadoEspanol());
        }
        
        if (kanjiActualizado.getNumeroTrazos() != null) {
            kanji.setNumeroTrazos(kanjiActualizado.getNumeroTrazos());
        }
        
        if (kanjiActualizado.getNivelJlpt() != null) {
            kanji.setNivelJlpt(kanjiActualizado.getNivelJlpt());
        }
        
        if (kanjiActualizado.getGradoEscolar() != null) {
            kanji.setGradoEscolar(kanjiActualizado.getGradoEscolar());
        }
        
        if (kanjiActualizado.getFrecuenciaUso() != null) {
            kanji.setFrecuenciaUso(kanjiActualizado.getFrecuenciaUso());
        }
        
        if (kanjiActualizado.getEjemplosPalabras() != null) {
            kanji.setEjemplosPalabras(kanjiActualizado.getEjemplosPalabras());
        }
        
        if (kanjiActualizado.getRadicalPrincipal() != null) {
            kanji.setRadicalPrincipal(kanjiActualizado.getRadicalPrincipal());
        }
    }
    
    private void validateKanjiCharacter(String kanjiChar, Long id) {
        if (kanjiChar.length() != 1) {
            throw new IllegalArgumentException("El kanji debe ser un solo carácter");
        }
        
        // Verificar que el nuevo kanji no esté en uso por otro registro
        Optional<Kanji> kanjiConCaracter = kanjiRepository.findByKanji(kanjiChar);
        if (kanjiConCaracter.isPresent() && !kanjiConCaracter.get().getId().equals(id)) {
            throw new IllegalArgumentException("Ya existe otro kanji con ese carácter");
        }
    }
}
