package com.rubenvj.springboot.kanjis.kanjis_springboot.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad Kanji - Representa un kanji con sus lecturas y significados
 */
@Entity
@Table(name = "kanjis")
public class Kanji {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 1)
    private String kanji;
    
    @Column(name = "lectura_kun", columnDefinition = "TEXT")
    private String lecturaKun;
    
    @Column(name = "lectura_on", columnDefinition = "TEXT")
    private String lecturaOn;
    
    @Column(name = "significado_espanol", columnDefinition = "TEXT")
    private String significadoEspanol;
    
    @Column(name = "numero_trazos")
    private Integer numeroTrazos;
    
    @Column(name = "nivel_jlpt")
    private String nivelJlpt;
    
    @Column(name = "grado_escolar")
    private Integer gradoEscolar;
    
    @Column(name = "frecuencia_uso")
    private Integer frecuenciaUso;
    
    @Column(name = "ejemplos_palabras", columnDefinition = "TEXT")
    private String ejemplosPalabras;
    
    @Column(name = "radical_principal")
    private String radicalPrincipal;
    
    // Constructores
    public Kanji() {
    }
    
    public Kanji(String kanji, String lecturaKun, String lecturaOn, String significadoEspanol) {
        this.kanji = kanji;
        this.lecturaKun = lecturaKun;
        this.lecturaOn = lecturaOn;
        this.significadoEspanol = significadoEspanol;
    }
    
    public Kanji(String kanji, String lecturaKun, String lecturaOn, String significadoEspanol,
                 Integer numeroTrazos, String nivelJlpt, Integer gradoEscolar) {
        this.kanji = kanji;
        this.lecturaKun = lecturaKun;
        this.lecturaOn = lecturaOn;
        this.significadoEspanol = significadoEspanol;
        this.numeroTrazos = numeroTrazos;
        this.nivelJlpt = nivelJlpt;
        this.gradoEscolar = gradoEscolar;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getKanji() {
        return kanji;
    }
    
    public void setKanji(String kanji) {
        this.kanji = kanji;
    }
    
    public String getLecturaKun() {
        return lecturaKun;
    }
    
    public void setLecturaKun(String lecturaKun) {
        this.lecturaKun = lecturaKun;
    }
    
    public String getLecturaOn() {
        return lecturaOn;
    }
    
    public void setLecturaOn(String lecturaOn) {
        this.lecturaOn = lecturaOn;
    }
    
    public String getSignificadoEspanol() {
        return significadoEspanol;
    }
    
    public void setSignificadoEspanol(String significadoEspanol) {
        this.significadoEspanol = significadoEspanol;
    }
    
    public Integer getNumeroTrazos() {
        return numeroTrazos;
    }
    
    public void setNumeroTrazos(Integer numeroTrazos) {
        this.numeroTrazos = numeroTrazos;
    }
    
    public String getNivelJlpt() {
        return nivelJlpt;
    }
    
    public void setNivelJlpt(String nivelJlpt) {
        this.nivelJlpt = nivelJlpt;
    }
    
    public Integer getGradoEscolar() {
        return gradoEscolar;
    }
    
    public void setGradoEscolar(Integer gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }
    
    public Integer getFrecuenciaUso() {
        return frecuenciaUso;
    }
    
    public void setFrecuenciaUso(Integer frecuenciaUso) {
        this.frecuenciaUso = frecuenciaUso;
    }
    
    public String getEjemplosPalabras() {
        return ejemplosPalabras;
    }
    
    public void setEjemplosPalabras(String ejemplosPalabras) {
        this.ejemplosPalabras = ejemplosPalabras;
    }
    
    public String getRadicalPrincipal() {
        return radicalPrincipal;
    }
    
    public void setRadicalPrincipal(String radicalPrincipal) {
        this.radicalPrincipal = radicalPrincipal;
    }
    
    @Override
    public String toString() {
        return "Kanji{" +
                "id=" + id +
                ", kanji='" + kanji + '\'' +
                ", lecturaKun='" + lecturaKun + '\'' +
                ", lecturaOn='" + lecturaOn + '\'' +
                ", significadoEspanol='" + significadoEspanol + '\'' +
                ", numeroTrazos=" + numeroTrazos +
                ", nivelJlpt='" + nivelJlpt + '\'' +
                ", gradoEscolar=" + gradoEscolar +
                '}';
    }
}
