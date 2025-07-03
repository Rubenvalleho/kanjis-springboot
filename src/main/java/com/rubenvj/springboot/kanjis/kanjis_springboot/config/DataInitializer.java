package com.rubenvj.springboot.kanjis.kanjis_springboot.config;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Usuario;
import com.rubenvj.springboot.kanjis.kanjis_springboot.repositories.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Solo carga datos si la tabla está vacía
        if (usuarioRepository.count() == 0) {
            cargarDatosIniciales();
        }
    }
    
    private void cargarDatosIniciales() {
        System.out.println("Cargando datos iniciales...");
        
        // Crear usuarios de ejemplo
        Usuario usuario1 = new Usuario("Juan Pérez", "juan.perez@email.com", "123456789", 28);
        Usuario usuario2 = new Usuario("María García", "maria.garcia@email.com", "987654321", 34);
        Usuario usuario3 = new Usuario("Carlos López", "carlos.lopez@email.com", "456789123", 22);
        Usuario usuario4 = new Usuario("Ana Martínez", "ana.martinez@email.com", "789123456", 31);
        Usuario usuario5 = new Usuario("Luis Rodríguez", "luis.rodriguez@email.com", "321654987", 45);
        
        // Guardar en la base de datos
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario4);
        usuarioRepository.save(usuario5);
        
        System.out.println("✅ Datos iniciales cargados correctamente");
        System.out.println("📊 Total de usuarios creados: " + usuarioRepository.count());
    }
}
