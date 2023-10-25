package com.facturaCliente.Domain;

import com.facturaCliente.Controller.ClienteInput;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data // lo usamos y no hace falta ir usando @Getter, setter,etc con esta anotación disminuimos nº de anotaciones
@NoArgsConstructor

public class Cliente {
    @Id
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

    public Cliente(String dni, String nombre, String pais, boolean premium, Date fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.pais = pais;
        this.premium = premium;
        this.fechaNac = fechaNac;
    }
    public static Cliente getCliente(ClienteInput clienteInput){
        return new Cliente(clienteInput.getDni(),clienteInput.getNombre(),clienteInput.getPais(), clienteInput.isPremium(), clienteInput.getFechaNac());
    }

}
