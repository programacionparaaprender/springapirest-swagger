package com.cavanosa.virtual.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TioDto {
    @NotBlank
    private String nombre;
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    
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
