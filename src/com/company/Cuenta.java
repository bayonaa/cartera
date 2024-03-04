package com.company;

public class Cuenta {
    private double saldo;

    public Cuenta() {
        // saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cant) {
        double roundOff = Math.round(cant * 100.0) / 100.0;
        if (roundOff < 0.0) {
            saldo = getSaldo();
        } else if (roundOff > 6000.0) {
            saldo = getSaldo();
        } else  {
            saldo += roundOff;
        }
    }

    public void retirar(double cant) {
        double roundOff = Math.round(cant * 100.0) / 100.0;
        if (roundOff < 0.0) {
            saldo = getSaldo();
        } else if (roundOff > 6000.0) {
            saldo = getSaldo();
        } else if (roundOff <= saldo) {
            saldo -= roundOff;
        }
    }

    public void transferencia(double cant, Cuenta cDestino) {
        double roundOff = Math.round(cant * 100.0) / 100.0;
        if (roundOff < 0.0) {
            saldo = getSaldo();
        } else if (roundOff > 3000.0) {
            saldo = getSaldo();
        } else if (roundOff <= saldo) {
            saldo -= roundOff;
            cDestino.ingresar(roundOff);
        }
    }
}
