package com.rubenvj.springboot.kanjis.kanjis_springboot.config;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Kanji;
import com.rubenvj.springboot.kanjis.kanjis_springboot.repositories.KanjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Configuración para cargar datos iniciales en la base de datos
 * Se ejecuta automáticamente al iniciar la aplicación
 */
@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private KanjiRepository kanjiRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Cargar kanjis si la tabla está vacía
        if (kanjiRepository.count() == 0) {
            cargarKanjisIniciales();
        }
    }
    
    private void cargarKanjisIniciales() {
        System.out.println("\n🈲 Cargando kanjis iniciales...");
        
        // Kanjis básicos N5 - Nivel 1
        Kanji kanji1 = new Kanji("水", "みず", "スイ", "agua");
        kanji1.setNumeroTrazos(4);
        kanji1.setNivelJlpt("N5");
        kanji1.setGradoEscolar(1);
        kanji1.setFrecuenciaUso(365);
        kanji1.setEjemplosPalabras("水 (みず) - agua, 水曜日 (すいようび) - miércoles");
        kanji1.setRadicalPrincipal("水");
        
        Kanji kanji2 = new Kanji("火", "ひ", "カ", "fuego");
        kanji2.setNumeroTrazos(4);
        kanji2.setNivelJlpt("N5");
        kanji2.setGradoEscolar(1);
        kanji2.setFrecuenciaUso(492);
        kanji2.setEjemplosPalabras("火 (ひ) - fuego, 火曜日 (かようび) - martes");
        kanji2.setRadicalPrincipal("火");
        
        Kanji kanji3 = new Kanji("木", "き", "モク", "árbol, madera");
        kanji3.setNumeroTrazos(4);
        kanji3.setNivelJlpt("N5");
        kanji3.setGradoEscolar(1);
        kanji3.setFrecuenciaUso(187);
        kanji3.setEjemplosPalabras("木 (き) - árbol, 木曜日 (もくようび) - jueves");
        kanji3.setRadicalPrincipal("木");
        
        Kanji kanji4 = new Kanji("金", "きん、かね", "キン", "oro, dinero, metal");
        kanji4.setNumeroTrazos(8);
        kanji4.setNivelJlpt("N5");
        kanji4.setGradoEscolar(1);
        kanji4.setFrecuenciaUso(206);
        kanji4.setEjemplosPalabras("金 (きん) - oro, 金曜日 (きんようび) - viernes, お金 (おかね) - dinero");
        kanji4.setRadicalPrincipal("金");
        
        Kanji kanji5 = new Kanji("土", "つち", "ド", "tierra, suelo");
        kanji5.setNumeroTrazos(3);
        kanji5.setNivelJlpt("N5");
        kanji5.setGradoEscolar(1);
        kanji5.setFrecuenciaUso(298);
        kanji5.setEjemplosPalabras("土 (つち) - tierra, 土曜日 (どようび) - sábado");
        kanji5.setRadicalPrincipal("土");
        
        Kanji kanji6 = new Kanji("日", "ひ、か", "ニチ", "sol, día");
        kanji6.setNumeroTrazos(4);
        kanji6.setNivelJlpt("N5");
        kanji6.setGradoEscolar(1);
        kanji6.setFrecuenciaUso(1);
        kanji6.setEjemplosPalabras("日 (ひ) - sol/día, 日曜日 (にちようび) - domingo, 今日 (きょう) - hoy");
        kanji6.setRadicalPrincipal("日");
        
        Kanji kanji7 = new Kanji("月", "つき", "ゲツ", "luna, mes");
        kanji7.setNumeroTrazos(4);
        kanji7.setNivelJlpt("N5");
        kanji7.setGradoEscolar(1);
        kanji7.setFrecuenciaUso(23);
        kanji7.setEjemplosPalabras("月 (つき) - luna, 月曜日 (げつようび) - lunes, 来月 (らいげつ) - mes que viene");
        kanji7.setRadicalPrincipal("月");
        
        Kanji kanji8 = new Kanji("人", "ひと", "ジン", "persona");
        kanji8.setNumeroTrazos(2);
        kanji8.setNivelJlpt("N5");
        kanji8.setGradoEscolar(1);
        kanji8.setFrecuenciaUso(5);
        kanji8.setEjemplosPalabras("人 (ひと) - persona, 日本人 (にほんじん) - japonés");
        kanji8.setRadicalPrincipal("人");
        
        Kanji kanji9 = new Kanji("大", "おお", "ダイ", "grande");
        kanji9.setNumeroTrazos(3);
        kanji9.setNivelJlpt("N5");
        kanji9.setGradoEscolar(1);
        kanji9.setFrecuenciaUso(10);
        kanji9.setEjemplosPalabras("大きい (おおきい) - grande, 大学 (だいがく) - universidad");
        kanji9.setRadicalPrincipal("大");
        
        Kanji kanji10 = new Kanji("小", "ちい、こ", "ショウ", "pequeño");
        kanji10.setNumeroTrazos(3);
        kanji10.setNivelJlpt("N5");
        kanji10.setGradoEscolar(1);
        kanji10.setFrecuenciaUso(29);
        kanji10.setEjemplosPalabras("小さい (ちいさい) - pequeño, 小学校 (しょうがっこう) - escuela primaria");
        kanji10.setRadicalPrincipal("小");
        
        // Kanjis N4 - Nivel 2
        Kanji kanji11 = new Kanji("食", "た", "ショク", "comer, comida");
        kanji11.setNumeroTrazos(9);
        kanji11.setNivelJlpt("N4");
        kanji11.setGradoEscolar(2);
        kanji11.setFrecuenciaUso(72);
        kanji11.setEjemplosPalabras("食べる (たべる) - comer, 食事 (しょくじ) - comida");
        kanji11.setRadicalPrincipal("食");
        
        Kanji kanji12 = new Kanji("飲", "の", "イン", "beber");
        kanji12.setNumeroTrazos(12);
        kanji12.setNivelJlpt("N4");
        kanji12.setGradoEscolar(3);
        kanji12.setFrecuenciaUso(515);
        kanji12.setEjemplosPalabras("飲む (のむ) - beber, 飲み物 (のみもの) - bebida");
        kanji12.setRadicalPrincipal("食");
        
        Kanji kanji13 = new Kanji("学", "まな", "ガク", "aprender, estudiar");
        kanji13.setNumeroTrazos(8);
        kanji13.setNivelJlpt("N4");
        kanji13.setGradoEscolar(1);
        kanji13.setFrecuenciaUso(20);
        kanji13.setEjemplosPalabras("学ぶ (まなぶ) - aprender, 学校 (がっこう) - escuela");
        kanji13.setRadicalPrincipal("学");
        
        Kanji kanji14 = new Kanji("車", "くるま", "シャ", "coche, vehículo");
        kanji14.setNumeroTrazos(7);
        kanji14.setNivelJlpt("N4");
        kanji14.setGradoEscolar(1);
        kanji14.setFrecuenciaUso(37);
        kanji14.setEjemplosPalabras("車 (くるま) - coche, 電車 (でんしゃ) - tren");
        kanji14.setRadicalPrincipal("車");
        
        Kanji kanji15 = new Kanji("家", "いえ、うち", "カ", "casa, hogar");
        kanji15.setNumeroTrazos(10);
        kanji15.setNivelJlpt("N4");
        kanji15.setGradoEscolar(2);
        kanji15.setFrecuenciaUso(33);
        kanji15.setEjemplosPalabras("家 (いえ) - casa, 家族 (かぞく) - familia");
        kanji15.setRadicalPrincipal("宀");
        
        // Kanjis N3 - Nivel 3
        Kanji kanji16 = new Kanji("病", "やまい", "ビョウ", "enfermedad");
        kanji16.setNumeroTrazos(10);
        kanji16.setNivelJlpt("N3");
        kanji16.setGradoEscolar(3);
        kanji16.setFrecuenciaUso(254);
        kanji16.setEjemplosPalabras("病気 (びょうき) - enfermedad, 病院 (びょういん) - hospital");
        kanji16.setRadicalPrincipal("疒");
        
        Kanji kanji17 = new Kanji("働", "はたら", "ドウ", "trabajar");
        kanji17.setNumeroTrazos(13);
        kanji17.setNivelJlpt("N3");
        kanji17.setGradoEscolar(4);
        kanji17.setFrecuenciaUso(276);
        kanji17.setEjemplosPalabras("働く (はたらく) - trabajar, 労働 (ろうどう) - trabajo");
        kanji17.setRadicalPrincipal("人");
        
        Kanji kanji18 = new Kanji("旅", "たび", "リョ", "viaje");
        kanji18.setNumeroTrazos(10);
        kanji18.setNivelJlpt("N3");
        kanji18.setGradoEscolar(3);
        kanji18.setFrecuenciaUso(455);
        kanji18.setEjemplosPalabras("旅 (たび) - viaje, 旅行 (りょこう) - viaje");
        kanji18.setRadicalPrincipal("方");
        
        Kanji kanji19 = new Kanji("音", "おと", "オン", "sonido");
        kanji19.setNumeroTrazos(9);
        kanji19.setNivelJlpt("N3");
        kanji19.setGradoEscolar(1);
        kanji19.setFrecuenciaUso(178);
        kanji19.setEjemplosPalabras("音 (おと) - sonido, 音楽 (おんがく) - música");
        kanji19.setRadicalPrincipal("音");
        
        Kanji kanji20 = new Kanji("色", "いろ", "ショク", "color");
        kanji20.setNumeroTrazos(6);
        kanji20.setNivelJlpt("N3");
        kanji20.setGradoEscolar(2);
        kanji20.setFrecuenciaUso(89);
        kanji20.setEjemplosPalabras("色 (いろ) - color, 黒色 (こくしょく) - negro");
        kanji20.setRadicalPrincipal("色");
        
        // Guardar todos los kanjis
        kanjiRepository.save(kanji1);
        kanjiRepository.save(kanji2);
        kanjiRepository.save(kanji3);
        kanjiRepository.save(kanji4);
        kanjiRepository.save(kanji5);
        kanjiRepository.save(kanji6);
        kanjiRepository.save(kanji7);
        kanjiRepository.save(kanji8);
        kanjiRepository.save(kanji9);
        kanjiRepository.save(kanji10);
        kanjiRepository.save(kanji11);
        kanjiRepository.save(kanji12);
        kanjiRepository.save(kanji13);
        kanjiRepository.save(kanji14);
        kanjiRepository.save(kanji15);
        kanjiRepository.save(kanji16);
        kanjiRepository.save(kanji17);
        kanjiRepository.save(kanji18);
        kanjiRepository.save(kanji19);
        kanjiRepository.save(kanji20);
        
        System.out.println("✅ Kanjis iniciales cargados correctamente");
        System.out.println("📊 Total de kanjis creados: " + kanjiRepository.count());
        
        // Mostrar estadísticas por nivel
        System.out.println("📈 Estadísticas por nivel JLPT:");
        System.out.println("   • N5: " + kanjiRepository.countByNivelJlpt("N5") + " kanjis");
        System.out.println("   • N4: " + kanjiRepository.countByNivelJlpt("N4") + " kanjis");
        System.out.println("   • N3: " + kanjiRepository.countByNivelJlpt("N3") + " kanjis");
        System.out.println("   • N2: " + kanjiRepository.countByNivelJlpt("N2") + " kanjis");
        System.out.println("   • N1: " + kanjiRepository.countByNivelJlpt("N1") + " kanjis");
    }
}
