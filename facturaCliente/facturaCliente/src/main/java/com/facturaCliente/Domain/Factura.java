package com.facturaCliente.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Factura {

    @Id
    private int codFra;
    private double total;
    private String mes;
    private int anyo;
    private String clienteDni;

    public Factura() {
    }

    public Factura(int codFra, double total, String mes, int anyo, String clienteDni) {
        this.codFra = codFra;
        this.total = total;
        this.mes = mes;
        this.anyo = anyo;
        this.clienteDni = clienteDni;
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

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setCodFra(int codFra) {
        this.codFra = codFra;
    }
}
