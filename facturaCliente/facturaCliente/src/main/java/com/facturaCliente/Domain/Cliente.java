package com.facturaCliente.Domain;

import org.apache.logging.log4j.spi.DefaultThreadContextStack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity

public class Cliente {

    @Id

    private String dni;
    private String nombre;
    private String pais;
    private boolean premium;
    private Date fechaNac;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String pais, boolean premium, Date fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.pais = pais;
        this.premium = premium;
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
