package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Factura;
import com.facturaCliente.Exception.InvalidFieldException;
import lombok.Data;

import javax.validation.constraints.Min;

@Data

public class FacturaCodTotalOutput {
    @Min(value = 0, message = "El codigo de la factura no puede ser negativo")
    private int codFra;
    @Min(value = 0, message = "El total no puede ser negativo")
    private double total;

    public FacturaCodTotalOutput() {
    }

    public FacturaCodTotalOutput(int codFra, double total){
        this.codFra = codFra;
        this.total = total;
    }
    public static FacturaCodTotalOutput getFactura(Factura factura){
        return new FacturaCodTotalOutput(factura.getCodFra(), factura.getTotal());
    }
}
