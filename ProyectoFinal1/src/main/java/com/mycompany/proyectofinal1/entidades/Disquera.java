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
public class Disquera implements Serializable{
    private String NombreD;
    private String DirCiudad;
    private String DirPais;
    
    public Disquera(){
    }
    public void setNombreD(String NombreD){
        this.NombreD = NombreD;
    }
    public String getNombreD(){
        return NombreD;
    }
    public void setDirCiudad(String DirCiudad){
        this.DirCiudad = DirCiudad;
    }
    public String getDirCiudad(){
        return DirCiudad;
    }
    public void setDirPais(String DirPais){
        this.DirPais = DirPais;
    }
    public String getDirPais(){
        return DirPais;
    }
}
