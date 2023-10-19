package com.facturaCliente.Controller;

import com.facturaCliente.Exception.InvalidFieldException;

import java.util.Date;

public class ClienteInput {
    private String dni;
    private String nombre;
    private String pais;
    private boolean premium;
    private Date fechaNac;

    public ClienteInput(String dni, String nombre, String pais, boolean premium, Date fechaNac) throws InvalidFieldException {
        if(dni.isEmpty()) throw new InvalidFieldException("El dni no puede estar vacio");
        if(dni == null) throw new InvalidFieldException("El dni no puede ser nulo");
        if(dni.trim().length() < 9) throw new InvalidFieldException("El dni no es correcto debe tener 9 caracteres");
        this.dni = dni;
        if(nombre.isEmpty()) throw new InvalidFieldException("El nombre no puede estar vacío");
        if(nombre == null) throw new InvalidFieldException("El nombre no puede ser nulo");
        this.nombre = nombre;
        if(pais.isEmpty()) throw new InvalidFieldException("El pais no puede estar vacio");
        if(pais == null) throw new InvalidFieldException("El pais no puede ser nulo");
        this.pais = pais;
        this.premium = premium;
        if(fechaNac == null) throw new InvalidFieldException("La fecha de nacimiento no puede ser cero");
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
        return premium;
    }

    public Date getFechaNac() {
        return fechaNac;
    }
}