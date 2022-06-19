/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dto;

import com.mycompany.proyectofinal1.entidades.Disco;
import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class DiscoDTO implements Serializable{
     private Disco entidad;

    public DiscoDTO() {
        entidad = new Disco();
    }

    public Disco getEntidad() {
        return entidad;
    }

    public void setEntidad(Disco entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id del disco: ").append(getEntidad().getIdDisco()).append("\n");
        sb.append("Nombre: ").append(getEntidad().getNombre()).append("\n");
        sb.append("Genero: ").append(getEntidad().getGenero()).append("\n");
        sb.append("No. de Canciones: ").append(getEntidad().getNoCanciones()).append("\n");
        sb.append("Nombre del artista: ").append(getEntidad().getArtista_Nombre()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        DiscoDTO dto = new DiscoDTO();
        dto.getEntidad().setIdDisco(06);
        dto.getEntidad().setNombre("K.O.");
        dto.getEntidad().setGenero("Pop latino, urbano");
        dto.getEntidad().setNoCanciones("8");
        dto.getEntidad().setArtista_Nombre("Danna Paola");
        
        System.out.println(dto);
    }
    
}
