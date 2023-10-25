package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Exception.InvalidFieldException;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ClienteOutput {
    @NotNull(message = "The dni cannot be null")
    @NotEmpty(message = "The dni cannot be empty")
    private String dni;
    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String nombre;
    @NotNull(message = "The country cannot be null")
    @NotEmpty(message = "The country cannot be empty")
    private String pais;
    private boolean premium;
    private Date fechaNac;

    public ClienteOutput(String dni, String nombre, String pais, boolean premium, Date fechaNac) throws InvalidFieldException {
        if(dni.trim().length() < 9) throw new InvalidFieldException("El dni no es correcto debe tener 9 caracteres");
        this.dni = dni;
        this.nombre = nombre;
        this.pais = pais;
        this.premium = premium;
        this.fechaNac = fechaNac;
    }

    public static ClienteOutput getCliente (Cliente cliente) throws InvalidFieldException {
        return new ClienteOutput(cliente.getDni(), cliente.getNombre(), cliente.getPais(),cliente.isPremium(), cliente.getFechaNac());
    }

  }
