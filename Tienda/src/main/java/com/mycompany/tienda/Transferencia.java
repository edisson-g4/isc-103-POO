/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda;

/**
 *
 * @author ediss
 */
public class Transferencia implements MetodoPago {

    private String numeroCuenta;

    @Override
    public boolean procesarPago(double monto) {
        return true;
    }

    public Transferencia(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

}