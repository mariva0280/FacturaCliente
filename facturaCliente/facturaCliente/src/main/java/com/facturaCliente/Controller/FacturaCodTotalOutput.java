package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Factura;
import com.facturaCliente.Exception.FacturaDoesntExistException;
import com.facturaCliente.Exception.InvalidFieldException;

public class FacturaCodTotalOutput {
    private int codFra;
    private double total;

    public FacturaCodTotalOutput() {
    }

    public FacturaCodTotalOutput(int codFra, double total){
        this.codFra = codFra;
        this.total = total;
    }
    public static FacturaCodTotalOutput getFactura(Factura factura) {
        return new FacturaCodTotalOutput(factura.getCodFra(), factura.getTotal());
    }


    public int getCodFra() {
        return codFra;
    }

    public double getTotal() {
        return total;
    }
}
