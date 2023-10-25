package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Exception.InvalidFieldException;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data

public class ClienteDniNombreOutput {
    @NotNull(message = "The dni cannot be null")
    @NotEmpty(message = "The dni cannot be empty")
    private String dni;
    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String nombre;

    public ClienteDniNombreOutput(String dni, String nombre) throws InvalidFieldException{
        if(dni.trim().length() < 9) throw new InvalidFieldException("El dni no es correcto debe tener 9 caracteres");
        this.dni = dni;
        this.nombre = nombre;
    }
    public static ClienteDniNombreOutput getCliente (Cliente cliente) throws InvalidFieldException {
        return new ClienteDniNombreOutput(cliente.getDni(), cliente.getNombre());
    }

}
