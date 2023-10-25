package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Factura;
import com.facturaCliente.Exception.InvalidFieldException;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class FacturaOutput {
    @Min(value = 0, message = "El codigo de la factura no puede ser negativo")
    private int codFra;
    @Min(value = 0, message = "El total no puede ser negativo")
    private double total;
    @NotNull(message = "El mes no puede ser null")
    @NotEmpty(message = "El mes no puede estar vacio")
    private String mes;
    private int anyo;

    public FacturaOutput(int codFra, double total, String mes, int anyo){
        this.codFra = codFra;
        this.total = total;
        this.mes = mes;
        this.anyo = anyo;
    }
    public static FacturaOutput getFactura(Factura factura) {
        return new FacturaOutput(factura.getCodFra(), factura.getTotal(), factura.getMes(), factura.getAnyo());
    }

}
