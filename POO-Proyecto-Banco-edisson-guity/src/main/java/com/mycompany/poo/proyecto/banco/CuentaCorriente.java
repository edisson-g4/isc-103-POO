/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.proyecto.banco;

/**
 *
 * @author ediss
 */
public class CuentaCorriente extends CuentaBancaria {

    public String nombreEmpresa;

    final private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {

        super(numeroCuenta, titular, saldoInicial);

        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public void retirarConSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
            return;
        }

        if (getSaldo() >= monto) {
            super.retirar(monto);

        } else {
            double dineroDisponible = getSaldo();
            double creditoNecesario = monto - dineroDisponible;
            double cargo = creditoNecesario * 0.03;
            double deudaTotal = creditoNecesario + cargo;

            if (creditoNecesario > 0 && sobregiroUtilizado + deudaTotal <= limiteSobregiro) {

                if (dineroDisponible > 0) {
                    super.retirar(dineroDisponible);
                }

                sobregiroUtilizado = sobregiroUtilizado + deudaTotal;

                System.out.println("Retiro realizado con sobregiro.");
                System.out.println("Dinero usado del saldo: L. "+ dineroDisponible);
                System.out.println("Credito utilizado: L. "+ creditoNecesario);
                System.out.println("Cargo del 3%: L. " + cargo);

            } else {
                System.out.println("Error: limite de sobregiro excedido.");
            }
        }
    }

    public void pagarSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("Error: el pago debe ser mayor que cero.");
            return;
        }

        if (monto <= sobregiroUtilizado) {
            sobregiroUtilizado = sobregiroUtilizado - monto;
            System.out.println("Pago de sobregiro realizado.");

        } else {
            double sobrante = monto - sobregiroUtilizado;

            sobregiroUtilizado = 0.0;
            depositar(sobrante);

            System.out.println("Sobregiro pagado completamente.");
            System.out.println("Dinero sobrante abonado al saldo: L. "+ sobrante);
        }
    }
}
