/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dto;

import com.mycompany.proyectofinal1.entidades.Canción;
import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class CanciónDTO implements Serializable{
    private Canción entidad;

    public CanciónDTO() {
        entidad = new Canción();
    }

    public Canción getEntidad() {
        return entidad;
    }

    public void setEntidad(Canción entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id de la canción: ").append(getEntidad().getIdCancion()).append("\n");
        sb.append("Nombre de la canción: ").append(getEntidad().getNombre()).append("\n");
        sb.append("Duración: ").append(getEntidad().getDuracion()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        CanciónDTO dto = new CanciónDTO();
        dto.getEntidad().setIdCancion(021);
        dto.getEntidad().setNombre("Amor Ordinario");
        dto.getEntidad().setDuracion("3.59");
        
        System.out.println(dto);
    }
    
}
