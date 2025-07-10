package com.rubenvj.springboot.kanjis.kanjis_springboot.infrastructure.repositories;

import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.repositories.KanjiRepositoryInterface;
import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import com.rubenvj.springboot.kanjis.kanjis_springboot.repositories.KanjiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanjiRepositoryImpl implements KanjiRepositoryInterface {
    
    private final KanjiRepository jpaKanjiRepository;
    
    public KanjiRepositoryImpl(KanjiRepository jpaKanjiRepository) {
        this.jpaKanjiRepository = jpaKanjiRepository;
    }
    
    @Override
    public List<Kanji> findAll() {
        return jpaKanjiRepository.findAll();
    }
    
    @Override
    public Optional<Kanji> findById(Long id) {
        return jpaKanjiRepository.findById(id);
    }
    
    @Override
    public Kanji save(Kanji kanji) {
        return jpaKanjiRepository.save(kanji);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaKanjiRepository.deleteById(id);
    }
    
    @Override
    public boolean existsById(Long id) {
        return jpaKanjiRepository.existsById(id);
    }
    
    @Override
    public long count() {
        return jpaKanjiRepository.count();
    }
    
    @Override
    public Optional<Kanji> findByKanji(String kanji) {
        return jpaKanjiRepository.findByKanji(kanji);
    }
    
    @Override
    public boolean existsByKanji(String kanji) {
        return jpaKanjiRepository.existsByKanji(kanji);
    }
    
    @Override
    public List<Kanji> findBySignificadoEspanolContainingIgnoreCase(String significado) {
        return jpaKanjiRepository.findBySignificadoEspanolContainingIgnoreCase(significado);
    }
    
    @Override
    public List<Kanji> findByLecturaKunContainingIgnoreCase(String lecturaKun) {
        return jpaKanjiRepository.findByLecturaKunContainingIgnoreCase(lecturaKun);
    }
    
    @Override
    public List<Kanji> findByLecturaOnContainingIgnoreCase(String lecturaOn) {
        return jpaKanjiRepository.findByLecturaOnContainingIgnoreCase(lecturaOn);
    }
    
    @Override
    public List<Kanji> findByNivelJlpt(String nivelJlpt) {
        return jpaKanjiRepository.findByNivelJlpt(nivelJlpt);
    }
    
    @Override
    public List<Kanji> findByGradoEscolar(Integer gradoEscolar) {
        return jpaKanjiRepository.findByGradoEscolar(gradoEscolar);
    }
    
    @Override
    public List<Kanji> findByNumeroTrazos(Integer numeroTrazos) {
        return jpaKanjiRepository.findByNumeroTrazos(numeroTrazos);
    }
    
    @Override
    public List<Kanji> findByNumeroTrazosBetween(Integer min, Integer max) {
        return jpaKanjiRepository.findByNumeroTrazosBetween(min, max);
    }
    
    @Override
    public List<Kanji> findByRadicalPrincipal(String radical) {
        return jpaKanjiRepository.findByRadicalPrincipal(radical);
    }
    
    @Override
    public List<Kanji> findAllByOrderByFrecuenciaUsoAsc() {
        return jpaKanjiRepository.findAllByOrderByFrecuenciaUsoAsc();
    }
    
    @Override
    public List<Kanji> findRandomKanjis(Integer limite) {
        return jpaKanjiRepository.findRandomKanjis(limite);
    }
    
    @Override
    public long countByNivelJlpt(String nivelJlpt) {
        return jpaKanjiRepository.countByNivelJlpt(nivelJlpt);
    }
    
    @Override
    public List<Kanji> buscarPorCriterios(String significado, String nivelJlpt, Integer gradoEscolar) {
        return jpaKanjiRepository.buscarPorCriterios(significado, nivelJlpt, gradoEscolar);
    }
}
