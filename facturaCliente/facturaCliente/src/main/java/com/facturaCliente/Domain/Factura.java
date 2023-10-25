package com.facturaCliente.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor


public class Factura {
    @Id
    @Min(value = 0, message = "El codigo de la factura no puede ser negativo")
    private int codFra;
    @Min(value = 0, message = "El total no puede ser negativo")
    private double total;
    @NotNull(message = "El mes no puede ser null")
    @NotEmpty(message = "El mes no puede estar vacio")
    private String mes;
    private int anyo;
    @NotNull(message = "El dni no puede ser null")
    @NotEmpty(message = "El dni no puede estar vacio")
    private String clienteDni;

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

}
