package com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;

import java.util.List;
import java.util.Optional;

/**
 * Interface del repositorio de Kanji para la capa de dominio
 * Define las operaciones de persistencia sin depender de la implementación
 */
public interface KanjiRepositoryInterface {
    
    // Operaciones CRUD básicas
    List<Kanji> findAll();
    Optional<Kanji> findById(Long id);
    Kanji save(Kanji kanji);
    void deleteById(Long id);
    boolean existsById(Long id);
    long count();
    
    // Búsquedas específicas
    Optional<Kanji> findByKanji(String kanji);
    boolean existsByKanji(String kanji);
    List<Kanji> findBySignificadoEspanolContainingIgnoreCase(String significado);
    List<Kanji> findByLecturaKunContainingIgnoreCase(String lecturaKun);
    List<Kanji> findByLecturaOnContainingIgnoreCase(String lecturaOn);
    List<Kanji> findByNivelJlpt(String nivelJlpt);
    List<Kanji> findByGradoEscolar(Integer gradoEscolar);
    List<Kanji> findByNumeroTrazos(Integer numeroTrazos);
    List<Kanji> findByNumeroTrazosBetween(Integer min, Integer max);
    List<Kanji> findByRadicalPrincipal(String radical);
    List<Kanji> findAllByOrderByFrecuenciaUsoAsc();
    List<Kanji> findRandomKanjis(Integer limite);
    long countByNivelJlpt(String nivelJlpt);
    List<Kanji> buscarPorCriterios(String significado, String nivelJlpt, Integer gradoEscolar);
}
