/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dto;

import com.mycompany.proyectofinal1.entidades.Artista;
import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class ArtistaDTO implements Serializable{
    private Artista entidad;

    public ArtistaDTO() {
        entidad = new Artista();
    }

    public Artista getEntidad() {
        return entidad;
    }

    public void setEntidad(Artista entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del artista: ").append(getEntidad().getNombreA()).append("\n");
        sb.append("Trayectoria: ").append(getEntidad().getTrayectoria()).append("\n");
        sb.append("Nombre real: ").append(getEntidad().getNombreR()).append("\n");
        sb.append("Nacionalidad: ").append(getEntidad().getNacionalidad()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        ArtistaDTO dto = new ArtistaDTO();
        dto.getEntidad().setNombreA("Danna Paola");
        dto.getEntidad().setTrayectoria("21 años");
        dto.getEntidad().setNombreR("Danna Paola Rivera Munguía");
        dto.getEntidad().setNacionalidad("Mexicana");
        
        System.out.println(dto);
    }
}
