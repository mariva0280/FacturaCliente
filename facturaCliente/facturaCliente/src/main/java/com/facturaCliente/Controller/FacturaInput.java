package com.facturaCliente.Controller;

import com.facturaCliente.Exception.InvalidFieldException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data

public class FacturaInput {
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

    public FacturaInput(int codFra, double total, String mes, int anyo,String clienteDni)  {
        this.codFra = codFra;
        this.total = total;
        this.mes = mes;
        this.anyo = anyo;
        this.clienteDni = clienteDni;
    }

}
