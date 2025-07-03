package com.rubenvj.springboot.kanjis.kanjis_springboot.entities;

import jakarta.persistence.*;

/**
 * Entidad Usuario - Representa la tabla usuarios en la base de datos
 * Esta clase define los atributos y estructura de un usuario
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, unique = true, length = 150)
    private String email;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(nullable = false)
    private Integer edad;
    
    // Constructor vacío (requerido por JPA)
    public Usuario() {
    }
    
    // Constructor con parámetros
    public Usuario(String nombre, String email, String telefono, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Integer getEdad() {
        return edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }
}
