package com.rubenvj.springboot.kanjis.kanjis_springboot.repositories;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para Kanji - Maneja el acceso a datos de kanjis
 */
@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {
    
    /**
     * Busca un kanji por su carácter
     */
    Optional<Kanji> findByKanji(String kanji);
    
    /**
     * Busca kanjis por significado (contiene la palabra)
     */
    List<Kanji> findBySignificadoEspanolContainingIgnoreCase(String significado);
    
    /**
     * Busca kanjis por lectura kun
     */
    List<Kanji> findByLecturaKunContainingIgnoreCase(String lecturaKun);
    
    /**
     * Busca kanjis por lectura on
     */
    List<Kanji> findByLecturaOnContainingIgnoreCase(String lecturaOn);
    
    /**
     * Busca kanjis por nivel JLPT
     */
    List<Kanji> findByNivelJlpt(String nivelJlpt);
    
    /**
     * Busca kanjis por grado escolar
     */
    List<Kanji> findByGradoEscolar(Integer gradoEscolar);
    
    /**
     * Busca kanjis por número de trazos
     */
    List<Kanji> findByNumeroTrazos(Integer numeroTrazos);
    
    /**
     * Busca kanjis por rango de trazos
     */
    List<Kanji> findByNumeroTrazosBetween(Integer min, Integer max);
    
    /**
     * Busca kanjis por radical principal
     */
    List<Kanji> findByRadicalPrincipal(String radical);
    
    /**
     * Busca kanjis ordenados por frecuencia de uso
     */
    List<Kanji> findAllByOrderByFrecuenciaUsoAsc();
    
    /**
     * Busca kanjis más frecuentes (límite)
     */
    @Query("SELECT k FROM Kanji k WHERE k.frecuenciaUso IS NOT NULL ORDER BY k.frecuenciaUso ASC")
    List<Kanji> findTopByFrecuenciaUso();
    
    /**
     * Busca kanjis por múltiples criterios
     */
    @Query("SELECT k FROM Kanji k WHERE " +
           "(:significado IS NULL OR LOWER(k.significadoEspanol) LIKE LOWER(CONCAT('%', :significado, '%'))) AND " +
           "(:nivelJlpt IS NULL OR k.nivelJlpt = :nivelJlpt) AND " +
           "(:gradoEscolar IS NULL OR k.gradoEscolar = :gradoEscolar)")
    List<Kanji> buscarPorCriterios(@Param("significado") String significado,
                                   @Param("nivelJlpt") String nivelJlpt,
                                   @Param("gradoEscolar") Integer gradoEscolar);
    
    /**
     * Busca kanjis aleatorios para práctica
     */
    @Query(value = "SELECT * FROM kanjis ORDER BY RANDOM() LIMIT :limite", nativeQuery = true)
    List<Kanji> findRandomKanjis(@Param("limite") Integer limite);
    
    /**
     * Cuenta kanjis por nivel JLPT
     */
    long countByNivelJlpt(String nivelJlpt);
    
    /**
     * Verifica si existe un kanji
     */
    boolean existsByKanji(String kanji);
}
