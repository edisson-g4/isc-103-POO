/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica01;

/**
 *
 * @author ediss
 */
public class Camioneta extends Vehiculo{
    
    //Atributos
    public String modelo;
    private double capacidadCarga;
    final private double capacidadMaxima;
    
    public Camioneta(String marca, double cantidadCombustible, String modelo, double capacidadCarga){
        
        super(marca, cantidadCombustible);
        
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;
        this.capacidadMaxima = capacidadCarga;
    }
    // no puede ser carga negativa
    // no puede exceder los 2500
    // vehiculo cargado, capacidad Libre: xxx
    
    public String getModelo(String marca){
        
        return this.modelo;
    }
    
    public double cargavehiculo(double carga){
        
        if(carga>this.capacidadMaxima){
            throw new Error("no se puede exceder de 2500");
        }
        if(carga<0){
             throw new Error("La carga tiene un valor incorrecto");
        }
        //Actualizar la carga 
        this.capacidadCarga = this.capacidadCarga - carga; 
        return this.capacidadCarga;
        
        //la capacidad restante
        //return this.capacidadCarga -= carga; //2500 - 1000 = 200
    } 
    
    double bajarCarga(double carga){
        if (carga > (this.capacidadMaxima - this.capacidadCarga)){
             throw new Error("no se puede exceder a la capacidad maxima");
        }
        if(carga < 0){
             throw new Error("La cantidad tiene un valor incorrecto");
        }
        
        return this.capacidadCarga +=carga;
    }
  
}
