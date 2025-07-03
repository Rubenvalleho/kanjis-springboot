package com.rubenvj.springboot.kanjis.kanjis_springboot.services;

import com.rubenvj.springboot.kanjis.kanjis_springboot.entities.Usuario;
import com.rubenvj.springboot.kanjis.kanjis_springboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para Usuario - Contiene la lógica de negocio
 * Esta capa se encarga de validaciones, transformaciones y reglas de negocio
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /**
     * Obtiene todos los usuarios
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    /**
     * Obtiene un usuario por ID
     */
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    /**
     * Crea un nuevo usuario
     */
    public Usuario crearUsuario(Usuario usuario) {
        // Validaciones básicas
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email es obligatorio");
        }
        
        if (usuario.getEdad() == null || usuario.getEdad() < 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo");
        }
        
        // Verificar si ya existe un usuario con ese email
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
        }
        
        return usuarioRepository.save(usuario);
    }
    
    /**
     * Actualiza un usuario existente
     */
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        
        if (usuarioExistente.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + id);
        }
        
        Usuario usuario = usuarioExistente.get();
        
        // Actualizar solo los campos que no sean nulos
        if (usuarioActualizado.getNombre() != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
        }
        
        if (usuarioActualizado.getEmail() != null) {
            // Verificar que el nuevo email no esté en uso por otro usuario
            Optional<Usuario> usuarioConEmail = usuarioRepository.findByEmail(usuarioActualizado.getEmail());
            if (usuarioConEmail.isPresent() && !usuarioConEmail.get().getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe otro usuario con ese email");
            }
            usuario.setEmail(usuarioActualizado.getEmail());
        }
        
        if (usuarioActualizado.getTelefono() != null) {
            usuario.setTelefono(usuarioActualizado.getTelefono());
        }
        
        if (usuarioActualizado.getEdad() != null) {
            if (usuarioActualizado.getEdad() < 0) {
                throw new IllegalArgumentException("La edad debe ser un número positivo");
            }
            usuario.setEdad(usuarioActualizado.getEdad());
        }
        
        return usuarioRepository.save(usuario);
    }
    
    /**
     * Elimina un usuario por ID
     */
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
    
    /**
     * Busca usuarios por nombre
     */
    public List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    /**
     * Busca usuarios por rango de edad
     */
    public List<Usuario> buscarUsuariosPorEdad(Integer edadMin, Integer edadMax) {
        return usuarioRepository.findByEdadBetween(edadMin, edadMax);
    }
}
