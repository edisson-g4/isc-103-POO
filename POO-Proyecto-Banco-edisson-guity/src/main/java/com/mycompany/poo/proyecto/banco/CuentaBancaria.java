/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.proyecto.banco;

/**
 *
 * @author ediss
 */
public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;

    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }

        this.totalTransacciones = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            totalTransacciones++;
            System.out.println("Deposito realizado correctamente.");
        } else {
            System.out.println("Error: el monto debe ser mayor que cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo = saldo - monto;
            totalTransacciones++;
            System.out.println("Retiro realizado correctamente.");
            return true;
        } else {
            System.out.println("Error: saldo insuficiente o monto invalido.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: L. " + getSaldo());
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
}
