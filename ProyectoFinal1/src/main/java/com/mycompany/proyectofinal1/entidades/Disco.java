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
public class Disco implements Serializable{
    private int idDisco;
    private String Nombre;
    private String Genero;
    private String NoCanciones;
    private String Artista_Nombre;
    
    public Disco(){
    }
    public void setIdDisco(int idDisco){
        this.idDisco = idDisco;
    }
    public int getIdDisco(){
        return idDisco;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setGenero(String Genero){
        this.Genero = Genero;
    }
    public String getGenero(){
        return Genero;
    }
    public void setNoCanciones(String NoCanciones){
        this.NoCanciones = NoCanciones;
    }
    public String getNoCanciones(){
        return NoCanciones;
    }
    public void setArtista_Nombre(String Artista_Nombre){
        this.Artista_Nombre = Artista_Nombre;
    }
    public String getArtista_Nombre(){
        return Artista_Nombre;
    }
}
