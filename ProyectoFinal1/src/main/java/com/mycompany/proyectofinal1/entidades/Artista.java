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
public class Artista implements Serializable{
    private String NombreA;
    private String Trayectoria;
    private String NombreR;
    private String Nacionalidad;
    
    public Artista(){
    }
    public void setNombreA(String NombreA){
        this.NombreA = NombreA;
    }
    public String getNombreA(){
        return NombreA;
    }
    public void setTrayectoria(String Trayectoria){
        this.Trayectoria = Trayectoria;
    }
    public String getTrayectoria(){
        return Trayectoria;
    }
    public void setNombreR(String NombreR){
        this.NombreR = NombreR;
    }
    public String getNombreR(){
        return NombreR;
    }
    public void setNacionalidad(String Nacionalidad){
        this.Nacionalidad = Nacionalidad;
    }
    public String getNacionalidad(){
        return Nacionalidad;
    }
}
