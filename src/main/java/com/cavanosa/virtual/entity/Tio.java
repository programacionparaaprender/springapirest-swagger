package com.cavanosa.virtual.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tio")
public class Tio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(unique = true)
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String email;

    
    @NotNull
    @Column(name="password")
    private String password;
    
    public Tio() {
    }

    public Tio(@NotNull String nombre, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
