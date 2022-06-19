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
public class Usuario implements Serializable{
    private String email;
    private String contraseña;
    private String nombre;
    private String gustos;
    
    public Usuario(){        
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setGustos(String gustos){
        this.gustos = gustos;
    }
    public String getGustos(){
        return gustos;
    }
}
