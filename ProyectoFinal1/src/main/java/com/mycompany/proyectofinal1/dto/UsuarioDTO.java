/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dto;

import com.mycompany.proyectofinal1.entidades.Usuario;
import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class UsuarioDTO implements Serializable{
    private Usuario entidad;

    public UsuarioDTO() {
        entidad = new Usuario();
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Email: ").append(getEntidad().getEmail()).append("\n");
        sb.append("Contraseña: ").append(getEntidad().getContraseña()).append("\n");
        sb.append("Nombre: ").append(getEntidad().getNombre()).append("\n");
        sb.append("Gustos: ").append(getEntidad().getGustos()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setEmail("Juliana@gmail.com");
        dto.getEntidad().setContraseña("papas");
        dto.getEntidad().setNombre("Juliana Rojas");
        dto.getEntidad().setGustos("Pop - Rock");
        
        System.out.println(dto);
    }
}
