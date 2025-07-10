package com.rubenvj.springboot.kanjis.kanjis_springboot.repositories;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {
    
    Optional<Kanji> findByKanji(String kanji);
    
    List<Kanji> findBySignificadoEspanolContainingIgnoreCase(String significado);
    
    List<Kanji> findByLecturaKunContainingIgnoreCase(String lecturaKun);
    
    List<Kanji> findByLecturaOnContainingIgnoreCase(String lecturaOn);
    
    List<Kanji> findByNivelJlpt(String nivelJlpt);
    
    List<Kanji> findByGradoEscolar(Integer gradoEscolar);
    
    List<Kanji> findByNumeroTrazos(Integer numeroTrazos);
    
    List<Kanji> findByNumeroTrazosBetween(Integer min, Integer max);
    
    List<Kanji> findByRadicalPrincipal(String radical);
    
    List<Kanji> findAllByOrderByFrecuenciaUsoAsc();
    
    @Query("SELECT k FROM Kanji k WHERE k.frecuenciaUso IS NOT NULL ORDER BY k.frecuenciaUso ASC")
    List<Kanji> findTopByFrecuenciaUso();
    
    @Query("SELECT k FROM Kanji k WHERE " +
           "(:significado IS NULL OR LOWER(k.significadoEspanol) LIKE LOWER(CONCAT('%', :significado, '%'))) AND " +
           "(:nivelJlpt IS NULL OR k.nivelJlpt = :nivelJlpt) AND " +
           "(:gradoEscolar IS NULL OR k.gradoEscolar = :gradoEscolar)")
    List<Kanji> buscarPorCriterios(@Param("significado") String significado,
                                   @Param("nivelJlpt") String nivelJlpt,
                                   @Param("gradoEscolar") Integer gradoEscolar);
    
    @Query(value = "SELECT * FROM kanjis ORDER BY RANDOM() LIMIT :limite", nativeQuery = true)
    List<Kanji> findRandomKanjis(@Param("limite") Integer limite);
    
    long countByNivelJlpt(String nivelJlpt);
    
    boolean existsByKanji(String kanji);
}
