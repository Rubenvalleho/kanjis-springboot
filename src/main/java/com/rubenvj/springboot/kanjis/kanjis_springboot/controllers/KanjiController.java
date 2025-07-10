package com.rubenvj.springboot.kanjis.kanjis_springboot.controllers;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import com.rubenvj.springboot.kanjis.kanjis_springboot.domain.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/kanjis")
@CrossOrigin(origins = "*")
public class KanjiController {
    
    private final GetAllKanjisUseCase getAllKanjisUseCase;
    private final GetKanjiByIdUseCase getKanjiByIdUseCase;
    private final GetKanjiByCharacterUseCase getKanjiByCharacterUseCase;
    private final CreateKanjiUseCase createKanjiUseCase;
    private final UpdateKanjiUseCase updateKanjiUseCase;
    private final DeleteKanjiUseCase deleteKanjiUseCase;
    private final SearchKanjisByMeaningUseCase searchKanjisByMeaningUseCase;
    private final SearchKanjisByKunReadingUseCase searchKanjisByKunReadingUseCase;
    private final SearchKanjisByOnReadingUseCase searchKanjisByOnReadingUseCase;
    private final SearchKanjisByJlptLevelUseCase searchKanjisByJlptLevelUseCase;
    private final SearchKanjisByGradeUseCase searchKanjisByGradeUseCase;
    private final SearchKanjisByStrokeCountUseCase searchKanjisByStrokeCountUseCase;
    private final SearchKanjisByStrokeRangeUseCase searchKanjisByStrokeRangeUseCase;
    private final SearchKanjisByRadicalUseCase searchKanjisByRadicalUseCase;
    private final GetKanjisByFrequencyUseCase getKanjisByFrequencyUseCase;
    private final GetRandomKanjisUseCase getRandomKanjisUseCase;
    private final SearchKanjisByCriteriaUseCase searchKanjisByCriteriaUseCase;
    private final GetKanjiStatisticsUseCase getKanjiStatisticsUseCase;
    
    public KanjiController(
            GetAllKanjisUseCase getAllKanjisUseCase,
            GetKanjiByIdUseCase getKanjiByIdUseCase,
            GetKanjiByCharacterUseCase getKanjiByCharacterUseCase,
            CreateKanjiUseCase createKanjiUseCase,
            UpdateKanjiUseCase updateKanjiUseCase,
            DeleteKanjiUseCase deleteKanjiUseCase,
            SearchKanjisByMeaningUseCase searchKanjisByMeaningUseCase,
            SearchKanjisByKunReadingUseCase searchKanjisByKunReadingUseCase,
            SearchKanjisByOnReadingUseCase searchKanjisByOnReadingUseCase,
            SearchKanjisByJlptLevelUseCase searchKanjisByJlptLevelUseCase,
            SearchKanjisByGradeUseCase searchKanjisByGradeUseCase,
            SearchKanjisByStrokeCountUseCase searchKanjisByStrokeCountUseCase,
            SearchKanjisByStrokeRangeUseCase searchKanjisByStrokeRangeUseCase,
            SearchKanjisByRadicalUseCase searchKanjisByRadicalUseCase,
            GetKanjisByFrequencyUseCase getKanjisByFrequencyUseCase,
            GetRandomKanjisUseCase getRandomKanjisUseCase,
            SearchKanjisByCriteriaUseCase searchKanjisByCriteriaUseCase,
            GetKanjiStatisticsUseCase getKanjiStatisticsUseCase
    ) {
        this.getAllKanjisUseCase = getAllKanjisUseCase;
        this.getKanjiByIdUseCase = getKanjiByIdUseCase;
        this.getKanjiByCharacterUseCase = getKanjiByCharacterUseCase;
        this.createKanjiUseCase = createKanjiUseCase;
        this.updateKanjiUseCase = updateKanjiUseCase;
        this.deleteKanjiUseCase = deleteKanjiUseCase;
        this.searchKanjisByMeaningUseCase = searchKanjisByMeaningUseCase;
        this.searchKanjisByKunReadingUseCase = searchKanjisByKunReadingUseCase;
        this.searchKanjisByOnReadingUseCase = searchKanjisByOnReadingUseCase;
        this.searchKanjisByJlptLevelUseCase = searchKanjisByJlptLevelUseCase;
        this.searchKanjisByGradeUseCase = searchKanjisByGradeUseCase;
        this.searchKanjisByStrokeCountUseCase = searchKanjisByStrokeCountUseCase;
        this.searchKanjisByStrokeRangeUseCase = searchKanjisByStrokeRangeUseCase;
        this.searchKanjisByRadicalUseCase = searchKanjisByRadicalUseCase;
        this.getKanjisByFrequencyUseCase = getKanjisByFrequencyUseCase;
        this.getRandomKanjisUseCase = getRandomKanjisUseCase;
        this.searchKanjisByCriteriaUseCase = searchKanjisByCriteriaUseCase;
        this.getKanjiStatisticsUseCase = getKanjiStatisticsUseCase;
    }
    
