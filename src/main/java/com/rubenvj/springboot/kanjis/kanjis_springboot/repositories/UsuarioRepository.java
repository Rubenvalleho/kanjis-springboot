package com.rubenvj.springboot.kanjis.kanjis_springboot.repositories;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository para Usuario - Maneja el acceso a datos
 * JpaRepository nos proporciona métodos básicos como save(), findAll(), findById(), delete(), etc.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Métodos personalizados de consulta
    // Spring Data JPA genera automáticamente la implementación basándose en el nombre del método
    
    /**
     * Busca usuarios por nombre (ignorando mayúsculas/minúsculas)
     */
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
    
    /**
     * Busca un usuario por email
     */
    Optional<Usuario> findByEmail(String email);
    
    /**
     * Busca usuarios por edad mayor a la especificada
     */
    List<Usuario> findByEdadGreaterThan(Integer edad);
    
    /**
     * Busca usuarios por edad entre dos valores
     */
    List<Usuario> findByEdadBetween(Integer edadMin, Integer edadMax);
    
    /**
     * Verifica si existe un usuario con ese email
     */
    boolean existsByEmail(String email);
}
