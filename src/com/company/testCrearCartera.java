package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCrearCartera {

    // 1. Creación de cuentas.
    @Test
    void testAlCrearCuentaElSaldoEsCero() {
        Cuenta c = new Cuenta();
        assertEquals(0.0,c.getSaldo());
    }


    // 2. Ingresos.
    @Test
    void testAlIngresar100EnCuentaVaciaElSaldoEs100() {
        Cuenta c = new Cuenta();
        c.ingresar(100.446);
        assertEquals(100.45,c.getSaldo());
    }

    @Test
    void testAlIngresar3000EnCuentaVaciaElSaldoEs3000() {
        Cuenta c = new Cuenta();
        c.ingresar(3000.0);
        assertEquals(3000.0,c.getSaldo());
    }

    @Test
    void testAlIngresar100EnCuentaCon3000ElSaldoEs3100() {
        Cuenta c = new Cuenta();
        c.ingresar(100.0);
        c.ingresar(3000.0);
        assertEquals(3100.0,c.getSaldo());
    }

    @Test
    void testAlIngresarMenos100EnCuentaConCeroElSaldoEsCero() {
        Cuenta c = new Cuenta();
        c.ingresar(-100.0);
        assertEquals(0.0,c.getSaldo());
    }

    @Test
    void testAlIngresar100Con45EnCuentaConCeroElSaldoEs100Con45() {
        Cuenta c = new Cuenta();
        c.ingresar(100.45);
        assertEquals(100.45,c.getSaldo());
    }

    @Test
    void testAlIngresar6000EnCuentaConCeroElSaldoEs6000() {
        Cuenta c = new Cuenta();
        c.ingresar(6000.0);
        assertEquals(6000.0,c.getSaldo());
    }

    @Test
    void testAlIngresar6000Con01EnCuentaConCeroElSaldoEsCero() {
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0.0,c.getSaldo());
    }


    // 3. Retiradas.
    @Test
    void testAlRetirar100EnCuentaCon500ElSaldoEs400() {
        Cuenta c = new Cuenta();
        c.ingresar(500.0);
        c.retirar(100.0);
        assertEquals(400.0,c.getSaldo());
    }

    @Test
    void testAlRetirar500EnCuentaCon200ElSaldoEs200() {
        Cuenta c = new Cuenta();
        c.ingresar(200.0);
        c.retirar(500.0);
        assertEquals(200.0,c.getSaldo());
    }

    @Test
    void testAlRetirarMenos100EnCuentaCon500ElSaldoEs500() {
        Cuenta c = new Cuenta();
        c.ingresar(500.0);
        c.retirar(-100.0);
        assertEquals(500.0,c.getSaldo());
    }

    @Test
    void testAlRetirar100Con45EnCuentaCon500ElSaldoEs399Con55() {
        Cuenta c = new Cuenta();
        c.ingresar(500.0);
        c.retirar(100.45);
        assertEquals(399.55,c.getSaldo());
    }

    @Test
    void testAlRetirar6000EnCuentaCon7000ElSaldoEs1000() {
        Cuenta c = new Cuenta();
        c.ingresar(6000.0);
        c.ingresar(1000.0);
        c.retirar(6000.0);
        assertEquals(1000.0,c.getSaldo());
    }

    @Test
    void testAlRetirar6000Con01EnCuentaCon7000ElSaldoEs7000() {
        Cuenta c = new Cuenta();
        c.ingresar(6000.0);
        c.ingresar(1000.0);
        c.retirar(6000.01);
        assertEquals(7000.0,c.getSaldo());
    }


    // 4. Transferencias.
    @Test
    void testTransferencia100Desde500A50() {
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaDestino = new Cuenta();
        cuenta.ingresar(500);
        cuentaDestino.ingresar(50);

        cuenta.transferencia(100, cuentaDestino);

        assertEquals(400, cuenta.getSaldo());
        assertEquals(150, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaNegativaNoPermitida() {
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaDestino = new Cuenta();
        cuenta.ingresar(500);
        cuentaDestino.ingresar(50);

        cuenta.transferencia(-100, cuentaDestino);

        assertEquals(500, cuenta.getSaldo());
        assertEquals(50, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaLimite3000Desde3500A50() {
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaDestino = new Cuenta();
        cuenta.ingresar(3500);
        cuentaDestino.ingresar(50);

        cuenta.transferencia(3000, cuentaDestino);

        assertEquals(500, cuenta.getSaldo());
        assertEquals(3050, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaMayorLimite3000Desde3500A50() {
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaDestino = new Cuenta();
        cuenta.ingresar(3500);
        cuentaDestino.ingresar(50);

        cuenta.transferencia(3000.01, cuentaDestino);

        assertEquals(3500, cuenta.getSaldo());
        assertEquals(50, cuentaDestino.getSaldo());
    }

}