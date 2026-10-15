/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.proyecto.banco;

/**
 *
 * @author ediss
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("===== CUENTA BANCARIA =====");

        CuentaBancaria miCuenta = new CuentaBancaria("001", "Juan Perez", 2000);

        // Error: saldo es privado y no se puede modificar directamente.
        // miCuenta.saldo = 50000;

        // Los atributos publicos se pueden consultar directamente.
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: "+ miCuenta.numeroCuenta);

        miCuenta.depositar(500);
        miCuenta.retirar(200);
        miCuenta.mostrarDatos();

        System.out.println("\n===== CUENTA DE AHORRO =====");

        CuentaAhorro ahorro = new CuentaAhorro("002", "Maria Lopez", 3000, 5);

        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);

        ahorro.aplicarInteresMensual();

        System.out.println("Saldo final de ahorro: L. "+ ahorro.getSaldo());

        System.out.println("\n===== CUENTA CORRIENTE =====");

        CuentaCorriente corriente = new CuentaCorriente("003", "Carlos Diaz", 1000, "Empresa ABC", 5000);

        corriente.retirarConSobregiro(3500);

        System.out.println("Saldo actual: L. "+ corriente.getSaldo());

        System.out.println("Deuda antes del pago: L. "+ corriente.getSobregiroUtilizado());

        // Realizar un pago de L. 1,000
        corriente.pagarSobregiro(1000);

        System.out.println("Deuda despues del pago: L. "+ corriente.getSobregiroUtilizado());

        System.out.println("Saldo final: L. "+ corriente.getSaldo());
    }
}