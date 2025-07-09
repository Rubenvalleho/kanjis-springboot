package com.rubenvj.springboot.kanjis.kanjis_springboot.controllers;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import com.rubenvj.springboot.kanjis.kanjis_springboot.services.KanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST para Kanji - Define los endpoints de la API de kanjis
 */
@RestController
@RequestMapping("/api/kanjis")
@CrossOrigin(origins = "*")
public class KanjiController {
    
    @Autowired
    private KanjiService kanjiService;
    
    /**
     * GET /api/kanjis - Obtiene todos los kanjis
     */
    @GetMapping
    public ResponseEntity<List<Kanji>> obtenerTodosLosKanjis() {
        try {
            List<Kanji> kanjis = kanjiService.obtenerTodosLosKanjis();
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/{id} - Obtiene un kanji por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Kanji> obtenerKanjiPorId(@PathVariable Long id) {
        try {
            Optional<Kanji> kanji = kanjiService.obtenerKanjiPorId(id);
            if (kanji.isPresent()) {
                return ResponseEntity.ok(kanji.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/caracter/{kanji} - Obtiene un kanji por su carácter
     */
    @GetMapping("/caracter/{kanji}")
    public ResponseEntity<Kanji> obtenerKanjiPorCaracter(@PathVariable String kanji) {
        try {
            Optional<Kanji> kanjiResult = kanjiService.obtenerKanjiPorCaracter(kanji);
            if (kanjiResult.isPresent()) {
                return ResponseEntity.ok(kanjiResult.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * POST /api/kanjis - Crea un nuevo kanji
     */
    @PostMapping
    public ResponseEntity<Kanji> crearKanji(@RequestBody Kanji kanji) {
        try {
            Kanji kanjiCreado = kanjiService.crearKanji(kanji);
            return ResponseEntity.status(HttpStatus.CREATED).body(kanjiCreado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * PUT /api/kanjis/{id} - Actualiza un kanji existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Kanji> actualizarKanji(@PathVariable Long id, @RequestBody Kanji kanji) {
        try {
            Kanji kanjiActualizado = kanjiService.actualizarKanji(id, kanji);
            return ResponseEntity.ok(kanjiActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * DELETE /api/kanjis/{id} - Elimina un kanji
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarKanji(@PathVariable Long id) {
        try {
            kanjiService.eliminarKanji(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/buscar/significado?q=agua - Busca kanjis por significado
     */
    @GetMapping("/buscar/significado")
    public ResponseEntity<List<Kanji>> buscarPorSignificado(@RequestParam String q) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorSignificado(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/buscar/kun?q=mizu - Busca kanjis por lectura kun
     */
    @GetMapping("/buscar/kun")
    public ResponseEntity<List<Kanji>> buscarPorLecturaKun(@RequestParam String q) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorLecturaKun(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/buscar/on?q=sui - Busca kanjis por lectura on
     */
    @GetMapping("/buscar/on")
    public ResponseEntity<List<Kanji>> buscarPorLecturaOn(@RequestParam String q) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorLecturaOn(q);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/jlpt/{nivel} - Busca kanjis por nivel JLPT
     */
    @GetMapping("/jlpt/{nivel}")
    public ResponseEntity<List<Kanji>> buscarPorNivelJlpt(@PathVariable String nivel) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorNivelJlpt(nivel);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/grado/{grado} - Busca kanjis por grado escolar
     */
    @GetMapping("/grado/{grado}")
    public ResponseEntity<List<Kanji>> buscarPorGradoEscolar(@PathVariable Integer grado) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorGradoEscolar(grado);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/trazos/{numero} - Busca kanjis por número de trazos
     */
    @GetMapping("/trazos/{numero}")
    public ResponseEntity<List<Kanji>> buscarPorNumeroTrazos(@PathVariable Integer numero) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorNumeroTrazos(numero);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/trazos/rango?min=1&max=5 - Busca kanjis por rango de trazos
     */
    @GetMapping("/trazos/rango")
    public ResponseEntity<List<Kanji>> buscarPorRangoTrazos(@RequestParam Integer min, @RequestParam Integer max) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorRangoTrazos(min, max);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/radical/{radical} - Busca kanjis por radical
     */
    @GetMapping("/radical/{radical}")
    public ResponseEntity<List<Kanji>> buscarPorRadical(@PathVariable String radical) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorRadical(radical);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/frecuencia - Obtiene kanjis ordenados por frecuencia de uso
     */
    @GetMapping("/frecuencia")
    public ResponseEntity<List<Kanji>> obtenerKanjisPorFrecuencia() {
        try {
            List<Kanji> kanjis = kanjiService.obtenerKanjisPorFrecuencia();
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/aleatorios?limite=10 - Obtiene kanjis aleatorios para práctica
     */
    @GetMapping("/aleatorios")
    public ResponseEntity<List<Kanji>> obtenerKanjisAleatorios(@RequestParam(defaultValue = "10") Integer limite) {
        try {
            List<Kanji> kanjis = kanjiService.obtenerKanjisAleatorios(limite);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/buscar/avanzado?significado=agua&jlpt=N5&grado=1 - Búsqueda avanzada
     */
    @GetMapping("/buscar/avanzado")
    public ResponseEntity<List<Kanji>> buscarPorCriterios(
            @RequestParam(required = false) String significado,
            @RequestParam(required = false) String jlpt,
            @RequestParam(required = false) Integer grado) {
        try {
            List<Kanji> kanjis = kanjiService.buscarPorCriterios(significado, jlpt, grado);
            return ResponseEntity.ok(kanjis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/kanjis/estadisticas - Obtiene estadísticas generales
     */
    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Object>> obtenerEstadisticas() {
        try {
            Map<String, Object> estadisticas = kanjiService.obtenerEstadisticas();
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