    @GetMapping
    public ResponseEntity<List<Kanji>> obtenerTodosLosKanjis() {
        try {
            List<Kanji> kanjis = getAllKanjisUseCase.execute();
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Kanji> obtenerKanjiPorId(@PathVariable Long id) {
        try {
            Optional<Kanji> kanji = getKanjiByIdUseCase.execute(id);
            if (kanji.isPresent()) {
                return ResponseEntity.ok(kanji.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/caracter/{kanji}")
    public ResponseEntity<Kanji> obtenerKanjiPorCaracter(@PathVariable String kanji) {
        try {
            Optional<Kanji> kanjiResult = getKanjiByCharacterUseCase.execute(kanji);
            if (kanjiResult.isPresent()) {
                return ResponseEntity.ok(kanjiResult.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Kanji> crearKanji(@RequestBody Kanji kanji) {
        try {
            Kanji kanjiCreado = createKanjiUseCase.execute(kanji);
            return ResponseEntity.status(HttpStatus.CREATED).body(kanjiCreado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Kanji> actualizarKanji(@PathVariable Long id, @RequestBody Kanji kanji) {
        try {
            Kanji kanjiActualizado = updateKanjiUseCase.execute(id, kanji);
            return ResponseEntity.ok(kanjiActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarKanji(@PathVariable Long id) {
        try {
            deleteKanjiUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar/significado")
    public ResponseEntity<List<Kanji>> buscarPorSignificado(@RequestParam String q) {
        try {
            List<Kanji> kanjis = searchKanjisByMeaningUseCase.execute(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar/kun")
    public ResponseEntity<List<Kanji>> buscarPorLecturaKun(@RequestParam String q) {
        try {
            List<Kanji> kanjis = searchKanjisByKunReadingUseCase.execute(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar/on")
    public ResponseEntity<List<Kanji>> buscarPorLecturaOn(@RequestParam String q) {
        try {
            List<Kanji> kanjis = searchKanjisByOnReadingUseCase.execute(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/jlpt/{nivel}")
    public ResponseEntity<List<Kanji>> buscarPorNivelJlpt(@PathVariable String nivel) {
        try {
            List<Kanji> kanjis = searchKanjisByJlptLevelUseCase.execute(nivel);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/grado/{grado}")
    public ResponseEntity<List<Kanji>> buscarPorGradoEscolar(@PathVariable Integer grado) {
        try {
            List<Kanji> kanjis = searchKanjisByGradeUseCase.execute(grado);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/trazos/{numero}")
    public ResponseEntity<List<Kanji>> buscarPorNumeroTrazos(@PathVariable Integer numero) {
        try {
            List<Kanji> kanjis = searchKanjisByStrokeCountUseCase.execute(numero);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/trazos/rango")
    public ResponseEntity<List<Kanji>> buscarPorRangoTrazos(@RequestParam Integer min, @RequestParam Integer max) {
        try {
            List<Kanji> kanjis = searchKanjisByStrokeRangeUseCase.execute(min, max);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/radical/{radical}")
    public ResponseEntity<List<Kanji>> buscarPorRadical(@PathVariable String radical) {
        try {
            List<Kanji> kanjis = searchKanjisByRadicalUseCase.execute(radical);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/frecuencia")
    public ResponseEntity<List<Kanji>> obtenerKanjisPorFrecuencia() {
        try {
            List<Kanji> kanjis = getKanjisByFrequencyUseCase.execute();
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/aleatorios")
    public ResponseEntity<List<Kanji>> obtenerKanjisAleatorios(@RequestParam(defaultValue = "10") Integer limite) {
        try {
            List<Kanji> kanjis = getRandomKanjisUseCase.execute(limite);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/buscar/avanzado")
    public ResponseEntity<List<Kanji>> buscarPorCriterios(
            @RequestParam(required = false) String significado,
            @RequestParam(required = false) String jlpt,
            @RequestParam(required = false) Integer grado) {
        try {
            List<Kanji> kanjis = searchKanjisByCriteriaUseCase.execute(significado, jlpt, grado);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Object>> obtenerEstadisticas() {
        try {
            Map<String, Object> estadisticas = getKanjiStatisticsUseCase.execute();
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
