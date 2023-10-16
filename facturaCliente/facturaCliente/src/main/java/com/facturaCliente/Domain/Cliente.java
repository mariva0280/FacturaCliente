package com.facturaCliente.Domain;

import java.util.Date;

public class Cliente {
    private String dni;
    private String nombre;
    private String pais;
    private boolean Premium;
    private int fechaNac;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String pais, boolean premium, int fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.pais = pais;
        Premium = premium;
        this.fechaNac = fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public boolean isPremium() {
        return Premium;
    }

    public int getFechaNac() {
        return fechaNac;
    }
}
