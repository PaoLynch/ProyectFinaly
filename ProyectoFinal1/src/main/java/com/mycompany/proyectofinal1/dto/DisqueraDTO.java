/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dto;

import com.mycompany.proyectofinal1.entidades.Disquera;
import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class DisqueraDTO implements Serializable{
    private Disquera entidad;

    public DisqueraDTO() {
        entidad = new Disquera();
    }

    public Disquera getEntidad() {
        return entidad;
    }

    public void setEntidad(Disquera entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de la disquera: ").append(getEntidad().getNombreD()).append("\n");
        sb.append("Ciudad donde se encuentra: ").append(getEntidad().getDirCiudad()).append("\n");
        sb.append("Pais donde se encuentra: ").append(getEntidad().getDirPais()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        DisqueraDTO dto = new DisqueraDTO();
        dto.getEntidad().setNombreD("Universal Music México");
        dto.getEntidad().setDirCiudad("CDMX");
        dto.getEntidad().setDirPais("México");
        
        System.out.println(dto);
    }
}
