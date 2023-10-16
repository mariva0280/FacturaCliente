package com.facturaCliente.Domain;

public class Factura {
    private int codFra;
    private double total;
    private String mes;
    private int anyo;

    public Factura() {
    }

    public Factura(int codFra, double total, String mes, int anyo) {
        this.codFra = codFra;
        this.total = total;
        this.mes = mes;
        this.anyo = anyo;
    }

    public int getCodFra() {
        return codFra;
    }

    public double getTotal() {
        return total;
    }

    public String getMes() {
        return mes;
    }

    public int getAnyo() {
        return anyo;
    }
}
