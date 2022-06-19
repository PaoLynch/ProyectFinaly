/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.entidades;

import java.io.Serializable;

/**
 *
 * @author 18072
 */
public class Canción implements Serializable{
    private int idCancion;
    private String Nombre;
    private String Duracion;
    
    public Canción(){
    }
    public void setIdCancion(int idCancion){
        this.idCancion = idCancion;
    }
    public int getIdCancion(){
        return idCancion;
    }
     public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setDuracion(String Duracion){
        this.Duracion = Duracion;
    }
    public String getDuracion(){
        return Duracion;
    }
}
