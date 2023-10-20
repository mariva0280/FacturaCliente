package com.facturaCliente.Service;

import com.facturaCliente.Controller.FacturaCodTotalOutput;
import com.facturaCliente.Controller.FacturaInput;
import com.facturaCliente.Controller.FacturaOutput;
import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Domain.Factura;
import com.facturaCliente.Exception.ClientDoesntExistException;
import com.facturaCliente.Exception.FacturaDoesntExistException;
import com.facturaCliente.Exception.FacturaExistsException;
import com.facturaCliente.Exception.InvalidFieldException;
import com.facturaCliente.Repository.ClienteRepository;
import com.facturaCliente.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    public void addFactura(FacturaInput facturaInput) throws FacturaExistsException {
        if(facturaRepository.existsById(facturaInput.getCodFra()))
            throw new FacturaExistsException("La factura ya existe");
        Factura factura = new Factura(facturaInput.getCodFra(),facturaInput.getTotal(),facturaInput.getMes(), facturaInput.getAnyo(),facturaInput.getClienteDni());
        facturaRepository.save(factura);
    }

    public List<FacturaOutput> listFacturas() throws InvalidFieldException, FacturaDoesntExistException {
        List<Factura> facturas = facturaRepository.findAll();
        List<FacturaOutput> facturaOutput = new ArrayList<>();
        for(Factura item : facturas) {
            facturaOutput.add(FacturaOutput.getFactura(item));
        }
        return facturaOutput;
    }
    public List<FacturaCodTotalOutput> listFacturasCliente(String clienteDni) throws ClientDoesntExistException, InvalidFieldException {
        Cliente cliente = clienteRepository.findById(clienteDni).orElse(null);
        if(cliente == null) {
            throw new ClientDoesntExistException("El cliente con dni " + clienteDni + " no existe");
        }
        List<Factura> facturas = facturaRepository.findByClienteDni(clienteDni);
        List<FacturaCodTotalOutput>facturaCodTotalOutputs = new ArrayList<>();
        for(Factura item : facturas){

            facturaCodTotalOutputs.add(FacturaCodTotalOutput.getFactura(item));

        }
        return facturaCodTotalOutputs;
    }
   public List<FacturaOutput>listFacturaByAnyoAndMes(int anyo,String mes) throws FacturaDoesntExistException, InvalidFieldException {
        List<Factura> facturas = facturaRepository.findAllByAnyoAndMes(anyo, mes);
        List<FacturaOutput> facturaOutputs = new ArrayList<>();
        for (Factura item : facturas) {
            facturaOutputs.add(FacturaOutput.getFactura(item));
        }
        return facturaOutputs;

    }
}
