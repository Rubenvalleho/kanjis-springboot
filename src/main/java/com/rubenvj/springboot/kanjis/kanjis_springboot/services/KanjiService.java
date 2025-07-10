package com.rubenvj.springboot.kanjis.kanjis_springboot.services;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import com.rubenvj.springboot.kanjis.kanjis_springboot.repositories.KanjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanjiService {
    
    @Autowired
    private KanjiRepository kanjiRepository;
    
    public List<Kanji> obtenerTodosLosKanjis() {
        return kanjiRepository.findAll();
    }
    
    public Optional<Kanji> obtenerKanjiPorId(Long id) {
        return kanjiRepository.findById(id);
    }
    
    public Optional<Kanji> obtenerKanjiPorCaracter(String kanji) {
        return kanjiRepository.findByKanji(kanji);
    }
    
    public Kanji crearKanji(Kanji kanji) {
        if (kanji.getKanji() == null || kanji.getKanji().trim().isEmpty()) {
            throw new IllegalArgumentException("El kanji es obligatorio");
        }
        
        if (kanji.getKanji().length() != 1) {
            throw new IllegalArgumentException("El kanji debe ser un solo carácter");
        }
        
        if (kanji.getSignificadoEspanol() == null || kanji.getSignificadoEspanol().trim().isEmpty()) {
            throw new IllegalArgumentException("El significado en español es obligatorio");
        }
        
        if (kanjiRepository.existsByKanji(kanji.getKanji())) {
            throw new IllegalArgumentException("Ya existe un kanji con ese carácter");
        }
        
        return kanjiRepository.save(kanji);
    }
    
    public Kanji actualizarKanji(Long id, Kanji kanjiActualizado) {
        Optional<Kanji> kanjiExistente = kanjiRepository.findById(id);
        
        if (kanjiExistente.isEmpty()) {
            throw new IllegalArgumentException("Kanji no encontrado con ID: " + id);
        }
        
        Kanji kanji = kanjiExistente.get();
        
        if (kanjiActualizado.getKanji() != null) {
            if (kanjiActualizado.getKanji().length() != 1) {
                throw new IllegalArgumentException("El kanji debe ser un solo carácter");
            }
            Optional<Kanji> kanjiConCaracter = kanjiRepository.findByKanji(kanjiActualizado.getKanji());
            if (kanjiConCaracter.isPresent() && !kanjiConCaracter.get().getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe otro kanji con ese carácter");
            }
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
        
        return kanjiRepository.save(kanji);
    }
    
    public void eliminarKanji(Long id) {
        if (!kanjiRepository.existsById(id)) {
            throw new IllegalArgumentException("Kanji no encontrado con ID: " + id);
        }
        kanjiRepository.deleteById(id);
    }
    
    public List<Kanji> buscarPorSignificado(String significado) {
        return kanjiRepository.findBySignificadoEspanolContainingIgnoreCase(significado);
    }
    
    public List<Kanji> buscarPorLecturaKun(String lecturaKun) {
        return kanjiRepository.findByLecturaKunContainingIgnoreCase(lecturaKun);
    }
    
    public List<Kanji> buscarPorLecturaOn(String lecturaOn) {
        return kanjiRepository.findByLecturaOnContainingIgnoreCase(lecturaOn);
    }
    
    public List<Kanji> buscarPorNivelJlpt(String nivelJlpt) {
        return kanjiRepository.findByNivelJlpt(nivelJlpt);
    }
    
    public List<Kanji> buscarPorGradoEscolar(Integer gradoEscolar) {
        return kanjiRepository.findByGradoEscolar(gradoEscolar);
    }
    
    public List<Kanji> buscarPorNumeroTrazos(Integer numeroTrazos) {
        return kanjiRepository.findByNumeroTrazos(numeroTrazos);
    }
    
    public List<Kanji> buscarPorRangoTrazos(Integer min, Integer max) {
        return kanjiRepository.findByNumeroTrazosBetween(min, max);
    }
    
    public List<Kanji> buscarPorRadical(String radical) {
        return kanjiRepository.findByRadicalPrincipal(radical);
    }
    
    public List<Kanji> obtenerKanjisPorFrecuencia() {
        return kanjiRepository.findAllByOrderByFrecuenciaUsoAsc();
    }
    
    public List<Kanji> buscarPorCriterios(String significado, String nivelJlpt, Integer gradoEscolar) {
        return kanjiRepository.buscarPorCriterios(significado, nivelJlpt, gradoEscolar);
    }
    
    public List<Kanji> obtenerKanjisAleatorios(Integer limite) {
        if (limite == null || limite <= 0) {
            limite = 10;
        }
        if (limite > 50) {
            limite = 50;
        }
        return kanjiRepository.findRandomKanjis(limite);
    }
    
    public long contarPorNivelJlpt(String nivelJlpt) {
        return kanjiRepository.countByNivelJlpt(nivelJlpt);
    }
    
    public java.util.Map<String, Object> obtenerEstadisticas() {
        java.util.Map<String, Object> estadisticas = new java.util.HashMap<>();
        
        estadisticas.put("totalKanjis", kanjiRepository.count());
        estadisticas.put("kanjisPorNivel", java.util.Map.of(
            "N5", contarPorNivelJlpt("N5"),
            "N4", contarPorNivelJlpt("N4"),
            "N3", contarPorNivelJlpt("N3"),
            "N2", contarPorNivelJlpt("N2"),
            "N1", contarPorNivelJlpt("N1")
        ));
        
        return estadisticas;
    }
}
